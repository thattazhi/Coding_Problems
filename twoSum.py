from math import floor
from numpy import array
from numpy import where


class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        nums = array(nums)
        for i in range(len(nums)):
            if target - nums[i] in nums[i + 1:]:
                ans = [i, where(nums[i + 1:] == target - nums[i])[0][0] + i + 1]
                return ans


sol = Solution()
print(sol.twoSum([3, 3], 6))

# a = [1,2,3,4]
# a= array(a)
# print(where(a == 3)[0][0])
