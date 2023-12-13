N = int(input())
array = []

for i in range(N):
    start, end = map(int, input().split())
    array.append((start, end))

print(array)
