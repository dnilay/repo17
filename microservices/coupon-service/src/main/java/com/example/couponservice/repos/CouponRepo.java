package com.example.couponservice.repos;

import com.example.couponservice.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CouponRepo extends JpaRepository<Coupon, Long> {

	public Coupon findByCode(String code);

}
