package com.sk.intercom.flatten;

import java.util.ArrayList;
import java.util.List;

/**
 * This class flattens an array of arbitrarily nested arrays of integers into a
 * flat array of integers. e.g. [[1,2,[3]],4] → [1,2,3,4]
 *
 * @author shishir_kumar
 *
 */

public class FlattenArray {

    /**
     * Flatten an array of arbitrarily nested arrays of integers into a flat
     * array of integers. e.g. [[1,2,[3]],4] -> [1,2,3,4].
     *
     * @param inputArray
     * @return flattened array of Integers or null if input is null
     */
    public static Integer[] flatten(final Object[] inputArray) {
        // check for null input and throw exception
        if (inputArray == null) {
            throw new IllegalArgumentException("Input can not be null.");
        }

        // initialize a list which is meant ot contain the flattened array
        // elements
        final List<Integer> flattenedList = new ArrayList<Integer>();

        // call the method which do the work
        doFlat(inputArray, flattenedList);

        // convert the list to integer array and return
        return flattenedList.toArray(new Integer[flattenedList.size()]);

    }

    /**
     * Recursive method which flattens an array of arbitrarily nested arrays of
     * integers into a flat List of integers.
     *
     * @param array
     * @param flattenedList
     */
    private static void doFlat(final Object[] array, final List<Integer> flattenedList) {
        // Move through the length of the array
        for (final Object element : array) {
            if (element instanceof Object[]) {
                // If the element is another array then the recurse the method
                doFlat((Object[]) element, flattenedList);
            } else if (element instanceof Integer) {
                // Else if the element is an integer then add it to the list.
                flattenedList.add((Integer) element);
            } else {
                // Else the element is not an array or an integer,
                throw new IllegalArgumentException("Input must be an array of Integers or nested arrays of Integers");
            }
        }
    }
}