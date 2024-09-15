package h09;

import java.util.Arrays;
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

        var pin1 = new KingPenguin("josh", 1);
        var pin2 = new KingPenguin("jerry", 2);
        var pin3 = new KingPenguin("tom", 3);
        test.push(new KingPenguin("josh", 1));
        test.push(new KingPenguin("jerry", 2));
        test.push(new KingPenguin("tom", 3));

        System.out.println(test.getMaxAmplitude());

        Supplier<PenguinEnclosure<KingPenguin>> supp = PenguinEnclosure::new;
        var test2 = test.filterFunc(supp, (penguin) -> !Objects.equals(penguin.name, "jerry"));

        System.out.println(test2.getMaxAmplitude());
        System.out.println(Arrays.toString(test2.getAnimals()));


        test.forEach(kingPenguin -> kingPenguin.eat());

        Consumer<KingPenguin> feedKing = (kingPenguin -> kingPenguin.eat());
        test.forEach(feedKing);

        var myEnclosure = Enclosure.of(WaterEnclosure::new,pin1, pin2, pin3);
        myEnclosure.push(pin3);
        Enclosure.of();

        WaterEnclosure<KingPenguin> test3 = test.filterFunc(WaterEnclosure::new, kingPenguin -> !Objects.equals(kingPenguin.name, "jerry"));
        test3.getMaxAmplitude();
    }
}
