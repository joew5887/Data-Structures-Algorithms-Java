package main.linear;

import java.util.ArrayList;

public class Stack implements BaseStruct {
    private ArrayList<Integer> elems;

    public Stack() {
        this.elems = new ArrayList<Integer>();
    }

    public int getLength() {
        return elems.size();
    }

    public boolean isEmpty() {
        return getLength() == 0;
    }

    public int get() {
        return elems.remove(0);
    }

    public void add(int value) {
        elems.add(0, value);
    }
}
