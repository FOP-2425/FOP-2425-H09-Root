package h09.abilities;

public interface Swims {
    float getAltitude();

    void swimUp();

    void swimDown();

    float MAX_ALTITUDE = 0;
    float MIN_ALTITUDE = -10;
    float HIGH_ALTITUDE = -3;
}
