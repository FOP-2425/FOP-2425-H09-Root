package h09.abilities;

/**
 * An object of a class implementing {@link Swims} has the ability to swim and live in an {@link h09.WaterEnclosure}
 */
public interface Swims {
    /**
     * @return the altitude of the swimming animal
     */
    float getAltitude();

    /**
     * Lets the animal swim up and increase in altitude.
     */
    void swimUp();

    /**
     * Lets the animal swim down and decrease in altitude.
     */
    void swimDown();

    /**
     * The max altitude an animal can swim to.
     */
    float MAX_ALTITUDE = 0;

    /**
     * The min altitude an animal can swim to.
     */
    float MIN_ALTITUDE = -10;

    /**
     * The altitude above which an animal is considered at a high altitude or at the surface.
     */
    float HIGH_ALTITUDE = -3;
}
