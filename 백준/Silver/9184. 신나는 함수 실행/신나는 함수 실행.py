import sys

memos = dict()

def w(a, b, c):
    global memos
    if ((a, b, c) in memos):
        return memos[(a, b, c)]

    if a <= 0 or b <= 0 or c <= 0:
        memos[(a, b, c)] = 1
        return memos[(a, b, c)]

    if ((a <= 20 and b <= 20 and c <= 20) and 
        (a >=0 and b >=0 and c >= 0) and (a == b == c)):
        memos[(a, b, c)] = 2 ** a
        return memos[(a, b, c)]
    
    if a > 20 or b > 20 or c > 20:
        memos[(a, b, c)] = 2 ** 20
        return memos[(a, b, c)]
    
    if a < b and b < c:
        memos[(a, b, c)] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
        return memos[(a, b, c)]
    
    memos[(a, b, c)] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
    return memos[(a, b, c)]

while (True):
    a, b, c = map(int, sys.stdin.readline().split())
    
    if (a == b == c == -1): break
    else:
        sys.stdout.write(f"w({a}, {b}, {c}) = {w(a, b, c)}\n")




