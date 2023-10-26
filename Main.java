package org.example;
import java.util.*;

public class Main {

    private static List<Visitor> registeredVisitors = new ArrayList<>();

    private static Visitor findVisitor(List<Visitor> visitors, String email) {
        for (Visitor visitor : visitors) {
            if (visitor.getName().equals(email)) {
                return visitor;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Zoo zoo = new Zoo();

        System.out.println("Welcome to ZOOtopia!\n");
        boolean choice = true;

        while(choice) {
            System.out.println("1. Enter as Admin\n"
                    + "2. Enter as Visitor\n"
                    + "3. View Special Deals\n");
            int loginChoice = sc.nextInt();
            switch(loginChoice) {
                //Enter as Admin
                case 1:
                    System.out.println("Enter Admin Username");
                    String u_name = sc.nextLine();
                    System.out.println("Enter Admin Password");
                    String p_wrd = sc.nextLine();

                    Admin admin = new Admin();
                    if (admin.login(u_name, p_wrd)) {
                        System.out.println("Logged in as Admin\n");

                        boolean adminMenu = true;

                        while (adminMenu) {
                            System.out.println("Admin Menu: \n"
                                    + "1. Manage Attractions\n"
                                    + "2. Manage Animals\n"
                                    + "3. Schedule Events\n"
                                    + "4. Set Discounts\n"
                                    + "5. Set Special Deals\n"
                                    + "6. View Visitor Stats\n"
                                    + "7. View Feedback\n"
                                    + "8. Exit\n");
                            int adminChoice = sc.nextInt();

                            switch (adminChoice) {
                                //Manage Attractions
                                case 1:
                                    boolean manageAttractionsMenu = true;

                                    while (manageAttractionsMenu) {
                                        System.out.println("1. Add Attractions\n"
                                                + "2. View Attraction\n"
                                                + "3. Modify Attraction\n"
                                                + "4. Remove Attraction\n"
                                                + "5. Exit\n");
                                        int attractionsMenuChoice = sc.nextInt();

                                        switch (attractionsMenuChoice) {
                                            //Add Attractions
                                            case 1:
                                                sc.nextLine();
                                                System.out.print("Enter the name of the attraction: ");
                                                String attractionName = sc.nextLine();
                                                System.out.print("Enter the description of the attraction: ");
                                                String attractionDescription = sc.nextLine();
                                                System.out.print("Enter the ticket price for the attraction: ");
                                                double ticketPrice = sc.nextDouble();

                                                // Create a new Attractions object
                                                int nextUniqueID = zoo.getNextUniqueID();
                                                Attractions newAttraction = new Attractions(nextUniqueID, attractionName, attractionDescription, ticketPrice);
                                                zoo.addAttraction(newAttraction);

                                                System.out.println("Attraction added successfully.");
                                                break;

                                            //View Attractions
                                            case 2:
                                                List<Attractions> allAttractions = zoo.viewAttractions();

                                                if (allAttractions.isEmpty()) {
                                                    System.out.println("No attractions available.");
                                                } else {
                                                    System.out.println("List of available attractions:");
                                                    for (Attractions attraction : allAttractions) {
                                                        System.out.println("Attraction ID: " + attraction.getUniqueID());
                                                        System.out.println("Name: " + attraction.getName());
                                                        System.out.println("Description: " + attraction.getDescription());
                                                        System.out.println("Ticket Price: Rs. " + attraction.getTicketPrice());
                                                        System.out.println();
                                                    }
                                                }
                                                break;

                                            //Modify Attractions
                                            case 3:
                                                System.out.print("Enter the unique ID of the attraction you want to modify: ");
                                                int attractionIDToModify = sc.nextInt();
                                                sc.nextLine();
                                                Attractions attractionToModify = zoo.getAttractionByID(attractionIDToModify);

                                                if (attractionToModify != null) {
                                                    System.out.println("Current Details of Attraction " + attractionToModify.getName() + ":");
                                                    System.out.println("Name: " + attractionToModify.getName());
                                                    System.out.println("Description: " + attractionToModify.getDescription());
                                                    System.out.println("Ticket Price: Rs. " + attractionToModify.getTicketPrice());

                                                    System.out.print("Enter the new name of the attraction: ");
                                                    String newName = sc.nextLine();
                                                    System.out.print("Enter the new description of the attraction: ");
                                                    String newDescription = sc.nextLine();
                                                    System.out.print("Enter the new ticket price for the attraction: Rs. ");
                                                    double newTicketPrice = sc.nextDouble();

                                                    Attractions updatedAttraction = new Attractions(attractionIDToModify, newName, newDescription, newTicketPrice);

                                                    boolean modificationResult = zoo.modifyAttraction(attractionIDToModify, updatedAttraction);

                                                    if (modificationResult) {
                                                        System.out.println("Attraction details modified successfully.");
                                                    } else {
                                                        System.out.println("Failed to modify attraction. Please check the attraction ID.");
                                                    }
                                                } else {
                                                    System.out.println("Attraction with the specified ID does not exist.");
                                                }
                                                break;

                                            //Remove Attractions
                                            case 4:
                                                System.out.print("Enter the unique ID of the attraction you want to remove: ");
                                                int attractionIDToRemove = sc.nextInt();
                                                boolean removalResult = zoo.removeAttraction(attractionIDToRemove);

                                                if (removalResult) {
                                                    System.out.println("Attraction with ID " + attractionIDToRemove + " has been removed successfully.");
                                                } else {
                                                    System.out.println("Failed to remove attraction. Please check the attraction ID.");
                                                }
                                                break;

                                            //Exit
                                            case 5:
                                                manageAttractionsMenu = false;
                                                break;

                                            default:
                                                System.out.println("Invalid choice selected. Please select a valid option");
                                        }
                                    }
                                    break;

                                //Manage Animals
                                case 2:
                                    boolean manageAnimalsMenu = true;

                                    while (manageAnimalsMenu) {
                                        System.out.println("1. Add Animal\n"
                                                + "2. Update Animal Details\n"
                                                + "3. Remove Animal\n"
                                                + "4. Exit\n");
                                        int animalMenuChoice = sc.nextInt();

                                        switch(animalMenuChoice) {
                                            //Add Animal
                                            case 1:
                                                boolean animalTypeMenu = true;

                                                while (animalTypeMenu) {
                                                    System.out.println("Select the type of animal to be added: \n"
                                                            + "1. Mammal\n"
                                                            + "2. Amphibian\n"
                                                            + "3. Reptile\n");
                                                    int animalTypeChoice = sc.nextInt();
                                                    sc.nextLine();

                                                    switch (animalTypeChoice) {
                                                        //Mammal
                                                        case 1:
                                                            System.out.println("Enter the name of the mammal: ");
                                                            String mammalName = sc.nextLine();
                                                            System.out.println("Enter the sound of the mammal: ");
                                                            String mammalSound = sc.nextLine();
                                                            System.out.println("Enter the animal history");
                                                            String mammalHistory = sc.nextLine();

                                                            Mammal newMammal = new Mammal(mammalName, mammalSound, mammalHistory);
                                                            zoo.addAnimal(newMammal);
                                                            break;

                                                        //Amphibian
                                                        case 2:
                                                            System.out.println("Enter the name of the amphibian: ");
                                                            String amphibianName = sc.nextLine();
                                                            System.out.println("Enter the sound of the mammal: ");
                                                            String amphibianSound = sc.nextLine();
                                                            System.out.println("Enter the animal history");
                                                            String amphibianHistory = sc.nextLine();

                                                            Mammal newAmphibian = new Mammal(amphibianName, amphibianSound, amphibianHistory);
                                                            zoo.addAnimal(newAmphibian);
                                                            break;

                                                        //Reptile
                                                        case 3:
                                                            System.out.println("Enter the name of the reptile: ");
                                                            String reptileName = sc.nextLine();
                                                            System.out.println("Enter the sound of the mammal: ");
                                                            String reptileSound = sc.nextLine();
                                                            System.out.println("Enter the animal history");
                                                            String reptileHistory = sc.nextLine();

                                                            Mammal newReptile = new Mammal(reptileName, reptileSound, reptileHistory);
                                                            zoo.addAnimal(newReptile);
                                                            break;

                                                        default:
                                                            System.out.println("Invalid choice selected. Please select a valid option");
                                                    }
                                                }
                                                break;

                                            //Update Animal Details
                                            case 2:
                                                break;

                                            //Remove Animal
                                            case 3:
                                                System.out.println("Select an animal to remove:");
                                                List<Animal> allAnimals = zoo.getAllAnimals();
                                                for (int i = 0; i < allAnimals.size(); i++) {
                                                    System.out.println((i + 1) + ". " + allAnimals.get(i).getName());
                                                }
                                                int selectedAnimalIndex = sc.nextInt() - 1;
                                                sc.nextLine();

                                                if (selectedAnimalIndex >= 0 && selectedAnimalIndex < allAnimals.size()) {
                                                    Animal animalToRemove = allAnimals.get(selectedAnimalIndex);
                                                    zoo.removeAnimal(animalToRemove);
                                                    System.out.println(animalToRemove.getName() + " has been removed from the zoo.");
                                                } else {
                                                    System.out.println("Invalid animal selection.");
                                                }
                                                break;

                                            //Exit
                                            case 4:
                                                manageAnimalsMenu = false;
                                                break;

                                            default:
                                                System.out.println("Invalid choice selected. Please select a valid option");
                                        }
                                    }
                                    break;

                                //Schedule Events
                                case 3:
                                    System.out.println("Enter the unique ID of the attraction to schedule an event:");
                                    int attractionID = sc.nextInt();
                                    sc.nextLine();

                                    Attractions attraction = zoo.getAttractionByID(attractionID);
                                    if (attraction != null) {
                                        attraction.setOpen(true);
                                        System.out.println("Event scheduled successfully for " + attraction.getName());
                                    } else {
                                        System.out.println("Attraction with ID " + attractionID + " does not exist.");
                                    }
                                    break;

                                //Set DIscounts
                                case 4:
                                    boolean setDiscountMenu = true;

                                    while (setDiscountMenu) {
                                        System.out.println("1. Add Discount\n"
                                                + "2. Modify Discount\n"
                                                + "3. Remove Discount\n"
                                                + "4. Exit\n");
                                        int discountMenuChoice = sc.nextInt();

                                        switch (discountMenuChoice) {
                                            //Add Discount
                                            case 1:
                                                System.out.println("Adding a New Discount");

                                                System.out.print("Enter Discount Category: ");
                                                String discountCategory = sc.nextLine();
                                                System.out.print("Enter Discount Percentage (e.g., 0.15 for 15%): ");
                                                double discountPercentage = sc.nextDouble();
                                                sc.nextLine();

                                                Discount newDiscount = new CustomDiscount(discountCategory, discountPercentage);
                                                zoo.addDiscount(newDiscount);

                                                System.out.println("Discount added successfully.");
                                                break;

                                            //Modify Discount
                                            case 2:
                                                System.out.println("Modify Discount:");
                                                System.out.print("Enter the Discount Category you want to modify: ");
                                                String discountCategoryToModify = sc.nextLine();

                                                Discount existingDiscount = zoo.findDiscountByCategory(discountCategoryToModify);

                                                if (existingDiscount != null) {
                                                    System.out.print("Enter the new Discount Percentage (e.g., 20 for 20%): ");
                                                    double newDiscountPercentage = sc.nextDouble();
                                                    sc.nextLine();

                                                    existingDiscount.setDiscountPercentage(newDiscountPercentage);
                                                    System.out.println("Discount has been modified successfully.");
                                                } else {
                                                    System.out.println("No discount found with the provided category.");
                                                }
                                                break;

                                            //Remove Discount
                                            case 3:
                                                System.out.println("Enter the category of the discount to remove: ");
                                                String categoryToRemove = sc.nextLine();
                                                zoo.removeDiscount(categoryToRemove);
                                                break;

                                            //Exit
                                            case 4:
                                                setDiscountMenu = false;
                                                break;

                                            default:
                                                System.out.println("Invalid choice selected. Please select a valid option");
                                        }
                                    }

                                    break;

                                //Set Special Deals
                                case 5:
                                    System.out.println("Choose a special deal:");
                                    System.out.println("1. Two Attraction Deal (15% off if visiting more than 2 attractions)");
                                    System.out.println("2. Three Attraction Deal (30% off if visiting more than 3 attractions)");
                                    int dealChoice = sc.nextInt();
                                    sc.nextLine();

                                    switch (dealChoice) {
                                        case 1:
                                            // Apply the Two Attraction Deal
                                            SpecialDeal twoAttractionDeal = new TwoAttractionDeal();
                                            zoo.setSpecialDeal(twoAttractionDeal);
                                            System.out.println("Two Attraction Deal has been set.");
                                            break;
                                        case 2:
                                            // Apply the Three Attraction Deal
                                            SpecialDeal threeAttractionDeal = new ThreeAttractionDeal();
                                            zoo.setSpecialDeal(threeAttractionDeal);
                                            System.out.println("Three Attraction Deal has been set.");
                                            break;
                                        default:
                                            System.out.println("Invalid choice. Please select a valid option.");
                                    }
                                    break;

                                //View Visitor Stats
                                case 6:
                                    admin.viewVisitorStats(zoo);
                                    break;

                                //View Feedback
                                case 7:
                                    List<Feedback> feedbackList = zoo.viewFeedback();
                                    if (feedbackList.isEmpty()) {
                                        System.out.println("No feedback available.");
                                    } else {
                                        System.out.println("Visitor Feedback:");
                                        for (Feedback feedback : feedbackList) {
                                            System.out.println("Visitor: " + feedback.getVisitorName());
                                            System.out.println("Feedback: " + feedback.getFeedbackContent());
                                            System.out.println("Date: " + feedback.getFeedbackDate());
                                            System.out.println();
                                        }
                                    }
                                    break;

                                //Exit
                                case 8:
                                    adminMenu = false;
                                    break;

                                default:
                                    System.out.println("Invalid choice selected. Please select a valid option");
                            }
                        }

                    }else {
                        System.out.println("Incorrect username and password. (3 trials exhauseted)");
                    }
                    break;

                //Enter as Visitor
                case 2:
                    boolean visitorRegisterLoginMenu = true;

                    while (visitorRegisterLoginMenu) {
                        System.out.println("1. Register\n"
                                + "2. Login\n");
                        int registerLoginChoice = sc.nextInt();

                        switch(registerLoginChoice) {
                            //Register
                            case 1:
                                sc.nextLine();
                                System.out.println("Enter Visitor Name: ");
                                String v_name = sc.nextLine();

                                System.out.println("Enter Visitor Age: ");
                                int v_age = sc.nextInt();
                                sc.nextLine();

                                System.out.println("Enter Visitor Phone Number: ");
                                String v_phoneNumber = sc.nextLine();

                                System.out.println("Enter Visitor Balance: ");
                                int v_balance = sc.nextInt();
                                sc.nextLine();

                                System.out.println("Enter Visitor Email: ");
                                String v_email = sc.nextLine();

                                System.out.println("Enter Visitor Password: ");
                                String v_password = sc.nextLine();

                                Visitor visitor = new Visitor(v_password, v_name, v_age, v_phoneNumber, v_balance, v_email);
                                registeredVisitors.add(visitor);

                                System.out.println("Registration is successful");
                                break;

                            //Log-in
                            case 2:
                                System.out.println("Enter visitor email");
                                String v_login_email = sc.nextLine();

                                System.out.println("Enter visitor password");
                                String v_login_password = sc.nextLine();

                                Visitor newVisitor = findVisitor(registeredVisitors, v_login_email);
                                if (newVisitor != null && newVisitor.login(v_login_email, v_login_password)) {
                                    System.out.println("Login Successful.");
                                    List<Feedback> feedbackList = new ArrayList<>();

                                    boolean visitorMenu = true;
                                    while (visitorMenu) {
                                        System.out.println("Visitor Menu: \n"
                                                + "1. Explore the Zoo\n"
                                                + "2. Buy Membership\n"
                                                + "3. Buy Tickets\n"
                                                + "4. View Discounts\n"
                                                + "5. View Special Deals\n"
                                                + "6. Visit Animals\n"
                                                + "7. Visit Attractions\n"
                                                + "8. Leave Feedback\n"
                                                + "9. Log-Out\n");
                                        int visitorMenuChoice = sc.nextInt();

                                        switch(visitorMenuChoice) {
                                            //Explore the Zoo
                                            case 1:
                                                boolean exploreZooMenu = true;

                                                while(exploreZooMenu) {
                                                    System.out.println("1. View Attractions\n"
                                                            + "2. View Animals\n"
                                                            + "3. Exit\n");
                                                    int exploreZooChoice = sc.nextInt();
                                                    sc.nextLine();

                                                    switch (exploreZooChoice) {
                                                        //View Attractions
                                                        case 1:
                                                            List<Attractions> attractions = zoo.viewAttractions();
                                                            System.out.println("Attractions in the Zoo:");
                                                            for (int i = 0; i < attractions.size(); i++) {
                                                                System.out.println((i + 1) + ". " + attractions.get(i).getName());
                                                            }
                                                            System.out.println("Enter your choice (1-" + attractions.size() + "):");
                                                            int attractionChoice = sc.nextInt();
                                                            sc.nextLine();

                                                            if (attractionChoice >= 1 && attractionChoice <= attractions.size()) {
                                                                Attractions selectedAttraction = attractions.get(attractionChoice - 1);
                                                                System.out.println(selectedAttraction.getDescription());
                                                            } else {
                                                                System.out.println("Invalid choice. Please select a valid attraction.");
                                                            }
                                                            break;

                                                        //View Animals
                                                        case 2:
                                                            List<Animal> animals = zoo.getAllAnimals();
                                                            if (animals.isEmpty()) {
                                                                System.out.println("There are no animals in the zoo.");
                                                            } else {
                                                                System.out.println("View Animals:");
                                                                System.out.println("Animal Types:");
                                                                Set<String> animalTypes = new HashSet<>();

                                                                for (Animal animal : animals) {
                                                                    animalTypes.add(animal.getAnimalType());
                                                                }

                                                                int typeCounter = 1;
                                                                for (String animalType : animalTypes) {
                                                                    System.out.println(typeCounter + ". " + animalType);
                                                                    typeCounter++;
                                                                }

                                                                System.out.println("Enter the number of the animal type you want to explore:");

                                                                int selectedType = sc.nextInt();
                                                                sc.nextLine();

                                                                if (selectedType >= 1 && selectedType <= animalTypes.size()) {
                                                                    String selectedAnimalType = (String) animalTypes.toArray()[selectedType - 1];

                                                                    List<Animal> animalsOfType = new ArrayList<>();
                                                                    for (Animal animal : animals) {
                                                                        if (animal.getAnimalType().equals(selectedAnimalType)) {
                                                                            animalsOfType.add(animal);
                                                                        }
                                                                    }

                                                                    if (!animalsOfType.isEmpty()) {
                                                                        System.out.println("Animals of type: " + selectedAnimalType);
                                                                        int animalCounter = 1;
                                                                        for (Animal animal : animalsOfType) {
                                                                            System.out.println(animalCounter + ". " + animal.getName());
                                                                            animalCounter++;
                                                                        }
                                                                        System.out.println("Enter the number of the animal you want to explore:");

                                                                        int selectedAnimal = sc.nextInt();
                                                                        sc.nextLine();

                                                                        if (selectedAnimal >= 1 && selectedAnimal <= animalsOfType.size()) {
                                                                            Animal selectedAnimalObj = animalsOfType.get(selectedAnimal - 1);

                                                                            System.out.println("Name: " + selectedAnimalObj.getName());
                                                                            System.out.println("Type: " + selectedAnimalObj.getAnimalType());
                                                                            System.out.println("Sound: " + selectedAnimalObj.makeSound());
                                                                            System.out.println("History: " + selectedAnimalObj.getAnimalHistory());
                                                                        } else {
                                                                            System.out.println("Invalid choice. Please select a valid animal.");
                                                                        }
                                                                    } else {
                                                                        System.out.println("There are no animals of the selected type in the zoo.");
                                                                    }
                                                                } else {
                                                                    System.out.println("Invalid choice. Please select a valid animal type.");
                                                                }
                                                            }
                                                            break;

                                                        //Exit
                                                        case 3:
                                                            exploreZooMenu = false;
                                                            break;

                                                        default:
                                                            System.out.println("Invalid choice selected. Please select a valid option");
                                                    }
                                                }
                                                break;

                                            //Buy Membership
                                            case 2:
                                                boolean membershipMenu = true;

                                                while(membershipMenu) {
                                                    System.out.println("Buy Membership: \n"
                                                            + "1. Basic Membership (Rs. 20)\n"
                                                            + "2. Premium Membership (Rs. 50)\n");

                                                    int membershipMenuChoice = sc.nextInt();
                                                    sc.nextLine();

                                                    switch (membershipMenuChoice) {
                                                        //Basic Membership
                                                        case 1:
                                                            if (newVisitor.getBalance() >= 20) {
                                                                newVisitor.purchaseBasicMembership();
                                                                newVisitor.setBalance(newVisitor.getBalance() - 20);
                                                                System.out.println("Basic Membership purchased successfully. Your balance is now ₹" + newVisitor.getBalance());
                                                            } else {
                                                                System.out.println("Insufficient balance to purchase Basic Membership.");
                                                            }
                                                            break;

                                                        //Premium Membership
                                                        case 2:
                                                            if (newVisitor.getBalance() >= 50) {
                                                                newVisitor.purchasePremiumMembership();
                                                                newVisitor.setBalance(newVisitor.getBalance() - 50);
                                                                System.out.println("Premium Membership purchased successfully. Your balance is now ₹" + newVisitor.getBalance());
                                                            } else {
                                                                System.out.println("Insufficient balance to purchase Premium Membership.");
                                                            }
                                                            break;

                                                        default:
                                                            System.out.println("Invalid choice selected. Please select a valid option");
                                                    }

                                                }
                                                break;

                                            // Buy Tickets
                                            case 3:
                                                boolean purchaseTicketsMenu = true;
                                                while (purchaseTicketsMenu) {
                                                    System.out.println("Available Attractions: ");
                                                    List<Attractions> availableAttractions = zoo.viewAttractions();
                                                    int attractionIndex = 1;

                                                    for (Attractions attraction : availableAttractions) {
                                                        System.out.println(attractionIndex + ". " + attraction.getName() + " (Rs. " + attraction.getTicketPrice() + ")");
                                                        attractionIndex++;
                                                    }
                                                    System.out.println(attractionIndex + ". Go Back");

                                                    int selectedAttractionIndex = sc.nextInt();
                                                    sc.nextLine();

                                                    if (selectedAttractionIndex == attractionIndex) {
                                                        purchaseTicketsMenu = false;
                                                    } else if (selectedAttractionIndex > 0 && selectedAttractionIndex <= availableAttractions.size()) {
                                                        Attractions selectedAttraction = availableAttractions.get(selectedAttractionIndex - 1);

                                                        if (newVisitor.canAccessAttraction(selectedAttraction)) {
                                                            System.out.println("You have access to " + selectedAttraction.getName() + ". No ticket required.");
                                                        } else {
                                                            double ticketPrice = selectedAttraction.getTicketPrice();
                                                            double discountedPrice = ticketPrice;

                                                            // Apply Minor Discount if eligible
                                                            Discount minorDiscount = new MinorDiscount();
                                                            if (minorDiscount.isEligible(newVisitor)) {
                                                                discountedPrice = minorDiscount.applyDiscount(discountedPrice);
                                                            }

                                                            // Apply Senior Discount if eligible
                                                            Discount seniorDiscount = new SeniorDiscount();
                                                            if (seniorDiscount.isEligible(newVisitor)) {
                                                                discountedPrice = seniorDiscount.applyDiscount(discountedPrice);
                                                            }

                                                            // Apply Special Deals
                                                            SpecialDeal twoAttractionDeal = new TwoAttractionDeal();
                                                            discountedPrice = twoAttractionDeal.applyDiscount(newVisitor.getPurchasedAttractions(), discountedPrice);

                                                            SpecialDeal threeAttractionDeal = new ThreeAttractionDeal();
                                                            discountedPrice = threeAttractionDeal.applyDiscount(newVisitor.getPurchasedAttractions(), discountedPrice);

                                                            System.out.println("The ticket price for " + selectedAttraction.getName() + " is: Rs. " + ticketPrice);
                                                            System.out.println("Your discounted price is: Rs. " + discountedPrice);
                                                            System.out.println("Do you want to purchase a ticket? (1 for Yes, 2 for No)");

                                                            int purchaseChoice = sc.nextInt();
                                                            sc.nextLine();

                                                            if (purchaseChoice == 1) {
                                                                if (discountedPrice <= newVisitor.getBalance()) {
                                                                    newVisitor.purchaseTicket(selectedAttraction);
                                                                    System.out.println("You purchased a ticket for " + selectedAttraction.getName() + " for Rs. " + discountedPrice);
                                                                } else {
                                                                    System.out.println("Insufficient balance to purchase this ticket.");
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println("Invalid selection.");
                                                    }
                                                }
                                                break;

                                            //View Discounts
                                            case 4:
                                                System.out.println("View Discounts: \n"
                                                        + "1. Minor (10% discount) - MINOR10\n"
                                                        + "2. Senior Citizen (20% discount) - SENIOR20\n");
                                                break;

                                            //View Special Deals
                                            case 5:
                                                System.out.println("Special Deals: \n"
                                                        + "1. Buy 2 tickets and get 15% off\n"
                                                        + "2. Buy 3 tickets and get 30% off\n");
                                                break;

                                            //Visit Animals
                                            case 6:
                                                boolean visitAnimalMenu = true;
                                                while (visitAnimalMenu) {
                                                    System.out.println("Select an animal to visit:");

                                                    // Provide a list of animals
                                                    List<Animal> animals = new ArrayList<>(); // Add the animals to this list
                                                    int animalIndex = 1;
                                                    for (Animal animal : animals) {
                                                        System.out.println(animalIndex + ". " + animal.getName());
                                                        animalIndex++;
                                                    }
                                                    System.out.println("0. Go back");

                                                    int selectedAnimalIndex = sc.nextInt();
                                                    sc.nextLine();

                                                    if (selectedAnimalIndex == 0) {
                                                        visitAnimalMenu = false;
                                                    } else if (selectedAnimalIndex > 0 && selectedAnimalIndex <= animals.size()) {
                                                        Animal selectedAnimal = animals.get(selectedAnimalIndex - 1);

                                                        System.out.println("1. Feed the animal");
                                                        System.out.println("2. Read about the animal");
                                                        System.out.println("3. Go back");
                                                        int animalActionChoice = sc.nextInt();

                                                        switch (animalActionChoice) {
                                                            case 1:
                                                                // Feed the animal
                                                                String animalSound = selectedAnimal.makeSound();
                                                                System.out.println("You fed the " + selectedAnimal.getName() + ". It makes a sound: " + animalSound);
                                                                break;
                                                            case 2:
                                                                // Read about the animal
                                                                String animalHistory = selectedAnimal.getAnimalHistory();
                                                                System.out.println("About " + selectedAnimal.getName() + ": " + animalHistory);
                                                                break;
                                                            case 3:
                                                                visitAnimalMenu = false;
                                                                break;

                                                            default:
                                                                System.out.println("Invalid choice selected. Please select a valid option");
                                                        }
                                                    } else {
                                                        System.out.println("Invalid selection.");
                                                    }
                                                }
                                                break;

                                            //Visit Attractions
                                            case 7:
                                                boolean attractionMenu = true;

                                                while (attractionMenu) {
                                                    System.out.println("Attractions in the zoo:");
                                                    List<Attractions> availableAttractions = zoo.viewAttractions();

                                                    int attractionIndex = 1;
                                                    for (Attractions attraction : availableAttractions) {
                                                        System.out.println(attractionIndex + ". " + attraction.getName());
                                                        attractionIndex++;
                                                    }

                                                    System.out.println(attractionIndex + ". Go Back");
                                                    System.out.print("Enter the number of the attraction you want to visit: ");
                                                    int selectedAttractionIndex = sc.nextInt();
                                                    sc.nextLine();

                                                    if (selectedAttractionIndex == attractionIndex) {
                                                        attractionMenu = false;
                                                    } else if (selectedAttractionIndex > 0 && selectedAttractionIndex <= availableAttractions.size()) {
                                                        Attractions selectedAttraction = availableAttractions.get(selectedAttractionIndex - 1);

                                                        System.out.println("ZOOtopia offers an adventure ride that allows you to explore unexplored trails.");
                                                        System.out.println("Buy your ticket now for " + selectedAttraction.getName() + "!");
                                                    } else {
                                                        System.out.println("Invalid selection.");
                                                    }
                                                }
                                                break;

                                            //Leave Feedback
                                            case 8:
                                                System.out.println("Enter your name: ");
                                                sc.nextLine();
                                                String visitorName = sc.nextLine();

                                                System.out.println("Enter your feedback (200 characters max): ");
                                                String feedbackContent = sc.nextLine();

                                                Feedback feedback = new Feedback(visitorName, feedbackContent);
                                                feedbackList.add(feedback);
                                                System.out.println("Thank you for your feedback!");
                                                break;

                                            //Log-Out
                                            case 9:
                                                System.out.println("Logging Out!");
                                                visitorMenu = false;
                                                break;

                                            default:
                                                System.out.println("Invalid choice selected. Please select a valid option");

                                        }
                                    }

                                } else {
                                    System.out.println("No such visitor found.");
                                }
                                break;
                        }
                    }

                    break;

                //View Special Deals
                case 3:
                    System.out.println("Special Deals:\n"
                            +"1. Buy 2 tickets and get 15% off\n"
                            +"2. Buy 3 tickets and get 20% off\n");

                    break;

                default:
                    System.out.println("Invalid choice selected. Please select a valid option");

            }
        }
        sc.close();
    }
}