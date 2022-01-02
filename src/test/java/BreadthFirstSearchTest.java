import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BreadthFirstSearchTest {
    BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();

    @Test
    void shouldBFTraversal1() {
        Graph friends = breadthFirstSearch.makeFriends();

        assertEquals(
                "[Bob, Alice, Rob, Mark, Maria]",
                breadthFirstSearch.BFTraversal(friends, "Bob").toString());
    }

    @Test
    void shouldBFTraversal2() {
        Graph friends = breadthFirstSearch.makeFriends();

        assertEquals(
                "[Alice, Bob, Mark, Maria, Rob]",
                breadthFirstSearch.BFTraversal(friends, "Alice").toString());
    }

    @Test
    void shouldBFTraversal3() {
        Graph friends = breadthFirstSearch.makeFriends();

        assertEquals(
                "[Maria, Alice, Rob, Bob, Mark]",
                breadthFirstSearch.BFTraversal(friends, "Maria").toString());
    }

    @Test
    void shouldFindBFSearch() {
        Graph friends = breadthFirstSearch.makeFriends();

        assertEquals(
                new Vertex("Alice"),
                breadthFirstSearch.BFSearch(friends, "Alice", "Bob"));
    }

    @Test
    void shouldNotFindBFSearch() {
        Graph friends = breadthFirstSearch.makeFriends();

        assertNull(breadthFirstSearch.BFSearch(friends, "Lucy", "Bob"));
    }
}