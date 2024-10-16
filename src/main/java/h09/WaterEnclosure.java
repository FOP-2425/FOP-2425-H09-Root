package h09;

import h09.abilities.Swims;
import h09.animals.Animal;
import org.tudalgo.algoutils.student.annotation.StudentImplementationRequired;

/**
 * An object of a class implementing {@link WaterEnclosure} has the ability to contain and manage a stack of
 * {@link Animal}s which have the ability to {@link Swims}.
 */
public class WaterEnclosure<A extends Animal & Swims> implements Enclosure<A> {
    /**
     * The stack of animals which is used manage the contained Animals.
     */
    @StudentImplementationRequired("H9.2.2")
    StackOfObjects<A> animals = new StackOfObjects<>();

    @StudentImplementationRequired("H9.2.2")
    @Override
    public StackOfObjects<A> getStack() {
        return animals;
    }

    @StudentImplementationRequired("H9.2.2")
    @Override
    public void feed() {
        for (int i = 0; i < getStack().size(); i++) {
            A a = getStack().get(i);
            if (a.isHungry()) {
                if (a.getAltitude() < Swims.HIGH_ALTITUDE) a.swimUp();
                a.eat();
                a.swimDown();
            }
        }
    }

    /**
     * Compares the altitudes of all {@link Animal}s in the enclosure and returns the maximum.
     *
     * @return the max altitude of all {@link Animal}s in the enclosure
     */
    @StudentImplementationRequired("H9.2.2")
    public float getMaxAltitude() {
        float maxAltitude = Float.NEGATIVE_INFINITY;
        for (int i = 0; i < getStack().size(); i++) {
            A a = getStack().get(i);
            if (a.getAltitude() > maxAltitude) maxAltitude = a.getAltitude();
        }
        return maxAltitude;
    }
}
