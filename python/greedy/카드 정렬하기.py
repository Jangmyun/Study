N = int(input())
cards = []
result = 0
answer = 0
for _ in range(N):
    cards.append(int(input()))

cards.sort()

if N != 0:
    result = 1
    for i in range(2, len(cards)):
        result += 1
elif N == 1:
    result = 0

print(result)
