package main.sorting;

import java.util.ArrayList;
import main.arrays.Array;

public class Sort {
    public static void selection(Array a) {
        for (int i = 0; i < a.length(); i++) { // to a.length (n)
            int j = a.findMin(i); // n
            a.swap(i, j); // 4 per loop
        }
    }

    public static int insertion(Array a) {
        int swaps = n_sort(a, 1, false);

        return swaps;
    }

    public static int insertion(Array a, boolean descending) {
        int swaps = n_sort(a, 1, descending);

        return swaps;
    }

    private static int n_sort(Array a, int step, boolean descending) {
        int swaps = 0;

        for (int j = 0; j < a.length(); j += step) { // to a.length (n)
            System.out.println(a);
            if (descending) {
                while (j > 0 && (a.get(j - 1) < a.get(j))) {
                    a.swap(j - 1, j);
                    swaps++;
                    j--;
                }
            } else {
                while (j > 0 && (a.get(j - 1) > a.get(j))) {
                    a.swap(j - 1, j);
                    swaps++;
                    j--;
                }
            }
        }

        return swaps;
    }

    public static int shell(Array a) {
        // gap sequence 2^k - 1
        ArrayList<Integer> gapSequence = getGapSequence(a);
        int swaps = 0;

        int step;
        for (int i = 0; i < gapSequence.size(); i++) {
            step = gapSequence.get(gapSequence.size() - i - 1);

            swaps += n_sort(a, step, false);
        }

        return swaps;
    }

    public static ArrayList<Integer> getGapSequence(Array a) {
        // gap sequence 2^k - 1
        ArrayList<Integer> gapSequence = new ArrayList<Integer>();
        int step = 1;
        int i = 2;
        while (step < a.length()) {
            gapSequence.add(step);
            step = (int) Math.pow(2, i) - 1;
            i++;
        }

        return gapSequence;
    }

    public static void mergesort(Array a) {
        int length = a.length();

        mergesortRec(a, 0, length);
    }

    public static void mergesortRec(Array a, int start, int end) {
        int length = end - start;

        if (length == 0) {
            return;
        } else if (length == 1) {
            if (a.get(start) > a.get(end)) {
                a.swap(start, end);
            }
            return;
        } else {
            int mp = start + (length / 2);
            mergesortRec(a, start, mp);
            mergesortRec(a, mp + 1, end);
        }
    }

    public static void quicksort(Array a) {
        int left = 0;
        int right = a.length() - 1;

        quicksortRec(a, left, right);
    }

    private static void quicksortRec(Array a, int left, int right) {
        if (left < right) {
            /*
             * pi is partitioning index, a[p] is now
             * at right place
             */
            int pi = partition(a, left, right);

            quicksortRec(a, left, pi - 1); // Before pi. Everything less than a[p]
            quicksortRec(a, pi + 1, right); // After pi. Everything more than a[p]
        }
    }

    public static int partition(Array a, int left, int right) {
        int p = a.get(left);
        int i = left + 1;
        int j = right; // assuming pivot is at the start of the array

        while (true) {
            while (a.get(i) < p && i < right)
                i++; // scan i right until you find an element larger than p
            while (a.get(j) > p && j > left)
                j--; // scan j left until you find an element smaller than p

            if (i >= j)
                break;

            // swap p into the right spot in the middle
            a.swap(i, j);
        }
        a.set(left, a.get(j));
        a.set(j, p);

        return j;
    }

    public static void main(String[] args) throws Exception {
        int[] input_arr = { 4, 2, 6, 1, 0, 3 };
        Array arr = new Array(input_arr);
        System.out.println(arr);
        int swaps = Sort.insertion(arr);
        System.out.println(swaps);
        System.out.println(arr);
    }
}
/*
 * for (int t = 1; t < 21; t++) {
 * Integer[] arr = new Integer[t];
 * int sum = 0;
 * 
 * for (int t2 = 0; t2 < t; t2++) {
 * arr[t2] = t2 + 1;
 * sum += t2;
 * }
 * 
 * List<Integer> intList = Arrays.asList(arr);
 * Collections.shuffle(intList);
 * intList.toArray(arr);
 * 
 * System.out.println(t);
 * System.out.println(Arrays.toString(arr));
 * 
 * int[] arr2 = new int[t];
 * int[] arr3 = new int[t];
 * 
 * for (int i = 0; i < t; i++) {
 * arr2[i] = arr[i];
 * arr3[i] = arr[i];
 * }
 * 
 * Array x = new Array(arr2);
 * Array y = new Array(arr3);
 * int swaps_asc = Sort.insertion(x, false);
 * System.out.println(x + ": " + swaps_asc);
 * int swaps_desc = Sort.insertion(y, true);
 * 
 * assert swaps_asc + swaps_desc == sum;
 * System.out.println(y + ": " + swaps_desc);
 * }
 * int[] input_arr = { 3, 2, 1, 8, 10, 7, 4, 8, 9, 5 };
 * 
 * Array arr = new Array(input_arr);
 * System.out.println(arr);
 * int swaps = Sort.insertion(arr, false);
 * System.out.println(swaps);
 * System.out.println(arr);
 * }
 */
// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
// 1, 10, 22, 55, 76, 100, 127, 157, 190, 226
