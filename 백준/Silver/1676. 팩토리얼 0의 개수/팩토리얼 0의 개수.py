import sys

def five_count(n):
    cnt = 0
    
    while n != 0:
        n //= 5
        cnt += n
       
    return cnt

n = int(sys.stdin.readline())

sys.stdout.write(f"{five_count(n)}")