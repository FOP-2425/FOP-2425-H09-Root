package h09.animals;

import h09.abilities.Swims;
import h09.abilities.Walks;

/**
 * An object of a class {@link Penguin} represents a penguin which can swim and walk.
 */
public class Penguin extends Animal implements Walks, Swims {
    float altitude = Swims.MAX_ALTITUDE / Swims.MIN_ALTITUDE;

    /**
     * Constructs a Penguin with the given name and age.
     *
     * @param name the name of the animal
     * @param age  the age of the animal
     */
    public Penguin(String name, int age) {
        super(name, age);
    }

    /**
     * Constructs a Penguin with the given name, age and altitude.
     *
     * @param name     the name of the animal
     * @param age      the age of the animal
     * @param altitude the altitude of the animal
     */
    public Penguin(String name, int age, float altitude) {
        super(name, age);
        this.altitude = altitude;
        if (altitude > Swims.MAX_ALTITUDE) this.altitude = Swims.MAX_ALTITUDE;
        if (altitude < Swims.MIN_ALTITUDE) this.altitude = Swims.MIN_ALTITUDE;
    }

    @Override
    public float getAltitude() {
        return altitude;
    }

    @Override
    public void swimUp() {
        altitude = Swims.MAX_ALTITUDE;
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
