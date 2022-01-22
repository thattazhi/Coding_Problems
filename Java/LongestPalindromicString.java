public class LongestPalindromicString 
{
    public String longestPalindrome(String s)
    {
        if(s.length() < 2) return s;

        int max = 0, start = 0, end = 0;

        for(int i = 0; i < s.length(); i++)
        {
            int l1 = expand(s, i, i);
            int l2 = expand(s, i, i + 1);
            int l = Math.max(l1, l2);

            if(l > max)
            {
                max = l;
                start = i - (l - 1) / 2;
                end = i + l / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    int expand(String s, int L, int R)
    {
        while(L > -1 && R < s.length() && s.charAt(L) == s.charAt(R))
        {
            L--;
            R++;
        }

        return R - L - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicString l = new LongestPalindromicString();
        System.out.println(l.longestPalindrome("babad"));
    }
}