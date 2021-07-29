package com.coronation.nqr.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "nqrcaller")
public class NqrProperties {

	private String merchantStatusQueryInterface;
	private String fixedQrCodePaymentInterface;
	private String dynamicQrCodePaymentInterface;
	private String orderPaymentStatusInterface;
	private String bankCardInformationqueryInterface;
	private String transferTransactionInterface;
	private String generateDynamicQrCodeInterface;
	private String createMerchantInterface;
	private String bindingCollectionAccountInterface;
	private String createSubMerchantInterface;
	private String merchantInformtionQueryInterface;
	private String merchantTransactionRecordQueryInterface;
	private String batchCreateMerchantInterface;
	private String batchCreateSubMerchantInterface;
	private String institutionCode;
	private String key;
	private String performPayment;
	private String transactionSuccessNotificationInterface;
	private String transactionFeeInquiryInterface;
	
	public String getMerchantStatusQueryInterface() {
		return merchantStatusQueryInterface;
	}
	public void setMerchantStatusQueryInterface(String merchantStatusQueryInterface) {
		this.merchantStatusQueryInterface = merchantStatusQueryInterface;
	}
	public String getFixedQrCodePaymentInterface() {
		return fixedQrCodePaymentInterface;
	}
	public void setFixedQrCodePaymentInterface(String fixedQrCodePaymentInterface) {
		this.fixedQrCodePaymentInterface = fixedQrCodePaymentInterface;
	}
	public String getDynamicQrCodePaymentInterface() {
		return dynamicQrCodePaymentInterface;
	}
	public void setDynamicQrCodePaymentInterface(String dynamicQrCodePaymentInterface) {
		this.dynamicQrCodePaymentInterface = dynamicQrCodePaymentInterface;
	}
	public String getOrderPaymentStatusInterface() {
		return orderPaymentStatusInterface;
	}
	public void setOrderPaymentStatusInterface(String orderPaymentStatusInterface) {
		this.orderPaymentStatusInterface = orderPaymentStatusInterface;
	}
	public String getBankCardInformationqueryInterface() {
		return bankCardInformationqueryInterface;
	}
	public void setBankCardInformationqueryInterface(String bankCardInformationqueryInterface) {
		this.bankCardInformationqueryInterface = bankCardInformationqueryInterface;
	}
	public String getTransferTransactionInterface() {
		return transferTransactionInterface;
	}
	public void setTransferTransactionInterface(String transferTransactionInterface) {
		this.transferTransactionInterface = transferTransactionInterface;
	}
	public String getGenerateDynamicQrCodeInterface() {
		return generateDynamicQrCodeInterface;
	}
	public void setGenerateDynamicQrCodeInterface(String generateDynamicQrCodeInterface) {
		this.generateDynamicQrCodeInterface = generateDynamicQrCodeInterface;
	}
	public String getCreateMerchantInterface() {
		return createMerchantInterface;
	}
	public void setCreateMerchantInterface(String createMerchantInterface) {
		this.createMerchantInterface = createMerchantInterface;
	}
	public String getBindingCollectionAccountInterface() {
		return bindingCollectionAccountInterface;
	}
	public void setBindingCollectionAccountInterface(String bindingCollectionAccountInterface) {
		this.bindingCollectionAccountInterface = bindingCollectionAccountInterface;
	}
	public String getCreateSubMerchantInterface() {
		return createSubMerchantInterface;
	}
	public void setCreateSubMerchantInterface(String createSubMerchantInterface) {
		this.createSubMerchantInterface = createSubMerchantInterface;
	}
	public String getMerchantInformtionQueryInterface() {
		return merchantInformtionQueryInterface;
	}
	public void setMerchantInformtionQueryInterface(String merchantInformtionQueryInterface) {
		this.merchantInformtionQueryInterface = merchantInformtionQueryInterface;
	}
	public String getMerchantTransactionRecordQueryInterface() {
		return merchantTransactionRecordQueryInterface;
	}
	public void setMerchantTransactionRecordQueryInterface(String merchantTransactionRecordQueryInterface) {
		this.merchantTransactionRecordQueryInterface = merchantTransactionRecordQueryInterface;
	}
	public String getBatchCreateMerchantInterface() {
		return batchCreateMerchantInterface;
	}
	public void setBatchCreateMerchantInterface(String batchCreateMerchantInterface) {
		this.batchCreateMerchantInterface = batchCreateMerchantInterface;
	}
	public String getBatchCreateSubMerchantInterface() {
		return batchCreateSubMerchantInterface;
	}
	public void setBatchCreateSubMerchantInterface(String batchCreateSubMerchantInterface) {
		this.batchCreateSubMerchantInterface = batchCreateSubMerchantInterface;
	}
	public String getInstitutionCode() {
		return institutionCode;
	}
	public void setInstitutionCode(String institutionCode) {
		this.institutionCode = institutionCode;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getPerformPayment() {
		return performPayment;
	}
	public void setPerformPayment(String performPayment) {
		this.performPayment = performPayment;
	}
	public String getTransactionSuccessNotificationInterface() {
		return transactionSuccessNotificationInterface;
	}
	public void setTransactionSuccessNotificationInterface(String transactionSuccessNotificationInterface) {
		this.transactionSuccessNotificationInterface = transactionSuccessNotificationInterface;
	}
	public String getTransactionFeeInquiryInterface() {
		return transactionFeeInquiryInterface;
	}
	public void setTransactionFeeInquiryInterface(String transactionFeeInquiryInterface) {
		this.transactionFeeInquiryInterface = transactionFeeInquiryInterface;
	}
	
}
