N = int(input())
array = list(map(int, input().split()))
array.sort()

result = 0

for i in range(len(array)):
    result += sum(array[:i+1])

print(result)
