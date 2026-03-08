import sys

t = int(sys.stdin.readline())

for _ in range(t):
    wears = {}
    wear_n = int(sys.stdin.readline())

    for i in range(wear_n):
        _, wear_c = sys.stdin.readline().rstrip().split()

        if wear_c in wears:
            wears[wear_c] += 1

        else:
            wears[wear_c] = 1

    answer = 1
    for key in wears:
        answer *= (wears[key] + 1)

    answer -= 1
    sys.stdout.write(f"{answer}\n")
