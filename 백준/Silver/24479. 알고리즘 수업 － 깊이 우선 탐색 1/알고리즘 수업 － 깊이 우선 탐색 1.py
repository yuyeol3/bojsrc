import sys

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


QU = {}

def dfs(v, r, done):
    global QU
    QU[r] = len(QU) + 1
    done.add(r)

    if r not in v:
        return

    for x in v[r]:
        if x not in done:
            dfs(v, x, done)
    return

done = set()
dfs(graph, r, done)

for i in range(1, n + 1):
    if i in QU:
        sys.stdout.write(f"{QU[i]}\n")
    else:
        sys.stdout.write(f"0\n")
    