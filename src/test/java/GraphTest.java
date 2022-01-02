import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    private final static String LEELA = "Leela";
    private final static String FRY = "Fry";
    private final static String BENDER = "Bender";

    @Test
    void shouldAddVertex() {
        Graph friends = new Graph();
        friends.addVertex(LEELA);

        Vertex result = friends.getGraphVertices().keySet().stream()
                .filter(k -> k.getValue().equals(LEELA)).findFirst().get();

        assertAll(
                () -> assertEquals(LEELA, result.getValue()),
                () -> assertEquals(new Vertex(LEELA), result)
        );
    }

    @Test
    void shouldAddEdge() {
        Graph friends = new Graph();
        friends.addVertex(LEELA);
        friends.addVertex(FRY);
        friends.addEdge(LEELA, FRY);

        List<Vertex> leelaFriends = friends.getGraphVertices().entrySet().stream()
                .filter(e -> e.getKey().getValue().equals(LEELA))
                .findFirst()
                .get()
                .getValue();

        List<Vertex> fryFriends = friends.getGraphVertices().entrySet().stream()
                .filter(e -> e.getKey().getValue().equals(FRY))
                .findFirst().get()
                .getValue();

        assertAll(
                () -> assertTrue(leelaFriends.contains(new Vertex(FRY))),
                () -> assertTrue(fryFriends.contains(new Vertex(LEELA)))
        );
    }
}