package h09.animals;

import h09.abilities.Walks;

public class Lion extends Animal implements Walks {
    public Lion(String name, int age) {
        super(name, age);
    }

    @Override
    public int getNumberOfLegs() {
        return 4;
    }
}
