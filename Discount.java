package org.example;

public interface Discount {
    boolean isEligible(Visitor visitor);
    double getDiscountPercentage();
    String getDiscountName();
    double applyDiscount(double originalPrice);
    String getDiscountCategory();
    void setDiscountPercentage(double percentage);
}
