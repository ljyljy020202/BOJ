n=int(input())
arr=[[0]*100 for i in range(100)]
for i in range(n):
    a,b=map(int,input().split())
    for j in range(a,a+10):
        for k in range(b,b+10):
            arr[j][k]=1
area=0
for i in range(100):
    for j in range(100):
        if arr[i][j]==1:
            area=area+1
print(area)
            