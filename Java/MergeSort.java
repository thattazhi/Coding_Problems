class MergeSort {
    void sort(int[] arr) {
        int n = arr.length;

        mergeSort(arr, 0, n - 1);
    }

    void mergeSort(int[] arr, int i, int j) {
        if (i < j) {
            int mid = (i + j) / 2;
            mergeSort(arr, i, mid);
            mergeSort(arr, mid + 1, j);
            merge(arr, i, mid, j);
        }
    }

    void merge(int[] arr, int i, int mid, int j) {
        int[] l = new int[mid - i + 1];
        int[] r = new int[j - mid];

        for (int x = 0, y = i; x < l.length && y < mid + 1; x++, y++)
            l[x] = arr[y];

        for (int x = 0, y = mid + 1; x < r.length && y < j + 1; x++, y++)
            r[x] = arr[y];

        int left = 0, right = 0;

        while (left < l.length && right < r.length) {
            if (l[left] < r[right])
                arr[i++] = l[left++];

            else
                arr[i++] = r[right++];
        }

        while (left < l.length)
            arr[i++] = l[left++];

        while (right < r.length)
            arr[i++] = r[right++];
    }

    public static void main(String[] args) {
        int[] arr = { 544, -578, 556, 713, -655, -359, -810, -731, 194, -531, -685, 689, -279, -738, 886, -54, -320,
                -500, 738, 445, -401, 993, -753, 329, -396, -924, -975, 376, 748, -356, 972, 459, 399, 669, -488, 568,
                -702, 551, 763, -90, -249, -45, 452, -917, 394, 195, -877, 153, 153, 788, 844, 867, 266, -739, 904,
                -154, -947, 464, 343, -312, 150, -656, 528, 61, 94, -581 };
        new MergeSort().sort(arr);

        for (int i : arr)
            System.out.println(i);
    }
}