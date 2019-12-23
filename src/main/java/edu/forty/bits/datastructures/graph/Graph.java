package edu.forty.bits.datastructures.graph;

public class Graph {
    GraphNode[] nodes;
    public static int MAX_VERTICES = 6;
    public int count;

    public GraphNode[] getNodes() {
        return nodes;
    }

    static class GraphNode {
        int data;
        State state;
        GraphNode[] adjacent;
        public int adjacentCount;
        private String vertex;

        public GraphNode(String vertex, int adjacentLength) {
            this.vertex = vertex;
            adjacentCount = 0;
            adjacent = new GraphNode[adjacentLength];
        }

        public void addAdjacent(GraphNode x) {
            if (adjacentCount < adjacent.length) {
                this.adjacent[adjacentCount] = x;
                adjacentCount++;
            } else {
                System.out.print("No more adjacent can be added");
            }
        }
    }

    public Graph() {
        nodes = new GraphNode[MAX_VERTICES];
        count = 0;

    }

    public void addNode(GraphNode x) {
        if (count < nodes.length) {
            nodes[count] = x;
            count++;
        } else {
            System.out.print("Graph full");
        }
    }
}