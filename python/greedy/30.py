N = input()
NList = []
result = ""

for i in N:
    NList.append(int(i))

NList.sort()

if NList[-1] != 0:
    print(-1)
else:
    for i in range(len(NList)):
        if i == 0:
            result = NList[i]
        else:
            tmp = result + NList[i]
            result = tmp

print(result)
