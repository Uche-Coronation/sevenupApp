package com.coronation.sevenupApp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.coronation.sevenupApp.model.InvoiceOrder;
import com.coronation.sevenupApp.model.Notification;
import com.coronation.sevenupApp.model.NotificationResponse;
import com.coronation.sevenupApp.model.NotificationStatusResponse;
import com.coronation.sevenupApp.model.PaymentInfo;
import com.coronation.sevenupApp.model.PresentUser;
import com.coronation.sevenupApp.model.Recs;
import com.coronation.sevenupApp.model.RecsResponse;
import com.coronation.sevenupApp.model.Region;
import com.coronation.sevenupApp.model.ValidationRequest;
import com.coronation.sevenupApp.model.ValidationResponse;
import com.coronation.sevenupApp.repo.NotificationRepo;
import com.coronation.sevenupApp.repo.PaymentInfoRepo;
import com.coronation.sevenupApp.repo.RegionRepo;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
public class ApiCallerService {

	@Autowired
	NotificationRepo notificationRepo;
	
	@Autowired
	PaymentInfoRepo paymentInfoRepo;
	
	@Autowired
	RegionRepo regionRepo;
	
	@Value("${apiCallerService.getInvoiceOrder}")
	private String getInvoiceOrderUrl;
	
	@Value("${apiCallerService.validateOrder}")
	private String validateOrderUrl;
	
	
	@Value("${apiCallerService.getNotificationStatus}")
	private String getNotificationStatusUrl;
	
	@Value("${apiCallerService.notify}")
	private String notifyUrl;
	
	@Value("${apiCallerService.performPayment}")
	private String performPaymentUrl;
	
	public InvoiceOrder getInvoiceOrder() throws UnirestException {
		String url = getInvoiceOrderUrl;
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest.get(url)
		  .asString();
		String resp = response.getBody();
		Gson gson = new Gson();
		InvoiceOrder invoiceOrder = gson.fromJson(resp, InvoiceOrder.class);
		//RestTemplate restTemplate = new RestTemplate();
		//InvoiceOrder  invoiceOrder = restTemplate.getForObject(url, InvoiceOrder.class);
		return invoiceOrder;
	}
	
	public ValidationResponse validateOrder(ValidationRequest validationRequest) throws UnirestException {
		String url = validateOrderUrl;
		Gson gson = new Gson();
		String req = gson.toJson(validationRequest);
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest.post(url)
		  .header("Content-Type", "application/json")
		  .body(req)
		  .asString();
		String resp = response.getBody();
		ValidationResponse validationResponse = gson.fromJson(resp, ValidationResponse.class);
		//RestTemplate restTemplate = new RestTemplate();
		//ValidationResponse validationResponse = restTemplate.postForObject(url,validationRequest, ValidationResponse.class);
		return validationResponse;
	}
	
	public NotificationResponse notify(Notification notification) throws UnirestException{
		System.out.println(notification.toString() + " service");
		notificationRepo.save(notification);
		System.out.println("Notification saved to database");
		String url = notifyUrl;
		Gson gson = new Gson();
		String req = gson.toJson(notification);
		System.out.println("Calling notification api");
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> feedback = Unirest.post(url)
		  .header("Content-Type", "application/json")
		  .body(req)
		  .asString();
		String resp = feedback.getBody();
		NotificationResponse response = gson.fromJson(resp, NotificationResponse.class);
		//RestTemplate restTemplate = new RestTemplate();
		//ResponseEntity<NotificationResponse> response = restTemplate.postForEntity(url, notification, NotificationResponse.class);
		System.out.println(response.toString());
		String status = response.getStatus();
		System.out.println("Notification Status: " + status);
		LocalTime start = LocalTime.now();
		LocalTime stop = LocalTime.now();
		long timeElapsed = Duration.between(start, stop).toMinutes();
		if(!status.equals("200")) {
		while(timeElapsed <= 360) {
			HttpResponse<String> feedback2 = Unirest.post(url)
					  .header("Content-Type", "application/json")
					  .body(req)
					  .asString();
			String resp2 = feedback2.getBody();
			NotificationResponse response2 = gson.fromJson(resp2, NotificationResponse.class);
			//ResponseEntity<NotificationResponse> response2 = restTemplate.postForEntity(url, notification, NotificationResponse.class);
			status = response2.getStatus();
			if(status.equals("200")) {
				response = response2;
				break;
			}
			timeElapsed = Duration.between(start, LocalTime.now()).toMinutes();
		}
		}	
		if(status.equals("200")) {
		    String formatDateTime = getDateTime(); 
		    notification.setUpdatedBy("api");
		    notification.setUpdatedDate(formatDateTime);
		    notification.setStatus("confirmed");
		    notificationRepo.save(notification);
		}
		return response;
	}
	
	public NotificationStatusResponse getNotificationStatus(String executionID) throws UnirestException {
		String url = getNotificationStatusUrl + executionID;
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest.get(url)
		  .asString();
		String resp = response.getBody();
		Gson gson = new Gson();
		NotificationStatusResponse nsr = gson.fromJson(resp, NotificationStatusResponse.class);
		//RestTemplate restTemplate = new RestTemplate();
		//NotificationStatusResponse nsr = restTemplate.getForObject(url, NotificationStatusResponse.class);
		return nsr;
	}
	
	public RecsResponse performPayment(Recs recs) throws UnirestException {
		String url = performPaymentUrl;
		Gson gson = new Gson();
		String req = gson.toJson(recs);
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest.post(url)
		  .header("Content-Type", "application/json")
		  .body(req)
		  .asString();
		String respon = response.getBody();
		RecsResponse resp = gson.fromJson(respon, RecsResponse.class);
		//RestTemplate restTemplate = new RestTemplate();
		//RecsResponse resp = restTemplate.postForObject(url, recs, RecsResponse.class);
		return resp;
	}
	
	public Notification getNotificationByReference(String paymentReference) {
		List<Notification> allNotifications = notificationRepo.findAll();
		Notification notification = null;
		for(Notification not : allNotifications) {
			if(not.getPaymentReference().equals(paymentReference)) {
				notification = not;
			}
		}
		return notification;
	}
	
	public Notification getNotificationByDate(String transactionApprovalDate) {
		List<Notification> allNotifications = notificationRepo.findAll();
		Notification notification = null;
		for(Notification not : allNotifications) {
			if(not.getTransactionApprovalDate().equals(transactionApprovalDate)) {
				notification = not;
			}
		}
		return notification;
	}
	
	public void updateNotification(String paymentReference, String username) {
		Notification notification = notificationRepo.findById(paymentReference).get();
		notification.setUpdatedBy(username);
		notification.setUpdatedDate(getDateTime());
		notification.setStatus("confirmed");
		notificationRepo.save(notification);
	}
	
	private String getDateTime() {
		Date date = Calendar.getInstance().getTime() ;	    
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");  
	    return format.format(date);
	}
	
	public List<Notification> notificationsBetweenDates(String fromDate, String toDate) throws ParseException{
		List<Notification> allNots = notificationRepo.findAll();
		List<Notification> rangeNots = new ArrayList<>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		Date from = format.parse(fromDate);
		Date to = format.parse(toDate);
		for(Notification not : allNots) {
			if(from.equals(format.parse(not.getTransactionApprovalDate())) || from.after(format.parse(not.getTransactionApprovalDate())) && 
					to.equals(format.parse(not.getTransactionApprovalDate())) || to.before(format.parse(not.getTransactionApprovalDate()))) {
				rangeNots.add(not);
			}
		}
		return rangeNots;
	}
	
	public void savePaymentInfo(PaymentInfo paymentInfo) {
		System.out.println(paymentInfo.toString());
		paymentInfoRepo.save(paymentInfo);
	}
	
	public Page<PaymentInfo> getAllPayments(Pageable pageable){
		return  paymentInfoRepo.findAll(pageable);
	}
	
	public void updatePaymentInfo(String paymentReference) {
		PaymentInfo paymentInfo = paymentInfoRepo.findByPaymentReference(paymentReference);
		paymentInfo.setStatus("confirmed");
		paymentInfoRepo.save(paymentInfo);
	}
	
	public void updateNotification(String paymentReference) {
		Notification not = notificationRepo.findById(paymentReference).get();
		not.setStatus("confirmed");
		not.setUpdatedBy(PresentUser.getUser().getUserEmail());
		not.setUpdatedDate(getDateTime());
		notificationRepo.save(not);
	}

	public Page<PaymentInfo> getAllPaymentsForRegion(Pageable pageable, String regionCode) {
		return paymentInfoRepo.findByCustomerRegionCode(regionCode, pageable);
	}
	
	public Page<Region> getAllRegionsPaginated(Pageable pageable){
		return regionRepo.findAll(pageable);
	}
	
	public List<Region> getAllRegions(){
		return regionRepo.findAll();
	}
	
	public void addRegion(Region region) {
		regionRepo.save(region);
	}
	
	public Region findRegion(String regionCode) {
		return regionRepo.findByRegionCode(regionCode);
	}
	
	public List<PaymentInfo> getAllPaymentInfo(){	
		List<PaymentInfo> paymentInfo = paymentInfoRepo.findAll();
		Collections.reverse(paymentInfo);
		return paymentInfo;
	}
	
	public List<PaymentInfo> findPaymentByRegionName(String regionName){
		List<PaymentInfo> paymentInfo = paymentInfoRepo.findByCustomerRegionName(regionName);
		Collections.reverse(paymentInfo);
		return paymentInfo;
	}
	
}
