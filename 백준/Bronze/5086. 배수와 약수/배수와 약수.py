import sys

slist = []
while True:
    a = sys.stdin.readline().strip()
    if a == '0 0':
        break
    slist.append(a)
   
for i in slist :
    a,b=map(int,i.split())
    if a>b :
        if a%b == 0 : print('multiple')
        else : print('neither')
    else :
        if b%a == 0 : print('factor')
        else : print('neither')