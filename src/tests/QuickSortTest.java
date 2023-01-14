package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import main.arrays.Array;
import main.arrays.InstrumentedArray;

public class QuickSortTest extends BaseSort {
    public Array sort(Array arr) {
        main.sorting.Sort.quicksort(arr);
        return arr;
    }
}