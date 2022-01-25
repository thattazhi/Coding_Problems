import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Deque;

class Kaitenzushi {
  
    public static int getMaximumEatenDishCount(int N, int[] D, int K) {
      Deque<Integer> eatenDishQ = new LinkedList<Integer>();
      Set<Integer> eatenDishSet = new HashSet<Integer>();
      int maxEatableDishes = 0;
      
      for(int dish: D) {
        if(!eatenDishSet.contains(dish)) {
          eatenDishQ.add(dish);
          eatenDishSet.add(dish);
          maxEatableDishes++;
          
          if(eatenDishQ.size() > K)
            eatenDishSet.remove(eatenDishQ.pop());
        }
      }
      
      return maxEatableDishes;
    }
    
    public static void main(String[] args) {
        int N = 6;
        int D[] = {1, 2, 3, 3, 2, 1};
        int K = 1;

        System.out.println(getMaximumEatenDishCount(N, D, K));
    }
  }
  