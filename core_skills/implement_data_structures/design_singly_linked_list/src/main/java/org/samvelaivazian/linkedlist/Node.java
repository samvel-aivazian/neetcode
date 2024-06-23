package org.samvelaivazian.linkedlist;

/**
 * This class represents a node in a linked list.
 * Each node contains a value and a reference to the next node in the list.
 */
public final class Node {

    /**
     * The value stored in this node.
     */
    private final int value;

    /**
     * The next node in the linked list.
     */
    private Node next;

    /**
     * Constructs a new node with the specified value.
     *
     * @param value the value to be stored in the node
     */
    public Node(final int value) {
        this.value = value;
    }

    /**
     * Returns the value stored in this node.
     *
     * @return the value of this node
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns the next node in the linked list.
     *
     * @return the next node, or null if there is no next node
     */
    public Node getNext() {
        return next;
    }

    /**
     * Sets the next node in the linked list.
     *
     * @param next the node to be set as the next node
     */
    public void setNext(final Node next) {
        this.next = next;
    }

}
