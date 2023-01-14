package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import main.arrays.Array;
import main.arrays.InstrumentedArray;

public class ShellSortTest extends BaseSort {
    public Array sort(Array arr) {
        main.sorting.Sort.shell(arr);
        return arr;
    }
}
