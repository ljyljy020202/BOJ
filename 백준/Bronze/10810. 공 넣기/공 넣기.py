n,m = map(int,input().split())
list = [0 for i in range(n)]
for a in range(m) :
    i,j,k = map(int,input().split())
    for b in range(i,j+1) :
        list[b-1] = k
for j in range(n) :
    print(list[j],end=' ')