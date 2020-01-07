package edu.forty.bits.datastructures.array;

import edu.forty.bits.datastructures.annotations.Array;
import edu.forty.bits.datastructures.annotations.Graph;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Each year, the govt. releases a list of the 10000 most common baby names and their frequencies.
 * The only problem with this is that some names have multiple spellings. For example "John" and "Jon"
 * which are essentially the same name but are listed separately. Given two lists, once of the names
 * and frequency and the other of the pairs of equivalent names, write an algorithm to print a new list
 * of the true frequency of each name. Note that, the pairs are both transitive and symmetric. In the final
 * list, any name can be used as a real name.
 */
@Graph
@Array
public class BabyNames {

    // todo: time-complexity?
    private Map<String, Integer> mergeFrequencies(Map<String, Integer> nameFrequencies, List<Pair> pairs) {
        Map<Pair, Set<String>> collectivePairs = pairs.stream()
                .collect(Collectors.toMap(Function.identity(),
                        pair -> new HashSet<>(Arrays.asList(pair.getSource(), pair.getDestination())),
                        (pair1, pair2) -> {
                            pair1.addAll(pair2);
                            return pair1;
                        }));
        return collectivePairs.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey().getSource(),
                        e -> e.getValue().stream()
                                .mapToInt(nameFrequencies::get).sum()));
        // the above implementation missed the names, that are a part of the frequency map
        // but do not have any synonym
    }

    @Getter
    static class Pair {
        String source;
        String destination;

        // implement equals in such a way that even if any of source or destination matches,
        // one finds the pairs as equal
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(source, pair.source) || Objects.equals(source, pair.destination) ||
                    Objects.equals(destination, pair.destination) || Objects.equals(destination, pair.source);
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination);
        }
    }


    // Another approach would be creating a graph while iterating the synonym pairs
    // and traversing each of its node performing a DFS/BFS to get the values from frequency table


    /* Add all names to graph as nodes. */
    public static Graph constructGraph(Map<String, Integer> names) {
        Graph graph = new Graph();
        for (Map.Entry<String, Integer> entry : names.entrySet()) {
            String name = entry.getKey();
            int frequency = entry.getValue();
            graph.createNode(name, frequency);
        }
        return graph;
    }

    /* Connect synonymous spellings. */
    public static void connectEdges(Graph graph, String[][] synonyms) {
        for (String[] entry : synonyms) {
            String name1 = entry[0];
            String name2 = entry[1];
            graph.addEdge(name1, name2);
        }
    }

    /* Do depth-first search to find the total frequency of this
     * component, and mark each node as visited.*/
    public static int getComponentFrequency(GraphNode node) {
        if (node.isVisited()) {
            return 0;
        }
        node.setVisited(true);
        int sum = node.getFrequency();
        for (GraphNode child : node.getNeighbors()) {
            sum += getComponentFrequency(child);
        }
        return sum;
    }

    /* Do DFS of each component. If a node has been visited before,
     * then its component has already been computed. */
    public static Map<String, Integer> getTrueFrequencies(Graph graph) {
        return graph.getNodes().stream()
                .filter(node -> !node.isVisited())
                .collect(Collectors.toMap(GraphNode::getName, BabyNames::getComponentFrequency, (a, b) -> b));
    }

    public static Map<String, Integer> trulyMostPopular(Map<String, Integer> names, String[][] synonyms) {
        Graph graph = constructGraph(names);
        connectEdges(graph, synonyms);
        return getTrueFrequencies(graph);
    }

    public static void main(String[] args) {
        HashMap<String, Integer> names = new HashMap<>();
        names.put("John", 3);
        names.put("Jonathan", 4);
        names.put("Johnny", 5);
        names.put("Chris", 1);
        names.put("Kris", 3);
        names.put("Brian", 2);
        names.put("Bryan", 4);
        names.put("Carleton", 4);

        String[][] synonyms =
                {{"John", "Jonathan"},
                        {"Jonathan", "Johnny"},
                        {"Chris", "Kris"},
                        {"Brian", "Bryan"}};

        Map<String, Integer> rootNames = trulyMostPopular(names, synonyms);
        for (Map.Entry<String, Integer> entry : rootNames.entrySet()) {
            String name = entry.getKey();
            int frequency = entry.getValue();
            System.out.println(name + ": " + frequency);
        }
    }


    @Getter
    @Setter
    static class GraphNode {
        private List<GraphNode> neighbors;
        private Map<String, GraphNode> map;
        private String name;
        private int frequency;
        private boolean visited = false;

        public GraphNode(String nm, int freq) {
            name = nm;
            frequency = freq;
            neighbors = new ArrayList<>();
            map = new HashMap<>();
        }

        public boolean addNeighbor(GraphNode node) {
            if (map.containsKey(node.getName())) {
                return false;
            }
            neighbors.add(node);
            map.put(node.getName(), node);
            return true;
        }
    }


    @Getter
    static class Graph {
        private List<GraphNode> nodes;
        private Map<String, GraphNode> map;

        public Graph() {
            map = new HashMap<>();
            nodes = new ArrayList<>();
        }

        public GraphNode createNode(String name, int freq) {
            if (map.containsKey(name)) {
                return getNode(name);
            }
            GraphNode node = new GraphNode(name, freq);
            nodes.add(node);
            map.put(name, node);
            return node;
        }

        public boolean hasNode(String name) {
            return map.containsKey(name);
        }

        private GraphNode getNode(String name) {
            return map.get(name);
        }

        public void addEdge(String startName, String endName) {
            GraphNode start = getNode(startName);
            GraphNode end = getNode(endName);
            if (start != null && end != null) {
                start.addNeighbor(end);
                end.addNeighbor(start);
            }
        }
    }
}