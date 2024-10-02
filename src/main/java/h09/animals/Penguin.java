package h09.animals;

import h09.abilities.Swims;
import h09.abilities.Walks;

public class Penguin extends Animal implements Walks, Swims {
    public Penguin(String name, int age) {
        super(name, age);
    }

    @Override
    public float getAltitude() {
        return getName().length();
    }

    @Override
    public int getNumberOfLegs() {
        return 2;
    }
}
