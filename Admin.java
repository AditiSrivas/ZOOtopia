package org.example;
import java.util.*;

public class Admin implements User{
    private String adminUserName = "admin";
    private String adminPassword = "admin123";

    @Override
    public String getName() {
        return this.adminUserName;
    }

    public boolean login(String u_name, String p_wrd) {
        int count = 0;
        while (count<3) {
            if (u_name!=this.adminUserName && p_wrd!=this.adminPassword) {
                count++;
            }
        }
        return true;
    }

    public void viewVisitorStats(Zoo zoo) {
        VisitorStats stats = zoo.getVisitorStats();
        System.out.println("Visitor Statistics:");
        System.out.println("Total Visitors: " + stats.getVisitorCount());
        System.out.println("Total Revenue: $" + stats.getRevenue());

        List<Attractions> popularAttractions = stats.getPopularAttractions();
        System.out.println("Most Popular Attractions:");
        for (Attractions attraction : popularAttractions) {
            System.out.println("- " + attraction.getName());
        }
    }
}
