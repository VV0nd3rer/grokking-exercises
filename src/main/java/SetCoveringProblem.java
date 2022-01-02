import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetCoveringProblem {
    public Set<String> findOptimalStations(Set<String> statesToBroadcast, Map<String, Set<String>> radiostations) {
        Set<String> finalStations = new HashSet<>();

        while (statesToBroadcast.iterator().hasNext()) {
            String bestStation = null;
            Set<String> statesCovered = new HashSet<>();
            for(Map.Entry<String, Set<String>> station : radiostations.entrySet()){
                Set<String> covered = new HashSet<>(statesToBroadcast);
                covered.retainAll(station.getValue());
                if(covered.size() > statesCovered.size()) {
                    statesCovered.clear();
                    statesCovered.addAll(covered);
                    bestStation = station.getKey();
                }
            }
            statesToBroadcast.removeAll(statesCovered);
            finalStations.add(bestStation);
        }

        return finalStations;
    }
}
