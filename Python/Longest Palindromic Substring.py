class Solution:
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """

        ans = ''

        if not s:
            return ans
        if s == s[::-1]:
            return s

        i = 0
        k = 1

        for j in range(2, len(s) + 1):
            if j - k - 1 >= 1:
                t = s[j - k - 2:j]
                if t == t[::-1]:
                    i = j - k - 2
                    k += 2
                    continue
            if j - k - 1 >= 0:
                t = s[j - k - 1:j]
                if t == t[::-1]:
                    i = j - k - 1
                    k += 1

        ans = s[i:i + k]

        return s[i:i + k]


sol = Solution()
print(sol.longestPalindrome("babad"))
print(sol.longestPalindrome("cbbd"))
print(sol.longestPalindrome("abb"))
print(sol.longestPalindrome("adam"))
print(sol.longestPalindrome("caba"))
print(sol.longestPalindrome("babadada"))
