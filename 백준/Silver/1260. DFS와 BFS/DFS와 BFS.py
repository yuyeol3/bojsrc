import sys
from collections import deque

n, m, v = map(int, sys.stdin.readline().split())

graph = {}

# 그래프 생성
for node in range(1, n + 1):
    graph[node] = set()

# 입력받기
for _ in range(m):
    x, y = map(int, sys.stdin.readline().split())
    graph[x].add(y)
    graph[y].add(x)


for key in graph:
    graph[key] = list(graph[key])
    graph[key].sort()

# 함수 정의
def dfs(graph, st):
    global done
    sys.stdout.write(f"{st} ")
    done.add(st)

    for x in graph[st]:
        if x not in done:
            dfs(graph, x)
    return

def bfs(graph, st):
    global done, qu
    sys.stdout.write(f"{st} ")
    done.add(st)
    qu.append(st)
    while (qu):
        u = qu.popleft()
        for i in graph[u]:
            if i not in done:
                sys.stdout.write(f"{i} ")
                done.add(i)
                qu.append(i)
    return

done = set()
dfs(graph, v)
sys.stdout.write("\n")

done.clear()
qu = deque()
bfs(graph, v)
sys.stdout.write("\n")