T = int(input())
for i in range(T):
    a,b = map(int,input().split())
    mul = a*b
    while(b != 0):
        r = a%b 
        a = b 
        b = r 
    print(int(mul/a)) 