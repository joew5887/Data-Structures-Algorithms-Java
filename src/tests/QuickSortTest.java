package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import main.linear.Array;
import main.linear.InstrumentedArray;

public class QuickSortTest extends BaseSort {
    public Array sort(Array arr) {
        main.sorting.Sort.quicksort(arr);
        return arr;
    }
}