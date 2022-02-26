public class RotationalCipher {
    String rotationalCipher(String input, int rotationFactor) {
        for(int i = 0; i < input.length(); i++) {
          char ch = input.charAt(i);
          
          input = input.substring(0, i) + (char) rotate(ch, rotationFactor) + input.substring(i + 1);
        }
        return input;
      }
      
      int rotate(char ch, int rotationFactor) {
        if(isNumber(ch)) return '0' + ((ch + rotationFactor - '0') % 10);
        
        if(isCaptial(ch)) return 'A' + ((ch + rotationFactor - 'A') % 26);
        
        if(isSmall(ch)) return 'a' + ((ch + rotationFactor - 'a') % 26);
        
        return ch;
      }
    
      boolean isNumber(char ch) {
        if(ch >= '0' && ch <= '9') return true;
        
        return false;
      }
    
      boolean isCaptial(char ch) {
        if(ch >= 'A' && ch <= 'Z') return true;
        
        return false;
      }
    
      boolean isSmall(char ch) {
        if(ch >= 'a' && ch <= 'z') return true;
        
        return false;
      }
    
    
    
    
    
    
    
      // These are the tests we use to determine if the solution is correct.
      // You can add your own at the bottom.
      int test_case_number = 1;
      void check(String expected, String output) {
        boolean result = (expected.equals(output));
        final String PASS = "PASSED";
        final String FAIL = "FAILED";
        if (result) {
          System.out.println(PASS + " Test #" + test_case_number);
        }
        else {
          System.out.print(FAIL + " Test #" + test_case_number + ": Expected ");
          printString(expected); 
          System.out.print(" Your output: ");
          printString(output);
          System.out.println();
        }
        test_case_number++;
      }
      void printString(String str) {
        System.out.print("[\"" + str + "\"]");
      }
      
      public void run() {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);
    
        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);
    
        // Add your own test cases here
        
      }
      
      public static void main(String[] args) {
        new RotationalCipher().run();
      }
}
