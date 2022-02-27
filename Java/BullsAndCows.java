public class BullsAndCows {
    public static String getHint(String secret, String guess) {
        int digitsInSecret[] = new int[10];
        int x = 0, y = 0;

        for (int i = 0; i < secret.length(); i++) {
            char secretChar = secret.charAt(i);
            char guessChar = guess.charAt(i);

            if (secretChar == guessChar) {
                x++;
            } else {
                if (digitsInSecret[secretChar - '0'] < 0)
                    y++;

                if (digitsInSecret[guessChar - '0'] > 0)
                    y++;

                digitsInSecret[secretChar - '0']++;
                digitsInSecret[guessChar - '0']--;
            }
        }

        return String.valueOf(x) + "A" + String.valueOf(y) + "B";
    }

    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810").equals("1A3B"));
        System.out.println(getHint("1123", "0111").equals("1A1B"));
        System.out.println(getHint("11100", "00110").equals("2A2B"));
    }
}
