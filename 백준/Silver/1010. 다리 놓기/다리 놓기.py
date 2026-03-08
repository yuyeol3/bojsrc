import sys

def fact(n):
    res = 1
    while (n):
        res *= n
        n -= 1

    return res

def comb(n, r):
    res = 1
    for i in range(r):
        res *= (n - i)

    return res // fact(r)


t = int(sys.stdin.readline())

for _ in range(t):
    n, m = map(int, sys.stdin.readline().split())
    sys.stdout.write(f"{comb(m, n)}\n")

