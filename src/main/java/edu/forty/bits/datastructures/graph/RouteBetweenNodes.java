package edu.forty.bits.datastructures.graph;

import java.util.LinkedList;

/**
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */
public class RouteBetweenNodes {

    // The problem is to perform more of a BFS on the graph, though even DFS works in this case
    // with O(N) runtime complexity. Marking nodes as visited would be the primary responsibility
    // while traversing to reduce repeated traversal.
    private static boolean searchRoute(Graph graph, Graph.GraphNode start, Graph.GraphNode end) {
        if (start == end) {
            return true;
        }
        var list = new LinkedList<Graph.GraphNode>(); // for queuing capability

        for (Graph.GraphNode gn : graph.getNodes()) {
            gn.state = State.UNVISITED;
        }
        start.state = State.VISITING;
        list.add(start);
        Graph.GraphNode node;
        while (!list.isEmpty()) {
            node = list.removeFirst(); // dequeue
            if (node != null) {
                for (Graph.GraphNode graphNode : node.adjacent) {
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


    public static void main(String[] args) {
        Graph g = createNewGraph();
        Graph.GraphNode[] n = g.getNodes();
        Graph.GraphNode start = n[3];
        Graph.GraphNode end = n[5];
        System.out.println(searchRoute(g, start, end));
    }

    public static Graph createNewGraph() {
        Graph g = new Graph();
        Graph.GraphNode[] temp = new Graph.GraphNode[6];

        temp[0] = new Graph.GraphNode("a", 3);
        temp[1] = new Graph.GraphNode("b", 0);
        temp[2] = new Graph.GraphNode("c", 0);
        temp[3] = new Graph.GraphNode("d", 1);
        temp[4] = new Graph.GraphNode("e", 1);
        temp[5] = new Graph.GraphNode("f", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);
        for (int i = 0; i < 6; i++) {
            g.addNode(temp[i]);
        }
        return g;
    }
}