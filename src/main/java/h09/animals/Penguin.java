package h09.animals;

import h09.abilities.Swims;
import h09.abilities.Walks;

public class Penguin extends Animal implements Walks, Swims {
    float altitude = 0;

    public Penguin(String name, int age) {
        super(name, age);
    }

    @Override
    public float getAltitude() {
        return altitude;
    }

    @Override
    public void swimUp() {
        altitude += 4;
        if (altitude > Swims.MAX_ALTITUDE) altitude = 0;
    }

    @Override
    public void swimDown() {
        altitude -= 4;
        if (altitude < Swims.MIN_ALTITUDE) altitude = 10;
    }

    @Override
    public int getNumberOfLegs() {
        return 2;
    }
}
