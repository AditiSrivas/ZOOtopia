package org.example;

public class MinorDiscount implements Discount{
    private double discountPercentage = 0.10;

    @Override
    public boolean isEligible(Visitor visitor) {
        return visitor.getAge() < 18;
    }
    @Override
    public double getDiscountPercentage() {
        return discountPercentage;
    }
    @Override
    public String getDiscountName() {
        return "Minor Discount";
    }
    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice * (1 - getDiscountPercentage());
    }
    @Override
    public String getDiscountCategory() {
        return "Minor Discount";
    }
    @Override
    public void setDiscountPercentage(double percentage) {
        this.discountPercentage = percentage;

    }
}
