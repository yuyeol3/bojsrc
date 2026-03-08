import sys

string = sys.stdin.readline().rstrip()
sub_strings = set()

length = len(string)

for st in range(1, length + 1):
    for i in range(length - st + 1):
        to_add = string[i:i+st]
        sub_strings.add(to_add)

sys.stdout.write(f"{len(sub_strings)}\n")