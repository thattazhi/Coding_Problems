def minimumBribes(q):
    n = len(q)
    count = 0
    for i in range(n):
        if q[i] > i + 3:
            print('Too chaotic')
            return

        for j in range(max(0, q[i] - 2), i):
            if q[j] > q[i]:
                count += 1

    print(count)


minimumBribes([2, 1, 5, 3, 4])
minimumBribes([1, 2, 5, 3, 4, 7, 8, 6])
minimumBribes([1, 2, 5, 3, 7, 8, 6, 4])
minimumBribes([3, 4, 5, 6, 7, 2, 9, 1, 8, 10])
