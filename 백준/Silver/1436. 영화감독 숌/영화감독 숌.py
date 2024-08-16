n=int(input())
cnt=0
num=1
while True:
    if str(num).find('666')>=0: cnt=cnt+1
    if cnt==n:
        print(num)
        break
    num=num+1