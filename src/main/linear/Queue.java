package main.linear;

import java.util.ArrayList;

public class Queue implements BaseStruct {
    private ArrayList<Integer> elems;

    public Queue() {
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
        elems.add(value);
    }
}
