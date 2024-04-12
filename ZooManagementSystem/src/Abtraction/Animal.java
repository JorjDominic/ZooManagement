// ABSTRACT CLASS 
package Abtraction;

abstract class Animal {
    String name;
    int age;
    double weight;
    String habitat;

    abstract void makeSound();
    abstract void sleep();
    abstract void feed();
}

// INTERFACES
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

interface Climber {
    void climb();
}

// CONCRETE SUBCLASSES

// MAMMAL SUBCLASS
class Mammal extends Animal implements Swimmable {
    public Mammal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    void makeSound() {
        System.out.println("Mammal Sounds");
    }

    void sleep() {
        System.out.println("Mammal sleeps");
    }

    public void swim() {
        System.out.println("Mammal swims");
    }

    public void feed() {
        System.out.println("Feeds Mammal " + name);
    }
}

// FISH SUBCLASS
class Fish extends Animal implements Swimmable {
    public Fish(String name, int age, double weight, String habitat) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.habitat = habitat;
    }

    void makeSound() {
        System.out.println("Fish Sounds");
    }

    void sleep() {
        System.out.println("Fish sleeps");
    }

    public void swim() {
        System.out.println("Fish swims");
    }

    public void feed() {
        System.out.println("Feeds fish " + name);
    }
}

// BIRD SUBCLASS
class Bird extends Animal implements Flyable {
    public Bird(String name, int age, double weight, String habitat) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.habitat = habitat;
    }

    void makeSound() {
        System.out.println("Bird Sounds");
    }

    void sleep() {
        System.out.println("Bird sleeps");
    }

    public void fly() {
        System.out.println("Bird flies");
    }

    public void feed() {
        System.out.println("Feeds bird " + name);
    }
}

// REPTILE SUBCLASS
class Reptile extends Animal implements Swimmable {
    public Reptile(String name, int age, double weight, String habitat) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.habitat = habitat;
    }

    void makeSound() {
        System.out.println("Reptile Sounds");
    }

    void sleep() {
        System.out.println("Reptile sleeps");
    }

    public void swim() {
        System.out.println("Reptile swims");
    }

    public void feed() {
        System.out.println("Feeds reptile " + name);
    }
}

// MAMMAL SUBCLASS PRIMATE
// PRIMATE SUBCLASS
class Primate extends Mammal implements Climber {
    public Primate(String name, int age, double weight, String habitat) {
        super(name, age, weight);
        this.habitat = habitat;
    }

    public void climb() {
        System.out.println("Primate climbs");
    }
}

// APE CLASS
class Ape extends Primate {
    public Ape(String name, int age, double weight, String habitat) {
        super(name, age, weight, habitat);
    }
}

// MONKEY CLASS
class Monkey extends Primate {
    public Monkey(String name, int age, double weight, String habitat) {
        super(name, age, weight, habitat);
    }
}