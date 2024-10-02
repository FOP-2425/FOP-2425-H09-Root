package h09;

import h09.abilities.Swims;
import h09.animals.Animal;

public class WaterEnclosure<A extends Animal & Swims> implements Enclosure<A> {
    StackOfObjects<A> animals = new StackOfObjects<A>();

    @Override
    public StackOfObjects<A> getStack() {
        return animals;
    }

    public void feedAtAmplitude(float amplitude) {
        for (int i = 0; i < getStack().size(); i++) {
            A a = getStack().get(i);
            if (a.getAltitude() == amplitude) a.eat();
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
