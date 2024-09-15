package h09;

public class Zoo<A> {
    private A[] animals = (A[]) new Object[0];

    public A[] getAnimals() {
        return animals;
    };

    public void add(A animal) {
        A[] newAnimals = (A[]) new Object[animals.length + 1];
        for (int i = 0; i < animals.length; i++) {
            newAnimals[i] = animals[i];
        }
        newAnimals[animals.length] = animal;
        animals = newAnimals;
    }

    public void remove(A animal) {
        A[] newAnimals = (A[]) new Object[animals.length - 1];
        int n = 0;
        for (int i = 0; i < animals.length; i++) {
            A currAnimal = animals[i];
            if (currAnimal == animal) {
                continue;
            }
            newAnimals[n++] = currAnimal;
        }
        animals = newAnimals;
    }

    public A pop() {
        A a = animals[animals.length - 1];
        remove(a);
        return a;
    }

    public static<A> Zoo<A> of(A... animals) {
        Zoo<A> zoo = new Zoo<>();

        zoo.animals = animals;

        return zoo;
    }

}
