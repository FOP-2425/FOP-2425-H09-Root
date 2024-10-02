package h09;

import h09.animals.Animal;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface Enclosure<A extends Animal> {
    StackOfObjects<A> getStack();

    default void feed() {
        for (int i = 0; i < getStack().size(); i++)
            getStack().get(i).eat();
    }

    default void forEach(Consumer<? super A> func) {
        for (int i = 0; i < getStack().size(); i++)
            func.accept(getStack().get(i));
    }

    default void filterObj(Predicate<? super A> filter) {
        for (int i = 0; i < getStack().size(); i++) {
            A a = getStack().get(i);
            if (!filter.test(a)) getStack().remove(a);
        }
    }

    default <E extends Enclosure<A>> E filterFunc(Supplier<? extends E> supp, Predicate<? super A> filter) {
        E filtered = supp.get();
        for (int i = 0; i < getStack().size(); i++) {
            A a = getStack().get(i);
            if (filter.test(a)) filtered.getStack().push(a);
        }
        return filtered;
    }

}
