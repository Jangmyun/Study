def merge_sort(array):
    # When the array can no longer be divided by two
    if len(array) < 2:
        return array
    # array/2 is the midpoint dividing the array
    mid = len(array) // 2

    leftArr = merge_sort(array[0:mid])
    rightArr = merge_sort(array[mid:len(array)])

    mergedArr = []
    left = right = 0

    # merge two array
    while (left < len(leftArr) and right < len(rightArr)):
        if leftArr[left] < rightArr[right]:
            mergedArr.append(leftArr[left])
            left += 1
        else:
            mergedArr.append(rightArr[right])
            right += 1

    # Save the remaining elements on either leftArr or rightArr
    mergedArr += leftArr[left:]
    mergedArr += rightArr[right:]
