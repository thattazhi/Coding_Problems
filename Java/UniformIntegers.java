public class UniformIntegers {
    public static int getUniformIntegerCountInInterval(long A, long B) {
        if(A == B) {
          if(isUniform(A)) return 1;
          else return 0;
        }
        
        int ans = 0;
        
        String stringA = String.valueOf(A);
        char firstDigitA = stringA.charAt(0);
        int digitsA = stringA.length();
        
        String diffString = "", uniformString = "";
        for(int i = 0; i < digitsA; i++) {
          diffString += "1";
          uniformString += firstDigitA;
        }
        
        long uniform = Long.parseLong(uniformString), diff = Long.parseLong(diffString);
        
        if(uniform < A) {
          uniform += diff;
        }
        
        while(uniform <= B) {
          if(String.valueOf(uniform).length() > String.valueOf(diff).length()) {
            diff = ++uniform;
            continue;
          }
          ans++;
          uniform += diff;
        }
        
        return ans;
    }
      
    private static boolean isUniform(long x) {
        String xString = String.valueOf(x);
        for(int i = 1; i < xString.length(); i++)
          if(xString.charAt(i - 1) != xString.charAt(i))
            return false;
        
        return true;
    }

    public static void main(String[] args) {
        System.out.println(getUniformIntegerCountInInterval(75, 300));
        System.out.println(getUniformIntegerCountInInterval(1, 9));
        System.out.println(getUniformIntegerCountInInterval(999999999999L, 999999999999L));
    }
}
