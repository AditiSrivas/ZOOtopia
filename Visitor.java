package org.example;
import java.util.*;

public class Visitor implements User{
    private String password;
    private String name;
    private int age;
    private String phoneNumber;
    private double balance;
    private String email;
    private Membership membership;
    private List<Attractions> purchasedAttractions;

    public Visitor(String password, String name, int age, String phoneNumber, double balance, String email) {
        this.password = password;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.email = email;
        this.purchasedAttractions = new ArrayList<>();
    }

    public String getPassword() {
        return password;
    }
    @Override
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public double getBalance() {
        return balance;
    }
    public String getEmail() {
        return email;
    }

    public double setBalance(double balance) {
        this.balance = balance;
        return balance;
    }

    @Override
    public boolean login(String enteredEmail, String enteredPassword) {
        return this.email.equals(enteredEmail) && this.password.equals(enteredPassword);
    }

    public double applyDiscount(Discount discount, double originalPrice) {
        if (discount.isEligible(this)) {
            double discountedPrice = originalPrice * (1 - discount.getDiscountPercentage());
            return discountedPrice;
        } else {
            return originalPrice;
        }
    }

    public boolean hasTicket(Attractions attraction) {
        return purchasedAttractions.contains(attraction);
    }
    public List<Attractions> getPurchasedAttractions() {
        return purchasedAttractions;
    }

    public void purchasePremiumMembership() {
        this.membership = new PremiumMembership();
    }
    public void purchaseBasicMembership() {
        this.membership = new BasicMembership();
    }
    public boolean canAccessAttraction(Attractions attraction) {
        if (membership.getCounter() == 1){
            return membership.canAccessAttraction(attraction);
        } else if (membership.getCounter() == 0 || hasTicket(attraction)) {
            return true;
        }
        return false;
    }

    public void purchaseTicket(Attractions attraction) {
        if (purchasedAttractions.contains(attraction)) {
            System.out.println("You have already purchased a ticket for this attraction.");
            return;
        }

        double ticketPrice = attraction.getTicketPrice();

        Discount discount = attraction.getDiscount();

        if (discount.isEligible(this)) {
            double discountedPrice = discount.applyDiscount(ticketPrice);
            if (discountedPrice > balance) {
                System.out.println("Insufficient balance to purchase this ticket with a discount.");
                return;
            }
            balance -= discountedPrice;
            purchasedAttractions.add(attraction);
            System.out.println("Ticket for " + attraction.getName() + " purchased with a discount.");
        } else {
            if (ticketPrice > balance) {
                System.out.println("Insufficient balance to purchase this ticket.");
                return;
            }
            balance -= ticketPrice;
            purchasedAttractions.add(attraction);
            System.out.println("Ticket for " + attraction.getName() + " purchased.");
        }
    }
}
