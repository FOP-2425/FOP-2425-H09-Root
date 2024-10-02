package h09;

import h09.abilities.Swims;
import h09.animals.Animal;

import java.util.function.Consumer;
import java.util.function.Predicate;

public final class Lambdas {
    static final Consumer<Animal> SLEEP =
        Animal::sleep;

    static final Consumer<Animal> FEED =
        Animal::eat;

    static final Predicate<Animal> IS_HUNGRY =
        Animal::isHungry;

    static final Predicate<Swims> SWIMS_AT_HIGH_ALTITUDE =
        swims -> swims.getAltitude() < 3;

    public static <T extends Animal & Swims> Consumer<T> FEED_AT_HIGH_ALTITUDE() {
        return (T animal) -> {
            if (animal.getAltitude() < 3) animal.eat();
        };
    }

}
