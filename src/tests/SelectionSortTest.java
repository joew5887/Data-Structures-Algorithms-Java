package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import main.arrays.Array;
import main.arrays.InstrumentedArray;

public class SelectionSortTest extends BaseSort {
    public Array sort(Array arr) {
        main.sorting.Sort.selection(arr);
        return arr;
    }
}
