import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BestDaysToBuyAndSellStocks {
    int[] bestDaysToBuyAndSellBrute(int[] arr) {
        int ans[] = new int[2];
        int n = arr.length, maxProfit = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (maxProfit < arr[j] - arr[i]) {
                    maxProfit = arr[j] - arr[i];
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        return ans;
    }

    int[] bestDaysToBuyAndSell(int[] arr) {
        int ans[] = new int[2];
        int n = arr.length, minIndex = 0, maxIndex = 0;

        for (int i = 0; i < n; i++) {
            if ((arr[maxIndex] < arr[i]) || ((arr[i] - arr[minIndex]) > (arr[ans[1]] - arr[ans[0]]))) {
                maxIndex = i;
            }

            if (arr[minIndex] > arr[i]) {
                minIndex = i;
            }

            if (minIndex >= maxIndex)
                continue;

            int newMax = arr[maxIndex] - arr[minIndex];
            int currentMax = arr[ans[1]] - arr[ans[0]];

            if (newMax > currentMax) {
                ans[0] = minIndex;
                ans[1] = maxIndex;
            }
        }

        return ans;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    void check(Set<int[]> expected, int[] output) {
        boolean result = false;
        for (int[] e : expected) {
            result |= Arrays.equals(e, output);
        }
        final String PASS = "PASSED";
        final String FAIL = "FAILED";
        if (result) {
            System.out.println(PASS + " Test #" + test_case_number);
        } else {
            System.out.print(FAIL + " Test #" + test_case_number + ": Expected ");
            printMultipleIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    void printMultipleIntegerArray(Set<int[]> set) {
        int j = 0;
        for (int[] arr : set) {
            if (j != 0) {
                System.out.print(" or ");
            }
            System.out.print("[");
            for (int i = 0; i < arr.length; i++) {
                if (i != 0) {
                    System.out.print(", ");
                }
                System.out.print(arr[i]);
            }
            System.out.print("]");
            j++;
        }
    }

    public void run() {
        int[] test_1 = { 100, 180, 260, 310, 40, 535, 695 };
        Set<int[]> expected_1 = new HashSet<>(Arrays.asList(new int[][] { { 4, 6 } }));
        int[] output_1 = bestDaysToBuyAndSell(test_1);
        check(expected_1, output_1);

        int[] test_2 = { 4, 2, 2, 2, 4 };
        Set<int[]> expected_2 = new HashSet<>(Arrays.asList(new int[][] { { 1, 4 }, { 2, 4 }, { 3, 4 } }));
        int[] output_2 = bestDaysToBuyAndSell(test_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new BestDaysToBuyAndSellStocks().run();
    }
}
