import sys

operand_list = [lambda x, y : x + y,
                lambda x, y: x - y,
                lambda x, y: x * y,
                lambda x, y: -((-x) // y) if x < 0 and y > 0 else x // y]

def rec(nums, operands, val, lvl=0):
    global res, n
    if lvl == n - 1:
        res.append(val)
        return

    for i in range(4):
        if operands[i]:
            next_val = operand_list[i](val, nums[lvl + 1])
            next_operands = operands[:]
            next_operands[i] -= 1
            rec(nums, next_operands, next_val, lvl + 1)

n = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))
operands = list(map(int, sys.stdin.readline().split()))
res = []

rec(nums, operands, nums[0])

maximum = max(res)
minimum = min(res)

sys.stdout.write(f"{maximum}\n{minimum}\n")
