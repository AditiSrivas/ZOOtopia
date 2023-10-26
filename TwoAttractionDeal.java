package org.example;
import java.util.List;

public class TwoAttractionDeal implements SpecialDeal{

    @Override
    public double applyDiscount(List<Attractions> attractions, double originalPrice) {
        if (attractions.size() > 2) {
            return originalPrice * 0.85;
        }
        return originalPrice;
    }

}
