idx = int(input())

lev = 1
start = 1
end = 1

while (start <= idx <= end) is not True:
    lev += 1
    start = end + 1
    end = end + lev

    
sum_div = lev + 1
idx -= (start - 1)

if lev % 2 == 0:
    print("{}/{}".format(idx, sum_div - idx))
else:
    print("{}/{}".format(sum_div - idx, idx))
