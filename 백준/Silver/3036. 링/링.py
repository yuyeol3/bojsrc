import sys

def gcd(x, y):
    while y != 0:
        x, y = y, x % y

    return x


n = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))

for num in nums[1:]:
    m = gcd(nums[0], num)
    print(f"{nums[0] // m}/{num // m}")
