package org.example;

public class PremiumMembership implements Membership{
    private int counter = 1;
    @Override
    public boolean canAccessAttraction(Attractions attraction) {
        return true;
    }
    @Override
    public int getCounter() {
        return counter;
    }
}
