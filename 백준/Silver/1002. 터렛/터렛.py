tc = int(input())

for i in range(tc):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    
    sq_distance = (x1 - x2) ** 2 + (y1 - y2) ** 2  # 두 원점의 거리의 제곱
    
    if (r2 - r1) ** 2 < sq_distance < (r2 + r1) ** 2:
        print(2)

    elif (r2 - r1) ** 2 == sq_distance and (x1, y1, r1) != (x2, y2, r2):  # 내접
        print(1)

    elif (r2 + r1) ** 2 == sq_distance and (x1, y1, r1) != (x2, y2, r2):  # 외접
        print(1)

    elif sq_distance > (r1 + r2) ** 2:
        print(0)

    elif sq_distance < (r1 - r2) ** 2:
        print(0)

    else:
        print(-1)


    
    