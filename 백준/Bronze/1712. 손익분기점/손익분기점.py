a,b,c=map(int,input().split())
if b!=c:
    x = int(a/(c-b))
else:
    x=-1    
if x>=0:
    print(x+1)
else:
    print(-1)