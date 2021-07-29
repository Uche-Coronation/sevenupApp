package com.coronation.nqr.service;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coronation.nqr.model.BankCardInformationQueryRequest;
import com.coronation.nqr.model.BankCardInformationQueryResponse;
import com.coronation.nqr.model.BindingCollectionAccountRequest;
import com.coronation.nqr.model.BindingCollectionAccountResponse;
import com.coronation.nqr.model.CreateBatchMerchantRequest;
import com.coronation.nqr.model.CreateBatchMerchantResponse;
import com.coronation.nqr.model.CreateBatchSubMerchantRequest;
import com.coronation.nqr.model.CreateBatchSubMerchantResponse;
import com.coronation.nqr.model.CreateMerchantRequest;
import com.coronation.nqr.model.CreateMerchantResponse;
import com.coronation.nqr.model.CreateSubMerchantRequest;
import com.coronation.nqr.model.CreateSubMerchantResponse;
import com.coronation.nqr.model.DynamicQrCodePaymentRequest;
import com.coronation.nqr.model.DynamicQrCodePaymentResponse;
import com.coronation.nqr.model.DynamicQrCodeQueryResponse;
import com.coronation.nqr.model.FailResponse;
import com.coronation.nqr.model.FixedQrCodeCustomAmountResponse;
import com.coronation.nqr.model.FixedQrCodeFixedAmountResponse;
import com.coronation.nqr.model.FixedQrCodePaymentRequest;
import com.coronation.nqr.model.FixedQrCodePaymentResponse;
import com.coronation.nqr.model.GenerateDynamicQrCodeRequest;
import com.coronation.nqr.model.GenerateDynamicQrCodeResponse;
import com.coronation.nqr.model.MerchantInformationQueryRequest;
import com.coronation.nqr.model.MerchantInformationQueryResponse;
import com.coronation.nqr.model.MerchantTransactionRecordQueryRequest;
import com.coronation.nqr.model.MerchantTransactionRecordQueryResponse;
import com.coronation.nqr.model.NotificationRequest;
import com.coronation.nqr.model.NotificationResponse;
import com.coronation.nqr.model.NqrProperties;
import com.coronation.nqr.model.OrderPaymentStatusRequestForOrderNo;
import com.coronation.nqr.model.OrderPaymentStatusRequestWithOrderSn;
import com.coronation.nqr.model.OrderPaymentStatusResponse;
import com.coronation.nqr.model.QrCodeQueryRequest;
import com.coronation.nqr.model.TransferTransactionRequest;
import com.coronation.nqr.model.TransferTransactionResponse;
import com.coronation.nqr.model.Recs;
import com.coronation.nqr.model.RecsResponse;
import com.coronation.nqr.model.TransactionFeeRequest;
import com.coronation.nqr.model.TransactionFeeResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
public class NqrCallerService {

	@Autowired
	private NqrProperties nqrProperties;
	
	public NqrCallerService() {
		Unirest.setObjectMapper(new ObjectMapper() {
		    com.fasterxml.jackson.databind.ObjectMapper mapper 
		      = new com.fasterxml.jackson.databind.ObjectMapper();

		    public String writeValue(Object value) {
		        try {
					return mapper.writeValueAsString(value);
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
		    }

		    public <T> T readValue(String value, Class<T> valueType) {
		        try {
					return mapper.readValue(value, valueType);
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
		    }
		});
		Unirest.setHttpClient(getClient());
	}
	
	private CloseableHttpClient getClient() {
		CloseableHttpClient httpClient
		  = HttpClients.custom()
		    .setSSLHostnameVerifier(new NoopHostnameVerifier())
		    .build();
		return httpClient;
	}
	
	public Object merchantQueryInterface(QrCodeQueryRequest qrCodeQueryRequest, String type) throws IOException, UnirestException{
		qrCodeQueryRequest.setInstitution_number(nqrProperties.getInstitutionCode());
		HashMap<String, String> fields = new HashMap<>();
		fields.put("institution_number", qrCodeQueryRequest.getInstitution_number());
		if(qrCodeQueryRequest.getQr_cate() != null) {
			fields.put("qr_cate", qrCodeQueryRequest.getQr_cate());
		}
		if(qrCodeQueryRequest.getSub_no() != null) {
			fields.put("sub_no", qrCodeQueryRequest.getSub_no());
		}
		if(qrCodeQueryRequest.getTimestamp() != null) {
			fields.put("timestamp", qrCodeQueryRequest.getTimestamp());
		}
		qrCodeQueryRequest.setSign(getSign(fields));
		System.out.println(qrCodeQueryRequest.toString());
		String url = nqrProperties.getMerchantStatusQueryInterface();
		 Map<String, String> headers = new HashMap<>();
		    headers.put("Content-type", "application/json");
		    HttpResponse<JsonNode> jsonResponse 
		      = Unirest.post(url)
		      .headers(headers).body(qrCodeQueryRequest)
		      .asJson();
		    if(jsonResponse.getBody() != null) {
		    if(jsonResponse.getBody().getObject().get("ReturnCode").equals("Success")) {
		    	if(jsonResponse.getBody().getObject().has("Amount") && jsonResponse.getBody().getObject().has("QrType")) {
		    	Gson gson = new Gson();
		    	String responseJSONString = jsonResponse.getBody().toString();
		    	FixedQrCodeFixedAmountResponse myObject = gson.fromJson(responseJSONString, FixedQrCodeFixedAmountResponse.class);
		    	return myObject;
		    }else if(jsonResponse.getBody().getObject().has("QrType")) {
		    	Gson gson = new Gson();
		    	String responseJSONString = jsonResponse.getBody().toString();
		    	FixedQrCodeCustomAmountResponse myObject = gson.fromJson(responseJSONString, FixedQrCodeCustomAmountResponse.class);
		    	return myObject;
		    }else {
		    	Gson gson = new Gson();
		    	String responseJSONString = jsonResponse.getBody().toString();
		    	DynamicQrCodeQueryResponse myObject = gson.fromJson(responseJSONString, DynamicQrCodeQueryResponse.class);
		    	return myObject;
		    }
		    }else {
		    	Gson gson = new Gson();
		    	String responseJSONString = jsonResponse.getBody().toString();
		    	FailResponse myObject = gson.fromJson(responseJSONString, FailResponse.class);
		    	return myObject;
		    }
		    }else {
		    	FailResponse failResponse = new FailResponse();
		    	failResponse.setReturnCode("Fail");
		    	failResponse.setReturnMsg("No Response");
		    	return failResponse;
		    }
	}
	
	private String getSign(HashMap<String, String> fields) {
		SortedSet<String> keySet = new TreeSet<>(fields.keySet());
		String aString = "";
		for(int i = 0; i < keySet.size(); i++) {
			if(i < keySet.size() - 1) {
				aString += indexOf(keySet, i) + "=" + fields.get(indexOf(keySet,i)) + "&";
			}else {
				aString += indexOf(keySet,i) + "=" + fields.get(indexOf(keySet,i)) ;
			}
		}
		String signTemp = aString + nqrProperties.getKey();
		System.out.println("Sign Temp: " + signTemp);
		String sign = MD5(signTemp).toUpperCase();
		return sign;
	}

	private String MD5(String signTemp) {
        MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
	        byte[] messageDigest = md.digest(signTemp.getBytes());
	        BigInteger no = new BigInteger(1, messageDigest);
	        String hashtext = no.toString(16);
	        while (hashtext.length() < 32) {
	            hashtext = "0" + hashtext;
	        }
	        return hashtext;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public Object fixedQrCodePaymentInterface(FixedQrCodePaymentRequest fixedQrCodePaymentRequest) throws IOException, UnirestException {
		fixedQrCodePaymentRequest.setInstitution_number(nqrProperties.getInstitutionCode());
		HashMap<String, String> fields = new HashMap<>();
		fields.put("institution_number", fixedQrCodePaymentRequest.getInstitution_number());
		if(fixedQrCodePaymentRequest.getChannel() != null) {
			fields.put("channel", fixedQrCodePaymentRequest.getChannel());
		}
		if(fixedQrCodePaymentRequest.getMch_no() != null) {
			fields.put("mch_no", fixedQrCodePaymentRequest.getMch_no());
		}
		if(fixedQrCodePaymentRequest.getSub_mch_no() != null) {
			fields.put("sub_mch_no", fixedQrCodePaymentRequest.getSub_mch_no());
		}
		if(fixedQrCodePaymentRequest.getUser_bank_no() != null) {
			fields.put("user_bank_no", fixedQrCodePaymentRequest.getUser_bank_no());
		}
		if(fixedQrCodePaymentRequest.getUser_account_name() != null) {
			fields.put("user_account_name", fixedQrCodePaymentRequest.getUser_account_name());
		}
		if(fixedQrCodePaymentRequest.getUser_account_number() != null) {
			fields.put("user_account_number", fixedQrCodePaymentRequest.getUser_account_number());
		}
		if(fixedQrCodePaymentRequest.getUser_bank_verification_number() != null) {
			fields.put("user_bank_verification_number", fixedQrCodePaymentRequest.getUser_bank_verification_number());
		}
		if(fixedQrCodePaymentRequest.getUser_kyc_level() != null) {
			fields.put("user_kyc_level", fixedQrCodePaymentRequest.getUser_kyc_level());
		}
		if(fixedQrCodePaymentRequest.getUser_gps() != null) {
			fields.put("user_gps", fixedQrCodePaymentRequest.getUser_gps());
		}
		if(fixedQrCodePaymentRequest.getAmount() != null) {
			fields.put("amount", fixedQrCodePaymentRequest.getAmount());
		}
		if(fixedQrCodePaymentRequest.getOrder_no() != null) {
			fields.put("order_no", fixedQrCodePaymentRequest.getOrder_no());
		}
		if(fixedQrCodePaymentRequest.getTimestamp() != null) {
			fields.put("timestamp", fixedQrCodePaymentRequest.getTimestamp());
		}
		fixedQrCodePaymentRequest.setSign(getSign(fields));
		System.out.println(fixedQrCodePaymentRequest.toString());
		String url = nqrProperties.getFixedQrCodePaymentInterface();
		Map<String, String> headers = new HashMap<>();
	    headers.put("Content-type", "application/json");
	    HttpResponse<JsonNode> jsonResponse 
	      = Unirest.post(url)
	      .headers(headers).body(fixedQrCodePaymentRequest)
	      .asJson();
	    if(jsonResponse.getBody() != null) {
		if(jsonResponse.getBody().getObject().get("ReturnCode").equals("Success")) {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	FixedQrCodePaymentResponse myObject = gson.fromJson(responseJSONString, FixedQrCodePaymentResponse.class);
	    	return myObject;
		}else {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	FailResponse myObject = gson.fromJson(responseJSONString, FailResponse.class);
	    	return myObject;
		}
	    }else {
	    	FailResponse failResponse = new FailResponse();
	    	failResponse.setReturnCode("Fail");
	    	failResponse.setReturnMsg("No Response");
	    	return failResponse;
	    }
	}
	
	public Object dynamicQrCodePaymentInterface(DynamicQrCodePaymentRequest dynamicQrCodePaymentRequest) throws IOException, UnirestException {
		dynamicQrCodePaymentRequest.setInstitution_number(nqrProperties.getInstitutionCode());
		HashMap<String, String> fields = new HashMap<>();
		fields.put("institution_number", dynamicQrCodePaymentRequest.getInstitution_number());
		if(dynamicQrCodePaymentRequest.getUser_bank_no() != null) {
			fields.put("user_bank_no", dynamicQrCodePaymentRequest.getUser_bank_no());
		}
		if(dynamicQrCodePaymentRequest.getUser_account_name() != null) {
			fields.put("user_account_name", dynamicQrCodePaymentRequest.getUser_account_name());
		}
		if(dynamicQrCodePaymentRequest.getUser_account_number() != null) {
			fields.put("user_account_number", dynamicQrCodePaymentRequest.getUser_account_number());
		}
		if(dynamicQrCodePaymentRequest.getUser_bank_verification_number() != null) {
			fields.put("user_bank_verification_number", dynamicQrCodePaymentRequest.getUser_bank_verification_number());
		}
		if(dynamicQrCodePaymentRequest.getUser_kyc_level() != null) {
			fields.put("user_kyc_level", dynamicQrCodePaymentRequest.getUser_kyc_level());
		}
		if(dynamicQrCodePaymentRequest.getUser_gps() != null) {
			fields.put("user_gps", dynamicQrCodePaymentRequest.getUser_gps());
		}
		if(dynamicQrCodePaymentRequest.getOrder_sn()!= null) {
			fields.put("order_sn", dynamicQrCodePaymentRequest.getOrder_sn());
		}
		if(dynamicQrCodePaymentRequest.getOrder_amount() != null) {
			fields.put("order_amount", dynamicQrCodePaymentRequest.getOrder_amount());
		}
		if(dynamicQrCodePaymentRequest.getTimestamp() != null) {
			fields.put("timestamp", dynamicQrCodePaymentRequest.getTimestamp());
		}
		dynamicQrCodePaymentRequest.setSign(getSign(fields));
		System.out.println(dynamicQrCodePaymentRequest.toString());
		String url = nqrProperties.getDynamicQrCodePaymentInterface();
		Map<String, String> headers = new HashMap<>();
	    headers.put("Content-type", "application/json");
	    HttpResponse<JsonNode> jsonResponse 
	      = Unirest.post(url)
	      .headers(headers).body(dynamicQrCodePaymentRequest)
	      .asJson();
	    if(jsonResponse.getBody() != null) {
	    if(jsonResponse.getBody().getObject().get("ReturnCode").equals("Success")) {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	DynamicQrCodePaymentResponse myObject = gson.fromJson(responseJSONString, DynamicQrCodePaymentResponse.class);
	    	return myObject;
		}else {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	FailResponse myObject = gson.fromJson(responseJSONString, FailResponse.class);
	    	return myObject;
		}
	    }else {
	    	FailResponse failResponse = new FailResponse();
	    	failResponse.setReturnCode("Fail");
	    	failResponse.setReturnMsg("No Response");
	    	return failResponse;
	    }
	}
	
	public Object orderPaymentStatusInterfaceOrderSn(OrderPaymentStatusRequestWithOrderSn object) throws IOException, UnirestException {
		object.setInstitution_number(nqrProperties.getInstitutionCode());
		HashMap<String, String> fields = new HashMap<>();
		fields.put("institution_number", object.getInstitution_number());
		if(object.getOrder_sn()!= null) {
			fields.put("order_sn", object.getOrder_sn());
		}
		if(object.getTimestamp() != null) {
			fields.put("timestamp", object.getTimestamp());
		}
		object.setSign(getSign(fields));
		System.out.println(object.toString());
		String url = nqrProperties.getOrderPaymentStatusInterface();
		Map<String, String> headers = new HashMap<>();
	    headers.put("Content-type", "application/json");
	    HttpResponse<JsonNode> jsonResponse 
	      = Unirest.post(url)
	      .headers(headers).body(object)
	      .asJson();
	    if(jsonResponse.getBody() != null) {
	    if(jsonResponse.getBody().getObject().get("ReturnCode").equals("Success")) {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	OrderPaymentStatusResponse myObject = gson.fromJson(responseJSONString, OrderPaymentStatusResponse.class);
	    	return myObject;
		}else {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	FailResponse myObject = gson.fromJson(responseJSONString, FailResponse.class);
	    	return myObject;
		}
	    }else {
	    	FailResponse failResponse = new FailResponse();
	    	failResponse.setReturnCode("Fail");
	    	failResponse.setReturnMsg("No Response");
	    	return failResponse;
	    }
	}
	
	public Object orderPaymentStatusInterfaceOrderNo(OrderPaymentStatusRequestForOrderNo object) throws IOException, UnirestException {
		object.setInstitution_number(nqrProperties.getInstitutionCode());
		HashMap<String, String> fields = new HashMap<>();
		fields.put("institution_number", object.getInstitution_number());
		if(object.getOrder_no()!= null) {
			fields.put("order_no", object.getOrder_no());
		}
		if(object.getTimestamp() != null) {
			fields.put("timestamp", object.getTimestamp());
		}
		object.setSign(getSign(fields));
		System.out.println(object.toString());
		String url = nqrProperties.getOrderPaymentStatusInterface();
		Map<String, String> headers = new HashMap<>();
	    headers.put("Content-type", "application/json");
	    HttpResponse<JsonNode> jsonResponse 
	      = Unirest.post(url)
	      .headers(headers).body(object)
	      .asJson();
	    if(jsonResponse.getBody() != null) {
	    if(jsonResponse.getBody().getObject().get("ReturnCode").equals("Success")) {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	OrderPaymentStatusResponse myObject = gson.fromJson(responseJSONString, OrderPaymentStatusResponse.class);
	    	return myObject;
		}else {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	FailResponse myObject = gson.fromJson(responseJSONString, FailResponse.class);
	    	return myObject;
		}
	    }else {
	    	FailResponse failResponse = new FailResponse();
	    	failResponse.setReturnCode("Fail");
	    	failResponse.setReturnMsg("No Response");
	    	return failResponse;
	    }
	}
	
	public Object bankCardInformationQueryInterface(BankCardInformationQueryRequest bankCardInformationQueryRequest) throws IOException, UnirestException {
		bankCardInformationQueryRequest.setInstitution_number(nqrProperties.getInstitutionCode());
		HashMap<String, String> fields = new HashMap<>();
		fields.put("institution_number", bankCardInformationQueryRequest.getInstitution_number());
		if(bankCardInformationQueryRequest.getChannel() != null) {
			fields.put("channel", bankCardInformationQueryRequest.getChannel());
		}
		if(bankCardInformationQueryRequest.getBank_number() != null) {
			fields.put("bank_number", bankCardInformationQueryRequest.getBank_number());
		}
		if(bankCardInformationQueryRequest.getAccount_number() != null) {
			fields.put("account_number", bankCardInformationQueryRequest.getAccount_number());
		}
		if(bankCardInformationQueryRequest.getTimestamp() != null) {
			fields.put("timestamp", bankCardInformationQueryRequest.getTimestamp());
		}
		bankCardInformationQueryRequest.setSign(getSign(fields));
		System.out.println(bankCardInformationQueryRequest.toString());
		String url = nqrProperties.getBankCardInformationqueryInterface();
		Map<String, String> headers = new HashMap<>();
	    headers.put("Content-type", "application/json");
	    HttpResponse<JsonNode> jsonResponse 
	      = Unirest.post(url)
	      .headers(headers).body(bankCardInformationQueryRequest)
	      .asJson();
	    if(jsonResponse.getBody() != null) {
	    if(jsonResponse.getBody().getObject().get("ReturnCode").equals("Success")) {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	BankCardInformationQueryResponse myObject = gson.fromJson(responseJSONString, BankCardInformationQueryResponse.class);
	    	return myObject;
		}else {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	FailResponse myObject = gson.fromJson(responseJSONString, FailResponse.class);
	    	return myObject;
		}
	    }else {
	    	FailResponse failResponse = new FailResponse();
	    	failResponse.setReturnCode("Fail");
	    	failResponse.setReturnMsg("No Response");
	    	return failResponse;
	    }
	}
	
	public Object transferTransactionInterface(TransferTransactionRequest transferTransactionRequest) throws IOException, UnirestException {
		transferTransactionRequest.setInstitution_number(nqrProperties.getInstitutionCode());
		HashMap<String, String> fields = new HashMap<>();
		fields.put("institution_number", transferTransactionRequest.getInstitution_number());
		if(transferTransactionRequest.getChannel() != null) {
			fields.put("channel", transferTransactionRequest.getChannel());
		}
		if(transferTransactionRequest.getAmount() != null) {
			fields.put("amount", transferTransactionRequest.getAmount());
		}
		if(transferTransactionRequest.getOrder_no() != null) {
			fields.put("order_no", transferTransactionRequest.getOrder_no());
		}
		if(transferTransactionRequest.getOrder_type() != null) {
			fields.put("order_type", transferTransactionRequest.getOrder_type());
		}
		if(transferTransactionRequest.getPayee_bank_no() != null) {
			fields.put("payee_bank_no", transferTransactionRequest.getPayee_bank_no());
		}
		if(transferTransactionRequest.getPayee_account_name() != null) {
			fields.put("payee_account_name", transferTransactionRequest.getPayee_account_name());
		}
		if(transferTransactionRequest.getPayee_account_number() != null) {
			fields.put("payee_account_number", transferTransactionRequest.getPayee_account_number());
		}
		if(transferTransactionRequest.getPayee_bank_verification_number() != null) {
			fields.put("payee_bank_verification_number", transferTransactionRequest.getPayee_bank_verification_number());
		}
		if(transferTransactionRequest.getPayee_kyc_level() != null) {
			fields.put("payee_kyc_level", transferTransactionRequest.getPayee_kyc_level());
		}
		if(transferTransactionRequest.getPayee_bank_no() != null) {
			fields.put("payer_bank_no", transferTransactionRequest.getPayer_bank_no());
		}
		if(transferTransactionRequest.getPayee_account_name() != null) {
			fields.put("payer_account_name", transferTransactionRequest.getPayer_account_name());
		}
		if(transferTransactionRequest.getPayee_account_number() != null) {
			fields.put("payer_account_number", transferTransactionRequest.getPayer_account_number());
		}
		if(transferTransactionRequest.getPayee_bank_verification_number() != null) {
			fields.put("payer_bank_verification_number", transferTransactionRequest.getPayer_bank_verification_number());
		}
		if(transferTransactionRequest.getPayee_kyc_level() != null) {
			fields.put("payer_kyc_level", transferTransactionRequest.getPayer_kyc_level());
		}
		if(transferTransactionRequest.getUser_gps() != null) {
			fields.put("user_gps", transferTransactionRequest.getUser_gps());
		}
		if(transferTransactionRequest.getTimestamp() != null) {
			fields.put("timestamp", transferTransactionRequest.getTimestamp());
		}
		transferTransactionRequest.setSign(getSign(fields));
		System.out.println(transferTransactionRequest.toString());
		String url = nqrProperties.getTransferTransactionInterface();
		Map<String, String> headers = new HashMap<>();
	    headers.put("Content-type", "application/json");

	    HttpResponse<JsonNode> jsonResponse 
	      = Unirest.post(url)
	      .headers(headers).body(transferTransactionRequest)
	      .asJson();
	    if(jsonResponse.getBody() != null) {
	    if(jsonResponse.getBody().getObject().get("ReturnCode").equals("Success")) {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	TransferTransactionResponse myObject = gson.fromJson(responseJSONString, TransferTransactionResponse.class);
	    	return myObject;
		}else {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	FailResponse myObject = gson.fromJson(responseJSONString, FailResponse.class);
	    	return myObject;
		}
	    }else {
	    	FailResponse failResponse = new FailResponse();
	    	failResponse.setReturnCode("Fail");
	    	failResponse.setReturnMsg("No Response");
	    	return failResponse;
	    }
	}

	public Object generateDynamicQrCodeInterface(GenerateDynamicQrCodeRequest generateDynamicQrCodeRequest) throws IOException, UnirestException {
		generateDynamicQrCodeRequest.setInstitution_number(nqrProperties.getInstitutionCode());
		HashMap<String, String> fields = new HashMap<>();
		fields.put("institution_number", generateDynamicQrCodeRequest.getInstitution_number());
		if(generateDynamicQrCodeRequest.getChannel() != null) {
			fields.put("channel", generateDynamicQrCodeRequest.getChannel());
		}
		if(generateDynamicQrCodeRequest.getMch_no() != null) {
			fields.put("mch_no", generateDynamicQrCodeRequest.getMch_no());
		}
		if(generateDynamicQrCodeRequest.getMch_no() != null) {
			fields.put("sub_mch_no", generateDynamicQrCodeRequest.getSub_mch_no());
		}
		if(generateDynamicQrCodeRequest.getCode_type() != null) {
			fields.put("code_type", generateDynamicQrCodeRequest.getCode_type());
		}
		if(generateDynamicQrCodeRequest .getAmount() != null) {
			fields.put("amount", generateDynamicQrCodeRequest.getAmount());
		}
		if(generateDynamicQrCodeRequest.getOrder_no() != null) {
			fields.put("order_no", generateDynamicQrCodeRequest.getOrder_no());
		}
		if(generateDynamicQrCodeRequest.getOrder_type() != null) {
			fields.put("order_type", generateDynamicQrCodeRequest.getOrder_type());
		}
		if(generateDynamicQrCodeRequest.getTimestamp() != null) {
			fields.put("timestamp", generateDynamicQrCodeRequest.getTimestamp());
		}
		generateDynamicQrCodeRequest.setSign(getSign(fields));
		System.out.println(generateDynamicQrCodeRequest.toString());
		String url = nqrProperties.getGenerateDynamicQrCodeInterface();
		Map<String, String> headers = new HashMap<>();
	    headers.put("Content-type", "application/json");
	    HttpResponse<JsonNode> jsonResponse 
	      = Unirest.post(url)
	      .headers(headers).body(generateDynamicQrCodeRequest)
	      .asJson();
	    if(jsonResponse.getBody() != null) {
	    if(jsonResponse.getBody().getObject().get("ReturnCode").equals("Success")) {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	GenerateDynamicQrCodeResponse myObject = gson.fromJson(responseJSONString, GenerateDynamicQrCodeResponse.class);
	    	return myObject;
		}else {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	FailResponse myObject = gson.fromJson(responseJSONString, FailResponse.class);
	    	return myObject;
		}
	    }else {
	    	FailResponse failResponse = new FailResponse();
	    	failResponse.setReturnCode("Fail");
	    	failResponse.setReturnMsg("No Response");
	    	return failResponse;
	    }
	}
	
	public Object createMerchantInterface(CreateMerchantRequest createMerchantRequest) throws IOException, UnirestException {
		createMerchantRequest.setInstitution_number(nqrProperties.getInstitutionCode());
		HashMap<String, String> fields = new HashMap<>();
		fields.put("institution_number", createMerchantRequest.getInstitution_number());
		if(createMerchantRequest.getName() != null) {
			fields.put("name", createMerchantRequest.getName());
		}
		if(createMerchantRequest.getTin() != null) {
			fields.put("tin", createMerchantRequest.getTin());
		}
		if(createMerchantRequest.getContact() != null) {
			fields.put("contact", createMerchantRequest.getContact());
		}
		if(createMerchantRequest.getPhone() != null) {
			fields.put("phone", createMerchantRequest.getPhone());
		}
		if(createMerchantRequest.getEmail() != null) {
			fields.put("email", createMerchantRequest.getEmail());
		}
		if(createMerchantRequest.getAddress() != null) {
			fields.put("address", createMerchantRequest.getAddress());
		}
		if(createMerchantRequest.getFee() != null) {
			fields.put("fee", createMerchantRequest.getFee());
		}
		if(createMerchantRequest.getTimestamp() != null) {
			fields.put("timestamp", createMerchantRequest.getTimestamp());
		}
		createMerchantRequest.setSign(getSign(fields));
		System.out.println(createMerchantRequest.toString());
		String url = nqrProperties.getCreateMerchantInterface();
		Map<String, String> headers = new HashMap<>();
	    headers.put("Content-type", "application/json");
	    HttpResponse<JsonNode> jsonResponse 
	      = Unirest.post(url)
	      .headers(headers).body(createMerchantRequest)
	      .asJson();
	    if(jsonResponse.getBody() != null) {
	    if(jsonResponse.getBody().getObject().get("ReturnCode").equals("Success")) {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	CreateMerchantResponse myObject = gson.fromJson(responseJSONString, CreateMerchantResponse.class);
	    	return myObject;
		}else {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	FailResponse myObject = gson.fromJson(responseJSONString, FailResponse.class);
	    	return myObject;
		}
	    }else {
	    	FailResponse failResponse = new FailResponse();
	    	failResponse.setReturnCode("Fail");
	    	failResponse.setReturnMsg("No Response");
	    	return failResponse;
	    }
	}
	
	public Object bindingCollectionAccountInterface(BindingCollectionAccountRequest bindingCollectionAccountRequest) throws IOException, UnirestException {
		bindingCollectionAccountRequest.setInstitution_number(nqrProperties.getInstitutionCode());
		HashMap<String, String> fields = new HashMap<>();
		fields.put("institution_number", bindingCollectionAccountRequest.getInstitution_number());
		if(bindingCollectionAccountRequest.getMch_no() != null) {
			fields.put("mch_no", bindingCollectionAccountRequest.getMch_no());
		}
		if(bindingCollectionAccountRequest.getBank_no() != null) {
			fields.put("bank_no", bindingCollectionAccountRequest.getBank_no());
		}
		if(bindingCollectionAccountRequest.getAccount_name() != null) {
			fields.put("account_name", bindingCollectionAccountRequest.getAccount_name());
		}
		if(bindingCollectionAccountRequest.getAccount_number() != null) {
			fields.put("account_number", bindingCollectionAccountRequest.getAccount_number());
		}
		if(bindingCollectionAccountRequest.getTimestamp() != null) {
			fields.put("timestamp", bindingCollectionAccountRequest.getTimestamp());
		}
		bindingCollectionAccountRequest.setSign(getSign(fields));
		System.out.println(bindingCollectionAccountRequest.toString());
		String url = nqrProperties.getBindingCollectionAccountInterface();
		System.out.println("Binding Url: " + url);
		Map<String, String> headers = new HashMap<>();
	    headers.put("Content-type", "application/json");
	    HttpResponse<JsonNode> jsonResponse 
	      = Unirest.post(url)
	      .headers(headers).body(bindingCollectionAccountRequest)
	      .asJson();
	    if(jsonResponse.getBody() != null) {
	    if(jsonResponse.getBody().getObject().get("ReturnCode").equals("Success")) {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	BindingCollectionAccountResponse myObject = gson.fromJson(responseJSONString, BindingCollectionAccountResponse.class);
	    	return myObject;
		}else {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	FailResponse myObject = gson.fromJson(responseJSONString, FailResponse.class);
	    	return myObject;
		}
	    }else {
	    	FailResponse failResponse = new FailResponse();
	    	failResponse.setReturnCode("Fail");
	    	failResponse.setReturnMsg("No Response");
	    	return failResponse;
	    }
	}
	
	public Object createSubMerchantInterface(CreateSubMerchantRequest createSubMerchantRequest) throws IOException, UnirestException {
		createSubMerchantRequest.setInstitution_number(nqrProperties.getInstitutionCode());
		HashMap<String, String> fields = new HashMap<>();
		fields.put("institution_number", createSubMerchantRequest.getInstitution_number());
		if(createSubMerchantRequest.getMch_no() != null) {
			fields.put("mch_no", createSubMerchantRequest.getMch_no());
		}
		if(createSubMerchantRequest.getName() != null) {
			fields.put("name", createSubMerchantRequest.getName());
		}
		if(createSubMerchantRequest.getEmail() != null) {
			fields.put("email", createSubMerchantRequest.getEmail());
		}
		if(createSubMerchantRequest.getPhone_number() != null) {
			fields.put("phone_number", createSubMerchantRequest.getPhone_number());
		}
		if(createSubMerchantRequest.getSub_fixed() != null) {
			fields.put("sub_fixed", createSubMerchantRequest.getSub_fixed());
		}
		if(createSubMerchantRequest.getSub_amount() != null) {
			fields.put("sub_amount", createSubMerchantRequest.getSub_amount());
		}
		if(createSubMerchantRequest.getTimestamp() != null) {
			fields.put("timestamp", createSubMerchantRequest.getTimestamp());
		}
		createSubMerchantRequest.setSign(getSign(fields));
		System.out.println(createSubMerchantRequest.toString());
		String url = nqrProperties.getCreateSubMerchantInterface();
		System.out.println("Sub Merchant Url: " + url);
		Map<String, String> headers = new HashMap<>();
	    headers.put("Content-type", "application/json");
	    HttpResponse<JsonNode> jsonResponse 
	      = Unirest.post(url)
	      .headers(headers).body(createSubMerchantRequest)
	      .asJson();
	    if(jsonResponse.getBody() != null) {
	    if(jsonResponse.getBody().getObject().get("ReturnCode").equals("Success")) {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	CreateSubMerchantResponse myObject = gson.fromJson(responseJSONString, CreateSubMerchantResponse.class);
	    	return myObject;
		}else {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	FailResponse myObject = gson.fromJson(responseJSONString, FailResponse.class);
	    	return myObject;
		}
	    }else {
	    	FailResponse failResponse = new FailResponse();
	    	failResponse.setReturnCode("Fail");
	    	failResponse.setReturnMsg("No Response");
	    	return failResponse;
	    }
	}
	
	public Object merchantInformationQueryInterface(MerchantInformationQueryRequest merchantInformationQueryRequest) throws IOException, UnirestException {
		merchantInformationQueryRequest.setInstitution_number(nqrProperties.getInstitutionCode());
		HashMap<String, String> fields = new HashMap<>();
		fields.put("institution_number", merchantInformationQueryRequest.getInstitution_number());
		if(merchantInformationQueryRequest.getMch_no() != null) {
			fields.put("mch_no", merchantInformationQueryRequest.getMch_no());
		}
		if(merchantInformationQueryRequest.getTimestamp() != null) {
			fields.put("timestamp", merchantInformationQueryRequest.getTimestamp());
		}
		merchantInformationQueryRequest.setSign(getSign(fields));
		System.out.println(merchantInformationQueryRequest.toString());
		String url = nqrProperties.getMerchantInformtionQueryInterface();
		Map<String, String> headers = new HashMap<>();
	    headers.put("Content-type", "application/json");
	    HttpResponse<JsonNode> jsonResponse 
	      = Unirest.post(url)
	      .headers(headers).body(merchantInformationQueryRequest)
	      .asJson();
	    if(jsonResponse.getBody() != null) {
	    if(jsonResponse.getBody().getObject().get("ReturnCode").equals("Success")) {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	MerchantInformationQueryResponse myObject = gson.fromJson(responseJSONString, MerchantInformationQueryResponse.class);
	    	return myObject;
		}else {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	FailResponse myObject = gson.fromJson(responseJSONString, FailResponse.class);
	    	return myObject;
		}
	    }else {
	    	FailResponse failResponse = new FailResponse();
	    	failResponse.setReturnCode("Fail");
	    	failResponse.setReturnMsg("No Response");
	    	return failResponse;
	    }
	}
	
	public Object merchantTransactionRecordQueryInterface(MerchantTransactionRecordQueryRequest merchantTransactionRecordQueryRequest) throws IOException, UnirestException {
		merchantTransactionRecordQueryRequest.setInstitution_number(nqrProperties.getInstitutionCode());
		HashMap<String, String> fields = new HashMap<>();
		fields.put("institution_number", merchantTransactionRecordQueryRequest.getInstitution_number());
		if(merchantTransactionRecordQueryRequest.getMch_no() != null) {
			fields.put("mch_no", merchantTransactionRecordQueryRequest.getMch_no());
		}
		if(merchantTransactionRecordQueryRequest.getStart_time() != null) {
			fields.put("start_time", merchantTransactionRecordQueryRequest.getStart_time());
		}
		if(merchantTransactionRecordQueryRequest.getEnd_time() != null) {
			fields.put("end_time", merchantTransactionRecordQueryRequest.getEnd_time());
		}
		if(merchantTransactionRecordQueryRequest.getOrder_type() != null) {
			fields.put("order_type", merchantTransactionRecordQueryRequest.getOrder_type());
		}
		if(merchantTransactionRecordQueryRequest.getPage() != null) {
			fields.put("page", merchantTransactionRecordQueryRequest.getPage());
		}
		if(merchantTransactionRecordQueryRequest.getTimestamp() != null) {
			fields.put("timestamp", merchantTransactionRecordQueryRequest.getTimestamp());
		}
		merchantTransactionRecordQueryRequest.setSign(getSign(fields));
		System.out.println(merchantTransactionRecordQueryRequest.toString());
		String url = nqrProperties.getMerchantTransactionRecordQueryInterface();
		Map<String, String> headers = new HashMap<>();
	    headers.put("Content-type", "application/json");
	    HttpResponse<JsonNode> jsonResponse 
	      = Unirest.post(url)
	      .headers(headers).body(merchantTransactionRecordQueryRequest)
	      .asJson();
	    if(jsonResponse.getBody() != null) {
	    if(jsonResponse.getBody().getObject().get("ReturnCode").equals("Success")) {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	MerchantTransactionRecordQueryResponse myObject = gson.fromJson(responseJSONString, MerchantTransactionRecordQueryResponse.class);
	    	return myObject;
		}else {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	FailResponse myObject = gson.fromJson(responseJSONString, FailResponse.class);
	    	return myObject;
		}
	    }else {
	    	FailResponse failResponse = new FailResponse();
	    	failResponse.setReturnCode("Fail");
	    	failResponse.setReturnMsg("No Response");
	    	return failResponse;
	    }
	}
	
	public Object batchCreateMerchantInterface(CreateBatchMerchantRequest createBatchMerchantRequest ) throws IOException, UnirestException {
		createBatchMerchantRequest.setInstitution_number(nqrProperties.getInstitutionCode());
		HashMap<String, String> fields = new HashMap<>();
		fields.put("institution_number", createBatchMerchantRequest.getInstitution_number());
		if(createBatchMerchantRequest.getTimestamp() != null) {
			fields.put("timestamp", createBatchMerchantRequest.getTimestamp());
		}
		createBatchMerchantRequest.setSign(getSign(fields));
		System.out.println(createBatchMerchantRequest.toString());
		String url = nqrProperties.getBatchCreateMerchantInterface();
		Map<String, String> headers = new HashMap<>();
	    headers.put("Content-type", "application/json");
	    HttpResponse<JsonNode> jsonResponse 
	      = Unirest.post(url)
	      .headers(headers).body(createBatchMerchantRequest)
	      .asJson();
	    if(jsonResponse.getBody() != null) {
	    if(jsonResponse.getBody().getObject().get("ReturnCode").equals("Success")) {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	CreateBatchMerchantResponse myObject = gson.fromJson(responseJSONString, CreateBatchMerchantResponse.class);
	    	return myObject;
		}else {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	FailResponse myObject = gson.fromJson(responseJSONString, FailResponse.class);
	    	return myObject;
		}
	    }else {
	    	FailResponse failResponse = new FailResponse();
	    	failResponse.setReturnCode("Fail");
	    	failResponse.setReturnMsg("No Response");
	    	return failResponse;
	    }
	}

	public Object batchCreateSubMerchantInterface(CreateBatchSubMerchantRequest createBatchSubMerchantRequest) throws IOException, UnirestException {
		createBatchSubMerchantRequest.setInstitution_number(nqrProperties.getInstitutionCode());
		HashMap<String, String> fields = new HashMap<>();
		fields.put("institution_number", createBatchSubMerchantRequest.getInstitution_number());
		if(createBatchSubMerchantRequest.getTimestamp() != null) {
			fields.put("timestamp", createBatchSubMerchantRequest.getTimestamp());
		}
		if(createBatchSubMerchantRequest.getMch_no() != null) {
			fields.put("mch_no", createBatchSubMerchantRequest.getMch_no());
		}
		createBatchSubMerchantRequest.setSign(getSign(fields));
		System.out.println(createBatchSubMerchantRequest.toString());
		String url = nqrProperties.getBatchCreateSubMerchantInterface();
		Map<String, String> headers = new HashMap<>();
	    headers.put("Content-type", "application/json");
	    HttpResponse<JsonNode> jsonResponse 
	      = Unirest.post(url)
	      .headers(headers).body(createBatchSubMerchantRequest)
	      .asJson();
	    if(jsonResponse.getBody() != null) {
	    if(jsonResponse.getBody().getObject().get("ReturnCode").equals("Success")) {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	CreateBatchSubMerchantResponse myObject = gson.fromJson(responseJSONString, CreateBatchSubMerchantResponse.class);
	    	return myObject;
		}else {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	FailResponse myObject = gson.fromJson(responseJSONString, FailResponse.class);
	    	return myObject;
		}
	    }else {
	    	FailResponse failResponse = new FailResponse();
	    	failResponse.setReturnCode("Fail");
	    	failResponse.setReturnMsg("No Response");
	    	return failResponse;
	    }
	}
	
	public Object transactionSuccessNotification(NotificationRequest notificationRequest) throws UnirestException {
		notificationRequest.setInstitution_number(nqrProperties.getInstitutionCode());
		HashMap<String, String> fields = new HashMap<>();
		fields.put("institution_number", notificationRequest.getInstitution_number());
		if(notificationRequest.getMch_no() != null) {
			fields.put("mch_no", notificationRequest.getMch_no());
		}
		if(notificationRequest.getSub_mch_no() != null) {
			fields.put("sub_mch_no", notificationRequest.getSub_mch_no());
		}
		if(notificationRequest.getSession_id() != null) {
			fields.put("session_id", notificationRequest.getSession_id());
		}
		if(notificationRequest.getAmount() != null) {
			fields.put("amount", notificationRequest.getAmount());
		}
		if(notificationRequest.getTimestamp() != null) {
			fields.put("timestamp", notificationRequest.getTimestamp());
		}
		notificationRequest.setSign(getSign(fields));
		System.out.println(notificationRequest.toString());
		String url = nqrProperties.getTransactionSuccessNotificationInterface();
		Map<String, String> headers = new HashMap<>();
	    headers.put("Content-type", "application/json");
	    HttpResponse<JsonNode> jsonResponse 
	      = Unirest.post(url)
	      .headers(headers).body(notificationRequest)
	      .asJson();
	    if(jsonResponse.getBody() != null) {
	    if(jsonResponse.getBody().getObject().get("ReturnCode").equals("Success")) {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	NotificationResponse myObject = gson.fromJson(responseJSONString, NotificationResponse.class);
	    	return myObject;
		}else {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	FailResponse myObject = gson.fromJson(responseJSONString, FailResponse.class);
	    	return myObject;
		}
	    }else {
	    	FailResponse failResponse = new FailResponse();
	    	failResponse.setReturnCode("Fail");
	    	failResponse.setReturnMsg("No Response");
	    	return failResponse;
	    }
	}

	public Object transactionFeeInquiry(TransactionFeeRequest transactionFeeRequest) throws UnirestException {
		transactionFeeRequest.setInstitution_number(nqrProperties.getInstitutionCode());
		HashMap<String, String> fields = new HashMap<>();
		fields.put("institution_number", transactionFeeRequest.getInstitution_number());
		if(transactionFeeRequest.getMch_no() != null) {
			fields.put("mch_no", transactionFeeRequest.getMch_no());
		}
		if(transactionFeeRequest.getSub_mch_no() != null) {
			fields.put("sub_mch_no", transactionFeeRequest.getSub_mch_no());
		}
		if(transactionFeeRequest.getUser_bank_no() != null) {
			fields.put("user_bank_no", transactionFeeRequest.getUser_bank_no());
		}
		if(transactionFeeRequest.getAmount() != null) {
			fields.put("amount", transactionFeeRequest.getAmount());
		}
		if(transactionFeeRequest.getTimestamp() != null) {
			fields.put("timestamp", transactionFeeRequest.getTimestamp());
		}
		transactionFeeRequest.setSign(getSign(fields));
		System.out.println(transactionFeeRequest.toString());
		String url = nqrProperties.getTransactionFeeInquiryInterface();
		Map<String, String> headers = new HashMap<>();
	    headers.put("Content-type", "application/json");
	    HttpResponse<JsonNode> jsonResponse 
	      = Unirest.post(url)
	      .headers(headers).body(transactionFeeRequest)
	      .asJson();
	    if(jsonResponse.getBody() != null) {
	    if(jsonResponse.getBody().getObject().get("ReturnCode").equals("Success")) {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	TransactionFeeResponse myObject = gson.fromJson(responseJSONString, TransactionFeeResponse.class);
	    	return myObject;
		}else {
			Gson gson = new Gson();
	    	String responseJSONString = jsonResponse.getBody().toString();
	    	FailResponse myObject = gson.fromJson(responseJSONString, FailResponse.class);
	    	return myObject;
		}
	    }else {
	    	FailResponse failResponse = new FailResponse();
	    	failResponse.setReturnCode("Fail");
	    	failResponse.setReturnMsg("No Response");
	    	return failResponse;
	    }
	}
	
	
	private static String indexOf(SortedSet<String> set, int element){
         List<String> list = new ArrayList<String>(set);
         return list.get(element);
     }
	
	public RecsResponse performPayment(Recs recs) {
		String url = nqrProperties.getPerformPayment();
		RestTemplate restTemplate = new RestTemplate();
		RecsResponse resp = restTemplate.postForObject(url, recs, RecsResponse.class);
		return resp;
	}
	
}
