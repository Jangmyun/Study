# 함수
def add(a, b):
    return a+b


print(add(1, 9))

# global 키워드
a = 0


def plusOne():
    global a
    a += 1
    print(a)


plusOne()

# 여러 값 return


def operator(a, b):
    return a+b, a-b, a*b, a/b


a, b, c, d = operator(3, 6)
print(a, b, c, d)

# 람다 표현식


def add(a, b):
    return a+b


print(add(3, 5))
# 람다표현식으로 함수 정의
print((lambda a, b: a+b)(3, 5))

# 람다 함수로 튜플 리스트 정렬
array = [('Kim', 50), ('Lee', 80), ('Park', 40)]


def score_key(x):
    return x[1]


print(sorted(array, key=score_key))
print(sorted(array, key=lambda x: x[1]))

# 람다 표현식을 다수의 리스트에 적용
li1 = [1, 2, 3, 4, 5]
li2 = [6, 7, 8, 9, 10]
result = map(lambda a, b: a+b, li1, li2)
print(list(result))
