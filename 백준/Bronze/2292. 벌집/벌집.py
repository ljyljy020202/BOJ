n = int(input())
layer = 1
cnt = 6
i = 1
while i<n :
    i += cnt
    cnt += 6
    layer += 1
print(layer)