n = int(input())

for i in range(n):
    a = input().split()
    a = [int(i) for i in a]

    num_of_stu = a[0]
    scores = a[1:]

    mean = sum(scores) / num_of_stu
    
    over_average = 0
    
    for i in scores:
        if i > mean:
            over_average += 1
    
    print(f"{over_average / num_of_stu * 100:.3f}%")