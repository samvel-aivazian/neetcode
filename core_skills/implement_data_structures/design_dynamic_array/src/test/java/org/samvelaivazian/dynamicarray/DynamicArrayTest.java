package org.samvelaivazian.dynamicarray;

import java.util.NoSuchElementException;

/**
 * This class contains test cases for the DynamicArray class.
 * Each test case verifies the functionality of specific methods in the DynamicArray class.
 * <p>
 * Note: To enable assertions, you need to add the VM argument `-ea` when running the tests.
 * </p>
 */
public final class DynamicArrayTest {

    /**
     * Main method to run all the test cases.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        testConstructor();
        testGet();
        testSet();
        testPushBack();
        testPopBack();
        testResize();
        testGetSize();
        testGetCapacity();

        System.out.println("All tests passed!");
    }

    /**
     * Tests the constructor with various capacities.
     * Expects correct initial capacity and size.
     * Expect IllegalArgumentException for invalid capacities.
     */
    private static void testConstructor() {
        final DynamicArray array = new DynamicArray(10);
        assert array.getCapacity() == 10 : "Initial capacity should be 10";
        assert array.getSize() == 0 : "Initial size should be 0";

        try {
            new DynamicArray(0);
            assert false : "Constructor should throw IllegalArgumentException for zero capacity";
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        try {
            new DynamicArray(-1);
            assert false : "Constructor should throw IllegalArgumentException for negative capacity";
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    /**
     * Tests the get method with various indices.
     * Expects correct values to be returned for valid indices.
     * Expect IndexOutOfBoundsException for invalid indices.
     * <p>
     * {@code @SuppressWarnings("ResultOfMethodCallIgnored")} is used to suppress warnings about the result of method
     * calls being ignored because we are intentionally calling methods to test their exception-throwing behavior.
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    private static void testGet() {
        final DynamicArray array = new DynamicArray(5);
        array.pushBack(10);
        array.pushBack(20);

        // Valid indices
        assert array.get(0) == 10 : "Element at index 0 should be 10";
        assert array.get(1) == 20 : "Element at index 1 should be 20";

        // Invalid index: i >= size
        try {
            array.get(2);
            assert false : "Get should throw IndexOutOfBoundsException for index 2";
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }

        // Invalid index: i < 0
        try {
            array.get(-1);
            assert false : "Get should throw IndexOutOfBoundsException for negative index -1";
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }
    }

    /**
     * Tests the set method with various indices.
     * Expects correct values to be set for valid indices.
     * Expect IndexOutOfBoundsException for invalid indices.
     */
    private static void testSet() {
        final DynamicArray array = new DynamicArray(5);
        array.pushBack(10);
        array.pushBack(20);

        // Valid index
        array.set(0, 15);
        assert array.get(0) == 15 : "Element at index 0 should be 15 after set";

        // Invalid index: i >= size
        try {
            array.set(2, 30);
            assert false : "Set should throw IndexOutOfBoundsException for index 2";
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }

        // Invalid index: i < 0
        try {
            array.set(-1, 30);
            assert false : "Set should throw IndexOutOfBoundsException for negative index -1";
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }

        // Another valid index
        array.set(1, 25);
        assert array.get(1) == 25 : "Element at index 1 should be 25 after set";
    }

    /**
     * Tests the pushBack method.
     * Adds elements to the end and verifies that the elements are appended correctly.
     */
    private static void testPushBack() {
        final DynamicArray array = new DynamicArray(2);
        array.pushBack(10);
        array.pushBack(20);

        assert array.getSize() == 2 : "Size should be 2 after two pushBack operations";
        assert array.get(1) == 20 : "Element at index 1 should be 20";

        array.pushBack(30); // This should trigger a resize
        assert array.getSize() == 3 : "Size should be 3 after three pushBack operations";
        assert array.getCapacity() == 4 : "Capacity should be 4 after resize";
        assert array.get(2) == 30 : "Element at index 2 should be 30 after pushBack and resize";
    }

    /**
     * Tests the popBack method.
     * Removes elements from the end and verifies that the elements are removed correctly.
     * Expect NoSuchElementException for popping from an empty array.
     */
    private static void testPopBack() {
        final DynamicArray array = new DynamicArray(3);
        array.pushBack(10);
        array.pushBack(20);
        array.pushBack(30);

        final int poppedValue1 = array.popBack();
        assert poppedValue1 == 30 : "Pop back should return 30";
        assert array.getSize() == 2 : "Size should be 2 after one popBack operation";

        final int poppedValue2 = array.popBack();
        assert poppedValue2 == 20 : "Pop back should return 20";
        assert array.getSize() == 1 : "Size should be 1 after two popBack operations";

        final int poppedValue3 = array.popBack();
        assert poppedValue3 == 10 : "Pop back should return 10";
        assert array.getSize() == 0 : "Size should be 0 after three popBack operations";

        try {
            array.popBack();
            assert false : "Pop back should throw NoSuchElementException for empty array";
        } catch (NoSuchElementException e) {
            // Expected exception
        }
    }

    /**
     * Tests the resizing of the dynamic array.
     * Verifies that the capacity is doubled when the array is full.
     */
    private static void testResize() {
        final DynamicArray array = new DynamicArray(1);
        array.pushBack(10);
        array.pushBack(20); // This should trigger a resize

        assert array.getCapacity() == 2 : "Capacity should be 2 after first resize";

        array.pushBack(30); // This should trigger another resize
        assert array.getCapacity() == 4 : "Capacity should be 4 after second resize";
        assert array.getSize() == 3 : "Size should be 3 after three pushBack operations";
    }

    /**
     * Tests the getSize method.
     * Verifies that the correct size is returned.
     */
    private static void testGetSize() {
        final DynamicArray array = new DynamicArray(3);
        assert array.getSize() == 0 : "Initial size should be 0";

        array.pushBack(10);
        assert array.getSize() == 1 : "Size should be 1 after one pushBack operation";

        array.pushBack(20);
        assert array.getSize() == 2 : "Size should be 2 after two pushBack operations";

        array.popBack();
        assert array.getSize() == 1 : "Size should be 1 after one popBack operation";
    }

    /**
     * Tests the getCapacity method.
     * Verifies that the correct capacity is returned.
     */
    private static void testGetCapacity() {
        final DynamicArray array = new DynamicArray(2);
        assert array.getCapacity() == 2 : "Initial capacity should be 2";

        array.pushBack(10);
        array.pushBack(20);
        array.pushBack(30); // This should trigger a resize

        assert array.getCapacity() == 4 : "Capacity should be 4 after resize";
    }

    /**
     * Private constructor to prevent instantiation.
     * <p>
     * This constructor is intentionally declared as private to prevent instantiation of this test class.
     * All methods in this class are static and should be accessed statically.
     * </p>
     */
    private DynamicArrayTest() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }

}
