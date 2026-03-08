import sys

n, m = map(int, sys.stdin.readline().rstrip().split())

name_to_num = {}
num_to_name = {}

for i in range(1, n + 1):
    pokemon = sys.stdin.readline().rstrip()
    name_to_num[pokemon] = i
    num_to_name[i] = pokemon

for i in range(m):
    problem = sys.stdin.readline().rstrip()
    if problem.isnumeric():
        sys.stdout.write(f"{num_to_name[int(problem)]}\n")

    else:
        sys.stdout.write(f"{name_to_num[problem]}\n")
