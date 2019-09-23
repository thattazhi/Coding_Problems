def swap(arr, i, j):
    arr[i] = arr[i] + arr[j]
    arr[j] = arr[i] - arr[j]
    arr[i] = arr[i] - arr[j]


def minimumSwaps(arr):
    i = 0
    count = 0

    while i < len(arr):
        if i + 1 != arr[i]:
            count += 1
            swap(arr, i, arr[i] - 1)

        else:
            i += 1

    return count


print(minimumSwaps([7, 1, 3, 2, 4, 5, 6]))
print(minimumSwaps())
print(minimumSwaps())
print(minimumSwaps())
print(minimumSwaps())
