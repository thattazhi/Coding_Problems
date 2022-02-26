import java.util.Map;
import java.util.HashMap;

public class BrailleTranslation {
    public static String solution(String s) {
		Map<Character, String> dictionary = new HashMap<>();
    	dictionary.put(' ', "000000");
    	dictionary.put('a', "100000");
    	dictionary.put('b', "110000");
    	dictionary.put('c', "100100");
    	dictionary.put('d', "100110");
    	dictionary.put('e', "100010");
    	dictionary.put('f', "110100");
    	dictionary.put('g', "110110");
    	dictionary.put('h', "110010");
    	dictionary.put('i', "010100");
    	dictionary.put('j', "010110");
    	dictionary.put('k', "101000");
    	dictionary.put('l', "111000");
    	dictionary.put('m', "101100");
    	dictionary.put('n', "101110");
    	dictionary.put('o', "101010");
    	dictionary.put('p', "111100");
    	dictionary.put('q', "111110");
    	dictionary.put('r', "111010");
    	dictionary.put('s', "011100");
    	dictionary.put('t', "011110");
    	dictionary.put('u', "101001");
    	dictionary.put('v', "111001");
    	dictionary.put('w', "010111");
    	dictionary.put('x', "101101");
    	dictionary.put('y', "101111");
    	dictionary.put('z', "101011");
    	String ans = "";
    	
    	for(char ch: s.toCharArray()) {
    	    if(ch >= 'A' && ch <= 'Z') {
    	        ans += "000001";
    	        ch += 'a' - 'A';
    	    }
    	    
    	    ans += dictionary.get(ch);
    	}
    	
    	return ans;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(BrailleTranslation.solution("code").equals("100100101010100110100010"));
        System.out.println(BrailleTranslation.solution("Braille").equals("000001110000111010100000010100111000111000100010"));
        System.out.println(BrailleTranslation.solution("The quick brown fox jumps over the lazy dog").equals("000001011110110010100010000000111110101001010100100100101000000000110000111010101010010111101110000000110100101010101101000000010110101001101100111100011100000000101010111001100010111010000000011110110010100010000000111000100000101011101111000000100110101010110110"));
    }
}