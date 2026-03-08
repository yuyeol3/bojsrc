def div_by_digit(num: int):
    str_num = str(num)
    num_divby_digit = []
    for d in str_num:
        num_divby_digit.append(int(d))
    
    return num_divby_digit


def check_hansu(num_list: list):
    n = len(num_list)
    ishansu = True
    
    if n == 1:  # 자릿수가 1이면 무조건 한수
        return ishansu
    
    diff = 0; prev_diff = 0
    
    for i in range(n-1):
        diff = num_list[i + 1] - num_list[i]
        
        if i >= 1 and prev_diff != diff:
            ishansu = False
            return ishansu
        
        prev_diff = diff

    return True


if __name__ == "__main__":
    N = int(input())

    total_hansu = 0

    for num in range(1, N + 1):
        num_divby_digit = div_by_digit(num)
        
        ishansu = check_hansu(num_divby_digit)
    
        if ishansu is True:
            total_hansu += 1
        
        
    print(total_hansu)
        
        