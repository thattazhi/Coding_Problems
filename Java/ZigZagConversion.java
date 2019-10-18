class ZigZagConversion {
    // Time: O(n) | Space: O(n)
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() < 3)
            return s;

        int l = s.length();
        char[] ans = new char[l];
        int maxGap = 2 * (numRows - 1), index = 0;

        for (int i = 0; i < numRows; i++) {
            int gap = maxGap - 2 * i;

            for (int j = i; j < l; j += maxGap) {
                ans[index++] = s.charAt(j);

                if (gap > 0 && gap < maxGap && j + gap < l)
                    ans[index++] = s.charAt(j + gap);
            }
        }

        return new String(ans);
    }
}