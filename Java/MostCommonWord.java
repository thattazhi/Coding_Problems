import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class MostCommonWord
{
    public String mostCommonWord(String paragraph, String[] banned)
    {
        Set<String> banset = new HashSet<>();

        for(String word: banned) banset.add(word);

        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        String ans = "";

        paragraph += ".";

        StringBuilder word = new StringBuilder();

        for(char ch: paragraph.toCharArray())
        {
            if(Character.isLetter(ch))
                word.append(ch);
            
            else if(word.length() > 0)
            {
                String current = word.toString();

                if(!banset.contains(current))
                {
                    map.put(current, map.getOrDefault(current, 0) + 1);

                    if(map.get(current) > max)
                    {
                        max = map.get(current);
                        ans = current;
                    }
                }

                word = new StringBuilder();
            }
        }

        return ans;
    } 
}