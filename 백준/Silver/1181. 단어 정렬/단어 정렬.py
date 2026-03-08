import sys

n = int(sys.stdin.readline().rstrip())

words = []
for _ in range(n):
    word = sys.stdin.readline().rstrip()
    words.append(
        (len(word), word)
    )

words = list(set(words))
words.sort()

for i in words:
    sys.stdout.write(f"{i[1]}\n")