class StringToIntegerATOI{
    public int myAtoi(String str) {
        int len = str.length();
        if(len == 0) return 0;
        
        char sc[] = str.toCharArray();
        
        int i = 0;
        for(; i < len && sc[i] == ' '; i++) {}
        
        if(i == len) return 0;
                
        int j = i;
        if(sc[j] == '+' || sc[j] == '-') j++;
        
        while(j < len && sc[j] > 47 && sc[j] < 58)
        {
            j++;
        }
        
        if(i < len && sc[i] == '-')
        {
            i++;
            while(i < len && sc[i] == 48)
                sc[i++] = '-';
            i--;
        }
        
        else
        {
            int temp = i;
            if(sc[i] == '+')
                while(++i < len && sc[i] == 48) i++;
            
            else
                while(i < len && sc[i] == 48) i++;
            
            if(i != temp) i--;
        }
        
        if(i == j || (j == i + 1 && (sc[i] == '+' || sc[i] == '-'))) return 0;
        
        str = new String(sc);
        str = str.substring(i, j);
        
        if(sc[i] == '-' && str.length() > 11) return Integer.MIN_VALUE;
        if(str.length() > 11) return Integer.MAX_VALUE;
        
        long num_l = Long.parseLong(str);
        if(num_l < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        
        if(num_l > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        
        return Integer.parseInt(str);
    }
}