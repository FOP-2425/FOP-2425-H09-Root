package h09.animals;

public class KingPenguin extends Penguin {
    public KingPenguin(String name, int age) {
        super(name, age);
    }

    void king() {
        System.out.println(getName() + " is King!");
    }
}
