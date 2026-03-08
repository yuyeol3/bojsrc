import sys

def rec(lst, max_num, left_num, agg):
    if left_num < 1:
        for num in agg:
            sys.stdout.write(f"{num} ")
        sys.stdout.write("\n")
        return

    for i in lst:
        agg[max_num - left_num] = i               
        rec(lst, max_num, left_num - 1, agg)


n, m = map(int, sys.stdin.readline().split())

nums = list(range(1, n + 1))
rec(nums, m, m, [0] * m)