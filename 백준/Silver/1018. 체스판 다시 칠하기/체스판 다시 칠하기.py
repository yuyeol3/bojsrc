def checker(r, c, type):
    color = ["W", "B"]
    if type == 0:
        if r % 2 == 0:
            return color[c % 2]
        else:
            return color[1 - (c % 2)]

    elif type == 1:
        if r % 2 == 0:
            return color[1 - (c % 2)]

        else:
            return color[c % 2]



m, n = map(int, input().split())

board = []
for i in range(m):
    line = input()
    board.append(list(line))


nums_of_fill = []

for i in range(0, m - 7):
    target = board[i:i+8]
    for j in range(0, n - 7):
        row_start = j
        row_end = j + 8
        possibles = []
        num_to_fill = 0
        for rnum, row in enumerate(target):
            for cnum, col in enumerate(row[row_start:row_end]):
                if checker(rnum, cnum, 0) != col:
                    num_to_fill += 1

        possibles.append(num_to_fill)
        num_to_fill = 0

        for rnum, row in enumerate(target):
            for cnum, col in enumerate(row[row_start:row_end]):
                if checker(rnum, cnum, 1) != col:
                    num_to_fill += 1
        
        possibles.append(num_to_fill)
        nums_of_fill.append(min(possibles))



print(min(nums_of_fill))