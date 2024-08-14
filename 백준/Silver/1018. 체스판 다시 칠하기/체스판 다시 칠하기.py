n,m=map(int,input().split())
arr=[[0]*m for k in range(n)]
for i in range(n):
    tmp=input()
    for j in range(m):
        arr[i][j]=tmp[j]

minnum=5000
for i in range(n-7):
    for j in range(m-7):
        min_1=0
        white=True
        for a in range(8):
            for b in range(8):
                if white:
                    if arr[i+a][j+b]=='B': min_1=min_1+1
                else:
                    if arr[i+a][j+b]=='W': min_1=min_1+1
                white = not white
            white = not white
        white=False
        min_2=0
        for a in range(8):
            for b in range(8):
                if white and arr[i+a][j+b]=='B': min_2=min_2+1
                elif (not white) and arr[i+a][j+b]=='W': min_2=min_2+1
                white = not white
            white = not white
        minnum=min(min(min_1,min_2),minnum)
        
print(minnum)
