class Solution:
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """

        sm = [''] * numRows
        n = 0
        flag = 0
        for i in range(len(s)):
            sm[n] += s[i]

            if flag == 0 and n < numRows - 1:
                n += 1

            elif flag == 0 and n == numRows - 1:
                n -= 1
                flag = 1

            elif flag == 1 and n > 0:
                n -= 1

            else:
                n += 1
                flag = 0

        ans = ''
        for i in range(numRows):
            ans += sm[i]

        return ans


sol = Solution()

print(sol.convert("PAYPALISHIRING", 3) == "PAHNAPLSIIGYIR")
print(sol.convert("PAYPALISHIRING", 4) == "PINALSIGYAHRPI")
print(sol.convert("PAYPALISHIRING", 2) == "PYAIHRNAPLSIIG")
