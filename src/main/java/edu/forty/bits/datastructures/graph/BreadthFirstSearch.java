package edu.forty.bits.datastructures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Print BFS traversal from a given source vertex. BFS(int s) traverses vertices reachable from s.
public class BreadthFirstSearch {

    // This class represents a directed graph using adjacency list representation
    static class Graph {
        private final int verticesCount;
        private final List<Integer>[] adjacencyList;

        // Constructor
        Graph(int verticesCount) {
            this.verticesCount = verticesCount;
            adjacencyList = new ArrayList[verticesCount];
            for (int i = 0; i < verticesCount; ++i) adjacencyList[i] = new ArrayList<>();
        }

        // Function to add an edge into the graph
        void addEdge(int v, int w) {
            adjacencyList[v].add(w);
        }

        // prints BFS traversal from a given source s
        void breadthFirstSearch(int source) {
            // Mark all the vertices as not visited(By default set as false)
            boolean[] visited = new boolean[verticesCount];

            // Create a queue for BFS
            LinkedList<Integer> queue = new LinkedList<>();

            // Mark the current node as visited and enqueue it
            visited[source] = true;
            queue.add(source);

            while (queue.size() != 0) {
                // Dequeue a vertex from queue and print it
                source = queue.poll();
                System.out.print(source + " ");

                // Get all adjacent vertices of the dequeued vertex s
                // If a adjacent has not been visited, then mark it visited and enqueue it
                for (int n : adjacencyList[source]) {
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("\nFollowing is Breadth First Traversal (starting from vertex 2) : ");
        graph.breadthFirstSearch(2);
        System.out.println("\nFollowing is Breadth First Traversal (starting from vertex 1) : ");
        graph.breadthFirstSearch(1);
    }
}