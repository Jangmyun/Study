# 선택정렬
# 가장 작은 것을 가장 앞으로
# 원소를 넣을 위치는 정해져있고, 어떤 원소를 넣을지 '선택'

array = [1, 10, 5, 8, 7, 6, 4, 3, 2, 9]


# 0부터 array 길이만큼 반복
for i in range(len(array)):
    minIndex = i
    # 선택한 인덱스의 값과 비교
    for j in range(i+1, len(array)):
        # 인덱스 값이 더 작은 값이 있으면 작은 값의 인덱스를 저장
        if array[minIndex] > array[j]:
            minIndex = j
    # 선택한 인덱스 값과 가장 작은 인덱스 값을 교환
    tmp = array[i]
    array[i] = array[minIndex]
    array[minIndex] = tmp

print(array)
