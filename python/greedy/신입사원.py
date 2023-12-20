t = int(input())
result = []

for _ in range(t):
    n = int(input())
    interviewees = []

    for _ in range(n):
        a, b = map(int, input().split())
        interviewees.append([a, b])

    interviewees = sorted(interviewees, key=lambda x: x[0])

    max = len(interviewees)

    for i in range(len(interviewees)):
        isWorse = False
        for j in range(i+1, 1, -1):
            if interviewees[j][1] < interviewees[i][1]:
                isScoreWorse = True
        if isScoreWorse:
            max -= 1

    result.append(max)

print(result)
