def optimal_broadcasting(states_to_broadcast, stations):

    final_stations = set()

    while states_to_broadcast:
        best_station = None
        states_covered = set()
        for station, states in stations.items():
            covered = states_to_broadcast & states
            if len(covered) > len(states_covered):
                best_station = station
                states_covered = covered

        states_to_broadcast -= states_covered
        final_stations.add(best_station)
    return final_stations

states_to_broadcast = set(["mt", "wa", "or", "id", "nv", "ut", "ca", "az"])
stations = {"kone" : {"id", "nv", "ut"}, "ktwo" : {"wa", "id", "mt"}, "kthree" : {"or", "nv", "ca"},
            "kfour" : {"nv", "ut"}, "kfive" : {"ca", "az"}}
print(optimal_broadcasting(states_to_broadcast, stations))