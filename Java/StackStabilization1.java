public class StackStabilization1 {
    public static int getMinimumDeflatedDiscCount(int N, int[] R) {
        if(R[N - 1] < N) return -1;
        
        int ans = 0;
        for(int i = N - 2; i >= 0; i--) {
          if(R[i] < i + 1) return -1;
          
          if(R[i] >=  R[i + 1]){
            R[i] = R[i + 1] - 1;
            ans++;
          }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        int N = 5;
        int R[] = {2, 5, 3, 6, 5};

        System.out.println(getMinimumDeflatedDiscCount(N, R));
    }
}
