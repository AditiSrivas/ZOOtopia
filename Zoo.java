package org.example;
import java.util.*;

public class Zoo {

    private List<Attractions> attractions;
    private VisitorStats stats;
    private Set<Integer> usedAttractionIDs;
    private List<Feedback> visitorFeedbackList;
    private List<Animal> animals;
    private SpecialDeal specialDeal;
    private List<Discount> discounts;

    public Zoo() {
        this.attractions = new ArrayList<>();
        this.stats = new VisitorStats();
        this.usedAttractionIDs = new HashSet<>();
        this.visitorFeedbackList = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.discounts = new ArrayList<>();
    }

    public void addAttraction(Attractions attraction) {
        attractions.add(attraction);
    }
    public List<Attractions> viewAttractions() {
        return attractions;
    }
    public Attractions getAttractionByID(int uniqueID) {
        for (Attractions attraction : attractions) {
            if (attraction.getUniqueID() == uniqueID) {
                return attraction;
            }
        }
        return null;
    }
    public boolean modifyAttraction(int uniqueID, Attractions updatedAttraction) {
        for (Attractions attraction : attractions) {
            if (attraction.getUniqueID() == uniqueID) {

                attraction.setName(updatedAttraction.getName());
                attraction.setDescription(updatedAttraction.getDescription());
                attraction.setTicketPrice(updatedAttraction.getTicketPrice());
                return true;
            }
        }
        return false;
    }
    public boolean removeAttraction(int uniqueID) {
        Attractions attractionToRemove = getAttractionByID(uniqueID);
        if (attractionToRemove != null) {
            attractions.remove(attractionToRemove);
            removeAttractionID(uniqueID);
            return true;
        }
        return false;
    }
    public void removeAttractionID(int uniqueID) {
        usedAttractionIDs.remove(uniqueID);
    }

    public void updateVisitorStats(int visitors, double revenue, List<Attractions> attractions) {
        stats.updateStats(visitors, revenue, attractions);
    }
    public VisitorStats getVisitorStats() {
        return stats;
    }
    public int getNextUniqueID() {
        int nextID = 1;
        while (usedAttractionIDs.contains(nextID)) {
            nextID++;
        }
        usedAttractionIDs.add(nextID);

        return nextID;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
    public List<Animal> getAllAnimals() {
        return animals;
    }
    public void removeAnimal(Animal animal) {
        if (animal != null) {
            int index = animals.indexOf(animal);
            if (index >= 0) {
                animals.remove(index);
            }
        }
    }

    public void addFeedback(Feedback feedback) {
        visitorFeedbackList.add(feedback);
    }
    public List<Feedback> viewFeedback() {
        return visitorFeedbackList;
    }

    public boolean scheduleEvent(int attractionID) {
        Attractions attraction = getAttractionByID(attractionID);
        if (attraction != null) {
            attraction.setOpen(true);
            return true;
        }
        return false;
    }

    public void setSpecialDeal(SpecialDeal specialDeal) {
        this.specialDeal = specialDeal;
    }
    public double applySpecialDeal(List<Attractions> attractions, double originalPrice) {
        if (specialDeal != null) {
            return specialDeal.applyDiscount(attractions, originalPrice);
        }
        return originalPrice;
    }

    public void addDiscount(Discount discount) {
        discounts.add(discount);
    }
    public List<Discount> getDiscounts() {
        return discounts;
    }
    public Discount findDiscountByCategory(String category) {
        for (Discount discount : discounts) {
            if (discount.getDiscountCategory().equalsIgnoreCase(category)) {
                return discount;
            }
        }
        return null;
    }
    public void removeDiscount(String category) {
        Discount discountToRemove = findDiscountByCategory(category);
        if (discountToRemove != null) {
            discounts.remove(discountToRemove);
            System.out.println("Discount removed successfully.");
        } else {
            System.out.println("No discount found with the specified category.");
        }
    }
}
