package BaeldungImplementations;
import java.util.*;

public class GraphBaeldung {
    private static class Vertex {
        String label;
        Vertex(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        // equals and hashCode
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return Objects.equals(label, vertex.label);
        }

        @Override
        public int hashCode() {
            return Objects.hash(label);
        }
        //adjacency list could also be in here, but then we would just skip Map structure entirely and just have a List or Tree or hash table of Vertices
    }
    private Map<Vertex, List<Vertex>> map;

    // standard constructor, getters, setters
    public GraphBaeldung() {
        this.map = new HashMap<>();
    }
    public Map<Vertex, List<Vertex>> getMap() {
        return map;
    }

    public void setMap(Map<Vertex, List<Vertex>> map) {
        this.map = map;
    }

    public void addVertex(String label) {
        map.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(String label) {
        Vertex v = new Vertex(label);
        map.values().stream().forEach(e -> e.remove(v));
        map.remove(new Vertex(label));
    }

    void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        map.get(v1).add(v2);
        map.get(v2).add(v1);
    }

    void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = map.get(v1);
        List<Vertex> eV2 = map.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    List<Vertex> getAdjVertices(String label) {
        return map.get(new Vertex(label));
    }

    public GraphBaeldung createGraph() {
        GraphBaeldung graph = new GraphBaeldung();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        return graph;
    }
    public Set<String> depthFirstTraversal(GraphBaeldung graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : graph.getAdjVertices(vertex)) {
                    stack.push(v.label);
                }
            }
        }
        return visited;
    }

    public Set<String> breadthFirstTraversal(GraphBaeldung graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            for (Vertex v : graph.getAdjVertices(vertex)) {
                if (!visited.contains(v.label)) {
                    visited.add(v.label);
                    queue.add(v.label);
                }
            }
        }
        return visited;
    }



}
