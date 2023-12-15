N = int(input())
meetings = []
result = 1

for _ in range(N):
    meetings.append(tuple(map(int, input().split())))

meetings = sorted(meetings, key=lambda x: (x[1], x[0]))

currentMeeting = meetings[0]

for i in range(1, len(meetings)):
    if meetings[i][0] >= currentMeeting[1]:
        result += 1
        currentMeeting = meetings[i]

print(result)
