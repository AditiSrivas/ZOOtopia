package org.example;

public class CustomDiscount implements Discount{
    private String discountCategory;
    private double discountPercentage;

    public CustomDiscount(String discountCategory, double discountPercentage) {
        this.discountCategory = discountCategory;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public boolean isEligible(Visitor visitor) {
        return true;
    }

    @Override
    public double getDiscountPercentage() {
        return discountPercentage;
    }

    @Override
    public String getDiscountName() {
        return discountCategory + " Discount";
    }

    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice * (1 - discountPercentage);
    }

    @Override
    public String getDiscountCategory() {
        return discountCategory;
    }

    @Override
    public void setDiscountPercentage(double percentage) {
        this.discountPercentage = percentage;

    }

}

