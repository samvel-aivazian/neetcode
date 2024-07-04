package org.samvelaivazian.dijkstraalgorithm;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * This class provides a method to compute the shortest paths from a source vertex to all other vertices in a graph
 * using Dijkstra's algorithm.
 */
public final class Solution {

    /**
     * Computes the shortest paths from the source vertex to all other vertices in the graph using Dijkstra's algorithm.
     *
     * @param n     The number of vertices in the graph
     * @param edges A list of edges, where each edge is represented as a list of integers
     *              [source, destination, weight]
     * @param src   The source vertex
     * @return A map where the keys are vertices, and the values are the shortest distance from the source vertex
     *         to that vertex or -1 if the vertex is unreachable from the source
     * @throws IndexOutOfBoundsException if the source vertex is out of bounds
     * @complexity Time: O((V + E) log V), where V is the number of vertices, and E is the number of edges.
     *             Space: O(V + E), to store the adjacency list, the shortest path map, and the priority queue.
     */
    public Map<Integer, Integer> shortestPath(final int n, final List<List<Integer>> edges, final int src) {
        // Check if the source vertex is out of bounds
        if (src < 0 || src >= n) {
            throw new IndexOutOfBoundsException("Source vertex is out of bounds, must be within 0 and " + (n - 1));
        }

        // Create a graph using the provided number of vertices and edges
        final Graph graph = new Graph(n, edges);

        // Initialize a map to store the shortest distances from the source to each vertex
        final Map<Integer, Integer> shortestDistances = new HashMap<>();

        // Initialize a priority queue to manage the vertices to be processed, ordered by the shortest distance
        final Queue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Node::distance));

        // Add the source vertex to the priority queue with a distance of 0
        final Node sourceNode = new Node(0, src);
        priorityQueue.offer(sourceNode);

        // While there are vertices to process in the priority queue
        while (!priorityQueue.isEmpty()) {
            // Extract the vertex with the smallest known distance from the priority queue
            final Node currentNode = priorityQueue.poll();
            final int currentDistance = currentNode.distance();
            final int currentVertex = currentNode.vertex();

            // If the vertex has already been processed, skip it
            if (shortestDistances.containsKey(currentVertex)) {
                continue;
            }

            // Mark the vertex as processed by adding it to the shortest distances map
            shortestDistances.put(currentVertex, currentDistance);

            // Process neighbors of the current vertex
            graph.getAdjacencyList().get(currentVertex)
                    .stream()
                    .filter(edge -> !shortestDistances.containsKey(edge.destinationVertex()))
                    .forEach(edge -> {
                        final int newDistance = currentDistance + edge.weight();
                        final Node neighborNode = new Node(newDistance, edge.destinationVertex());

                        // Add the neighbor vertex to the priority queue with the new distance
                        priorityQueue.offer(neighborNode);
                    });
        }

        // Set distance to -1 for nodes that are unreachable from the source using streams
        IntStream.range(0, n).forEach(i -> shortestDistances.putIfAbsent(i, -1));

        return shortestDistances;
    }

}
