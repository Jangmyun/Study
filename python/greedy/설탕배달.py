N = int(input())

result = 0

for i in range((N//5)+1):
    remainder = N-(5*i)
    a = i
    a = a + (remainder//3)
    remainder = remainder % 3

    if result <= 0:
        if remainder == 0:
            result = a
        elif remainder != 0:
            result = -1
    elif result > 0:
        if remainder == 0 and result > a:
            result = a

print(result)
