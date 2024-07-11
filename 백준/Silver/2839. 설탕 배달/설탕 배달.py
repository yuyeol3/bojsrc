N = int(input())

# 5x + 3y = N
# y = (N - 5x) / 3

results = []

x = 0

while 5 * x <= N:

    if (N - 5 * x) % 3 == 0:
        y = (N - 5 * x) // 3

        results.append(x + y)
    
    x += 1


if len(results) >= 1:
    print(min(results))

else:
    print(-1)




