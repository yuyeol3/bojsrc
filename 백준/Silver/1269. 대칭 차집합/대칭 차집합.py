import sys

noa, nob = map(int, sys.stdin.readline().rstrip().split())

a = set(map(int, sys.stdin.readline().rstrip().split()))
b = set(map(int, sys.stdin.readline().rstrip().split()))


res = a.symmetric_difference(b)

sys.stdout.write(f"{len(res)}")
