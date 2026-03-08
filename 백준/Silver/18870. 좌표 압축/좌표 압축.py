import sys

n = int(sys.stdin.readline().rstrip())
nums = list(map(int, sys.stdin.readline().rstrip().split()))
distinct_nums = list(set(nums))
distinct_nums.sort()
distinct_nums = dict([(val, idx) for idx, val in enumerate(distinct_nums)])


for num in nums:
    sys.stdout.write(f"{distinct_nums[num]} ")
sys.stdout.write("\n")

