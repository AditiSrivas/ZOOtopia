package org.example;

public class BasicMembership implements Membership{
    private int counter = 0;
    @Override
    public boolean canAccessAttraction(Attractions attraction) {
        return false;
    }
    @Override
    public int getCounter() {
        return counter;
    }

}
