# 72까지의 소수 구하기
# 72까지의 소수 중 가장 작으면서 나머지가 0인 것으로 나누기

# 몫으로 반복


def is_prime(num):
    
    if num <= 1:
        return False

    for i in range(2, num):
        if num % i == 0:
            return False
    
    return True


if __name__ == "__main__":
    num = int(input())

    if num != 1:
        primes = []

        
        while is_prime(num) is False:
            succeeded = False
            for prime in primes:
                if num % i == 0:
                    num = num // prime
                    print(prime)
                    succeeded = True
                    break
                    
            if not succeeded:        
                for i in range(1, num):
                    if is_prime(i) and num % i == 0:
                        num = num // i
                        print(i)
                        break
            
        print(num)
        
    else:
        pass