package org.samvelaivazian.adapter.model;

/**
 * Represents a SquareHole with a specific side length.
 */
public final class SquareHole {

    /**
     * The side length of the square hole.
     */
    private final double sideLength;

    /**
     * Constructor for creating a SquareHole with a specific side length.
     *
     * @param sideLength the side length of the square hole.
     */
    public SquareHole(final double sideLength) {
        this.sideLength = sideLength;
    }

    /**
     * Checks if a given square can fit into this square hole.
     *
     * @param square the square to check.
     * @return true if the square fits into the hole, false otherwise.
     */
    public boolean canFit(final Square square) {
        return this.sideLength >= square.getSideLength();
    }

}
