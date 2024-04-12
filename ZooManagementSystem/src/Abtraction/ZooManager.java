package Abtraction;

import java.util.Scanner;
import java.util.ArrayList;
//ZOOMANAGER CLASS 

public class ZooManager {
	
	//MAIN METHOD
    public static void main(String[] args) throws Exception {
       Scanner input = new Scanner(System.in);
       ArrayList<Animal> animals = new ArrayList<>();
       
       //MENU LOOP
        String loop;
       do{
        System.out.println("ZOO MANAGEMENT MENU");
        System.out.println("1. Add Animal");
        System.out.println("2. View all animals in the zoo");
        System.out.println("3. Feed animals");
        System.out.println("4. Simulate animal behavior");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        
        String option = input.nextLine().trim();

        switch(option){
            case "1":
                addAnimal(animals,input);
                break;
            case "2":
                view(animals);
                break;
            case "3":
            	feed(animals);
                break;
            case "4":
            	simulate(animals);
                break;
            case "5":
            	System.exit(0);
            	break;
        }
        System.out.println("Would you like to select again?yes/no");
        loop = input.nextLine().trim();
        System.out.println("Loop value: " + loop);
    }while (loop.equalsIgnoreCase("yes"));
    System.out.println("Exiting Zoo Management System. Goodbye!");
}
    //FUNCTIONALITY METHODS 
    //ADD ANIMALS METHOD 
    public static void addAnimal(ArrayList<Animal> animals, Scanner input) {
    	System.out.println("Select animal type:");
    	System.out.println("1. Mammal");
    	System.out.println("2. Bird (Aviary)");
    	System.out.println("3. Fish (Aquarium)");
    	System.out.println("4. Reptile (Savannah)");
    	String animalType = input.nextLine().trim();

    	Animal animal;
    	switch (animalType) {
    	    case "1":
    	        System.out.println("Select mammal type:");
    	        System.out.println("1. Monkey (Jungle)");
    	        System.out.println("2. Ape (Jungle)");
    	        String mammalType = input.nextLine().trim();
    	        switch (mammalType) {
    	            case "1":
    	                animal = createAnimal(input, "Monkey");
    	                break;
    	            case "2":
    	                animal = createAnimal(input, "Ape");
    	                break;
    	            default:
    	                System.out.println("Invalid mammal type. Animal not added.");
    	                return;
    	        }
    	        break;
    	    case "2":
    	        animal = createAnimal(input, "Bird");
    	        break;
    	    case "3":
    	        animal = createAnimal(input, "Fish");
    	        break;
    	    case "4":
    	        animal = createAnimal(input, "Reptile");
    	        break;
    	    default:
    	        System.out.println("Invalid animal type. Animal not added.");
    	        return;
    	}
        animals.add(animal);
        System.out.println("Animal added successfully.");
    }
    //HELPER METHOD FOR ADD ANIMALS 
    public static Animal createAnimal(Scanner input, String animalType) {
        String habitat;
        switch (animalType) {
            case "Monkey":
            case "Ape":
                habitat = "Jungle";
                break;
            case "Bird":
                habitat = "Aviary";
                break;
            case "Fish":
                habitat = "Aquarium";
                break;
            case "Reptile":
                habitat = "Savannah";
                break;
            default:
                System.out.println("Invalid animal type. Animal not added.");
                return null;
        }

        System.out.print("Enter animal name: ");
        String name = input.nextLine().trim();
        System.out.print("Enter animal age: ");
        int age = input.nextInt();
        input.nextLine();
        System.out.print("Enter animal weight: ");
        double weight = input.nextDouble();
        input.nextLine();

        switch (animalType) {
            case "Monkey":
                return new Monkey(name, age, weight, habitat);
            case "Ape":
                return new Ape(name, age, weight, habitat);
            case "Bird":
                return new Bird(name, age, weight, habitat);
            case "Fish":
                return new Fish(name, age, weight, habitat);
            case "Reptile":
                return new Reptile(name, age, weight, habitat);
            default:
                System.out.println("Invalid animal type. Animal not added.");
                return null;
        }
    }
    //VIEW ALL ANIMALS 
    public static void view(ArrayList<Animal> animals) {
        if (animals.isEmpty()) {
            System.out.println("No animals in the zoo.");
            return;
        }
        System.out.println("Animals in the zoo:");
        for (Animal animal : animals) {
            if (animal instanceof Mammal) {
                System.out.println("Type: Mammal");
                if (animal instanceof Monkey) {
                    System.out.println("Subtype: Monkey");
                } else if (animal instanceof Ape) {
                    System.out.println("Subtype: Ape");
                }
            } else if (animal instanceof Bird) {
                System.out.println("Type: Bird");
            } else if (animal instanceof Fish) {
                System.out.println("Type: Fish");
            } else if (animal instanceof Reptile) {
                System.out.println("Type: Reptile");
            } else {
                System.out.println("Type: Unknown");
            }
            System.out.println("Habitat: " + animal.habitat);
            System.out.println("Name: " + animal.name);
            System.out.println("Age: " + animal.age);
            System.out.println("Weight: " + animal.weight);
            System.out.println();
        }
        
    }
    //VIEW HABITAT 
    public static void feed(ArrayList<Animal> animals) {
        if (animals.isEmpty()) {
            System.out.println("No animals in the zoo.");
            return;
        }
        for (Animal animal : animals) {
            if (animal instanceof Mammal) {
                ((Mammal) animal).feed();
            } else if (animal instanceof Bird) {
                ((Bird) animal).feed();
            } else if (animal instanceof Fish) {
                ((Fish) animal).feed();
            } else if (animal instanceof Reptile) {
                ((Reptile) animal).feed();
            } else {
                System.out.println("Unknown animal type. Unable to feed.");
            }
        }
    }
    public static void simulate(ArrayList<Animal> animals) {
        if (animals.isEmpty()) {
            System.out.println("No animals in the zoo to simulate.");
            return;
        }

        System.out.println("Simulation begins:");
        for (Animal animal : animals) {
            System.out.println("Simulating " + animal.name + ":");
            animal.makeSound();
            animal.sleep();
            animal.feed();

            if (animal instanceof Mammal) {
                Mammal mammal = (Mammal) animal;
                mammal.swim(); 
            } else if (animal instanceof Bird) {
                Bird bird = (Bird) animal;
                bird.fly(); 
            } else if (animal instanceof Fish) {
                Fish fish = (Fish) animal;
                fish.swim(); 
            } else if (animal instanceof Reptile) {
                Reptile reptile = (Reptile) animal;
                reptile.swim(); 
            }

            System.out.println();
        }
        System.out.println("Simulation ends.");
    }
    
    }


