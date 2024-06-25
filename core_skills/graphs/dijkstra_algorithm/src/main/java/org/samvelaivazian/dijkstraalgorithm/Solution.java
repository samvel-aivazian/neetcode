package org.samvelaivazian.dijkstraalgorithm;

import java.util.List;
import java.util.Map;
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

}
