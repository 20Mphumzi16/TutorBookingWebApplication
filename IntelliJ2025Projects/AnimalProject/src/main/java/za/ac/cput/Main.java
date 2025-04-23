package za.ac.cput;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Cat cat = new Cat("Mpumzi",1);
        cat.makeSound();
        System.out.println(cat);

        Dog dog = new Dog("Danger",1);
        dog.makeSound();
        System.out.println(dog);
    }
}