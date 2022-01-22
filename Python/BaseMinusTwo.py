import math


def decimal_to_bits(N):
    s = []
    while (N != 0):
        if (N % 2 == 0):
            s.append(0)
        else:
            s.append(1)
            N -= 1
        N /= -2

    if (len(s) == 0):
        s.append(0)

    return s

def bits_to_decimal(arr):
    ans = 0

    for i in range(len(arr)):
        ans += arr[i] * math.pow(-2, i)

    return ans

def Solution(A, B):
    return decimal_to_bits(bits_to_decimal(A) + bits_to_decimal(B))


A = [0,1,1,0,0,1,0,1,1,1,0,1,0,1,1]
B = [0,0,1,0,0,1,1,1,1,1,0,1]

print(Solution(A, B))