n,m=map(int,input().split())
card = list(map(int,input().split()))
maxnum=0

for i in range(len(card)):
    for j in range(len(card)):
        if i==j: continue
        for k in range(len(card)):
            if i==k or j==k: continue
            x = card[i]+card[j]+card[k]
            if x>m: continue
            elif x==m:
                print(m)
                exit(0)
            else:
                maxnum=max(maxnum,x)
print(maxnum)