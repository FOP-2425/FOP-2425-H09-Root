package h09;

import org.tudalgo.algoutils.student.annotation.StudentImplementationRequired;

public class StackOfObjects<O> {
    @StudentImplementationRequired("H9.1.1")
    private O[] objs = (O[]) new Object[0];

    @StudentImplementationRequired("H9.1.2")
    public void push(O obj) {
        O[] newArray = (O[]) new Object[objs.length + 1];
        System.arraycopy(objs, 0, newArray, 0, objs.length);
        newArray[objs.length] = obj;
        objs = newArray;
    }

    @StudentImplementationRequired("H9.1.3")
    public void remove(O obj) {
        O[] newArray = (O[]) new Object[objs.length - 1];
        int n = 0;
        for (O currObj : objs) {
            if (currObj == obj) continue;
            newArray[n++] = currObj;
        }
        objs = newArray;
    }

    @StudentImplementationRequired("H9.1.4")
    public int size() {
        return objs.length;
    }

    @StudentImplementationRequired("H9.1.4")
    public O get(int index) {
        return objs[index];
    }

    @StudentImplementationRequired("H9.1.4")
    public O pop() {
        O o = get(objs.length - 1);
        remove(o);
        return o;
    }

    @SafeVarargs
    @StudentImplementationRequired("H9.1.5")
    public static <O> StackOfObjects<O> of(O... objs) {
        StackOfObjects<O> stack = new StackOfObjects<>();
        stack.objs = objs;
        return stack;
    }
}
