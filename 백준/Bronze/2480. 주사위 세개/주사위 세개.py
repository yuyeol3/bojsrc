a, b, c = map(int, input().split())

reward = 0

if a == b:
    if b == c:
        reward = 10000 + (a * 1000)
    else:
        reward = 1000 + (a * 100)
elif b == c:
    reward = 1000 + (b * 100)
elif a == c:
    reward = 1000 + (a * 100)
else:
    reward = max(a, b, c) * 100
    
print(reward)
    
