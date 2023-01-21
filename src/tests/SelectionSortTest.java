package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import main.linear.Array;
import main.linear.InstrumentedArray;

public class SelectionSortTest extends BaseSort {
    public Array sort(Array arr) {
        main.sorting.Sort.selection(arr);
        return arr;
    }
}
