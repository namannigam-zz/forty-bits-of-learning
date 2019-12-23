package edu.forty.bits.datastructures.graph;

import java.util.LinkedList;

/**
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */
public class RouteBetweenNodes {

    // The problem is to perform more of a BFS on the graph, though even DFS works in this case
    // with O(N) runtime complexity. Marking nodes as visited would be the primary responsibility
    // while traversing to reduce repeated traversal.
    private boolean searchRoute(Graph graph, Graph.GraphNode start, Graph.GraphNode end) {
        if (start == end) {
            return true;
        }
        LinkedList<Graph.GraphNode> list = new LinkedList<>(); // for queuing capability

        for (Graph.GraphNode gn : graph.getNodes()) {
            gn.state = State.UNVISITED;
        }
        start.state = State.VISITING;
        list.add(start);
        Graph.GraphNode node;
        while (!list.isEmpty()) {
            node = list.removeFirst(); // dequeue
            if (node != null) {
                for (Graph.GraphNode graphNode : node.adjacents) {
                    if (graphNode.state == State.UNVISITED) {
                        if (graphNode == end) {
                            return true;
                        } else {
                            graphNode.state = State.VISITING;
                            list.add(graphNode);
                        }
                    }
                }
                node.state = State.VISITED;
            }
        }
        return false;
    }
}