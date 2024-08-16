alist = ['c=','c-','dz=','d-','lj','nj','s=','z=']
s = input()
cnt = 0
for ch in alist :
    if ch in s :
        cnt += s.count(ch)
print(len(s)-cnt)