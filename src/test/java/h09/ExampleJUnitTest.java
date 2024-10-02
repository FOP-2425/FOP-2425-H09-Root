package h09;

import h09.animals.Penguin;
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
    public void testForEach() {
        Penguin penga = new Penguin("Penga", 1);
        Penguin penge = new Penguin("Penge", 2);
        Penguin pengi = new Penguin("Pengi", 3);

        WaterEnclosure<Penguin> enclosure = new WaterEnclosure<>();
        enclosure.getStack().push(penga);
        enclosure.getStack().push(penge);
        enclosure.getStack().push(pengi);

        assertTrue(penga.isHungry());
        assertTrue(penge.isHungry());
        assertTrue(pengi.isHungry());

        enclosure.forEach(Lambdas.FEED);

        assertFalse(penga.isHungry());
        assertFalse(penge.isHungry());
        assertFalse(pengi.isHungry());
    }


    @Test
    public void testFilter() {
        Penguin penga = new Penguin("Penga", 1);
        Penguin penge = new Penguin("Penge", 2);
        Penguin pengi = new Penguin("Pengi", 3);

        WaterEnclosure<Penguin> enclosure = new WaterEnclosure<>();
        enclosure.getStack().push(penga);
        enclosure.getStack().push(penge);
        enclosure.getStack().push(pengi);

        penga.eat();

        assertFalse(penga.isHungry());
        assertTrue(penge.isHungry());
        assertTrue(pengi.isHungry());

        WaterEnclosure<Penguin> newEnclosure = enclosure.filterFunc(WaterEnclosure::new, Lambdas.IS_HUNGRY);

        assertEquals(newEnclosure.getStack().size(), 2);
    }

}
