package org.samvelaivazian.sort.insertion;

import java.util.ArrayList;
import java.util.List;

/**
 * The Solution class provides an implementation of the insertion sort algorithm
 * that sorts a list of Pair objects based on their keys. It also returns a list of lists
 * showing the state of the array after each insertion, demonstrating the progression of the sorting process.
 */
public final class Solution {

    /**
     * Sorts a list of Pair objects using the insertion sort algorithm.
     * Returns a list of lists showing the state of the array after each insertion.
     *
     * @param pairs the list of Pair objects to be sorted
     * @return a list of lists showing the state of the array after each insertion
     * @throws IllegalArgumentException if the list size is greater than 100
     * @complexity Time complexity: O(n^2) in the worst case, where n is the number of elements in the list
     *             Space complexity: O(n^2) due to storing intermediate states of the list
     */
    public List<List<Pair>> insertionSort(final List<Pair> pairs) {
        if (pairs.size() > 100) {
            throw new IllegalArgumentException("The list size must be less than or equal to 100");
        }

        final List<List<Pair>> sortedPairs = new ArrayList<>();

        // Copy the original list to avoid modifying it directly
        final List<Pair> pairsCopy = new ArrayList<>(pairs.size());
        // Deep copy 'pairs' to 'pairsCopy' to preserve the original list and add it properly in sortedPairs
        pairsCopy.addAll(pairs);

        for (int i = 0; i < pairsCopy.size(); i++) {
            final Pair current = pairsCopy.get(i);
            int j = i - 1;

            // Find the correct position for 'current'
            while (j >= 0 && pairsCopy.get(j).key() > current.key()) {
                pairsCopy.set(j + 1, pairsCopy.get(j));
                j--;
            }
            pairsCopy.set(j + 1, current);

            // Add a deep copy of pairsCopy to sortedPairs to show the progression
            final List<Pair> currentListSnapshot = new ArrayList<>(pairsCopy.size());
            currentListSnapshot.addAll(pairsCopy);
            sortedPairs.add(currentListSnapshot);
        }

        return sortedPairs;
    }
}
