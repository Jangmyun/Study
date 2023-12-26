# 필요할 때만 각 숫자를 적절한 위치에 삽입


array = [1, 10, 5, 8, 7, 6, 4, 3, 2, 9]

for i in range(1, len(array)):
    tmp = array[i]
    prev = i-1

    while (prev >= 0 and array[prev] > tmp):
        array[prev+1] = array[prev]
        prev -= 1

    array[prev+1] = tmp

print(array)
