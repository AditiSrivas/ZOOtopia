package org.example;
import java.util.*;

public class VisitorStats {
    private int totalVisitors;
    private double totalRevenue;
    private List<Attractions> popularAttractions;
    private Map<Attractions, Integer> interactionsCount;

    public VisitorStats() {
        this.totalVisitors = 0;
        this.totalRevenue = 0.0;
        this.popularAttractions = new ArrayList<>();
        this.interactionsCount = new HashMap<>();
    }

    public void updateStats(int visitors, double revenue, List<Attractions> attractions) {
        this.totalVisitors += visitors;
        this.totalRevenue += revenue;
        updatePopularAttractions(attractions);
        updateInteractionsCount(attractions);
    }

    public void updatePopularAttractions(List<Attractions> attractions) {
        popularAttractions.clear();

        interactionsCount.forEach((attraction, interactions) -> {
            if (interactions > 10) {
                popularAttractions.add(attraction);
            }
        });
    }

    private void updateInteractionsCount(List<Attractions> attractions) {
        for (Attractions attraction : attractions) {
            int interactions = interactionsCount.getOrDefault(attraction, 0);
            interactionsCount.put(attraction, interactions + 1);
        }
    }

    public int getVisitorCount() {
        return totalVisitors;
    }

    public double getRevenue() {
        return totalRevenue;
    }

    public List<Attractions> getPopularAttractions() {
        return popularAttractions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Visitor Statistics:");
        sb.append("\n- Total Visitors: ").append(totalVisitors);
        sb.append("\n- Total Revenue: $").append(totalRevenue);
        sb.append("\n- Most Popular Attraction: ");

        if (!popularAttractions.isEmpty()) {
            sb.append(popularAttractions.get(0).getName()); // Assuming the first popular attraction is the most popular
        } else {
            sb.append("No popular attractions yet.");
        }

        return sb.toString();
    }
}