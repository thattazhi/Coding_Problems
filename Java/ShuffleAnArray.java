class Solution {
    
    private int[] arr;
    private int[] ans;
    private int size;

    public Solution(int[] nums) {
        arr = nums;
        ans = nums.clone();
        size = nums.length;
    }
    
    public int[] reset() {
        return arr;
    }
    
    public int[] shuffle() {
        for(int i = 0; i < size; i++) {
            int randIndex = (int) (Math.random() * (size - i)) + i;
            int temp = ans[i];
            ans[i] = ans[randIndex];
            ans[randIndex] = temp;
        }
        
        return ans;
    }
}