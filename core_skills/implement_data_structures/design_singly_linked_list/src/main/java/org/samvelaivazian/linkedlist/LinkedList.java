package org.samvelaivazian.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a singly linked list.
 * It supports various operations such as insertion at the head or tail,
 * retrieval of node values, and removal of nodes.
 * <p>
 * It maintains references to both the head and tail nodes,
 * and keeps track of the size of the list.
 * </p>
 */
public final class LinkedList {

    /**
     * The head node of the linked list.
     */
    private Node head;

    /**
     * The tail node of the linked list.
     */
    private Node tail;

    /**
     * The size of the linked list.
     */
    private int size;

    /**
     * Constructs an empty linked list.
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Retrieves the value of the index-th node in the linked list.
     * If the index is invalid, an IndexOutOfBoundsException is thrown.
     *
     * @param index the index of the node to retrieve
     * @return the value of the node at the given index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     * @complexity Time: O(n), where n is the index. Space: O(1).
     */
    public int get(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getValue();
    }

    /**
     * Inserts a node with the specified value at the head of the linked list.
     * After insertion, the new node will be the first node of the linked list.
     *
     * @param value the value to insert at the head
     * @complexity Time: O(1). Space: O(1).
     */
    public void insertHead(final int value) {
        final Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }

        size++;
    }

    /**
     * Appends a node with the specified value to the tail of the linked list.
     *
     * @param value the value to insert at the tail
     * @complexity Time: O(1). Space: O(1).
     */
    public void insertTail(final int value) {
        final Node newNode = new Node(value);

        if (tail == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }

        tail = newNode;

        size++;
    }

    /**
     * Removes the index-th node in the linked list if the index is valid.
     *
     * @param index the index of the node to remove
     * @return true if the node was removed, false if the index is out of bounds
     * @complexity Time: O(n), where n is the index. Space: O(1).
     */
    public boolean remove(final int index) {
        if (index < 0 || index >= size) {
            return false;
        }

        if (index == 0) {
            head = head.getNext();

            if (head == null) {
                tail = null;
            }
        } else {
            Node previous = head;

            for (int i = 0; i < index - 1; i++) {
                previous = previous.getNext();
            }

            previous.setNext(previous.getNext().getNext());

            if (previous.getNext() == null) {
                tail = previous;
            }
        }

        size--;
        return true;
    }

    /**
     * Retrieves all the values in the linked list in a list form.
     *
     * @return a list of all values in the linked list from head to tail
     * @complexity Time: O(n), where n is the size of the list. Space: O(n).
     */
    public List<Integer> getValues() {
        final List<Integer> values = new ArrayList<>();
        Node current = head;

        for (int i = 0; i < size; i++) {
            values.add(current.getValue());
            current = current.getNext();
        }

        return values;
    }

}
