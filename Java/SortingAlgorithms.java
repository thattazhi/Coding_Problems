public class SortingAlgorithms {
    // Time : O(n^2) (Best case : O(n)) || Space : O(1)
    public static void bubbleSort(int[] a) {
        while (true) {
            int swap = 0;

            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    a[i] = a[i] + a[i + 1];
                    a[i + 1] = a[i] - a[i + 1];
                    a[i] = a[i] - a[i + 1];
                    swap++;
                }
            }

            if (swap == 0)
                break;
        }
    }

    // Time : O(n^2) || Space : O(1)
    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[smallest] > a[j]) {
                    smallest = j;
                }
            }

            if (smallest != i) {
                a[i] = a[i] + a[smallest];
                a[smallest] = a[i] - a[smallest];
                a[i] = a[i] - a[smallest];
            }
        }
    }

    // Time : O(n^2) (Best case : O(n)) || Space : O(1)
    public static void insertionSort(int[] a) {
        for (int index = 0; index < a.length - 1; index++) {
            int i = index, j = i + 1;
            while (i >= 0 && a[i] > a[j]) {
                a[i] = a[i] + a[j];
                a[j] = a[i] - a[j];
                a[i] = a[i] - a[j];
                i--;
                j--;
            }
        }
    }

    // Time : O(nlogn) || Space : O(n)
    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    public static void mergeSort(int[] a, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(a, start, mid);
            mergeSort(a, mid + 1, end);
            merge(a, start, mid, end);
        }
    }

    public static void merge(int[] a, int start, int mid, int end) {
        int[] l = new int[mid - start + 1];
        int[] r = new int[end - mid];

        for (int i = 0; i < l.length; i++) {
            l[i] = a[start + i];
        }

        for (int i = 0; i < r.length; i++) {
            r[i] = a[mid + 1 + i];
        }

        int i = 0, j = 0, k = start;

        while (i < l.length && j < r.length) {
            if (l[i] < r[j])
                a[k++] = l[i++];

            else
                a[k++] = r[j++];
        }

        while (i < l.length)
            a[k++] = l[i++];

        while (j < r.length)
            a[k++] = r[j++];
    }

    // Time : O(nlogn) (Worst case : O(n^2)) || Space : O(logn)
    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivot = randomizedPartition(a, low, high);

            quickSort(a, low, pivot - 1);
            quickSort(a, pivot + 1, high);
        }
    }

    public static int randomizedPartition(int[] a, int low, int high) {
        int random = (int) (Math.random() * (high - low + 1) + low);

        swap(a, low, random);

        return partition(a, low, high);
    }

    public static int partition(int[] a, int low, int high) {
        int pivot = a[low];
        int i = low + 1, j = high;

        while (i <= j) {
            if (a[i] > pivot && a[j] < pivot)
                swap(a, i, j);

            if (a[i] <= pivot)
                i++;

            if (a[j] >= pivot)
                j--;
        }

        swap(a, low, j);

        return j;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr;

        System.out.println("Bubble");
        arr = new int[] { 4, 65, 8, 7, 46, 2, 4, 93, 4, 8, -5, 2, -8, -25 };
        bubbleSort(arr);
        for (int i : arr)
            System.out.print(i + " ");

        System.out.println("\nSelection");
        arr = new int[] { 4, 65, 8, 7, 46, 2, 4, 93, 4, 8, -5, 2, -8, -25 };
        selectionSort(arr);
        for (int i : arr)
            System.out.print(i + " ");

        System.out.println("\nInsertion");
        arr = new int[] { 4, 65, 8, 7, 46, 2, 4, 93, 4, 8, -5, 2, -8, -25 };
        insertionSort(arr);
        for (int i : arr)
            System.out.print(i + " ");

        System.out.println("\nMerge");
        arr = new int[] { 4, 65, 8, 7, 46, 2, 4, 93, 4, 8, -5, 2, -8, -25 };
        mergeSort(arr);
        for (int i : arr)
            System.out.print(i + " ");

        System.out.println("\nQuick");
        arr = new int[] { 4, 65, 8, 7, 46, 2, 4, 93, 4, 8, -5, 2, -8, -25 };
        quickSort(arr);
        for (int i : arr)
            System.out.print(i + " ");

    }
}