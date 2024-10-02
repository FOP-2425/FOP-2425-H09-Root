package h09;

import org.tudalgo.algoutils.student.annotation.StudentImplementationRequired;

public class StackOfObjects<A> {
    private A[] animals = (A[]) new Object[0];

    @StudentImplementationRequired
    public void push(A animal) {
        A[] newAnimals = (A[]) new Object[animals.length + 1];
        System.arraycopy(animals, 0, newAnimals, 0, animals.length);
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

    public int size() {
        return animals.length;
    }

    public A get(int index) {
        return animals[index];
    }

    public A pop() {
        A a = animals[animals.length - 1];
        remove(a);
        return a;
    }


    public static <A> StackOfObjects<A> of(A... animals) {
        StackOfObjects<A> stack = new StackOfObjects<>();
        stack.animals = animals;
        return stack;
    }


}
