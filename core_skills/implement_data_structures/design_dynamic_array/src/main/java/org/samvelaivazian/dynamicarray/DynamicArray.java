package org.samvelaivazian.dynamicarray;

import java.util.NoSuchElementException;

/**
 * A class representing a dynamic array (resizable array).
 * It supports basic operations like getting and setting elements,
 * adding elements to the end, removing elements from the end,
 * and resizing the array when necessary.
 */
public final class DynamicArray {

    /**
     * The internal array to store elements.
     */
    private Integer[] array;

    /**
     * The current number of elements in the array.
     */
    private int size;

    /**
     * Constructs a DynamicArray with the specified initial capacity.
     *
     * @param capacity the initial capacity of the array / must be greater than 0
     * @throws IllegalArgumentException if the specified capacity is not positive
     * @complexity Time: O(1). Space: O(n), where n is the capacity.
     */
    public DynamicArray(final int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be a positive integer");
        }

        this.array = new Integer[capacity];
        this.size = 0;
    }

    /**
     * Returns the element at the specified position in this array.
     *
     * @param i the index of the element to return
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     * @complexity Time: O(1), Space: O(1).
     */
    public int get(final int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }

        return array[i];
    }

    /**
     * Replaces the element at the specified position in this array with the specified element.
     *
     * @param i the index of the element to replace
     * @param n the element to be stored at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     * @complexity Time: O(1). Space complexity: O(1).
     */
    public void set(final int i, final int n) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }

        array[i] = n;
    }

    /**
     * Appends the specified element to the end of this array.
     * If the array is full, it will be resized to accommodate the new element.
     *
     * @param n the element to be appended to this array
     * @complexity Time: Amortized O(1). Space: O(1) for the new element, O(n) for the resize.
     * Amortized time complexity means the average time per operation is O(1) over a sequence of operations,
     * even though individual operations (resizes) may take longer.
     */
    public void pushBack(final int n) {
        if (size == array.length) {
            resize();
        }

        array[size] = n;
        size++;
    }

    /**
     * Removes the element at the end of this array and returns it.
     *
     * @return the element that was removed from the end of the array
     * @throws NoSuchElementException if the array is empty
     * @complexity Time: O(1). Space: O(1).
     */
    public int popBack() {
        if (size == 0) {
            throw new NoSuchElementException("Pop Back can't be done to empty array");
        }

        final int popBackValue = array[size - 1];
        array[size - 1] = null;
        size--;

        return popBackValue;
    }

    /**
     * Returns the number of elements in this array.
     *
     * @return the number of elements in this array
     * @complexity Time: O(1), Space: O(1).
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the current capacity of this array.
     *
     * @return the current capacity of this array
     * @complexity Time: O(1). Space: O(1).
     */
    public int getCapacity() {
        return array.length;
    }

    /**
     * Doubles the capacity of the array.
     * This method is called internally when the array needs to be resized.
     *
     * @complexity Time: O(n), Space: O(n).
     */
    private void resize() {
        final Integer[] resizedArray = new Integer[array.length * 2];

        System.arraycopy(array, 0, resizedArray, 0, array.length);

        array = resizedArray;
    }

}
