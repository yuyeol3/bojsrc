import sys


def five_count(n):
    cnt = 0
    while n != 0:
        n //= 5
        cnt += n
    return cnt

def two_count(n):
    cnt = 0
    while n != 0:
        n //= 2
        cnt +=n
    return cnt

n, r = map(int, sys.stdin.readline().split())

n_five = five_count(n) - five_count(n-r) - five_count(r)
n_two = two_count(n) - two_count(n-r) - two_count(r)

res = min(n_five, n_two)

sys.stdout.write(f"{res}\n")