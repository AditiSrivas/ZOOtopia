package org.example;

public class Reptile implements Animal{
    private String animalName;
    private String animalSound;
    private String animalHistory;

    public Reptile(String animalName, String animalSound, String animalHistory) {
        this.animalName = animalName;
        this.animalSound = animalSound;
        this.animalHistory = animalHistory;
    }

    @Override
    public String getAnimalType() {
        return "Reptile";
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
