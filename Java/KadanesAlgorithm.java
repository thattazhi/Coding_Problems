class KadanesAlgorithm {
    public static int kadanesAlgorithm(int[] array) {
        int current = array[0], max_so_far = array[0], i = 0;

        while (++i < array.length) {
            current = Math.max(current + array[i], array[i]);
            max_so_far = Math.max(max_so_far, current);
        }

        return max_so_far;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, -22, 7, 8, 9, 10};

        System.out.println(kadanesAlgorithm(input));
    }
}