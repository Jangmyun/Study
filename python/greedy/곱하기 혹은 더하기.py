S = list(map(int, list(input())))
result = 0

for i in S:
    if result <= 1 or i <= 1:
        result += i
    else:
        result *= i

print(result)
