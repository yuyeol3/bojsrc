import sys
import heapq

def allocate_rooms(classes):
    priority_queue = []  
    req_room = 0
    for _class in classes:
        while priority_queue and priority_queue[0] <= _class[0]:
            heapq.heappop(priority_queue)
        heapq.heappush(priority_queue, _class[1]) 
        req_room = max(req_room, len(priority_queue))  
    return req_room

if __name__ == "__main__":
    n = int(sys.stdin.readline())
    classes = []

    for _ in range(n):
        classes.append(tuple(map(int, sys.stdin.readline().split())))

    classes.sort()  # Sort based on class start time

    required_rooms = allocate_rooms(classes)
    sys.stdout.write(f"{required_rooms}\n")
