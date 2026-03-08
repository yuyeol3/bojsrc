import sys

n = int(sys.stdin.readline().rstrip())

cards = {}

having = map(int, sys.stdin.readline().rstrip().split())


for num in having:

    if num not in cards:
        cards[num] = 1
    else:
        cards[num] += 1


m = int(sys.stdin.readline().rstrip())

to_check = list(map(int, sys.stdin.readline().rstrip().split()))

for num in to_check:
    if num in cards:
        sys.stdout.write(f"{cards.get(num)} ")
    else:
        sys.stdout.write("0 ")

sys.stdout.write("\n")