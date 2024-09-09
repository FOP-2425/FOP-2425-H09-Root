package h09;

public class WaterEnclosure<A extends Animal & Swims> extends Enclosure<A> {


    @Override
    public void feed() {

    }

    public void feedAtAmplitude(A a) {
        a.getAmplitude();
        a.eat();
    }

    public float getMaxAmplitude() {
        float maxAmplitude = 0;
        for (A a : getAnimals())
            if (a.getAmplitude() > maxAmplitude) maxAmplitude = a.getAmplitude();
        return maxAmplitude;
    }
}
