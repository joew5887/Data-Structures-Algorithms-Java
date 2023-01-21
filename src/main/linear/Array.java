package main.linear;

import java.util.Arrays;

public class Array {
    private int[] arr;

    // Constructor that receives an array of ints to store
    public Array(int[] a) {
        this.arr = a;
    }

    public String toString() {
        return Arrays.toString(this.arr);
    }

    public boolean matchesArray(int[] a) {
        return Arrays.equals(this.arr, a);
    }

    // Get the length
    public int length() {
        return this.arr.length;
    }

    // Get the value at position i
    public int get(int i) {
        int value = this.arr[i];

        return value;
    }

    // Set the contents at position i to be n
    public void set(int i, int n) {
        this.arr[i] = n;
    }

    // Swap two entries
    public void swap(int i, int j) {
        int temp = get(i);
        set(i, get(j));
        set(j, temp);
    }

    // find min from index 0 to i
    public int findMin(int i) {
        int m = i; // 1 assignment
        for (int j = i; j < length(); j++) { // to a.length (n)
            if (get(j) < get(m)) { // 2 array accesses per loop
                m = j; // 1 assignment
            }
        }

        return m;
    }
}
