n = int(input())
list = list(map(int,input().split()))
m = max(list)
for i in range(n) :
    list[i] = list[i]/m*100
print(sum(list)/len(list))