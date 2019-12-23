package edu.forty.bits.datastructures.graph;

public class Graph {
    GraphNode[] nodes;

    public GraphNode[] getNodes() {
        return nodes;
    }

    static class GraphNode {
        int data;
        State state;
        GraphNode[] adjacents;
    }
}