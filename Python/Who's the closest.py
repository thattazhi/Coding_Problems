import numpy as np


def closest(s, queries):
    length = len(queries)

    ans = [-1] * length
    n = 0

    s = np.array(list(s))

    for q in queries:
        s_left = s[: q]
        s_left = s_left[:: -1]
        s_right = s[q + 1:]

        if s[q] not in s_left and s[q] not in s_right:
            n += 1
            continue

        min_so_far = i_left = i_right = len(s)

        if s[q] in s_left:
            i_left = s_left.index(s[q])
            min_so_far = i_left + 1
            i_left = q - min_so_far

        # if min_so_far == 0:
        #     min_so_far = len(s)

        if min_so_far != 1:
            if s[q] in s_right:
                i_right = s_right.index(s[q])

        if min_so_far > i_right + 1:
            ans[n] = q + i_right + 1

        else:
            ans[n] = i_left

        n += 1

    return ans


print(closest('sam', [1]))

# min_so_far = max(len(s_left), len(s_right))
#
# if s[q] in s_left:
#     for i in range(len(s_left) - 1, -1, -1):
#         if s_left[i] == s[q]:
#             min_so_far = q - i
#             ans[n] = i
#             break
#
# if min_so_far != 1:
#     if s[q] in s_right[: min_so_far]:
#         for i in range(min_so_far):
#             if s_right[i] == s[q]:
#                 ans[n] = q + i + 1
#                 break
