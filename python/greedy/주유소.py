N = int(input())

roadDistance = list(map(int, input().split()))
city = list(map(int, input().split()))

isCheaper = False
currentPrice = city[0]
result = city[0]*roadDistance[0]

for i in range(1, len(roadDistance)):
    if currentPrice > city[i]:
        currentPrice = city[i]
    result += currentPrice*roadDistance[i]

print(result)
