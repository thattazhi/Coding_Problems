class Solution:
    memo = {'A': 1,
            'B': 2,
            'C': 3,
            'D': 4,
            'E': 5,
            'F': 6,
            'G': 7,
            'H': 8,
            'I': 9,
            'J': 10,
            'K': 11,
            'L': 12,
            'M': 13,
            'N': 14,
            'O': 15,
            'P': 16,
            'Q': 17,
            'R': 18,
            'S': 19,
            'T': 20,
            'U': 21,
            'V': 22,
            'W': 23,
            'X': 24,
            'Y': 25,
            'Z': 26}

    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        l = len(s)

        if l == 1:
            return self.memo[s]

        # ans = 0
        #
        # for i in range(l - 1):
        #     ans += 26
        #     ans *= self.memo[s[i]]
        #
        # ans += self.memo[s[l - 1]]

        ans = 0

        for i in range(l):
            ans += (26 ** i) * self.memo[s[l - 1 - i]]

        return ans


sol = Solution()

print(sol.titleToNumber('A'))
print(sol.titleToNumber('AB'))
print(sol.titleToNumber('ZY'))
print(sol.titleToNumber('ABA'))
