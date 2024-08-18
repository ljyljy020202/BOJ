n = int(input())
card = list(map(int,input().split()))
m = int(input())
num = list(map(int,input().split()))
count=[0 for i in range(20000001)]

for i in range(n) :
    count[card[i]+10000000]=count[card[i]+10000000]+1
    
for i in range(m) :
    print(count[num[i]+10000000],end=" ")
