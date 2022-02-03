import java.util.ArrayList;
import java.util.List;

public class DuplicatesInArray {
    public static int[] findDuplicates(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        
        for(int i: arr)
          arr[i % arr.length] += arr.length;
        
        for(int i = 0; i < arr.length; i++)
          if(arr[i] / arr.length > 1)
            ans.add(i);
        
        return ans.stream().mapToInt(i -> i).toArray();
    }
    
    private static int test_case_number = 1;
    
    private static void check(int[] expected, int[] output) {
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
        }
        else {
          System.out.print(FAIL + " Test #" + test_case_number + ": Expected ");
          printIntegerArray(expected); 
          System.out.print(" Your output: ");
          printIntegerArray(output);
          System.out.println();
        }
        test_case_number++;
    }

    
    private static void printIntegerArray(int[] arr) {
        int len = arr.length; 
        System.out.print("[");
        for(int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        int[] test_1 = {0,3,1,2};
        int[] expected_1 = {};
        int[] output_1 = findDuplicates(test_1);
        check(expected_1, output_1);
        
        int[] test_2 = {2,3,1,2,3};
        int[] expected_2 = {2, 3};
        int[] output_2 = findDuplicates(test_2);
        check(expected_2, output_2);
        
        int[] test_3 = {0, 8, 6, 5, 5, 4, 7, 1, 8};
        int[] expected_3 = {5, 8};
        int[] output_3 = findDuplicates(test_3);
        check(expected_3, output_3);
    }
}
