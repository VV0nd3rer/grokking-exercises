from collections import deque

def searchBF(name):
    search_queue = deque()
    search_queue += graph[name]
    while search_queue:
        person = search_queue.popleft()
        if person_is_dancer(person):
            print("{} is dancer!".format(person))
            return True
        else:
            search_queue += graph[person]
    return False

def person_is_dancer(name):
    return name[0] == 'k'

graph = {}
graph["me"]=["nick", "andrew", "ira"]
graph["nick"]=[]
graph["andrew"]=[]
graph["ira"]=["lidka", "katka"]
graph["lidka"]=[]
graph["katka"]=[]

searchBF("me")