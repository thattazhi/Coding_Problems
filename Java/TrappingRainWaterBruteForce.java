class TrappingRainWaterBruteForce {
    public int trap(int[] height) {
        int water = 0;
        
        for(int i = 0; i < height.length; i++)
        {
            int max_left = 0, max_right = 0;
            for(int j = i; j > -1; j--)
                max_left = Math.max(max_left, height[j]);
            
            for(int j = i; j < height.length; j++)
                max_right = Math.max(max_right, height[j]);
            
            water += Math.min(max_right, max_left) - height[i];
        }
        
        return water;
    }
}