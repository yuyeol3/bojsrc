def char_to_ascii(k):
    if 0 <= ord(k) - ord('a') < 26:
        return ord(k) - ord('a')
    elif 0 <= ord(k) - ord('A') < 26:
        return ord(k) - ord('A')



input_string = input()
alphabet = [0 for i in range(26)]


for i in input_string:
    alphabet[char_to_ascii(i)] += 1


max_idx = 0

for i in range(26):
    if alphabet[max_idx] < alphabet[i]:
        max_idx = i

for i in range(26):
    if alphabet[max_idx] == alphabet[i] and max_idx != i:
        max_idx = -1
        break



if max_idx == -1:
    print("?")
else:
    print(chr(max_idx + ord('A')))
        
 
