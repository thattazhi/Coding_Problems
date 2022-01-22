public class ReverseString {
    public void reverseSpell(String input) {
        input = input.toLowerCase();

        StringBuilder sb = new StringBuilder();
        for(int i = input.length() - 1; i >= 0; i--) {
            char ch = input.charAt(i);
            
            if(ch < '0' || (ch > '9' && ch < 'a') || ch > 'z')
                continue;
            
            sb.append(input.charAt(i));
            sb.append("-");
        }

        String ans = sb.toString();

        if(ans.charAt(ans.length() - 1) == '-')
            ans = ans.substring(0, ans.length() - 1);
        
        System.out.println(ans);
    }
}