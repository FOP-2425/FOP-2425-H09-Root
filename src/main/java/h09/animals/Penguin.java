package h09.animals;

import h09.abilities.Swims;
import h09.abilities.Walks;

/**
 * An object of a class {@link Penguin} represents a penguin which can swim and walk.
 */
public class Penguin extends Animal implements Walks, Swims {
    float altitude = 0;

    /**
     * Constructs a Penguin with the given name and age.
     *
     * @param name the name of the animal
     * @param age  the age of the animal
     */
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
        if (altitude > Swims.MAX_ALTITUDE) altitude = Swims.MAX_ALTITUDE;
    }

    @Override
    public void swimDown() {
        altitude -= 4;
        if (altitude < Swims.MIN_ALTITUDE) altitude = Swims.MIN_ALTITUDE;
    }

    @Override
    public int getNumberOfLegs() {
        return 2;
    }
}
