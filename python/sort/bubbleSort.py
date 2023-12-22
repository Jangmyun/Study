# 버블 정렬
# 서로 인접한 두 원소를 비교

array = [1, 10, 5, 8, 7, 6, 4, 3, 2, 9]

# 0부터 데이터 길이만큼 반복
for i in range(len(array)):
    # 인접한 두 원소의 비교이므로 j와 j-1끼리의 비교를 위해 1부터 시작
    for j in range(1, len(array)-i):
        # j-1위치의 값이 더 크면 위치이동
        if array[j-1] > array[j]:
            tmp = array[j-1]
            array[j-1] = array[j]
            array[j] = tmp

print(array)
