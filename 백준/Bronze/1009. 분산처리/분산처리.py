def get_ldgit(a, b):
    mem = mem = [int(str(a)[-1])]
    init_a = int(str(a)[-1])

    for i in range(b - 1):
        str_a = str(a * init_a)[-1]
        a = int(str_a)

        if a in mem:
            break

        mem.append(a)

    b = (b % len(mem) if b % len(mem) > 0 else len(mem)) - 1

    return mem[b]

n = int(input())

for i in range(n):
    a, b = map(int, input().split())
    
    k = get_ldgit(a, b)
    if k == 0:
        print(10)
    else:
        print(k)
    