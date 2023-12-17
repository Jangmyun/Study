N = int(input())
cards = []

for _ in range(N):
    cards.append(int(input()))

cards.sort()

result = cards[0]+cards[1]

for i in range(2, len(cards)):
    result = result + result+cards[i]
