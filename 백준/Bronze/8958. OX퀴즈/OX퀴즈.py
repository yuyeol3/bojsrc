n = int(input())

for i in range(n):
    quiz_result = input()
    score = 0
    series = 0
    
    for i in range(len(quiz_result)):
        if quiz_result[i] == 'O':
            series += 1
            score += series
        elif quiz_result[i] == 'X':
            series = 0
    
    
    print(score)
            
