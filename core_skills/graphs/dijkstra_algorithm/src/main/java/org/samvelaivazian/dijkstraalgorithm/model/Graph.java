package org.samvelaivazian.dijkstraalgorithm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents a graph using an adjacency list.
 * Each vertex points to a list of edges, where each edge has a destination vertex and a weight.
 */
public final class Graph {

    /**
     * Adjacency list representing the graph.
     * The key is the source vertex, and the value is a list of edges originating from that vertex.
     */
    private final Map<Integer, List<Edge>> adjacencyList;

    /**
     * Constructs a Graph with a specified number of vertices and edges.
     *
     * @param numberOfVertices The number of vertices in the graph
     * @param edges            A list of edges, where each edge is represented as a list of integers
     *                         [source, destination, weight]
     * @throws IllegalArgumentException if the vertices count is out of the valid range or edges contain invalid data
     * @complexity Time: O(V + E), where V is the number of vertices, and E is the number of edges.
     *             Space: O(V + E), to store the adjacency list and the edges.
     */
    public Graph(final int numberOfVertices, final List<List<Integer>> edges) {
        validateInputData(numberOfVertices, edges);

        // Initialize the adjacency list
        this.adjacencyList = new HashMap<>();
        for (int vertex = 0; vertex < numberOfVertices; vertex++) {
            this.adjacencyList.put(vertex, new ArrayList<>());
        }

        // Populate the adjacency list with edges
        for (List<Integer> edge : edges) {
            final int sourceVertex = edge.get(0);
            final int destinationVertex = edge.get(1);
            final int weight = edge.get(2);
            final Edge directedEdge = new Edge(destinationVertex, weight);

            this.adjacencyList.get(sourceVertex).add(directedEdge);
        }
    }

    /**
     * Returns the adjacency list of the graph.
     *
     * @return The adjacency list
     * @complexity Time: O(1). Space: O(1).
     */
    public Map<Integer, List<Edge>> getAdjacencyList() {
        return adjacencyList;
    }

    /**
     * Validates the input data for the graph.
     *
     * @param numberOfVertices The number of vertices in the graph
     * @param edges            A list of edges, where each edge is represented as a list of integers
     *                         [source, destination, weight]
     * @throws IllegalArgumentException if the vertices count is out of the valid range or edges contain invalid data
     * @complexity Time: O(E), where E is the number of edges. Space: O(1).
     */
    private void validateInputData(final int numberOfVertices, final List<List<Integer>> edges) {
        if (numberOfVertices < 2 || numberOfVertices > 100) {
            throw new IllegalArgumentException("Invalid number of vertices in the graph!");
        }

        final boolean hasInvalidEdges = edges.stream().anyMatch(edge -> edge.size() != 3);
        if (hasInvalidEdges) {
            throw new IllegalArgumentException(
                    "Each edge should have exactly 3 elements: source, destination, and weight!"
            );
        }

        final boolean hasInvalidWeights = edges.stream().anyMatch(edge -> {
            final int weight = edge.getLast();
            return weight < 1 || weight > 10;
        });
        if (hasInvalidWeights) {
            throw new IllegalArgumentException("Edge weights must be between 1 and 10!");
        }
    }

}
