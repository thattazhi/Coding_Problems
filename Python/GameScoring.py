def game_scoring(score):
    if score == 1:
        return [[1]]
    if score == 2:
        return [[1, 1], [2]]
    if score == 3:
        return [[1, 1, 1], [1, 2], [2, 1], [3]]

    return merge(1, game_scoring(score - 1)) + merge(2, game_scoring(score - 2)) + merge(3, game_scoring(score - 3))


def merge(x, arr):
    return [[x] + a for a in arr]

    # These are the tests we use to determine if the solution is correct.
    # You can add your own at the bottom.


test_case_number = 1


def check(expected, output):
    global test_case_number
    result = True
    if len(expected) == len(output):
        for score in expected:
            result = result & (score in output)
        for score in output:
            result = result & (score in expected)
    else:
        result = False
    _PASS = 'PASSED'
    _FAIL = 'FAILED'
    if result:
        print(_PASS, ' Test #', test_case_number, sep='')
    else:
        print(_FAIL, ' Test #', test_case_number, ': Expected ', sep='', end='')
        print(expected)
        print(' Your output: ', end='')
        print(output)
        print()
    test_case_number += 1


if __name__ == "__main__":
    test_1 = 4
    expected_1 = [
        [1, 1, 1, 1],
        [1, 1, 2],
        [1, 2, 1],
        [1, 3],
        [2, 1, 1],
        [2, 2],
        [3, 1]
    ]
    output_1 = game_scoring(test_1)
    check(expected_1, output_1)

    test_2 = 5
    expected_2 = [
        [1, 1, 1, 1, 1],
        [1, 1, 1, 2],
        [1, 1, 2, 1],
        [1, 1, 3],
        [1, 2, 1, 1],
        [1, 2, 2],
        [1, 3, 1],
        [2, 1, 1, 1],
        [2, 1, 2],
        [2, 2, 1],
        [2, 3],
        [3, 1, 1],
        [3, 2],
    ]
    output_2 = game_scoring(test_2)
    check(expected_2, output_2)

    # Add your own test cases here
