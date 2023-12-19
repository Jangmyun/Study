A, B = map(int, input().split())
answer = 0

while B > A:
    if B % 10 == 1:
        B = B//10
        answer += 1
    else:
        B /= 2
        answer += 1

if B != A:
    print(-1)
else:
    print(answer+1)
