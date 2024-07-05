package org.samvelaivazian.linkedlist;

import java.util.List;

/**
 * This class contains test cases for the LinkedList class.
 * Each test case verifies the functionality of specific methods in the LinkedList class.
 * <p>
 * Note: To enable assertions, you need to add the VM argument `-ea` when running the tests.
 * </p>
 */
public final class LinkedListTest {

    /**
     * Main method to run all the test cases.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        testGet();
        testInsertHead();
        testInsertTail();
        testRemove();
        testGetValues();

        System.out.println("All tests passed!");
    }

    /**
     * Tests the get method with various indices.
     * Expects correct values to be returned for valid indices.
     * Expect IndexOutOfBoundsException for invalid indices.
     */
    private static void testGet() {
        final LinkedList list = new LinkedList();
        list.insertHead(1); // List: 1
        list.insertHead(2); // List: 2 -> 1
        list.insertTail(3); // List: 2 -> 1 -> 3
        list.insertTail(4); // List: 2 -> 1 -> 3 -> 4

        // Test valid indices
        assert list.get(0) == 2 : "Test get failed at index 0";
        assert list.get(1) == 1 : "Test get failed at index 1";
        assert list.get(2) == 3 : "Test get failed at index 2";
        assert list.get(3) == 4 : "Test get failed at index 3";

        // Additional edge cases to ensure a false path for index < 0
        list.remove(3); // List: 2 -> 1 -> 3
        try {
            list.get(-2);
            assert false : "Test get failed - should have thrown IndexOutOfBoundsException for negative index -2";
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }

        // Additional edge cases to ensure a false path for index >= size
        list.remove(2); // List: 2 -> 1
        try {
            list.get(3);
            assert false : "Test get failed - should have thrown IndexOutOfBoundsException for index 3";
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }

        // Test index equal to size
        try {
            list.get(2);
            assert false : "Test get failed - should have thrown IndexOutOfBoundsException for index equal to size";
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }
    }

    /**
     * Tests the insertHead method.
     * Inserts nodes at the head and verifies that the head is updated correctly.
     */
    private static void testInsertHead() {
        final LinkedList list = new LinkedList();

        // Test inserting into an empty list
        list.insertHead(1);
        assert list.get(0) == 1 : "Test insertHead failed - head should be 1";

        // Test inserting into a non-empty list
        list.insertHead(2);
        assert list.get(0) == 2 : "Test insertHead failed - head should be 2";
        assert list.get(1) == 1 : "Test insertHead failed - second element should be 1";

        // Insert another element at the head
        list.insertHead(3);
        assert list.get(0) == 3 : "Test insertHead failed - head should be 3";
        assert list.get(1) == 2 : "Test insertHead failed - second element should be 2";
        assert list.get(2) == 1 : "Test insertHead failed - third element should be 1";
    }

    /**
     * Tests the insertTail method.
     * Appends nodes to the tail and verifies that the tail is updated correctly.
     */
    private static void testInsertTail() {
        final LinkedList list = new LinkedList();

        // Test inserting into an empty list
        list.insertTail(1);
        assert list.get(0) == 1 : "Test insertTail failed - tail should be 1";

        // Test inserting into a non-empty list
        list.insertTail(2);
        assert list.get(1) == 2 : "Test insertTail failed - tail should be 2";

        // Insert another element at the tail
        list.insertTail(3);
        assert list.get(2) == 3 : "Test insertTail failed - tail should be 3";
    }

    /**
     * Tests the remove method.
     * Removes nodes at various positions and verifies that the list is updated correctly.
     */
    private static void testRemove() {
        final LinkedList list = new LinkedList();
        list.insertHead(1); // List: 1
        list.insertHead(2); // List: 2 -> 1
        list.insertTail(3); // List: 2 -> 1 -> 3
        list.insertTail(4); // List: 2 -> 1 -> 3 -> 4
        list.insertTail(5); // List: 2 -> 1 -> 3 -> 4 -> 5

        // Test removing head
        final boolean removedHead = list.remove(0);
        assert removedHead : "Test remove failed - should return true when removing head";
        assert list.get(0) == 1 : "Test remove failed - head should now be 1";
        assert list.get(1) == 3 : "Test remove failed - second element should now be 3";
        assert list.get(2) == 4 : "Test remove failed - third element should now be 4";
        assert list.get(3) == 5 : "Test remove failed - fourth element should now be 5";

        // Test removing from the middle (this will ensure true hits for i < index - 1)
        final boolean removedMiddle = list.remove(2); // List should be: 1 -> 3 -> 5
        assert removedMiddle : "Test remove failed - should return true when removing from the middle";
        assert list.get(0) == 1 : "Test remove failed - head should still be 1";
        assert list.get(1) == 3 : "Test remove failed - second element should now be 3";
        assert list.get(2) == 5 : "Test remove failed - third element should now be 5";

        // Test removing tail
        final boolean removedTail = list.remove(2);
        assert removedTail : "Test remove failed - should return true when removing tail";
        assert list.get(0) == 1 : "Test remove failed - head should still be 1";
        assert list.get(1) == 3 : "Test remove failed - second element should still be 3";

        // Test removing last element
        final boolean removedLastFirstCall = list.remove(0); // First remove call to remove the only element
        final boolean removedLastSecondCall = list.remove(0); // Second remove call to remove the new head
        assert removedLastFirstCall : "Test remove failed - should return true when removing the last element";
        assert removedLastSecondCall : "Test remove failed - should return true when removing the last element";

        // Test removing from an empty list
        final boolean removedFromEmptyList = list.remove(0);
        assert !removedFromEmptyList : "Test remove failed - should return false when removing from an empty list";

        // Test removing with negative index
        final boolean removedNegativeIndex = list.remove(-1);
        assert !removedNegativeIndex : "Test remove failed - should return false when removing with negative index";

        // Test removing with index out of bounds
        final boolean removedOutOfBoundsIndex = list.remove(1);
        assert !removedOutOfBoundsIndex : "Test remove failed - should return false when removing with out of bounds index";
    }

    /**
     * Tests the getValues method.
     * Verifies that the list of values returned matches the expected order from head to tail.
     */
    private static void testGetValues() {
        // Test with an empty list
        final LinkedList list = new LinkedList();
        final List<Integer> emptyValues = list.getValues();
        assert emptyValues.isEmpty() : "Test getValues failed - should return an empty list for an empty LinkedList";

        // Test with a single element
        list.insertHead(1); // List: 1
        final List<Integer> singleElementValues = list.getValues();
        assert singleElementValues.size() == 1 : "Test getValues failed - list should contain one element";
        assert singleElementValues.getFirst() == 1 : "Test getValues failed - the single element should be 1";

        // Test with multiple elements
        list.insertHead(2); // List: 2 -> 1
        list.insertTail(1); // List: 2 -> 1 -> 1
        list.insertTail(3); // List: 2 -> 1 -> 1 -> 3
        list.insertTail(4); // List: 2 -> 1 -> 1 -> 3 -> 4
        final List<Integer> multipleValues = list.getValues();
        assert multipleValues.size() == 5 : "Test getValues failed - list should contain five elements";
        assert multipleValues.get(0) == 2 : "Test getValues failed - first element should be 2";
        assert multipleValues.get(1) == 1 : "Test getValues failed - second element should be 1";
        assert multipleValues.get(2) == 1 : "Test getValues failed - third element should be 1";
        assert multipleValues.get(3) == 3 : "Test getValues failed - fourth element should be 3";
        assert multipleValues.get(4) == 4 : "Test getValues failed - fifth element should be 4";

        // Test after removing elements
        list.remove(2); // List: 2 -> 1 -> 3 -> 4
        final List<Integer> valuesAfterRemoval = list.getValues();
        assert valuesAfterRemoval.size() == 4 : "Test getValues failed - list should contain four elements after removal";
        assert valuesAfterRemoval.get(0) == 2 : "Test getValues failed - first element should be 2";
        assert valuesAfterRemoval.get(1) == 1 : "Test getValues failed - second element should be 1";
        assert valuesAfterRemoval.get(2) == 3 : "Test getValues failed - third element should be 3";
        assert valuesAfterRemoval.get(3) == 4 : "Test getValues failed - fourth element should be 4";

        // Test after clearing the list
        list.remove(0); // List: 1 -> 3 -> 4
        list.remove(0); // List: 3 -> 4
        list.remove(0); // List: 4
        list.remove(0); // List: empty
        final List<Integer> valuesAfterClearing = list.getValues();
        assert valuesAfterClearing.isEmpty() : "Test getValues failed - should return an empty list after clearing the LinkedList";
    }

    /**
     * Private constructor to prevent instantiation.
     * <p>
     * This constructor is intentionally declared as private to prevent instantiation of this test class.
     * All methods in this class are static and should be accessed statically.
     * </p>
     */
    private LinkedListTest() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }

}
