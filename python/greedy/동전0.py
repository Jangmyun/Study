N, K = map(int, input().split())
array = []
result = 0

for i in range(N):
    array.append(int(input()))

array.sort(reverse=True)

for i in array:
    result += K//i
    K = K % i

print(result)
