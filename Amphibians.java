package org.example;

public class Amphibians implements Animal{
    private String animalName;
    private String animalSound;
    private String animalHistory;

    public Amphibians(String animalName, String animalSound, String animalHistory) {
        this.animalName = animalName;
        this.animalSound = animalSound;
        this.animalHistory = animalHistory;
    }

    @Override
    public String getAnimalType() {
        return "Amphibian";
    }

    @Override
    public String getName() {
        return this.animalName;
    }

    @Override
    public String makeSound() {
        return this.animalSound;
    }

    @Override
    public String getAnimalHistory() {
        return this.animalHistory;
    }

}
