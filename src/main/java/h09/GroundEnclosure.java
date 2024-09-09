package h09;

public class GroundEnclosure<A extends Animal & Walks> extends Enclosure<A> {


    @Override
    public void feed() {

    }

    public int countLegs(A a) {
        return a.getNumberOfLegs();
    }
}
