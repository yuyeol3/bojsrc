import sys

n, m = map(int, sys.stdin.readline().rstrip().split())

sets = set()
for _ in range(n):
    sets.add(
        sys.stdin.readline().rstrip()
    )

isin = 0

for _ in range(m):
    to_check = sys.stdin.readline().rstrip()
    if to_check in sets:
        isin += 1

sys.stdout.write(f"{isin}\n")

