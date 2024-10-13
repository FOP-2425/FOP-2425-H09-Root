package h09;

import h09.animals.Fish;
import h09.animals.Lion;
import h09.animals.Penguin;

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
        System.out.println("Creating lion enclosure...");
        GroundEnclosure<Lion> lionEnclosure = new GroundEnclosure<>();
        lionEnclosure.getStack().push(new Lion("Lia", 1));
        lionEnclosure.getStack().push(new Lion("Lib", 2));
        lionEnclosure.getStack().push(new Lion("Lic", 3));

        System.out.println("\nCounting legs of lions...");
        System.out.println("Legs: " + lionEnclosure.countLegs());

        System.out.println("\nFeed the lions...");
        lionEnclosure.feed();

        System.out.println("\nCreating fish enclosure...");
        WaterEnclosure<Fish> fishEnclosure = new WaterEnclosure<>();
        fishEnclosure.getStack().push(new Fish("Fishaaa", 1));
        fishEnclosure.getStack().push(new Fish("Fishbb", 2));
        fishEnclosure.getStack().push(new Fish("Fisch", 3));

        System.out.println("Get fish altitude...");
        fishEnclosure.forEach(fish -> System.out.println(fish.getName() + ": " + fish.getAltitude()));

        System.out.println("\nLet fish swim up...");
        fishEnclosure.forEach(Fish::swimUp);
        fishEnclosure.forEach(Fish::swimUp);
        fishEnclosure.forEach(Fish::swimUp);

        System.out.println("\nFeed the fish...");
        fishEnclosure.feed();

        System.out.println("\nGet fish max altitude...");
        System.out.println("Max Altitude: " + fishEnclosure.getMaxAltitude());

        System.out.println("\nCreating penguin enclosure...");
        GroundEnclosure<Penguin> penguinGroundEnclosure = new GroundEnclosure<>();
        penguinGroundEnclosure.getStack().push(new Penguin("Penga", 5));
        penguinGroundEnclosure.getStack().push(new Penguin("Pengb", 20));
        penguinGroundEnclosure.getStack().push(new Penguin("Pengc", 30));

        System.out.println("\nMigrating the Penguins to a WaterEnclosure...");
        WaterEnclosure<Penguin> penguinWaterEnclosure = new WaterEnclosure<>();
        while (penguinGroundEnclosure.getStack().size() > 0) {
            Penguin penguin = penguinGroundEnclosure.getStack().pop();
            penguinWaterEnclosure.getStack().push(penguin);
        }

        System.out.println("\nLooking for hungry and old Penguins...");
        System.out.println(penguinWaterEnclosure.countHungry() + " hungry penguins.");
        System.out.println(penguinWaterEnclosure.filterFunc(WaterEnclosure::new, Enclosure.IS_OLD).getStack().size() + " old penguins.");

        System.out.println("\nFeed old penguins and let them sleep...");
        penguinWaterEnclosure.filterFunc(WaterEnclosure::new, Enclosure.IS_OLD).forEach(Enclosure.FEED_AND_SLEEP);


        System.out.println("\nRemove old penguins");
        penguinWaterEnclosure.filterObj(Enclosure.IS_OLD.negate());
        System.out.println(penguinWaterEnclosure.getStack().size() + " young penguin(s) left.");
    }
}
