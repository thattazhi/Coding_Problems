import java.util.Stack;

public class ContiguousSubarrays {
  int[] countSubarraysBrute(int[] arr) {
    int n = arr.length;
    int ans[] = new int[n];

    for (int i = 0; i < n; i++) {
      ans[i] = 1;

      for (int j = i - 1; j >= 0; j--) {
        if (arr[j] > arr[i])
          break;

        ans[i]++;
      }

      for (int j = i + 1; j < n; j++) {
        if (arr[j] > arr[i])
          break;

        ans[i]++;
      }
    }

    return ans;
  }
  
  int[] countSubarrays(int[] arr) {
    int n = arr.length;
    int ans[] = new int[n];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
      while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        int index = stack.pop();
        ans[index] = i - index;
      }

      stack.push(i);
    }

    while(!stack.isEmpty()) {
      int index = stack.pop();
      ans[index] = n - index;
    }
    
    for (int i = n - 1; i >= 0; i--) {
      ans[i]--;
      while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        int index = stack.pop();
        ans[index] += index - i;
      }

      stack.push(i);
    }

    while(!stack.isEmpty()) {
      int index = stack.pop();
      ans[index] += index + 1;
    }

    return ans;
  }

  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom.
  int test_case_number = 1;

  void check(int[] expected, int[] output) {
    int expected_size = expected.length;
    int output_size = output.length;
    boolean result = true;
    if (expected_size != output_size) {
      result = false;
    }
    for (int i = 0; i < Math.min(expected_size, output_size); i++) {
      result &= (output[i] == expected[i]);
    }
    final String PASS = "PASSED";
    final String FAIL = "FAILED";
    if (result) {
      System.out.println(PASS + " Test #" + test_case_number);
    } else {
      System.out.print(FAIL + " Test #" + test_case_number + ": Expected ");
      printIntegerArray(expected);
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

  public void run() {
    int[] test_1 = { 3, 4, 1, 6, 2 };
    int[] expected_1 = { 1, 3, 1, 5, 1 };
    int[] output_1 = countSubarrays(test_1);
    check(expected_1, output_1);

    int[] test_2 = { 2, 4, 7, 1, 5, 3 };
    int[] expected_2 = { 1, 2, 6, 1, 3, 1 };
    int[] output_2 = countSubarrays(test_2);
    check(expected_2, output_2);

    // Add your own test cases here

  }

  public static void main(String[] args) {
    new ContiguousSubarrays().run();
  }
}