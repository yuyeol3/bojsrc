T = int(input())

for i in range(T): 
    # h: 층 수, w: 방 수, n: 손님 수
    h, w, n = map(int, input().split())
    
    floor = n % h if (n % h) > 0 else h
    room = int((n - 1) / h) + 1
    
    
    print(f"{floor}{room:02}")