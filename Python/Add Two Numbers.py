# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

    def AddNode(self, x):
        pass


class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """

        x = 1
        n1 = 0
        for i in range(len(l1)):
            n1 += x * l1[i]
            x *= 10
        #
        # x = 1
        # n2 = 0
        # for i in range(len(l2)):
        #     n2 += x * l2[i]
        #     x *= 10
        #
        # n = n1 + n2
        # l = []
        #
        # while n > 0:
        #     l.append(n % 10)
        #     n //= 10
        #
        # return l
