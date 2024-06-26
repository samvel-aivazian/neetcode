package org.samvelaivazian.dijkstraalgorithm;

/**
 * This class represents a node in the priority queue, containing the distance and the vertex.
 *
 * @param distance The distance of the node from the source
 * @param vertex   The vertex represented by the node
 * @complexity Time: O(1). Space: O(1).
 */
public record Node(int distance, int vertex) {
}
