n=int(input())
five=n//5
while five>=0:
    tmp=n
    if (n-five*5)%3==0:
        print(five+(n-five*5)//3)
        exit(0)
    five=five-1
print(-1)
