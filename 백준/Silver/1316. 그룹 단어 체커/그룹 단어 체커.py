n = int(input())
group_word = 0


for i in range(n):
    text = input()
    isgroup = True
    alphabets = []
    prevchar = ''


    for char in text:
        if char not in alphabets:
            alphabets.append(char)

        
        elif char in alphabets and char != prevchar:
            isgroup = False
            break
    
        prevchar = char

    if isgroup:
        group_word += 1


print(group_word)
    

