def general_func(k, n):
    gen = 1
    for i in range(k + 1):
        gen = gen * (n + i)

    # 계수 곱해주기
    for i in range(1, k + 2):
        gen = gen / i

    return int(gen)
        

if __name__ == "__main__":
    testcase = int(input())

    for i in range(testcase):
        k = int(input())
        n = int(input())
        print(general_func(k, n))