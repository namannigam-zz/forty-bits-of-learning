package edu.forty.bits.datastructures.graph;

import java.util.*;
/**
 * You are given a list of projects and a list of pair of dependencies
 * (second project is a dependent on the first project). All of the project dependencies must be built before
 * the project is. Find a build order that will allow the projects to be build, if there is no valid build order,
 * return the error.
 */
public class BuildOrder {

    // first approach towards this would be that we represent the projects as a graph node
    // and draw the dependencies between them with edges going from independent project to dependent
    // project
    // so the edge A -> B means B depends on A to be build first

    // the exact method to find the build order
    Project[] findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    private Project[] orderProjects(List<Project> projects) {
        Project[] order = new Project[projects.size()];
        int endOfList = addNonDependent(order, projects, 0);

        int toBeProcessed = 0; // pointer to keep a track of all the nodes to be processed

        while (toBeProcessed < order.length) {
            Project current = order[toBeProcessed];
            // circular dependency check
            if (current == null) {
                return null;
            }

            // remove the project from dependency
            List<Project> children = current.getChildren();
            for (Project child : children) {
                child.decrementDependencies();
            }

            // add children that have no dependencies
            endOfList = addNonDependent(order, children, endOfList);
            toBeProcessed++;
        }
        return order;
    }

    private int addNonDependent(Project[] order, List<Project> projects, int offSet) {
        for (Project project : projects) {
            if (project.getDependencies() == 0) {
                order[offSet] = project;
                offSet++;
            }
        }
        return offSet;
    }

    private Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        Arrays.stream(projects).forEach(graph::getOrCreateNode); // create all nodes
        Arrays.stream(dependencies)
                .forEach(
                        dependency ->
                                graph.addEdge(dependency[0], dependency[1])); // create the dependencies and map
        return graph;
    }

    class Project {
        List<Project> children = new ArrayList<>(); // dependent projects for this node
        Map<String, Project> map = new HashMap<>();
        private String name;
        private int dependencies = 0; // count of incoming edges to a node

        Project(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        List<Project> getChildren() {
            return children;
        }

        int getDependencies() {
            return dependencies;
        }

        void addNeighbour(Project node) {
            if (!map.containsKey(node.getName())) {
                children.add(node);
                map.put(name, node);
                node.incrementDependencies();
            }
        }

        void incrementDependencies() {
            dependencies++;
        }

        void decrementDependencies() {
            dependencies--;
        }
    }

    class Graph {
        List<Project> nodes = new ArrayList<>();
        Map<String, Project> map = new HashMap<>();

        Project getOrCreateNode(String name) {
            if (!map.containsKey(name)) {
                Project project = new Project(name);
                nodes.add(project);
                map.put(name, project);
            }
            return map.get(name);
        }

        public List<Project> getNodes() {
            return nodes;
        }

        void addEdge(String startName, String endName) {
            Project start = getOrCreateNode(startName);
            Project end = getOrCreateNode(endName);
            start.addNeighbour(end);
        }
    }
}