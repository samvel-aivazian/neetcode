package org.samvelaivazian.dijkstraalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public final class Solution {

    // ToDo: continue implementation
    public Map<Integer, Integer> shortestPath(final int n, final List<List<Integer>> edges, final int src) {
        if (n < 2 || n > 100) {
            throw new IllegalArgumentException("Invalid number of vertices in the graph!");
        }
        if (src < 0 || src >= n) {
            throw new IllegalArgumentException("Invalid source vertex id!");
        }
        edges.stream().map(edge -> edge.get(2)).filter(weight -> weight < 1 || weight > 10).findFirst()
                .orElseThrow();

        final Map<Integer, Integer> shortestDistancesMap = new TreeMap<>();

        // routes to vertex from starting:
        // 0 - only 0
        // 1
        // 0 -> 1
        // 0 -> 2 -> 1
        // 2
        // 0 -> 2
        // 3
        // 0 -> 1 -> 3
        // 0 -> 2 -> 1 -> 3
        // 0 -> 2 -> 3
        // 4
        // 0 -> 1 -> 3 -> 4
        // 0 -> 2 -> 1 -> 3 -> 4
        // 0 -> 2 -> 3 -> 4
        // 0 -> 2 -> 4

        for (int i = 0; i < n; i++) {

        }

        return shortestDistancesMap;
    }

    private static class Edge {
        int targetNode;
        int distance;

        public Edge(int targetNode, int distance) {
            this.targetNode = targetNode;
            this.distance = distance;
        }
    }

    private static class Graph {
        private final int nodes;
        private final List<List<Edge>> adjacencyList;

        public Graph(int nodes) {
            this.nodes = nodes;
            adjacencyList = new ArrayList<>(nodes);
            for (int i = 0; i < nodes; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v, int weight) {
            adjacencyList.get(u).add(new Edge(v, weight));
        }

        private int[] dijkstra(int startNode) {
            int[] distances = new int[nodes];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[startNode] = 0;

            PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.distance));
            priorityQueue.add(new Edge(startNode, 0));

            boolean[] visited = new boolean[nodes];

            while (!priorityQueue.isEmpty()) {
                Edge current = priorityQueue.poll();
                int currentNode = current.targetNode;

                if (visited[currentNode]) continue;
                visited[currentNode] = true;

                for (Edge neighbor : adjacencyList.get(currentNode)) {
                    if (!visited[neighbor.targetNode]) {
                        int newDist = distances[currentNode] + neighbor.distance;
                        if (newDist < distances[neighbor.targetNode]) {
                            distances[neighbor.targetNode] = newDist;
                            priorityQueue.add(new Edge(neighbor.targetNode, newDist));
                        }
                    }
                }
            }

            return distances;
        }
    }
}

