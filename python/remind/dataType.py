# round method
a = 123.456
roundA = round(a, 2)
print(roundA)

n = 10
a = [0]*n
print(a)

# List Indexing
a = [1, 5, 3, 2, 4]
a[4] = 6
print(a)

# List Slicing
a = [1, 2, 3, 4, 5, 6, 7, 8, 9]
print(a[1:4])

# List comprehension
a = [i for i in range(10)]
print(a)

a = [i for i in range(20) if i % 2 == 1]
print(a)

# 2th dimension initializing
n = 4
m = 3
array = [[0]*m for i in range(n)]
print(array)

array = [[0]*m]*n
print(array)
array[1][1] = 2
print(array)

# uses UnderBar
sum = 0
for i in range(1, 10):
    sum += i
print(sum)

for _ in range(5):
    print('Hello World')

# List Methods
a = [1, 3, 2]
a.append(4)
print(a)
a.sort()
print(a)
# 내림차순
a.sort(reverse=True)
print(a)

a = [4, 3, 2, 1]
a.reverse()
print(a)
a.insert(0, 1)
print(a)
print(a.count(1))
# 특정값 원소 제거 (1개만)
a.remove(1)
print(a)
# 특정값 원소 모두 제거
a = [1, 2, 3, 3, 3, 4, 5, 5]
remove_set = {3, 5}
removedA = [i for i in a if i not in remove_set]
print(removedA)

# String
a = "Hello"
b = "World"
print(a + b)
print(a*3)

# Tuple
a = (1, 2, 3, 4, 5, 6, 7, 8)
print(a[3])

# Dictionary
data = dict()
data['사과'] = 'Apple'
data['바나나'] = 'Banana'
data['코코넛'] = 'Coconut'
print(data)

key_list = data.keys()
value_list = data.values()
print(key_list)
print(value_list)
key_list = list(key_list)
print(key_list)

# set
data = set([1, 2, 3, 4, 4, 1, 5])
print(data)  # 중복 원소 제거

a = set([1, 2, 3, 4, 5])
b = set([3, 4, 5, 6, 7])
print(a | b)  # 합집합
print(a & b)  # 교집합
print(a-b)  # 차집합

data.add(6)  # 원소 하나 추가
print(data)
data.update([7, 8])  # 원소 여러개 추가
print(data)
data.remove(8)  # 원소 삭제
print(data)
