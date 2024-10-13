package h09;

import h09.abilities.Walks;
import h09.animals.Animal;

public class GroundEnclosure<A extends Animal & Walks> implements Enclosure<A> {
    final StackOfObjects<A> animals = new StackOfObjects<>();

    @Override
    public StackOfObjects<A> getStack() {
        return animals;
    }

    @Override
    public void feed() {
        for (int i = 0; i < getStack().size(); i++) {
            A a = getStack().get(i);
            a.eat();
        }
    }

    public int countLegs() {
        int sum = 0;
        for (int i = 0; i < getStack().size(); i++)
            sum += getStack().get(i).getNumberOfLegs();
        return sum;
    }
}
