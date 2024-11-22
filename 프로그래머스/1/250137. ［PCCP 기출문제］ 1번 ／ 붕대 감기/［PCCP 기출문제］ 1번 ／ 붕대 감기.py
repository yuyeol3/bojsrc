def solution(bandage, health, attacks):
    continuous = 0
    game_period = attacks[-1][0]
    atk_idx = 0
    cur_health = health
    for t in range(1, game_period+1):
        if (t == attacks[atk_idx][0]):
            cur_health -= attacks[atk_idx][1]
            continuous = 0
            atk_idx += 1
        else:
            continuous += 1
            if (continuous == bandage[0]):
                continuous = 0
                cur_health = min(health, cur_health + bandage[1] + bandage[2])
            else:
                cur_health = min(health, cur_health + bandage[1])
        
        if cur_health <= 0:
            return -1

    return cur_health
