def dfs(numbers, target, index=0, current_sum=0):
    if index == len(numbers):
        return 1 if current_sum == target else 0
    
    return dfs(numbers, target, index + 1, current_sum + numbers[index]) + \
           dfs(numbers, target, index + 1, current_sum - numbers[index])

def solution(numbers, target):
    return dfs(numbers,target)