N = input()

if '0' not in N:
    print(-1)
else:
    sum = 0
    for i in N:
        sum += int(i)
    if sum % 3 != 0:
        print(-1)
    else:
        N = sorted(N, reverse=True)
        result = ''.join(N)
        print(result)
