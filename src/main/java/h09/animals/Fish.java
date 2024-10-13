package h09.animals;

import h09.abilities.Swims;

public class Fish extends Animal implements Swims {
    public Fish(String name, int age) {
        super(name, age);
    }

    @Override
    public float getAltitude() {
        return Swims.MAX_ALTITUDE - (Swims.MIN_ALTITUDE - Swims.MAX_ALTITUDE) / (getName().length() + 1);
    }

    @Override
    public void swimUp() {
        name += "Blub";
    }

    @Override
    public void swimDown() {
        if (name.length() < 4) return;
        name = name.substring(0, name.length() - 4);
    }
}
