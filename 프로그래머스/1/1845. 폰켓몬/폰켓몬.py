def solution(nums):
    n = len(nums)
    set_nums = set(nums)
    
    answer = min(n//2, len(set_nums))
    
    return answer