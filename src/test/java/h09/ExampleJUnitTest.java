package h09;

import h09.abilities.Swims;
import h09.animals.Animal;
import h09.animals.Penguin;
import org.junit.jupiter.api.Test;
import org.tudalgo.algoutils.student.annotation.StudentImplementationRequired;

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
    @StudentImplementationRequired("H9.5.1")
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

        enclosure.forEach(Animal::eat);

        assertFalse(penga.isHungry());
        assertFalse(penge.isHungry());
        assertFalse(pengi.isHungry());
    }


    @Test
    @StudentImplementationRequired("H9.5.2")
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

        enclosure
            .filterFunc(WaterEnclosure::new, Animal::isHungry)
            .filterFunc(WaterEnclosure::new, Enclosure.SWIMS_AT_LOW_ALTITUDE)
            .forEach(Swims::swimUp);
        enclosure
            .filterFunc(WaterEnclosure::new, Animal::isHungry)
            .forEach(Enclosure.EAT_AND_SINK());

    }
}
