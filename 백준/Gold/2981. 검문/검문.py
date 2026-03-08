import sys

def gcd(x, y):
    while y > 0:
        x, y = y, x % y

    return x

def gcds(nums):
    res = nums[0]
    for i in nums[1:]:
        res = gcd(res, i)
        if res == 1:
            break

    return res

def get_aq(a):
    res = []
    for i in range(2, a+1):
        if a % i == 0:
            res.append(i)

    return res


n = int(sys.stdin.readline())
nums = []

for _ in range(n):
    nums.append(
        int(sys.stdin.readline())
    )

nums.sort()

dffs = []

for i in range(1, n):
    dffs.append(nums[i] - nums[i - 1])

max_m = gcds(dffs)
poss_m = get_aq(max_m)

for i in poss_m:
    sys.stdout.write(f"{i} ")

sys.stdout.write("\n")


