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
                if (a.getElevation() < Swims.HIGH_ELEVATION) a.swimUp();
                a.eat();
                a.swimDown();
            }
        }
    }

    /**
     * Compares the elevations of all {@link Animal}s in the enclosure and returns the maximum.
     *
     * @return the max elevation of all {@link Animal}s in the enclosure
     */
    @StudentImplementationRequired("H9.2.2")
    public float getMaxElevation() {
        float maxElevation = Float.NEGATIVE_INFINITY;
        for (int i = 0; i < getStack().size(); i++) {
            A a = getStack().get(i);
            if (a.getElevation() > maxElevation) maxElevation = a.getElevation();
        }
        return maxElevation;
    }
}
