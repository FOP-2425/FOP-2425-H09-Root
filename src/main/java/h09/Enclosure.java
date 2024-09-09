package h09;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public abstract class Enclosure<A extends Animal> extends Zoo<A> {
    abstract public void feed();

    public void forEach(Consumer<? super A> func)
    {
        for (A animal : getAnimals())
            func.accept(animal);
    }

    public void filterObj(Predicate<? super A> filter) {
        for (A a : getAnimals())
            if (!filter.test(a)) remove(a);
    }

    public <E extends Enclosure<A>> E filterFunc(Supplier<? extends E> supp, Predicate<? super A> filter) {
        E filtered = supp.get();
        for (A a : getAnimals())
            if (filter.test(a)) filtered.add(a);
        return filtered;
    }
}
