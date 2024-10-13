package h09.animals;

public class Animal {
    protected String name;
    private int age;
    private boolean isHungry = true;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void eat() {
        System.out.println(name + " ate...");
        isHungry = false;
    }

    public void sleep() {
        System.out.println(name + " slept...");
        isHungry = true;
        age++;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public int getAge() {
        return age;
    }
}
