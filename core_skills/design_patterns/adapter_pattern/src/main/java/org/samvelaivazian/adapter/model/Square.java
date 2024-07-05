package org.samvelaivazian.adapter.model;

/**
 * Represents a Square with a specific side length.
 */
public class Square {

    /**
     * The side length of the square.
     */
    private double sideLength;

    /**
     * Default constructor for creating a Square.
     * Needed for the Adapter pattern to allow for flexible instantiation.
     */
    public Square() {}

    /**
     * Constructor for creating a Square with a specific side length.
     *
     * @param sideLength the side length of the square.
     */
    public Square(final double sideLength) {
        this.sideLength = sideLength;
    }

    /**
     * Gets the side length of the square.
     *
     * @return the side length of the square.
     */
    public double getSideLength() {
        return sideLength;
    }

}
