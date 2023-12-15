N = int(input())
ropes = []
for _ in range(N):
    ropes.append(int(input()))

ropes.sort(reverse=True)

result = 0

for i in range(len(ropes)):
    if ropes[i]*(i+1) > result:
        result = ropes[i]*(i+1)

print(result)
