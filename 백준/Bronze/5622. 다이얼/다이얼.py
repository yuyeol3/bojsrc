num_alpha = input()
match_dict = {"2": "ABC", "3": "DEF", "4": "GHI", "5": "JKL", "6": "MNO", "7": "PQRS", "8": "TUV", "9": "WXYZ"}
tot_time = 0

for i in num_alpha:
    for j in range(len(match_dict)):
        if i in list(match_dict.values())[j]:
            num = int(list(match_dict.keys())[j])
            tot_time += 2 + (num - 1)
            break
        
print(tot_time)