import sys
import math


CACHE_TNUM = [0] * 45
def triangle_number(n):
    global CACHE_TNUM

    if (CACHE_TNUM[n]):
        return CACHE_TNUM[n]

    CACHE_TNUM[n] = (n * (n + 1)) // 2 
    return CACHE_TNUM[n]

def get_lim(k):
    return int( (math.sqrt(1 + 8 * k) - 1) / 2 ) + 1

n = int(sys.stdin.readline())

for _ in range(n):
    target_num = int(sys.stdin.readline())

    tri_poss = False
    _breaked = False
    for i in range(1, get_lim(target_num)):
        summation = triangle_number(i)
        for j in range(1, get_lim(target_num - summation)):
            summation += triangle_number(j)
            for k in range(1, get_lim(target_num - summation)):
                summation += triangle_number(k)

                if (summation == target_num):
                    tri_poss = not tri_poss
                    _breaked = not _breaked
                    break

                summation -= triangle_number(k)

            if _breaked:
                break
            
            summation -= triangle_number(j)

        if _breaked:
            break

    
    sys.stdout.write(f"{int(tri_poss)}\n")





