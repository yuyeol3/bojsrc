def dujari(num: str):
    if (len(num) <= 1):
        num = '0' + num
    
    return num


if __name__ == "__main__":
    init_num = input()
    num = init_num
    sum_of_num = 0
    res = ''
    cycle = 0

        
    while (True):
        cycle += 1
        num = dujari(num)
        
        sum_of_num = int(num[0]) + int(num[1])
        sum_of_num = str(sum_of_num)
        
        res = num[-1] + sum_of_num[-1]
        
        if dujari(init_num) == dujari(res):
            break

        num = res
        res = ''
        

    print(cycle)
