h, m = map(int, input().split())
required_t = int(input())

if required_t // 60 >= 1:
    h += required_t // 60
    required_t = required_t % 60
    
m += required_t

if m > 59:
    h += 1
    m -= 60

if h >= 24:
    h -= 24
    
print(f"{h} {m}")