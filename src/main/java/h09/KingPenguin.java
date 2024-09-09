package h09;

public class KingPenguin extends Penguin {
    public KingPenguin(String name, int age) {
        super(name, age);
    }

    void king() {
        System.out.println(name + " is King!");
    }
}
