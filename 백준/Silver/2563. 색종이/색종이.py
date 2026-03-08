import sys

background = []

for _ in range(100):
    background.append([0] * 100)


t = int(sys.stdin.readline())

for _ in range(t):
    x, y = map(int, sys.stdin.readline().split())

    for i in range(x, x + 10):
        for j in range(y, y + 10):
            background[i][j] = 1

area = 0
for lst in background:
    area += sum(lst)

sys.stdout.write(f"{area}\n")
