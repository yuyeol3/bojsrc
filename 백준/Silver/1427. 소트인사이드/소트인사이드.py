import sys

num = list(sys.stdin.readline().rstrip())
num = [int(i) for i in num]

for i in range(len(num) - 1):
    max_idx = i
    for j in range(i + 1, len(num)):
        if num[max_idx] < num[j]:
            max_idx = j
    
    num[i], num[max_idx] = num[max_idx], num[i]

for i in num:
    sys.stdout.write(str(i))

sys.stdout.write('\n')
