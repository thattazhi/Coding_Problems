public class RotaryLock {
    public static long getMinCodeEntryTime(int N, int M, int[] C) {
        int current = 1;
        long minTime = 0L;

        for(int code: C) {
            int absTime = Math.abs(code - current);
            minTime += Math.min(absTime, N - absTime);
            current = code;
        }

        return minTime;
    }
    
    public static void main(String[] args) {
        int N = 14;
        int M = 11;
        int C[] = {1, 9, 9, 8, 6, 5, 10, 13, 1, 4, 6, 7};
        
        System.out.println(getMinCodeEntryTime(N, M, C));
    }
}