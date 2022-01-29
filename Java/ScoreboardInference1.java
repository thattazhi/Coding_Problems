class ScoreboardInference1 {
  
    public static int getMinProblemCount(int N, int[] S) {
      int maxScore = 0;
      boolean isOdd = false;
      
      for(int score: S) {
        if(score % 2 != 0) isOdd = true;
        
        if(score > maxScore) maxScore = score;
      }
      
      if(isOdd) return (maxScore / 2) + 1;
      
      return maxScore / 2;
    }

    public static void main(String[] args) {
        int N = 6;
        int S[] = {1, 2, 3, 4, 5, 6};

        System.out.println(getMinProblemCount(N, S));
    }
    
  }