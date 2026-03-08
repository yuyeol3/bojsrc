def d(n):
    res = n
    for i in range(len(str(n))):
        res += int(str(n)[i])
    
    return res

all_num = set([i for i in range(1, 10001)])
non_self_num = set()


for i in range(1, 10001):
    init = i
    while True:
        init = d(init)
        if init > 10000:
            break
        
        non_self_num.add(init)

        
self_num = list(all_num - non_self_num)
self_num.sort()


for i in self_num:
    print(i)
        