import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SetCoveringProblemTest {

    @Test
    void findOptimalStations() {
        Map<String, Set<String>> radiostations = new LinkedHashMap<>();
        radiostations.put("kone", Set.of("id", "nv", "ut"));
        radiostations.put("ktwo", Set.of("wa", "id", "mt"));
        radiostations.put("kthree", Set.of("or", "nv", "ca"));
        radiostations.put("kfour", Set.of("nv", "ut"));
        radiostations.put("kfive", Set.of("ca", "az"));

        SetCoveringProblem setCoveringProblem = new SetCoveringProblem();

        Set<String> optimalRadiostations = setCoveringProblem.findOptimalStations(
                new LinkedHashSet<>(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az")),
                radiostations
        );
        assertEquals(Set.of("kfive", "kthree", "ktwo", "kone"), optimalRadiostations);
        assert(Set.of("kfive", "kthree", "ktwo", "kone")).containsAll(optimalRadiostations);
    }
}