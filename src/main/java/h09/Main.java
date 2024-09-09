package h09;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Main entry point in executing the program.
 */
public class Main {
    /**
     * Main entry point in executing the program.
     *
     * @param args program arguments, currently ignored
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");

        WaterEnclosure<KingPenguin> test = new WaterEnclosure<>();
        test.add(new KingPenguin("josh", 1));
        test.add(new KingPenguin("jerry", 2));
        test.add(new KingPenguin("tom", 3));

        System.out.println(test.getMaxAmplitude());

        Supplier<PenguinEnclosure<KingPenguin>> supp = PenguinEnclosure::new;
        var test2 = test.filterFunc(supp, (penguin) -> !Objects.equals(penguin.name, "jerry"));

        System.out.println(test2.getMaxAmplitude());
        System.out.println(Arrays.toString(test2.getAnimals()));


        test.forEach(kingPenguin -> kingPenguin.eat());

        Consumer<KingPenguin> feedKing = (kingPenguin -> kingPenguin.eat());
        test.forEach(feedKing);

    }
}
