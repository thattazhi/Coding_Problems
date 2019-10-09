import java.util.*;

class LevenshteinDistance {
    public static int levenshteinDistance(String str1, String str2) {
        int[][] memo = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i < str1.length() + 1; i++) {
            memo[i][0] = i;
            for (int j = 1; j < str2.length() + 1; j++)
                memo[i][j] = j;
        }

        for (int i = 1; i < str1.length() + 1; i++)
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i - 1) != str2.charAt(j - 1))
                    memo[i][j] = 1 + Math.min(memo[i - 1][j - 1], Math.min(memo[i - 1][j], memo[i][j - 1]));
                else
                    memo[i][j] = memo[i - 1][j - 1];
            }

        return memo[str1.length()][str2.length()];
    }

    public static int LevenshteinDistanceBetter(String str1, String str2) {
        String small = str1.length() < str2.length() ? str1 : str2;
        String big = str1.length() >= str2.length() ? str1 : str2;

        int[] evenEdits = new int[small.length() + 1];
        int[] oddEdits = new int[small.length() + 1];

        for (int i = 0; i < small.length() + 1; i++)
            evenEdits[i] = i;

        for (int i = 1; i < big.length() + 1; i++) {
            int[] currentEdits = new int[small.length() + 1];
            int[] prevEdits = new int[small.length() + 1];

            if (i % 2 == 1) {
                currentEdits = oddEdits;
                prevEdits = evenEdits;
            }

            else {
                currentEdits = evenEdits;
                prevEdits = oddEdits;
            }

            currentEdits[0] = i;

            for (int j = 1; j < small.length() + 1; j++) {
                if (big.charAt(i - 1) == small.charAt(j - 1))
                    currentEdits[j] = prevEdits[j - 1];

                else
                    currentEdits[j] = 1 + Math.min(prevEdits[j - 1], Math.min(prevEdits[j], currentEdits[j - 1]));
            }
        }

        return big.length() % 2 == 1 ? oddEdits[small.length()] : evenEdits[small.length()];
    }

    public static void main(String[] args) {
        System.out.println(LevenshteinDistanceBetter("abbbbbbbbb", "bbbbbbbbba"));
    }
}