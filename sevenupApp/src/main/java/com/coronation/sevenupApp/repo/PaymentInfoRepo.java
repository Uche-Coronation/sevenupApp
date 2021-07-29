package com.coronation.sevenupApp.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.coronation.sevenupApp.model.PaymentInfo;

public interface PaymentInfoRepo extends JpaRepository<PaymentInfo, Integer>{

	public PaymentInfo findByPaymentReference(String paymentReference);
	public Page<PaymentInfo> findByCustomerRegionCode(String customerregionCode, Pageable pageable);
	public Page<PaymentInfo> findByCustomerRegionName(String customerRegionName, Pageable pageable);
	public List<PaymentInfo> findByCustomerRegionName(String customerRegionName);
}
