m, n = map(int, input().split())

a = [False, False] + [True] * (n - 1)
primes = []

for i in range(2, n + 1):
    if a[i] and i >= m:  # 참일경우
        primes.append(i)
    for j in range(2 * i, n + 1, i):  # i의 배수들은 전부 지운다.
        a[j] = False


print(*primes, sep='\n')