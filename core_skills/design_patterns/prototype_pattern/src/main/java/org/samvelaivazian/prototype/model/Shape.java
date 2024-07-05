package org.samvelaivazian.prototype.model;

/**
 * An interface for shapes that can be cloned.
 */
public interface Shape {

    /**
     * Creates a copy of this shape.
     *
     * @return a new {@code Shape} with the same properties as this shape.
     */
    Shape clone();

}
