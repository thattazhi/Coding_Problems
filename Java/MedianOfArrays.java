public class MedianOfArrays {
    // Time: O(n) | Space: O(n)
    public static double medianOfArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[] C = new int[m + n];

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (A[i] < B[j])
                C[k++] = A[i++];

            else
                C[k++] = B[j++];
        }

        while (i < m)
            C[k++] = A[i++];

        while (j < n)
            C[k++] = B[j++];

        if ((m + n) % 2 == 0)
            return (C[(m + n) / 2] + C[(m + n) / 2 - 1]) / 2.0;

        return (double) C[(m + n) / 2];
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 5};
        int[] B = {2, 4, 6};
        System.out.println(medianOfArrays(A, B));
    }
}