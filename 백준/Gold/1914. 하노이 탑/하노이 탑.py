import sys

dp = {}

def hanoi(n, start, end, via):
    if (n == 1):
        return f"{start} {end}\n"
    
    res = ""
    res += hanoi(n-1, start, via, end)
    res += f"{start} {end}\n"
    res += hanoi(n-1, via, end, start)
    return res


n = int(sys.stdin.readline())
sys.stdout.write(f"{(2**n)-1}\n")

if (n <= 20):
    sys.stdout.write(hanoi(n, 1, 3, 2))
