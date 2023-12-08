N = int(input())
array = list(map(int, input().split()))

array.sort()
print(array)

checking = 0
count = 0
group = 0
for i in array:
    if checking < i:
        checking = i

    count += 1
    if checking == count:
        group += 1
        count = 0

print(group)
