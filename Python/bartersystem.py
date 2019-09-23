def find_ex_rate(triplets, query, N):
    if query[0] == query[1]:
        return 1

    for i in range(N):
        if query[0] == triplets[i][0]:
            if triplets[i][1] == query[1]:
                Output = int(triplets[i][2])
                return Output

            else:
                query = [triplets[i][1], query[1]]
                j = find_ex_rate(triplets, query, N)
                Output = j * int(triplets[i][2])
                return Output

    return -1


def main():
    N = int(input())

    triplet = [''] * N

    for i in range(N):
        str = input()
        triplet[i] = str.split(" ")

    Q = int(input())

    Output = [0] * Q

    for i in range(Q):
        query = input()
        query = query.split(' ')
        Output[i] = find_ex_rate(triplet, query, N)
        if Output[i] != -1:
            Output[i] = Output[i] % 998244353

    for i in range(N): 
        print(Output[i])


if __name__ == '__main__':

    main()
