package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import main.linear.Array;
import main.linear.InstrumentedArray;

public class InsertionSortTest extends BaseSort {
    public Array sort(Array arr) {
        main.sorting.Sort.insertion(arr);
        return arr;
    }
}
