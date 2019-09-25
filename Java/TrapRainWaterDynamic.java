class TrapRainWaterDynamic {
    public int trap(int[] height) {
        int water = 0, max = 0;
        
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        
        for(int i = 0; i < height.length; i++)
        {
            if(max < height[i])
                max = height[i];
            
            left[i] = max;
        }
        
        max = 0;
        
        for(int i = height.length - 1; i > -1; i--)
        {
            if(max < height[i])
                max = height[i];
            
            right[i] = max;
        }
        
        for(int i = 0; i < height.length; i++)
            water += Math.min(left[i], right[i]) - height[i];
        
        return water;
    }
}