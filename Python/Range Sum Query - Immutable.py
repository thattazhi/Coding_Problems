import numpy as np

class NumArray:

    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.nums = np.array(nums)

    def sumRange(self, i, j):
        """
        :type i: int
        :type j: int
        :rtype: int
        """

        return int(np.sum(self.nums[i: j + 1]))

# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(i,j)


nums = np.int64([-2, 0, 3, -5, 2, -1])
print(type(nums[0]))
obj = NumArray(nums)

print(obj.sumRange(0, 2))
print(obj.sumRange(2, 5))
print(obj.sumRange(0, 5))