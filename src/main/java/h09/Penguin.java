package h09;

public class Penguin extends Animal implements Walks, Swims {
    public Penguin(String name, int age) {
        super(name, age);
    }

    @Override
    public float getAmplitude() {
        return name.length();
    }

    @Override
    public int getNumberOfLegs() {
        return 2;
    }
}
