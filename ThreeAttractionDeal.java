package org.example;
import java.util.List;

public class ThreeAttractionDeal implements SpecialDeal{

    @Override
    public double applyDiscount(List<Attractions> attractions, double originalPrice) {
        if (attractions.size() > 3) {
            return originalPrice * 0.7;
        }
        return originalPrice;
    }

}
