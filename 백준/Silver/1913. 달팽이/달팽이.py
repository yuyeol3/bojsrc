import sys

n = int(sys.stdin.readline())
to_find = int(sys.stdin.readline())
arr = []

# 배열에 칸 만들기
for _ in range(n):
    arr.append([0] * n)

coor_x, coor_y = n // 2, n // 2
num = 1
ans_coord = tuple()

# 1은 미리 넣어두기
arr[coor_x][coor_y] = 1
if (num == to_find): ans_coord = (coor_x, coor_y)
num += 1
coor_y += 1


for length in range(3, n + 1, 2):
    for i in range(length - 2):
        arr[coor_x][coor_y] = num
        if (num == to_find): ans_coord = (coor_x, coor_y)
        num += 1
        coor_x += 1

    for i in range(length - 1):
        arr[coor_x][coor_y] = num
        if (num == to_find): ans_coord = (coor_x, coor_y)
        num += 1
        coor_y -= 1

    for i in range(length - 1):
        arr[coor_x][coor_y] = num
        if (num == to_find): ans_coord = (coor_x, coor_y)
        num += 1
        coor_x -= 1

    for i in range(length):
        arr[coor_x][coor_y] = num
        if (num == to_find): ans_coord = (coor_x, coor_y)
        num += 1
        coor_y += 1


for y in range(n - 1, -1, -1):
    for x in range(n):
        sys.stdout.write(f"{arr[x][y]} ")

    sys.stdout.write("\n")

sys.stdout.write(f"{n - (ans_coord[1])} {ans_coord[0] + 1}\n")
