package h09;

import h09.abilities.Swims;
import h09.animals.Animal;
import org.tudalgo.algoutils.student.annotation.StudentCreationRequired;

@StudentCreationRequired("H9.2.2")
public class WaterEnclosure<A extends Animal & Swims> implements Enclosure<A> {
    StackOfObjects<A> animals = new StackOfObjects<>();

    @Override
    public StackOfObjects<A> getStack() {
        return animals;
    }

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

    public float getMaxAmplitude() {
        float maxAmplitude = 0;
        for (int i = 0; i < getStack().size(); i++) {
            A a = getStack().get(i);
            if (a.getAltitude() > maxAmplitude) maxAmplitude = a.getAltitude();
        }
        return maxAmplitude;
    }

}
