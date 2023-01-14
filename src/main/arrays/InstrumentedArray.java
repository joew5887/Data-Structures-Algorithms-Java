package main.arrays;

public class InstrumentedArray extends Array {
    private int count = 0;

    // Constructor that receives an array of ints to store
    public InstrumentedArray(int[] a) {
        super(a);
    }

    // Get the length
    public int length() {
        int value = super.length();
        this.count++;

        return value;
    }

    // Get the value at position i
    public int get(int i) {
        int value = super.get(i);
        this.count++;

        return value;
    }

    // Set the contents at position i to be n
    public void set(int i, int n) {
        super.set(i, n);
        this.count++;
    }

    // Ask how many times the array has been accessed (set, get or swap)
    public int accessCount() {
        return this.count;
    }

}
