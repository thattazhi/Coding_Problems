class Solution:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """

        if x in range(-9, 10):
            return x

        s = str(x)
        if x < 0:
            s = s[1:]

            x = int(s[::-1]) * -1

            if x not in range(-2147483648, 2147483648):
                return 0

            return x

        x = int(s[::-1])

        if x not in range(-2147483648, 2147483648):
            return 0

        return x


sol = Solution()

print(sol.reverse(123))
print(sol.reverse(-123))
print(sol.reverse(120))
print(sol.reverse(1534236469))
print(sol.reverse(1))
