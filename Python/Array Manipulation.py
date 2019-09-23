def arrayManipulation(n, queries):
    list = [0] * (n + 1)
    for Q in queries:
        x, y, incr = Q[0], Q[1], Q[2]
        list[x - 1] += incr
        if y <= len(list):
            list[y] -= incr

    max = x = 0
    for i in list:
        x = x + i
        if max < x:
            max = x

    return max


result = arrayManipulation(10, [[1,5,3],
                               [4, 8,7],
                               [6,9,1]])



print(result)
