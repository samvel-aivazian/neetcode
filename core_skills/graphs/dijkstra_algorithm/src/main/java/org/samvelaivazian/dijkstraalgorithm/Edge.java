package org.samvelaivazian.dijkstraalgorithm;

/**
 * This class represents an edge in the graph with a destination vertex and a weight.
 * Each edge has a destination vertex and an associated weight representing the cost to travel to that vertex.
 *
 * @param destinationVertex The destination vertex that this edge points to
 * @param weight            The weight of this edge
 * @complexity Time: O(1). Space: O(1).
 */
public record Edge(int destinationVertex, int weight) {
}
