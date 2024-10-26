package h09;

import h09.animals.Fish;
import h09.animals.Lion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * An example JUnit test class.
 */
public class ExampleJUnitTest {

    @Test
    public void testAddition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGroundEnclosure() {
        // crating lions
        Lion lia = new Lion("Lia", 1);
        Lion lib = new Lion("Lib", 1);
        Lion lic = new Lion("Lic", 1);

        // Creating lion enclosure...
        GroundEnclosure<Lion> lionEnclosure = new GroundEnclosure<>();
        lionEnclosure.getStack().push(lia);
        lionEnclosure.getStack().push(lib);
        lionEnclosure.getStack().push(lic);

        // Counting legs of lions...
        assertEquals(lionEnclosure.countLegs(), 3 * 4);

        // Feed the lions...
        assertTrue(lia.isHungry());
        lionEnclosure.feed();
        assertFalse(lia.isHungry());
    }

    @Test
    public void testWaterEnclosure() {
        // crating fish
        Fish fisha = new Fish("Fishaaa", 1);
        Fish fib = new Fish("Fishbb", 1);
        Fish fisch = new Fish("Fisch", 1);

        // Creating fish enclosure...
        WaterEnclosure<Fish> fishEnclosure = new WaterEnclosure<>();
        fishEnclosure.getStack().push(fisha);
        fishEnclosure.getStack().push(fib);
        fishEnclosure.getStack().push(fisch);

        // Check max amplitude / hungry
        assertEquals(fishEnclosure.getMaxElevation(), -1.25);
        assertTrue(fisch.isHungry());

        // feed the fish (they swim down, when they have eaten)
        fishEnclosure.feed();

        // Check max amplitude / hungry
        assertEquals(fishEnclosure.getMaxElevation(), -2.5);
        assertFalse(fisch.isHungry());
    }
}
