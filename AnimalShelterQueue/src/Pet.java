/* Author: Jack Williams
* Date: July 10th, 2025
* Description: This is a Pet POJO that holds data for the type of pet,
* Their name, breed, gender, and age. PetType is a boolean value that
* is converted to a string to be shown to the user in the toString
* method. True = dog, False = cat. */



public class Pet {

    private boolean petType;
    private String petName;
    private String petBreed;
    private String petGender;
    private int petAge;

    public Pet(boolean petType, String petName, String petBreed, String petGender, int petAge) {
        this.petType = petType;
        this.petName = petName;
        this.petBreed = petBreed;
        this.petGender = petGender;
        this.petAge = petAge;
    }

    public boolean getPetType() {
        return petType;
    }

    public String getPetName() {
        return petName;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public String getPetGender() {
        return petGender;
    }

    public int getPetAge() {
        return petAge;
    }

    public void setPetType(boolean petType) {
        this.petType = petType;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public void setPetGender(String petGender) {
        this.petGender = petGender;
    }

    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

    public String convertBooleanPetTypeToString(boolean petType) {
        if (petType) {
            return "Dog";
        } else {
            return "Cat";
        }
    }

    public String toString() {
        return "Type of pet: " + convertBooleanPetTypeToString(petType) + " Name: " + petName + " Breed: " + petBreed + " Gender: " + petGender + " Age: " + petAge;
    }
}
