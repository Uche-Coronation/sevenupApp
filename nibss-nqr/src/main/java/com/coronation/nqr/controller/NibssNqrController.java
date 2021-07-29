package com.coronation.nqr.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coronation.nqr.model.BankCardInformationQueryRequest;
import com.coronation.nqr.model.BindingCollectionAccountRequest;
import com.coronation.nqr.model.CreateBatchMerchantRequest;
import com.coronation.nqr.model.CreateBatchSubMerchantRequest;
import com.coronation.nqr.model.CreateMerchantRequest;
import com.coronation.nqr.model.CreateSubMerchantRequest;
import com.coronation.nqr.model.DynamicQrCodePaymentRequest;
import com.coronation.nqr.model.FixedQrCodePaymentRequest;
import com.coronation.nqr.model.GenerateDynamicQrCodeRequest;
import com.coronation.nqr.model.MerchantInformationQueryRequest;
import com.coronation.nqr.model.MerchantTransactionRecordQueryRequest;
import com.coronation.nqr.model.NotificationRequest;
import com.coronation.nqr.model.OrderPaymentStatusRequestForOrderNo;
import com.coronation.nqr.model.OrderPaymentStatusRequestWithOrderSn;
import com.coronation.nqr.model.QrCodeQueryRequest;
import com.coronation.nqr.model.TransferTransactionRequest;
import com.coronation.nqr.service.NqrCallerService;
import com.coronation.nqr.model.Recs;
import com.coronation.nqr.model.RecsResponse;
import com.coronation.nqr.model.TransactionFeeRequest;
import com.mashape.unirest.http.exceptions.UnirestException;

@RestController
public class NibssNqrController {

	@Autowired
	NqrCallerService nqrCallerService;
	
	@PostMapping(value ="/fixedQrCodeCustomAmount", produces = "application/json")
	@ResponseBody
	public Object fixedqrCodeCustomAmount(@RequestBody QrCodeQueryRequest qrCodeQueryRequest) throws IOException, UnirestException {
		return nqrCallerService.merchantQueryInterface(qrCodeQueryRequest, "fixedCustom");
	}
	
	@PostMapping(value = "/fixedQrCodeFixedAmount", produces= "application/json")
	@ResponseBody
	public Object fixedqrCodeFixedAmount(@RequestBody QrCodeQueryRequest qrCodeQueryRequest) throws IOException, UnirestException {
		return nqrCallerService.merchantQueryInterface(qrCodeQueryRequest, "fixedFixed");
	}
	
	@PostMapping(value="/dynamicQrCode", produces="application/json")
	@ResponseBody
	public Object dynamicQrCode(@RequestBody QrCodeQueryRequest qrCodeQueryRequest) throws IOException, UnirestException {
		return nqrCallerService.merchantQueryInterface(qrCodeQueryRequest, "dynamic");
	}
	
	@PostMapping(value="/fixedQrCodePayment", produces="application/json")
	@ResponseBody
	public Object fixedQrCodePayment(@RequestBody FixedQrCodePaymentRequest fixedQrCodePaymentRequest) throws IOException, UnirestException {
		return nqrCallerService.fixedQrCodePaymentInterface(fixedQrCodePaymentRequest);
	}
	
	@PostMapping(value="/dynamicQrCodePayment", produces="application/json")
	@ResponseBody
	public Object dynamicQrCodePayment(@RequestBody DynamicQrCodePaymentRequest dynamicQrCodePaymentRequest) throws IOException, UnirestException {
		return nqrCallerService.dynamicQrCodePaymentInterface(dynamicQrCodePaymentRequest);
	}
	
	@PostMapping(value="/orderPaymentStatusOrderNo", produces="application/json")
	@ResponseBody
	public Object orderPaymentStatusOrderNo(@RequestBody OrderPaymentStatusRequestForOrderNo orderPaymentStatusRequestForOrderNo) throws IOException, UnirestException {
		return nqrCallerService.orderPaymentStatusInterfaceOrderNo(orderPaymentStatusRequestForOrderNo);
	}
	
	@PostMapping(value="/orderPaymentStatusOrderSn", produces="application/json")
	@ResponseBody
	public Object orderPaymentStatusOrderSn(@RequestBody OrderPaymentStatusRequestWithOrderSn orderPaymentStatusRequestWithOrderSn) throws IOException, UnirestException {
		return nqrCallerService.orderPaymentStatusInterfaceOrderSn(orderPaymentStatusRequestWithOrderSn);
	}
	
	@PostMapping(value="/bankInformationQuery", produces="application/json")
	@ResponseBody
	public Object bankInformationQuery(@RequestBody BankCardInformationQueryRequest bankCardInformationQueryRequest) throws IOException, UnirestException {
		return nqrCallerService.bankCardInformationQueryInterface(bankCardInformationQueryRequest);
	}
	
	@PostMapping(value="/transferTransactionInterface", produces="application/json")
	@ResponseBody
	public Object transfertransactionInterface(@RequestBody TransferTransactionRequest transferTransactionRequest) throws IOException, UnirestException {
		return nqrCallerService.transferTransactionInterface(transferTransactionRequest);
	}
	
	@PostMapping(value="/generateDynamicQrCodeInterface", produces="application/json")
	@ResponseBody
	public Object generateDynamicQrCodeInterface(@RequestBody GenerateDynamicQrCodeRequest generateDynamicQrCodeRequest) throws IOException, UnirestException {
		return nqrCallerService.generateDynamicQrCodeInterface(generateDynamicQrCodeRequest);
	}
	
	@PostMapping(value="/createMerchantInterface", produces="application/json")
	@ResponseBody
	public Object createMerchantInterface(@RequestBody CreateMerchantRequest createMerchantRequest) throws IOException, UnirestException {
		return nqrCallerService.createMerchantInterface(createMerchantRequest);
	}
	
	@PostMapping(value="/bindingCollectionAccountInterface", produces="application/json")
	@ResponseBody
	public Object bindingCollectionAccountInterface(@RequestBody BindingCollectionAccountRequest bindingCollectionAccountRequest) throws IOException, UnirestException {
		return nqrCallerService.bindingCollectionAccountInterface(bindingCollectionAccountRequest);
	}
	
	@PostMapping(value="/createSubMerchantInterface", produces="application/json")
	@ResponseBody
	public Object createSubMerchantInterface(@RequestBody CreateSubMerchantRequest createSubMerchantRequest) throws IOException, UnirestException {
		return nqrCallerService.createSubMerchantInterface(createSubMerchantRequest);
	}
	
	@PostMapping(value="/merchantInformationQueryInterface", produces="application/json")
	@ResponseBody
	public Object merchantInformationQueryInterface(@RequestBody MerchantInformationQueryRequest merchantInformationQueryRequest) throws IOException, UnirestException {
		return nqrCallerService.merchantInformationQueryInterface(merchantInformationQueryRequest);
	}
	
	@PostMapping(value="/merchantTransactionRecordQueryInterface", produces="application/json")
	@ResponseBody
	public Object merchantTransactionRecordQueryInterface(@RequestBody MerchantTransactionRecordQueryRequest merchantTransactionRecordQueryRequest) throws IOException, UnirestException {
		return nqrCallerService.merchantTransactionRecordQueryInterface(merchantTransactionRecordQueryRequest);
	}
	
	@PostMapping(value="/batchCreateMerchantInterface", produces="application/json")
	@ResponseBody
	public Object batchCreateMerchantInterface(@RequestBody CreateBatchMerchantRequest createBatchMerchantRequest) throws IOException, UnirestException {
		return nqrCallerService.batchCreateMerchantInterface(createBatchMerchantRequest);
	}
	
	@PostMapping(value="/batchCreateSubMerchantInterface", produces="application/json")
	@ResponseBody
	public Object batchCreateSubMerchantInterface(@RequestBody CreateBatchSubMerchantRequest createBatchSubMerchantRequest) throws IOException, UnirestException {
		return nqrCallerService.batchCreateSubMerchantInterface(createBatchSubMerchantRequest);
	}
	
	@PostMapping(value="/transactionSuccessNotification", produces="application/json")
	@ResponseBody
	public Object transactionSuccessNotification(@RequestBody NotificationRequest notificationRequest) throws IOException, UnirestException {
		return nqrCallerService.transactionSuccessNotification(notificationRequest);
	}
	
	@PostMapping(value="/transactionFeeInquiry", produces="application/json")
	@ResponseBody
	public Object transactionFeeInquiry(@RequestBody TransactionFeeRequest transactionFeeRequest) throws IOException, UnirestException {
		return nqrCallerService.transactionFeeInquiry(transactionFeeRequest);
	}
	
	@PostMapping(value="/performPayment", produces = "application/json")
	@ResponseBody
	public RecsResponse performPayment(@RequestBody Recs recs) {
		return nqrCallerService.performPayment(recs);
	}
	
}
