package h09;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface Enclosure<A extends Animal> {
    void feed();
    StackOfObjects<A> getStack();

     default void forEach(Consumer<? super A> func)
    {
        for (A animal : getStack().getAnimals())
            func.accept(animal);
    }

     default void filterObj(Predicate<? super A> filter) {
        for (A a : getStack().getAnimals())
            if (!filter.test(a)) getStack().remove(a);
    }

     default <E extends Enclosure<A>> E filterFunc(Supplier<? extends E> supp, Predicate<? super A> filter) {
        E filtered = supp.get();
        for (A a : getStack().getAnimals())
            if (filter.test(a)) filtered.getStack().push(a);
        return filtered;
    }

     static <A extends Animal, E extends Enclosure<A>> E of(Supplier<? extends E> supp, A... animals) {
        E zoo = supp.get();
        zoo.getStack().animals = animals;
        return zoo;
    }
}
