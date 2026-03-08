import sys

class Side:
    def __init__(self, toward, length, order):
        self.toward = toward
        self.length = length
        self.order = order

def neighbour_check(num, clist):
    num = num.order
    for cnum in clist:
        if ((num - 1) == cnum) or ((num + 1) == cnum) or (num == 5 and cnum == 0) or (num == 0 and cnum == 5):
            return True

    return False

melon = int(sys.stdin.readline().rstrip())

nums = {1:[], 2:[], 3:[], 4:[]}
for i in range(6):
    toward, num = tuple(map(int, sys.stdin.readline().rstrip().split()))
    nums[toward].append(Side(toward, num, i))



big_rec = 1
concaved = []
cnum = []

for key in nums:
    if len(nums[key]) == 1:
        big_rec *= nums[key][0].length
        cnum.append(nums[key][0].order)

    else:
        concaved.extend(nums[key])


small_rec = 1

for i in concaved:
    if not neighbour_check(i, cnum):
        small_rec *= i.length

rec = big_rec-small_rec
res = rec * melon

print(res)
