

def dfs(numbers, operations, target, idx=0, static_num=[0]):
    evaluated = 0
    for i, val in enumerate(numbers):
        evaluated += val * operations[i]
    
    if (evaluated == target):
        static_num[0] += 1
        return
    
    elif (idx >= len(numbers)):
        return
    
    for i in range(idx, len(operations)):
        new_op = operations[:]
        new_op[i] = -1
        dfs(numbers, new_op, target, i+1)
            
    return static_num[0]
    

def solution(numbers, target):
    answer = dfs(numbers, [1] * len(numbers), target)
    
    return answer