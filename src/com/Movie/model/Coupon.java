package com.Movie.model;

public class Coupon {
	
    private String couponCode;
    private double discountPercent;
    private boolean active;
    private String expiryDate;

    public Coupon(String couponCode, double discountPercent, boolean active, String expiryDate) {
        this.couponCode = couponCode;
        this.discountPercent = discountPercent;
        this.active = active;
        this.expiryDate = expiryDate;
    }

    public String getCouponCode() { return couponCode; }
    public double getDiscountPercent() { return discountPercent; }
    public boolean isActive() { return active; }
    public String getExpiryDate() { return expiryDate; }

}
