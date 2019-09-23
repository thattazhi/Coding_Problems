class Solution:
    def sort(self, Items):
        if len(Items) > 1:
            mid = len(Items) // 2

            L = Items[:mid]
            R = Items[mid:]

            self.sort(L)
            self.sort(R)

            i = j = k = 0

            while i < len(L) and j < len(R):
                if L[i] < R[j]:
                    Items[k] = L[i]
                    i += 1

                else:
                    Items[k] = R[j]
                    j += 1

                k += 1

            while i < len(L):
                Items[k] = L[i]
                i += 1
                k += 1

            while j < len(R):
                Items[k] = R[j]
                j += 1
                k += 1

    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        num = nums1 + nums2

        num.sort()

        if len(num) % 2 == 1:
            return float(num[len(num) // 2])

        else:
            return float((num[len(num) // 2] + num[(len(num) // 2) - 1]) / 2)


sol = Solution()

nums1 = [1, 3]
nums2 = [2]

print(sol.findMedianSortedArrays(nums1, nums2))

nums1 = [1, 2]
nums2 = [3, 4]

print(sol.findMedianSortedArrays(nums1, nums2))
