# while
i = 1
sum = 0

while i <= 9:
    sum += i
    i += 1

print(sum)

# for
li = [1, 2, 3, 4, 5]
for i in li:
    print(i)

sum = 0
for i in range(10):
    sum += i
print(sum)

# continue
scores = [90, 85, 77, 65, 97]
cheating_student = {2, 4}
for i in range(5):
    if i+1 in cheating_student:
        continue
    if scores[i] >= 80:
        print(f"{i+1}번 학생: 합격")
