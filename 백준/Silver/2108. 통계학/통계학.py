import sys

def meanof(nums):
    return sum(nums) / len(nums)

def medianof(nums):
    return nums[len(nums) // 2]

def modeof(nums):
    dict_nums = {}
    
    for num in set(nums):
        dict_nums[num] = 0

    for num in nums:
        dict_nums[num] += 1

    max_freq = max(dict_nums.values())

    res = []

    for num in dict_nums:
        if dict_nums[num] == max_freq:
            res.append(num)

    res.sort()

    if len(res) <= 1:
        return res[0]
    
    else:
        return res[1]


def rangeof(nums):
    return nums[-1] - nums[0]

n = int(sys.stdin.readline().rstrip())

nums = []
for _ in range(n):
    nums.append(
        int(sys.stdin.readline().rstrip())
    )

nums.sort()

mean = round(meanof(nums))
median = medianof(nums)
mode = modeof(nums)
rng = rangeof(nums)

sys.stdout.write(str(mean) + '\n')
sys.stdout.write(str(median) + '\n')
sys.stdout.write(str(mode) + '\n')
sys.stdout.write(str(rng) + '\n')