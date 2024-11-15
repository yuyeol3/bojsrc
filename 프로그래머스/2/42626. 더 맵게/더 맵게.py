import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    answer = 0
    while True:
        if (scoville[0] >= K):
            break
            
        if (len(scoville) <= 1):
            answer = -1
            break
        
        e1 = heapq.heappop(scoville)
        e2 = heapq.heappop(scoville)
        heapq.heappush(scoville, e1 + (e2 * 2))
        
        answer += 1
        
    
    return answer