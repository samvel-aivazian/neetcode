package org.samvelaivazian.dijkstraalgorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * This class contains test cases for the Solution class implementing Dijkstra's algorithm.
 * Each test case verifies the functionality of specific methods in the Solution class.
 * <p>
 * Note: To enable assertions, you need to add the VM argument `-ea` when running the tests.
 * </p>
 */
public final class DijkstraAlgorithmTest {

    /**
     * Main method to run all the test cases.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        testShortestPath();

        System.out.println("All tests passed!");
    }

    /**
     * Tests the shortestPath method with various graphs and source vertices.
     * Expects correct shortest path distances to be returned.
     */
    private static void testShortestPath() {
        // Test Case 1: Basic graph
        final List<List<Integer>> edges1 = Arrays.asList(
                Arrays.asList(0, 1, 10),
                Arrays.asList(0, 2, 3),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 1, 4),
                Arrays.asList(2, 3, 8),
                Arrays.asList(2, 4, 2),
                Arrays.asList(3, 4, 5)
        );
        final Map<Integer, Integer> shortestPaths1 = findShortestPath(5, edges1, 0);
        assert shortestPaths1.get(0) == 0 : "Distance to vertex 0 should be 0";
        assert shortestPaths1.get(1) == 7 : "Distance to vertex 1 should be 7";
        assert shortestPaths1.get(2) == 3 : "Distance to vertex 2 should be 3";
        assert shortestPaths1.get(3) == 9 : "Distance to vertex 3 should be 9";
        assert shortestPaths1.get(4) == 5 : "Distance to vertex 4 should be 5";

        // Test Case 2: Small graph with two vertices
        final List<List<Integer>> edges2 = List.of(
                Arrays.asList(0, 1, 5)
        );
        final Map<Integer, Integer> shortestPaths2 = findShortestPath(2, edges2, 0);
        assert shortestPaths2.get(0) == 0 : "Distance to vertex 0 should be 0";
        assert shortestPaths2.get(1) == 5 : "Distance to vertex 1 should be 5";

        // Test Case 3: Disconnected graph
        final List<List<Integer>> edges3 = Arrays.asList(
                Arrays.asList(0, 1, 1),
                Arrays.asList(1, 2, 2)
        );
        final Map<Integer, Integer> shortestPaths3 = findShortestPath(4, edges3, 0);
        assert shortestPaths3.get(0) == 0 : "Distance to vertex 0 should be 0";
        assert shortestPaths3.get(1) == 1 : "Distance to vertex 1 should be 1";
        assert shortestPaths3.get(2) == 3 : "Distance to vertex 2 should be 3";
        assert shortestPaths3.get(3) == -1 : "Distance to vertex 3 should be -1 (unreachable)";

        // Test Case 4: Negative weights (should throw exception)
        final List<List<Integer>> edges4 = Arrays.asList(
                Arrays.asList(0, 1, -1),
                Arrays.asList(1, 2, -2)
        );
        try {
            findShortestPath(3, edges4, 0);
            assert false : "Should throw IllegalArgumentException for negative weights";
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        // Test Case 5: Source vertex out of bounds
        final List<List<Integer>> edges5 = Arrays.asList(
                Arrays.asList(0, 1, 1),
                Arrays.asList(1, 2, 2)
        );
        try {
            findShortestPath(3, edges5, 3);
            assert false : "Should throw IndexOutOfBoundsException for out of bounds source vertex";
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }

        // Test Case 6: Source vertex less than 0
        final List<List<Integer>> edges6 = Arrays.asList(
                Arrays.asList(0, 1, 1),
                Arrays.asList(1, 2, 2)
        );
        try {
            findShortestPath(3, edges6, -1);
            assert false : "Should throw IndexOutOfBoundsException for source vertex less than 0";
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }

        // Test Case 7: Number of vertices < 2
        final List<List<Integer>> edges7 = List.of(
                Arrays.asList(0, 1, 1)
        );
        try {
            findShortestPath(1, edges7, 0);
            assert false : "Should throw IllegalArgumentException for number of vertices less than 2";
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        // Test Case 8: Invalid edges (edge size != 3)
        final List<List<Integer>> edges8 = List.of(
                Arrays.asList(0, 1)
        );
        try {
            findShortestPath(2, edges8, 0);
            assert false : "Should throw IllegalArgumentException for invalid edge";
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        // Test Case 9: Invalid weights (weight < 1)
        final List<List<Integer>> edges9 = List.of(
                Arrays.asList(0, 1, 0)
        );
        try {
            findShortestPath(2, edges9, 0);
            assert false : "Should throw IllegalArgumentException for edge weight less than 1";
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        // Test Case 10: Invalid weights (weight > 10)
        final List<List<Integer>> edges10 = List.of(
                Arrays.asList(0, 1, 11)
        );
        try {
            findShortestPath(2, edges10, 0);
            assert false : "Should throw IllegalArgumentException for edge weight greater than 10";
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        // Test Case 11: Number of vertices > 100
        final List<List<Integer>> edges11 = List.of(
                Arrays.asList(0, 1, 1)
        );
        try {
            findShortestPath(101, edges11, 0);
            assert false : "Should throw IllegalArgumentException for number of vertices greater than 100";
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    private static Map<Integer, Integer> findShortestPath(final int numberOfVertices,
                                                          final List<List<Integer>> edges,
                                                          final int sourceVertex) {
        final Solution solution = new Solution();
        return solution.shortestPath(numberOfVertices, edges, sourceVertex);
    }

    /**
     * Private constructor to prevent instantiation.
     * <p>
     * This constructor is intentionally declared as private to prevent instantiation of this test class.
     * All methods in this class are static and should be accessed statically.
     * </p>
     */
    private DijkstraAlgorithmTest() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }

}
