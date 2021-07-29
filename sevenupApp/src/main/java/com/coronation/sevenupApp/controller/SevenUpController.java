package com.coronation.sevenupApp.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coronation.sevenupApp.model.InvoiceOrder;
import com.coronation.sevenupApp.model.MainModel;
import com.coronation.sevenupApp.model.NoNotification;
import com.coronation.sevenupApp.model.Notification;
import com.coronation.sevenupApp.model.NotificationResponse;
import com.coronation.sevenupApp.model.NotificationStatusResponse;
import com.coronation.sevenupApp.model.PaymentInfo;
import com.coronation.sevenupApp.model.Recs;
import com.coronation.sevenupApp.model.RecsResponse;
import com.coronation.sevenupApp.model.ValidationRequest;
import com.coronation.sevenupApp.model.ValidationResponse;
import com.coronation.sevenupApp.service.ApiCallerService;
import com.mashape.unirest.http.exceptions.UnirestException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class SevenUpController {

	@Autowired
	ApiCallerService apiCallerService;
	
	@GetMapping(value="/getInvoiceOrder", produces = "application/json")
	@ResponseBody
	public InvoiceOrder getInvoiceOrder() throws UnirestException{
	  return apiCallerService.getInvoiceOrder();
	}
	
	@PostMapping(value="/validateOrder", produces = "application/json")
	@ResponseBody
	public ValidationResponse validateOrder(@RequestBody ValidationRequest validationRequest) throws UnirestException {
		return apiCallerService.validateOrder(validationRequest);
	}
	
	@PostMapping(value="/notify", produces = "application/json")
	@ResponseBody
	public NotificationResponse notify(@RequestBody Notification notification) throws UnirestException{
		System.out.println(notification.toString() + " api");
		return apiCallerService.notify(notification);
	}
	
	@GetMapping(value="/getNotificationStatus", produces = "application/json")
	@ResponseBody
	public NotificationStatusResponse getNotificationResponse(@RequestParam String executionID) throws UnirestException{
		return apiCallerService.getNotificationStatus(executionID);
	}
	
	@PostMapping(value="/performPayment", produces = "application/json")
	@ResponseBody
	public RecsResponse performPayment(@RequestBody Recs recs) throws UnirestException {
		return apiCallerService.performPayment(recs);
	}
	
	@PostMapping(value="/getNotification", produces="application/json")
	@ResponseBody
	public ResponseEntity<?> getNotification(@RequestParam(value = "paymentReference", required = false) String paymentReference, 
				@RequestParam(value = "transactionApprovalDate", required = false) String transactionApprovalDate) {
			
			if (paymentReference != null) {
				Notification not = apiCallerService.getNotificationByReference(paymentReference);
				if(not != null) {
					return new ResponseEntity<>(not,HttpStatus.OK);
				}else {
					NoNotification non = new NoNotification();
					non.setStatus("404");
					non.setMessage("No such Notification in records");
					return new ResponseEntity<>(non,HttpStatus.NOT_FOUND);
				}
			}else if (transactionApprovalDate != null) {
				Notification not =  apiCallerService.getNotificationByDate(transactionApprovalDate);
				if(not != null) {
					return new ResponseEntity<>(not,HttpStatus.OK);
				}else {
					NoNotification non = new NoNotification();
					non.setStatus("404");
					non.setMessage("No such Notification in records");
					return new ResponseEntity<>(non,HttpStatus.NOT_FOUND);
				}
			}else {
				NoNotification non = new NoNotification();
				non.setStatus("400");
				non.setMessage("Provide either Payment Reference or Transaction Approval Date");
				return new ResponseEntity<>(non,HttpStatus.BAD_REQUEST);
			}
	}
	
	@PostMapping(value="/unifiedEndpoint", produces = "application/json")
	@ResponseBody
	public NotificationResponse unifiedEndpoint(@RequestBody MainModel mainModel) throws UnirestException {
		InvoiceOrder invoiceOrder = apiCallerService.getInvoiceOrder();
		ValidationRequest validationRequest = new ValidationRequest();
		validationRequest.setCustomerCode(invoiceOrder.getCustomerCode());
		validationRequest.setInvoiceNumber(invoiceOrder.getInvoiceNumber());
		validationRequest.setSecurityCode(String.valueOf(invoiceOrder.getSecurityCode()));
		validationRequest.setAmount(invoiceOrder.getAmount());
		validationRequest.setBankCode(mainModel.getBankCode());
		validationRequest.setBankAccountCode(mainModel.getBankAccountCode());
		validationRequest.setProviderCode(mainModel.getProviderCode());
		ValidationResponse validationResponse = apiCallerService.validateOrder(validationRequest);
		Recs recs = new Recs();
		recs.setRecs(mainModel.getRecs());
		recs.setReqUuid(mainModel.getReqUuid());
		apiCallerService.performPayment(recs);
		Notification notification = new Notification();
		notification.setCustomerCode(validationRequest.getCustomerCode());
		notification.setCustomerName(mainModel.getCustomerName());
		notification.setInvoiceNumber(validationRequest.getInvoiceNumber());
		notification.setSecurityCode(validationRequest.getSecurityCode());
		notification.setSourceBankCode(mainModel.getSourceBankCode());
		notification.setExecutionId(validationResponse.getExecutionId());
		notification.setSBCFee(mainModel.getSBCFee());
		notification.setCustomerFee(mainModel.getCustomerFee());
		notification.setAmount(validationRequest.getAmount());
		notification.setTotalAmount(notification.getAmount() + notification.getCustomerFee() + notification.getSBCFee());
		notification.setNarration(mainModel.getNarration());
		notification.setChannelName(mainModel.getChannelName());
		notification.setCustomerAccountNumber(mainModel.getCustomerAccountNumber());
		notification.setPaymentReference(mainModel.getPaymentReference());
		notification.setTransactionApprovalDate(mainModel.getTransactionApprovalDate());
		notification.setProviderCode(mainModel.getProviderCode());
		notification.setCollectionBankCode(mainModel.getCollectionBankCode());
		notification.setCollectionBankAccountCode(mainModel.getCollectionBankAccountCode());
		notification.setPaymentStatus(mainModel.getPaymentStatus());
		notification.setStatus(mainModel.getStatus());
		notification.setUpdatedDate(mainModel.getUpdatedDate());
		notification.setUpdatedBy(mainModel.getUpdatedBy());
		NotificationResponse notificationResponse = apiCallerService.notify(notification);
		return notificationResponse;
	}
	
	@PostMapping(value="/notificationsBetweenDates", produces="application/json")
	@ResponseBody
	public List<Notification> notificationsBetweenDates(@RequestParam String fromDate, @RequestParam String toDate) throws ParseException{
		return apiCallerService.notificationsBetweenDates(fromDate, toDate);
	}
	
	@PostMapping(value="/updateNotification", produces="application/json")
	@ResponseBody
	public ResponseEntity<?> updateNotification(@RequestParam String paymentReference, @RequestParam String username){
		apiCallerService.updateNotification(paymentReference, username);
		return ResponseEntity.ok("Notification Updated");
	}
	
	@PostMapping(value="/savePaymentInfo", produces="application/json")
	@ResponseBody
	public ResponseEntity<?> savePaymentInfo(@RequestBody PaymentInfo paymentInfo){
		System.out.print("Frome Controller: ");
		System.out.println(paymentInfo.toString());
		apiCallerService.savePaymentInfo(paymentInfo);
		return ResponseEntity.ok("Payment Info Saved");
	}
	
	}

