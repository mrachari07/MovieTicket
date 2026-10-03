package com.Movie.Service;

import com.Movie.model.Coupon;

public class PricingService {
	
	    private static final double WEEKDAY_PRICE = 180.0;
	    private static final double WEEKEND_PRICE = 220.0;

	    public double getBasePrice(boolean isWeekend) {
	        return isWeekend ? WEEKEND_PRICE : WEEKDAY_PRICE;
	    }

	    public double calculateFinalPrice(boolean isWeekend, Coupon coupon) {
	        double price = getBasePrice(isWeekend);
	        if (coupon != null && coupon.isActive()) {
	            price = price - (price * coupon.getDiscountPercent() / 100);
	        }
	        return price;
	    }
	}
