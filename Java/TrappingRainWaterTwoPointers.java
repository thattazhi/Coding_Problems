class TrappingRainWaterTwoPointers {
    public int trap(int[] height) {
        int water = 0, left = 0, right = height.length - 1, left_max = 0, right_max = 0;
        
        while(left < right)
        {
            if(height[left] < height[right])
            {
                if(height[left] > left_max)
                    left_max = height[left];
                
                water += left_max - height[left++];
            }
            
            else
            {
                if(height[right] > right_max)
                    right_max = height[right];
                
                water += right_max - height[right--];
            }
        }
        
        return water;
    }
}