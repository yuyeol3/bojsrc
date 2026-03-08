import sys

n, m = map(int, sys.stdin.readline().rstrip().split())

not_listened = set()
not_seen = set()

for i in range(n):
    to_add = sys.stdin.readline().rstrip()
    not_listened.add(to_add)

for i in range(m):
    to_add = sys.stdin.readline().rstrip()
    not_seen.add(to_add)


res = list(not_listened & not_seen)
res.sort()

sys.stdout.write(f"{len(res)}\n")
for i in res:
    sys.stdout.write(f"{i}\n")