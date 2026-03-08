import sys
from collections import deque

sys.setrecursionlimit(100000000)

n, m, r = map(int, sys.stdin.readline().split())
graph = {}

# 입력받기
for _ in range(m):
    x, y = map(int, sys.stdin.readline().split())
    if x not in graph:
        graph[x] = set()
    if y not in graph:
        graph[y] = set()
    graph[x].add(y)
    graph[y].add(x)

# 리스트로 변환 및 오름차순 정렬
for key in graph:
    graph[key] = list(graph[key])
    graph[key].sort()



def bfs(v, r):
    global done, qu, vis_ord
    done.add(r)
    vis_ord[r] = len(vis_ord) + 1
    qu.append(r)
    while (qu):
        u = qu.popleft()
        for i in v[u]:
            if i not in done:
                done.add(i)
                vis_ord[i] = len(vis_ord) + 1
                qu.append(i)
    return


done = set()
qu = deque()
vis_ord = {}

bfs(graph, r)
for i in range(1, n + 1):
    if i in vis_ord:
        sys.stdout.write(f"{vis_ord[i]}\n")
    else:
        sys.stdout.write("0\n")