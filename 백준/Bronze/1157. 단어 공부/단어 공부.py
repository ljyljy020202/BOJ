a = input().upper()
alist = [0 for i in range(26)]
for i in a :
    alist[ord(i)-65] += 1
maxidx = 0
for j in range(26) :
    if alist[j] > alist[maxidx] : maxidx=j
maxcnt = 0
for j in range(26) :
    if alist[j] == alist[maxidx] : maxcnt += 1
if maxcnt >= 2: print('?')
else : print(chr(maxidx+65))