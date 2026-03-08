
num = int(input())

count_num = 0
end_num = 665
while count_num < num:
    end_num += 1
    if "666" in str(end_num):
        count_num += 1


print(end_num)