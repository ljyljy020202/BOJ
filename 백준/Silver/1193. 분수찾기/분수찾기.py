x = int(input())
i=0
n=0
while n<x :
    i+=1
    n+=i
n-=i
a=x-n
b=i-x+n+1
if i%2 == 0 :
    print(str(a)+'/'+str(b))
else :
    print(str(b)+'/'+str(a))