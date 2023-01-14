package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import main.arrays.Array;
import main.arrays.InstrumentedArray;

public class MergeSortTest extends BaseSort {
    public Array sort(Array arr) {
        main.sorting.Sort.mergesort(arr);
        return arr;
    }
}