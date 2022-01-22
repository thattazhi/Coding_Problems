import java.util.HashMap;
import java.util.Map;

public class DNAComplement {
    public static String dnaComplement(String s) {
        int len = s.length();
        Map<Character, Character> map = new HashMap<>();
        map.put('A', 'T');
        map.put('T', 'A');
        map.put('C', 'G');
        map.put('G', 'C');

        StringBuilder sb = new StringBuilder();
        
        for(int i = len - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            sb.append(map.get(ch));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(dnaComplement("GTCAG"));
        System.out.println(dnaComplement("ACCGGGTTTT"));
        System.out.println(dnaComplement("ATGC"));
        System.out.println(dnaComplement("ATCGTA"));
    }
}