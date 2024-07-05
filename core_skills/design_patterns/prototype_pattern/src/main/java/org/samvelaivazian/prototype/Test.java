package org.samvelaivazian.prototype;

import org.samvelaivazian.prototype.model.Shape;

import java.util.List;

/**
 * A utility class to clone a list of shapes.
 */
public final class Test {

    /**
     * Clones a list of shapes.
     *
     * @param shapes the list of shapes to clone.
     * @return a new list containing clones of the shapes in the original list.
     */
    public List<Shape> cloneShapes(final List<Shape> shapes) {
        return shapes.stream().map(Shape::clone).toList();
    }

}
