import java.util.HashMap;
import java.util.Map;

public class SplitString {
    public static int findNumberOfSplits(String s) {
        
        // Store total count of 0s
        int cnt = 0;
 
        // Count total no. of 0s
        // character in given string
        for (char c : s.toCharArray()) {
            cnt += c == 'a' ? 1 : 0;
        }
 
        // If total count of 0
        // character is not
        // divisible by 3
        if (cnt % 3 != 0)
            return 0;
 
        int res = 0, k = cnt / 3, sum = 0;
 
        // Initialize map to store
        // frequency of k
        Map<Integer, Integer> map = new HashMap<>();
 
        // Traverse string to find
        // ways to split string
        for (int i = 0; i < s.length(); i++) {
 
            // Increment count if 0 appears
            sum += s.charAt(i) == 'a' ? 1 : 0;
 
            // Increment result if sum equal to
            // 2*k and k exists in map
            if (sum == 2 * k && map.containsKey(k)
                && i < s.length() - 1 && i > 0) {
                res += map.get(k);
            }
 
            // Insert sum in map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
 
        // Return result
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findNumberOfSplits("babaa"));
        System.out.println(findNumberOfSplits("ababa"));
        System.out.println(findNumberOfSplits("aba"));
        System.out.println(findNumberOfSplits("bbbbb"));
    }
}
