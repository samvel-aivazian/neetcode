package org.samvelaivazian.adapter;

import org.samvelaivazian.adapter.model.Circle;
import org.samvelaivazian.adapter.model.Square;
import org.samvelaivazian.adapter.model.SquareHole;

/**
 * This class contains test cases for the CircleToSquareAdapter class.
 * Each test case verifies the functionality of the adapter pattern implementation.
 * <p>
 * Note: To enable assertions, you need to add the VM argument `-ea` when running the tests.
 * </p>
 */
public final class AdapterTest {

    /**
     * Main method to run all the test cases.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        testCircleToSquareAdapter();
        testCircleFitsInSquareHole();
        testSquareFitsInSquareHole();

        System.out.println("All tests passed!");
    }

    /**
     * Tests the CircleToSquareAdapter to ensure it correctly adapts a Circle to a Square.
     */
    private static void testCircleToSquareAdapter() {
        final Circle circle = new Circle(5);
        final Square adapter = new CircleToSquareAdapter(circle);

        assert adapter.getSideLength() == 10 : "Side length should be equal to circle's diameter (10)";
    }

    /**
     * Tests the SquareHole to ensure a Circle (adapted to a Square) can fit in it.
     */
    private static void testCircleFitsInSquareHole() {
        final Circle circle = new Circle(5);
        final Square adapter = new CircleToSquareAdapter(circle);
        final SquareHole squareHole = new SquareHole(10);

        assert squareHole.canFit(adapter) : "Circle (adapted to square) with diameter 10 should fit in square hole with side length 10";

        final SquareHole smallerSquareHole = new SquareHole(8);

        assert !smallerSquareHole.canFit(adapter) : "Circle (adapted to square) with diameter 10 should not fit in square hole with side length 8";
    }

    /**
     * Tests the SquareHole to ensure a Square can fit in it.
     */
    private static void testSquareFitsInSquareHole() {
        final Square square1 = new Square(5);
        final SquareHole squareHole1 = new SquareHole(5);

        assert squareHole1.canFit(square1) : "Square with side length 5 should fit in square hole with side length 5";

        final Square square2 = new Square(6);
        final SquareHole squareHole2 = new SquareHole(5);

        assert !squareHole2.canFit(square2) : "Square with side length 6 should not fit in square hole with side length 5";
    }

    /**
     * Private constructor to prevent instantiation.
     * <p>
     * This constructor is intentionally declared as private to prevent instantiation of this test class.
     * All methods in this class are static and should be accessed statically.
     * </p>
     */
    private AdapterTest() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }

}
