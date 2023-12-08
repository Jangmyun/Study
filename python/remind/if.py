a = 5
if a >= 0:
    print(" a >= 0 ")
elif a >= -20:
    print(" 0 >= a >= -20")
else:
    print(" -20 > a")

# 논리 연산자
True and False
True or False
not False

# in 연산자
li = [1, 2, 4, 5]
if 3 not in li:
    print("no 3")
if 1 in li:
    print("1")

str = "ABCEF"
if 'D' not in str:
    print("no 'D'")

# pass 키워드
a = 0
if 30 >= a:
    pass
else:
    print("kk")
