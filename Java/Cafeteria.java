import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Cafeteria {
    /**
     * O(M*log(M))
     */
    public static long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
        Arrays.sort(S);
    
        long maxNewDiners = (S[0] - 1L) / (K + 1);
        
        long i = S[0] + K + 1;
        int j = 1;
        
        while(i <= N && j < M) {
            if(i < S[j] - K)
                maxNewDiners += (S[j] - i) / (K + 1);
            
            i = S[j++] + K + 1;
            }
        
        if(i <= N)
            maxNewDiners += (N - S[--j]) / (K + 1);
        
        return maxNewDiners;
    }

    /**
     * O(N)
     */
    public static long getMaxAdditionalDinersCount2(long N, long K, int M, long[] S) {
        Arrays.sort(S);
    
        long maxNewDiners = 0L, i = 1L;
        int j = 0;
        
        while(i <= N && j < M){
            if(i < S[j] - K){
                maxNewDiners++;
                i += K + 1;
                continue;
            }
            
            i = S[j] + K + 1;
            j++;
        }

        while(i <= N) {
            maxNewDiners++;
            i += K + 1;
        }
        
        return maxNewDiners;
    }

    /**
     * O(N*N/K)
     */
    public static long getMaxAdditionalDinersCount3(long N, long K, int M, long[] S) {
        Set<Long> noSeatSet = new HashSet<Long>();
        
        for(long seat: S) updateNoSeatSet(noSeatSet, seat, K, N);

        long maxNewDiners = 0L;
        
        for(long i = 1L; i <= N; i++)
          if(!noSeatSet.contains(i)) {
            maxNewDiners++;
            updateNoSeatSet(noSeatSet, i, K, N);
          }
        
        return maxNewDiners;
    }
    
    private static void updateNoSeatSet(Set<Long> noSeatSet, long seat, long K, long N) {
        long i = seat - K < 1 ? 1 : seat - K;
        while(i <= seat + K && i <= N) {
          noSeatSet.add(i);
          i++;
        }
    }

    /**
     * O(N*M)
     */
    public static long getMaxAdditionalDinersCount4(long N, long K, int M, long[] S) {
        long i = 1L;
        long maxNewDiners = 0L;
        
        while(i <= N) {
          boolean isValidSeat = true;
          for(long seat: S)
            if((i == seat) || (i < seat && i >= seat - K) || (i > seat && i <= seat + K)) {
              isValidSeat = false;
              break;
            }
          
          if(isValidSeat) {
            maxNewDiners++;
            i += K + 1;
            continue;
          }
          
          i++;
        }
        return maxNewDiners;
    }
    
    public static void main(String[] args) {
        long N = 10L, K = 1L;
        int M = 2;
        long[] S = {2L, 6L};

        System.out.println(getMaxAdditionalDinersCount(N, K, M, S));
    }
}
