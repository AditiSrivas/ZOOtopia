package org.example;

public class Attractions {
    private int uniqueID;
    private String name;
    private String description;
    private double ticketPrice;
    private Discount discount;
    private boolean isOpen;

    public Attractions(int uniqueID, String name, String description, double ticketPrice) {
        this.uniqueID = uniqueID;
        this.name = name;
        this.description = description;
        this.ticketPrice = ticketPrice;
        this.isOpen = false;
    }

    public int getUniqueID() {
        return uniqueID;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getTicketPrice() {
        return ticketPrice;
    }
    public Discount getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public boolean isOpen() {
        return isOpen;
    }
    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
}
