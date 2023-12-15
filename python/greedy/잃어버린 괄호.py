import re

expression = input()

numbers = list(map(int, re.split('[+ -]', expression)))
operators = list(filter(lambda x: x != '', re.split('\d', expression)))

result = numbers[0]

bracketOpened = False

for i in range(len(operators)):
    if operators[i] == '-':
        result -= numbers[i+1]
        bracketOpened = True
    elif operators[i] == '+':
        if bracketOpened:
            result -= numbers[i+1]
        else:
            result += numbers[i+1]

print(result)
