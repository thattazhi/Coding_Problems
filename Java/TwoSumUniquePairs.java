import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class TwoSumUniquePairs {

    // Time : O(n) || Space : O(n)
    public static int countPairs(int[] nums, int S) {
        Map<Integer, Boolean> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            int complement = S - num;

            if (map.containsKey(complement)) {

                if (map.get(complement)) {
                    count++;
                    map.put(complement, false);
                }
            }

            else
                map.put(num, map.getOrDefault(num, true));
        }

        return count;
    }

    // Time : O(nlogn) || Space : O(1)
    public static int uniquePairsNLogN(int[] nums, int target) {
        int count = 0, i = 0, j = nums.length - 1;
        Arrays.sort(nums);

        while (i < j) {
            int sum = nums[i] + nums[j];

            if (sum < target)
                i++;

            else if (sum > target)
                j--;

            else {
                count++;
                i++;
                j--;

                while (i < j && nums[i] == nums[i - 1])
                    i++;

                while (i < j && nums[j] == nums[j + 1])
                    j--;
            }
        }

        return count;
    }

    // Time : O(n) || Space : O(2n) or O(n)
    public static int uniquePairsN(int[] nums, int target) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        Set<Integer> seen = new HashSet<>();

        for(int num: nums) {
            int complement = target - num;

            if (set.contains(complement) && !seen.contains(num)) {
                count++;
                seen.add(num);
                seen.add(complement);
            }

            set.add(num);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 4, 4, 4, 4 };

        int sum = 8;

        System.out.println(countPairs(nums, sum));
        System.out.println(uniquePairsN(nums, sum));
        System.out.println(uniquePairsNLogN(nums, sum));
    }
}