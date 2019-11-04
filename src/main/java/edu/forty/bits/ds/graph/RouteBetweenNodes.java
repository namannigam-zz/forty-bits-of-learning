package edu.forty.bits.ds.graph;

import java.util.LinkedList;

public class RouteBetweenNodes {

  // this is more of a BFS on the graph, though even DFS works in this case with O(N) runtime
  // complexity
  // marking nodes as visited would be the primary responsibility while traversing to reduce
  // repeated traversal
  boolean searchRoute(Graph graph, GraphNode start, GraphNode end) {
    if (start == end) {
      return true;
    }
    LinkedList<GraphNode> list = new LinkedList<>();

    for (GraphNode gn : graph.getNodes()) {
      gn.state = State.Unvisited;
    }
    start.state = State.Visiting;
    list.add(start);
    GraphNode node;
    while (!list.isEmpty()) {
      node = list.removeFirst(); // dequeue
      if (node != null) {
        for (GraphNode g : node.adjacents) {
          if (g.state == State.Unvisited) {
            if (g == end) {
              return true;
            } else {
              g.state = State.Visiting;
              list.add(g);
            }
          }
        }
        node.state = State.Visited;
      }
    }
    return false;
  }
}
