package org.samvelaivazian.sort.insertion;

import org.samvelaivazian.sort.insertion.model.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains test cases for the Solution class's insertionSort method.
 * Each test case verifies the functionality of the insertionSort method by comparing
 * the expected intermediate states with the actual states produced by the method.
 * <p>
 * Note: To enable assertions, you need to add the VM argument `-ea` when running the tests.
 * </p>
 */
public final class InsertionSortTest {

    /**
     * Main method to run all the test cases.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        testEmptyList();
        testSingleElement();
        testSortedOrder();
        testReverseOrder();
        testRandomOrder();
        testStableSort();
        testInputValidation();

        System.out.println("All tests passed!");
    }

    /**
     * Tests the insertionSort method with an empty list.
     * Expects an empty list of states as the output.
     */
    private static void testEmptyList() {
        final Solution solution = new Solution();
        final List<Pair> pairs = new ArrayList<>();

        final List<List<Pair>> result = solution.insertionSort(pairs);

        assert result.isEmpty() : "Result should be empty for an empty input list";
    }

    /**
     * Tests the insertionSort method with a single element list.
     * Expects the single element list as the only state.
     */
    private static void testSingleElement() {
        final Solution solution = new Solution();
        final List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(1, "one"));

        final List<List<Pair>> result = solution.insertionSort(pairs);

        assert result.size() == 1 : "Result should contain one state for a single element list";
        assert result.getFirst().getFirst().key() == 1 : "The single element should be 1";
        assert result.getFirst().getFirst().value().equals("one") : "The single element value should be 'one'";
    }

    /**
     * Tests the insertionSort method with an already sorted list.
     * Expects the list to remain the same through all intermediate states.
     */
    private static void testSortedOrder() {
        final Solution solution = new Solution();
        final List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(1, "one"));
        pairs.add(new Pair(2, "two"));
        pairs.add(new Pair(3, "three"));

        final List<List<Pair>> result = solution.insertionSort(pairs);

        assert result.size() == 3 : "Result should contain three states";
        assert result.get(2).get(0).key() == 1 : "First element should be 1";
        assert result.get(2).get(0).value().equals("one") : "First element value should be 'one'";
        assert result.get(2).get(1).key() == 2 : "Second element should be 2";
        assert result.get(2).get(1).value().equals("two") : "Second element value should be 'two'";
        assert result.get(2).get(2).key() == 3 : "Third element should be 3";
        assert result.get(2).get(2).value().equals("three") : "Third element value should be 'three'";
    }

    /**
     * Tests the insertionSort method with a list sorted in reverse order.
     * Expects the list to be sorted in ascending order through intermediate states.
     */
    private static void testReverseOrder() {
        final Solution solution = new Solution();
        final List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(3, "three"));
        pairs.add(new Pair(2, "two"));
        pairs.add(new Pair(1, "one"));

        final List<List<Pair>> result = solution.insertionSort(pairs);

        assert result.size() == 3 : "Result should contain three states";
        assert result.get(2).get(0).key() == 1 : "First element should be 1";
        assert result.get(2).get(0).value().equals("one") : "First element value should be 'one'";
        assert result.get(2).get(1).key() == 2 : "Second element should be 2";
        assert result.get(2).get(1).value().equals("two") : "Second element value should be 'two'";
        assert result.get(2).get(2).key() == 3 : "Third element should be 3";
        assert result.get(2).get(2).value().equals("three") : "Third element value should be 'three'";
    }

    /**
     * Tests the insertionSort method with a randomly ordered list.
     * Expects the list to be sorted in ascending order through intermediate states.
     */
    private static void testRandomOrder() {
        final Solution solution = new Solution();
        final List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(3, "three"));
        pairs.add(new Pair(1, "one"));
        pairs.add(new Pair(2, "two"));

        final List<List<Pair>> result = solution.insertionSort(pairs);

        assert result.size() == 3 : "Result should contain three states";
        assert result.get(2).get(0).key() == 1 : "First element should be 1";
        assert result.get(2).get(0).value().equals("one") : "First element value should be 'one'";
        assert result.get(2).get(1).key() == 2 : "Second element should be 2";
        assert result.get(2).get(1).value().equals("two") : "Second element value should be 'two'";
        assert result.get(2).get(2).key() == 3 : "Third element should be 3";
        assert result.get(2).get(2).value().equals("three") : "Third element value should be 'three'";
    }

    /**
     * Tests the insertionSort method with a list that has duplicate keys.
     * Expects the relative order of elements with duplicate keys to be preserved (stable sort).
     */
    private static void testStableSort() {
        final Solution solution = new Solution();
        final List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(3, "three"));
        pairs.add(new Pair(1, "one"));
        pairs.add(new Pair(2, "two"));
        pairs.add(new Pair(3, "three-b"));

        final List<List<Pair>> result = solution.insertionSort(pairs);

        assert result.size() == 4 : "Result should contain four states";
        assert result.get(3).get(0).key() == 1 : "First element should be 1";
        assert result.get(3).get(0).value().equals("one") : "First element value should be 'one'";
        assert result.get(3).get(1).key() == 2 : "Second element should be 2";
        assert result.get(3).get(1).value().equals("two") : "Second element value should be 'two'";
        assert result.get(3).get(2).key() == 3 : "Third element should be 3";
        assert result.get(3).get(2).value().equals("three") : "Third element value should be 'three'";
        assert result.get(3).get(3).value().equals("three-b") : "Fourth element should be 'three-b'";
    }

    /**
     * Tests the insertionSort method with invalid and valid list sizes.
     * Expects an IllegalArgumentException to be thrown for list sizes greater than 100.
     */
    private static void testInputValidation() {
        final Solution solution = new Solution();
        final List<Pair> pairsWithInvalidSize = new ArrayList<>();

        for (int i = 101; i > 0; i--) {
            pairsWithInvalidSize.add(new Pair(i, "value" + i));
        }

        try {
            solution.insertionSort(pairsWithInvalidSize);
            assert false : "Expected IllegalArgumentException for list size greater than 100";
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        // Test with exactly 100 elements
        final List<Pair> pairsWithValidSize = new ArrayList<>();
        for (int i = 100; i > 0; i--) {
            pairsWithValidSize.add(new Pair(i, "value" + i));
        }

        final List<List<Pair>> result = solution.insertionSort(pairsWithValidSize);

        assert result.size() == 100 : "Result should contain 100 states";
        for (int i = 0; i < 100; i++) {
            assert result.get(99).get(i).key() == i + 1 : "Element should be " + (i + 1) + " in the final sorted list";
        }
    }

    /**
     * Private constructor to prevent instantiation.
     * <p>
     * This constructor is intentionally declared as private to prevent instantiation of this test class.
     * All methods in this class are static and should be accessed statically.
     * </p>
     */
    private InsertionSortTest() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }

}
