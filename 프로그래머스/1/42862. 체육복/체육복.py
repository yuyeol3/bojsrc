def solution(n, lost, reserve):
    
    un = set(reserve) & set(lost)
    reserve = set(reserve) - un
    lost = list(set(lost) - un)
    answer = n - len(lost)
    
    for stu in lost:
        if (stu-1 in reserve):
            answer += 1
            reserve.remove(stu-1)
            
        elif (stu+1 in reserve):
            answer += 1
            reserve.remove(stu+1)

    return answer