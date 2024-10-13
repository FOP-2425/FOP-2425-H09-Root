package h09;

import h09.abilities.Swims;
import h09.animals.Animal;
import org.tudalgo.algoutils.student.annotation.DoNotTouch;
import org.tudalgo.algoutils.student.annotation.StudentCreationRequired;
import org.tudalgo.algoutils.student.annotation.StudentImplementationRequired;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface Enclosure<A extends Animal> {
    @StudentImplementationRequired("H9.1")
    StackOfObjects<A> getStack();

    @DoNotTouch
    void feed();

    @DoNotTouch
    default int countHungry() {
        int count = 0;
        for (int i = 0; i < getStack().size(); i++)
            if (getStack().get(i).isHungry()) count++;
        return count;
    }

    @StudentImplementationRequired("H9.1")
    default void forEach(Consumer<? super A> func) {
        for (int i = 0; i < getStack().size(); i++)
            func.accept(getStack().get(i));
    }

    @StudentImplementationRequired("H9.1")
    default void filterObj(Predicate<? super A> filter) {
        for (int i = 0; i < getStack().size(); i++) {
            A a = getStack().get(i);
            if (!filter.test(a)) getStack().remove(a);
        }
    }

    @StudentImplementationRequired("H9.1")
    default <E extends Enclosure<A>> E filterFunc(Supplier<? extends E> supp, Predicate<? super A> filter) {
        E filtered = supp.get();
        for (int i = 0; i < getStack().size(); i++) {
            A a = getStack().get(i);
            if (filter.test(a)) filtered.getStack().push(a);
        }
        return filtered;
    }

    @DoNotTouch
    Predicate<Animal> IS_OLD = animal -> animal.getAge() > 10;

    @StudentCreationRequired("H9.1")
    Predicate<Swims> SWIMS_AT_LOW_ALTITUDE = swims -> swims.getAltitude() < Swims.HIGH_ALTITUDE;

    @StudentCreationRequired("H9.1")
    Consumer<Animal> FEED_AND_SLEEP = a -> {
        a.eat();
        a.sleep();
    };

    @StudentCreationRequired("H9.1")
    static <T extends Animal & Swims> Consumer<T> EAT_AND_SINK() {
        return (T animal) -> {
            animal.eat();
            animal.swimDown();
        };
    }
}
