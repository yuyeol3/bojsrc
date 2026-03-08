import sys

def check_strike_ball(answer: str, to_check: str):
    strike = 0
    ball = 0

    for idx in range(3):
        if to_check[idx] == answer[idx]:
            strike += 1

        elif to_check[idx] in answer:
            ball += 1

    return [str(strike), str(ball)]


n = int(sys.stdin.readline())

responses = []

for _ in range(n):
    responses.append(
        sys.stdin.readline().split()
    )

poss = 0
for i in range(100, 1000):
    # 0을 포함하는 숫자 제외
    if '0' in str(i):
        continue

    # 중복되는 숫자가 있는 경우 제외
    if len(set(str(i))) < 3:
        continue

    vaild_poss = True
    for response in responses:
        res = check_strike_ball(str(i), response[0])
        if res != response[1:]:
            vaild_poss = not vaild_poss
            break
    
    if vaild_poss:
        poss += 1

sys.stdout.write(f"{poss}\n")