class SingleCycleCheck {
    public static boolean hasSingleCycle(int[] array) {
        int i = 0, n = array.length, count = 1;

        if (n == 0)
            return false;

        i = array[0] % n;

        if (i < 0 && i * -1 < n)
            i += n;

        while (i != 0) {
            i = (i + array[i]) % n;
            count++;

            if (i < 0 && i * -1 < n)
                i += n;

            if (count > n)
                return false;
        }

        if (count == n)
            return true;

        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasSingleCycle(new int[] { -1, 2, 2 }));
    }
}