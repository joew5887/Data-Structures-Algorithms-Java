package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import main.arrays.Array;
import main.arrays.InstrumentedArray;

public abstract class BaseSort {
    public abstract Array sort(Array arr);

    @Test
    public void sorted_list() {
        int[] inputArr = { 1, 2, 3, 4, 5 };
        int[] expectedOutput = { 1, 2, 3, 4, 5 };

        Array arr = new Array(inputArr);
        sort(arr);

        assert arr.matchesArray(expectedOutput);
    }

    @Test
    public void reverse_list() {
        int[] inputArr = { 5, 4, 3, 2, 1 };
        int[] expectedOutput = { 1, 2, 3, 4, 5 };

        Array arr = new Array(inputArr);
        sort(arr);

        assert arr.matchesArray(expectedOutput);
    }

    @Test
    public void random_list() {
        int[] inputArr = { 1, 4, 5, 3, 2 };
        int[] expectedOutput = { 1, 2, 3, 4, 5 };

        Array arr = new Array(inputArr);
        sort(arr);

        assert arr.matchesArray(expectedOutput);
    }

    @Test
    public void empty_list() {
        int[] inputArr = {};
        int[] expectedOutput = {};

        Array arr = new Array(inputArr);
        sort(arr);

        assertTrue(arr.matchesArray(expectedOutput));
    }

    /*
     * @Test
     * public void complexity_count_best_case() {
     * int[] inputArr = { 1, 2, 3, 4 };
     * int expectedOutput = 0;
     * 
     * InstrumentedArray arr = new InstrumentedArray(inputArr);
     * sort(arr);
     * 
     * assert arr.accessCount() == expectedOutput;
     * }
     */
}
