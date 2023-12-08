# 내장함수

import itertools
# 반복되는 데이터 처리할때 사용 (순열, 조합)

import heapq
# Heap 자료구조 제공 , 우선순위 큐 구현할때 사용

import bisect
# 이진탐색 기능 제공

import collections
# 덱, 카운터 등 유용한 자료구조 포함

import math
# 수학 관련 함수나 상수


# 자주쓰는 내장함수
# sum
result = sum([1, 2, 3, 4, 5, 6, 7, 8, 9])
print(result)
# min / max
min = min(5, 4, 6, 2)
max = max(5, 4, 6, 2)
print(min, max)
# eval => 문자열로 수식 계산
result = eval("3+5/3")
print(result)
# sorted()
result = sorted([1, 7, 5, 6, 9, 3])
print(result)
print(sorted(result, reverse=True))

# sorted() with key
array = [('Kim', 50), ('Lee', 80), ('Park', 40)]

result = sorted(array, key=lambda x: x[1])
print(result)

# 순열과 조합
# 순열 = 서로다른 n개에서 서로다른 r개 선택해서 일렬로 나열
# 조합 = 서로다른 n개에서 순서 상관없이 서로다른 r개 선택

data = ['A', 'B', 'C']
# data 내부 값 중 3개를 선택해서 나열하는 순열
result = list(itertools.permutations(data, 3))
print(result)
# data 내부 값 중 2개를 뽑는 조합
result = list(itertools.combinations(data, 2))
print(result)

# 중복 순열
# 2개를 뽑는 모든 순열
result = list(itertools.product(data, repeat=2))
print(result)

# 중복 조합
# 2개를 뽑는 모든 조합
result = list(itertools.combinations_with_replacement(data, 2))
print(result)


# collection.counter

counter = collections.Counter(['A', 'B', 'A', 'A', 'C', 'D', 'C'])
print(counter['A'])  # A가 등장한 횟수
print(dict(counter))


# 최대공약수, 최소공배수
a = 6
b = 18
# 최대공약수
print(math.gcd(a, b))
# 최소공배수


def lcm(a, b):
    return a*b // math.gcd(a, b)


print(lcm(a, b))
