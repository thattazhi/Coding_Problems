class QuickSortRandomized {
    public static int[] quickSort(int[] array) {
<<<<<<< Updated upstream
      quickSort(array, 0, array.length - 1);
          
          return array;
    }
      
      static void quickSort(int[] array, int low, int high)
      {
          if(low < high)
          {
              int pivot = random_partition(array, low, high);
              
              quickSort(array, low, pivot - 1);
              quickSort(array, pivot + 1, high);
          }
      }
      
      static int random_partition(int[] array, int low, int high)
      {
          int rand = (int) (Math.random() * (high - low + 1)) + low;
          
          swap(array, low, rand);
          
          return partition(array, low, high);
      }
      
      static int partition(int[] array, int low, int high)
      {
          int pivot = array[high];
          int i = low;
          for(int j = low; j < high; j++)
          {
              if(array[j] < pivot)
              {
                  swap(array, i, j);
                  i++;
              }
          }
          
          swap(array, i, high);
          
          return i;
      }
      
      static void swap(int[] array, int i, int j)
      {
          int temp = array[j];
          array[j] = array[i];
          array[i] = temp;
      }

      public static void main(String[] args) {
        int[] input = {1, 3, 2};

        quickSort(input);

        for(int i: input)
            System.out.println(i);
      }
  }
  
=======
        quickSort(array, 0, array.length - 1);

        return array;
    }

    static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = random_partition(array, low, high);

            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    static int random_partition(int[] array, int low, int high) {
        int rand = (int) (Math.random() * (high - low + 1)) + low;

        swap(array, low, rand);

        return partition(array, low, high);
    }

    static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                swap(array, i, j);
                i++;
            }
        }

        swap(array, i, high);

        return i;
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        int[] input = { 1, 3, 2 };

        quickSort(input);

        for (int i : input)
            System.out.println(i);
    }
}
>>>>>>> Stashed changes
