def get_factor(n):
    factors = []
    
    for i in range(1, n):
        if n % i == 0:
            factors.append(i)
            
    return factors

n = input()
nums = tuple(map(int, input().split()))

for num in nums:
    factors = get_factor(num)
    sum_factors = sum(factors)
    
    if sum_factors == num:
        print("Perfect")
    elif sum_factors < num:
        print("Deficient")
    elif sum_factors > num:
        print("Abundant")