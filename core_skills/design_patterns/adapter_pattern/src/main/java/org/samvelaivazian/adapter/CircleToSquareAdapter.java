package org.samvelaivazian.adapter;

import org.samvelaivazian.adapter.model.Circle;
import org.samvelaivazian.adapter.model.Square;

/**
 * Adapter class to adapt a Circle to a Square.
 * <p>
 * This class adapts a {@link Circle} to a {@link Square} by calculating the equivalent side length of a square
 * that can encapsulate the given circle. The side length of the square is equal to the diameter of the circle.
 * </p>
 */
public final class CircleToSquareAdapter extends Square {

    private final Circle circle;

    /**
     * Constructor for CircleToSquareAdapter.
     *
     * @param circle the Circle instance to adapt.
     */
    public CircleToSquareAdapter(final Circle circle) {
        this.circle = circle;
    }

    /**
     * Gets the side length of the square that can encapsulate the circle.
     * <p>
     * The side length of the square is calculated as twice the radius of the circle.
     * </p>
     *
     * @return the side length equivalent to the Circle's diameter.
     */
    @Override
    public double getSideLength() {
        final double DIAMETER_MULTIPLIER = 2.0;

        return DIAMETER_MULTIPLIER * circle.radius();
    }

}
