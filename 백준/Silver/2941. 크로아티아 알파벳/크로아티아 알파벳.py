text = input()
n = len(text)
cnt = 0
k = 0

while k < n:
    if k + 2 < n:
        if text[k] == "c" and (text[k + 1] == "=" or text[k + 1] == "-"):
            cnt += 1
            k  += 2
        elif text[k] == "d":
            if text[k + 1] == "z" and text[k + 2] == "=":
                cnt += 1
                k += 3
            elif text[k + 1] == "-":
                cnt += 1
                k += 2
            else:
                cnt += 1
                k += 1
        elif text[k] == "l" and text[k + 1] == "j":
            cnt += 1
            k += 2
        elif text[k] == "n" and text[k + 1] == "j":
            cnt += 1
            k += 2
        elif text[k] == "s" and text[k + 1] == "=":
            cnt += 1
            k += 2
        elif text[k] == "z" and text[k + 1] == "=":
            cnt += 1
            k += 2
        else:
            cnt += 1
            k += 1
    
    elif k + 1 < n:
        if text[k] == "c" and (text[k + 1] == "=" or text[k + 1] == "-"):
            cnt += 1
            k  += 2
        elif text[k] == "d":
            if text[k + 1] == "-":
                cnt += 1
                k += 2
            else:
                cnt += 1
                k += 1
        elif text[k] == "l" and text[k + 1] == "j":
            cnt += 1
            k += 2
        elif text[k] == "n" and text[k + 1] == "j":
            cnt += 1
            k += 2
        elif text[k] == "s" and text[k + 1] == "=":
            cnt += 1
            k += 2
        elif text[k] == "z" and text[k + 1] == "=":
            cnt += 1
            k += 2
        else:
            cnt += 1
            k += 1
    else:
        cnt += 1
        k += 1
        
print(cnt)
    