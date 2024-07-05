package org.samvelaivazian.prototype;

import org.samvelaivazian.prototype.model.Rectangle;
import org.samvelaivazian.prototype.model.Shape;
import org.samvelaivazian.prototype.model.Square;

import java.util.Arrays;
import java.util.List;

/**
 * This class contains test cases for the Prototype pattern implementation.
 * Each test case verifies the functionality of specific methods in the Rectangle, Square, and Test classes.
 * <p>
 * Note: To enable assertions, you need to add the VM argument `-ea` when running the tests.
 * </p>
 */
public final class PrototypeTest {

    /**
     * Main method to run all the test cases.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        testRectangleClone();
        testSquareClone();
        testCloneShapes();

        System.out.println("All tests passed!");
    }

    /**
     * Tests the clone method of the Rectangle class.
     * Expects a new Rectangle object with the same width and height.
     */
    private static void testRectangleClone() {
        final Rectangle rect1 = new Rectangle(10, 20);
        final Rectangle rect2 = rect1.clone();

        assert areDifferentInstances(rect1, rect2) : "Clone should create a new object";
        assert rect1.equals(rect2) : "Clone should be equal to the original object in value";
        assert rect1.width() == rect2.width() : "Width should be equal";
        assert rect1.height() == rect2.height() : "Height should be equal";
    }

    /**
     * Tests the clone method of the Square class.
     * Expects a new Square object with the same length.
     */
    private static void testSquareClone() {
        final Square sq1 = new Square(15);
        final Square sq2 = sq1.clone();

        assert areDifferentInstances(sq1, sq2) : "Clone should create a new object";
        assert sq1.equals(sq2) : "Clone should be equal to the original object in value";
        assert sq1.length() == sq2.length() : "Length should be equal";
    }

    /**
     * Tests the cloneShapes method of the Test class.
     * Expects a new list containing clones of the shapes in the original list.
     */
    private static void testCloneShapes() {
        final List<Shape> shapes = Arrays.asList(
                new Rectangle(10, 20),
                new Square(15)
        );

        final Test test = new Test();
        final List<Shape> clonedShapes = test.cloneShapes(shapes);

        assert clonedShapes.size() == shapes.size() : "The size of the cloned list should be the same";

        final Shape originalRectangle = shapes.getFirst();
        final Shape clonedRectangle = clonedShapes.getFirst();
        assert areDifferentInstances(originalRectangle, clonedRectangle) : "Cloned rectangle should be a different object";
        assert originalRectangle.equals(clonedRectangle) : "Cloned rectangle should be equal to the original object in value";
        assert ((Rectangle) originalRectangle).width() == ((Rectangle) clonedRectangle).width() : "Cloned rectangle's width should be the same";
        assert ((Rectangle) originalRectangle).height() == ((Rectangle) clonedRectangle).height() : "Cloned rectangle's height should be the same";

        final Shape originalSquare = shapes.getLast();
        final Shape clonedSquare = clonedShapes.getLast();
        assert areDifferentInstances(originalSquare, clonedSquare) : "Cloned square should be a different object";
        assert originalSquare.equals(clonedSquare) : "Cloned square should be equal to the original object in value";
        assert ((Square) originalSquare).length() == ((Square) clonedSquare).length() : "Cloned square's length should be the same";
    }

    /**
     * Checks if two objects are different instances.
     *
     * @param obj1 the first object
     * @param obj2 the second object
     * @return {@code true} if the objects are different instances, {@code false} otherwise
     * <p>
     * This method is used to explicitly check if two objects are different instances, which is necessary for
     * verifying that the clone method creates a new object. This approach is used to make the intention clear
     * and avoid IDE warnings about comparing objects using {@code !=}.
     * </p>
     */
    private static boolean areDifferentInstances(final Shape obj1, final Shape obj2) {
        return obj1 != obj2;
    }

    /**
     * Private constructor to prevent instantiation.
     * <p>
     * This constructor is intentionally declared as private to prevent instantiation of this test class.
     * All methods in this class are static and should be accessed statically.
     * </p>
     */
    private PrototypeTest() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }

}
