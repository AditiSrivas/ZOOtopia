package org.example;

public class SeniorDiscount implements Discount{
    private double discountPercentage = 0.20;

    @Override
    public boolean isEligible(Visitor visitor) {
        return visitor.getAge() > 60;
    }
    @Override
    public double getDiscountPercentage() {
        return discountPercentage;
    }
    @Override
    public String getDiscountName() {
        return "Senior Discount";
    }
    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice * (1 - getDiscountPercentage());
    }
    @Override
    public String getDiscountCategory() {
        return "Senior Discount";
    }
    @Override
    public void setDiscountPercentage(double percentage) {
        this.discountPercentage = percentage;

    }
}
