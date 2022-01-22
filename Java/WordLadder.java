import java.util.HashSet;
import java.util.Set;
import java.util.List;

class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord))
            return 0;

        return countLength(beginSet, endSet, dict, 1);
    }

    private static int countLength(Set<String> beginSet, Set<String> endSet, Set<String> dict, int length) {
        if (beginSet.isEmpty() || endSet.isEmpty())
            return 0;

        length++;
        dict.removeAll(beginSet);
        Set<String> nextSet = new HashSet<>();

        for (String word : beginSet)
        {
            char[] wordChar = word.toCharArray();

            for (int i = 0; i < wordChar.length; i++)
            {
                char ch = wordChar[i];

                for (char j = 'a'; j <= 'z'; j++)
                {
                    wordChar[i] = j;
                    String temp = new String(wordChar);

                    if (!dict.contains(temp))
                        continue;

                    if (endSet.contains(temp))
                        return length;

                    nextSet.add(temp);
                }

                wordChar[i] = ch;
            }
        }

        return nextSet.size() > endSet.size() ? countLength(endSet, nextSet, dict, length)
                : countLength(nextSet, endSet, dict, length);
    }
}