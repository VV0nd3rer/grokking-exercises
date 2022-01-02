import java.util.*;

public class BreadthFirstSearch {

    public Graph makeFriends() {
        Graph graph = new Graph();
        graph.addVertex("Bob"); // -> Alice, Rob
        graph.addVertex("Alice"); // -> Bob, Mark, Maria
        graph.addVertex("Mark"); // ->
        graph.addVertex("Rob"); // ->
        graph.addVertex("Maria"); // -> Alice, Rob, Bob, Mark
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        return graph;
    }

    public Set<String> BFTraversal(Graph graph, String whoToStartFrom) {
        Set<String> visitedFriends = new LinkedHashSet<>();
        Queue<String> friendsToCheck = new LinkedList<>();

        visitedFriends.add(whoToStartFrom);
        friendsToCheck.add(whoToStartFrom);

        while (!friendsToCheck.isEmpty()) {
            String personToCheck = friendsToCheck.poll();

            for (Vertex person : graph.getAdjacencyVertices(personToCheck)) {
                if (!visitedFriends.contains(person.getValue())) {
                    visitedFriends.add(person.getValue());
                    friendsToCheck.add(person.getValue());
                }
            }
        }
        return visitedFriends;
    }

    public Vertex BFSearch(Graph graph, String personToFind, String personToStartWith) {
        Set<String> visitedFriends = new LinkedHashSet<>();
        Queue<String> friendsToVisit = new LinkedList<>();
        visitedFriends.add(personToStartWith);
        friendsToVisit.add(personToStartWith);
        while (!friendsToVisit.isEmpty()) {
            String personToCheck = friendsToVisit.poll();
            for (Vertex person : graph.getAdjacencyVertices(personToCheck)) {
                if (!visitedFriends.contains(person.getValue())){
                    if (person.getValue().equals(personToFind)) {
                        return person;
                    }
                    visitedFriends.add(person.getValue());
                    friendsToVisit.add(person.getValue());
                }
            }

        }
        return null;
    }
}

class Graph {
    private Map<Vertex, List<Vertex>> adjacencyVertices;

    public Graph() {
        adjacencyVertices = new HashMap<>();
    }

    public Map<Vertex, List<Vertex>> getGraphVertices() {
        return adjacencyVertices;
    }

    public List<Vertex> getAdjacencyVertices(String value) {
        return adjacencyVertices.get(new Vertex(value));
    }

    public void addVertex(String val) {
        this.adjacencyVertices.putIfAbsent(new Vertex(val), new ArrayList<>());
//        adjacencyVertices.put(vertex, new ArrayList<>());
    }

    public void removeVertex(String val) {
        Vertex toRemove = new Vertex(val);
        adjacencyVertices.values().stream().forEach(list -> list.remove(toRemove));
        adjacencyVertices.remove(toRemove);
    }

    public void addEdge(String val1, String val2) {
        Vertex person1 = new Vertex(val1);
        Vertex person2 = new Vertex(val2);
        adjacencyVertices.get(person1).add(person2);
        adjacencyVertices.get(person2).add(person1);
    }

    public void removeEdge(String val1, String val2) {
        Vertex person1 = new Vertex(val1);
        Vertex person2 = new Vertex(val2);

        List person1Friend2 = adjacencyVertices.get(person1);
        if (person1Friend2 != null) {
            person1Friend2.remove(person2);
        }
        List person2Friend1 = adjacencyVertices.get(person2);
        if (person2Friend1 != null) {
            person2Friend1.remove(person1);
        }
    }
}

class Vertex {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Vertex(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return value.equals(vertex.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}