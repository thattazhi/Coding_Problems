class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack= new Stack<>();
        
        for(char ch: s.toCharArray())
        {
            switch(ch)
            {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default:
                    if(stack.empty() || stack.pop() != ch)
                        return false;
            }
        }
        
        return stack.empty();
    }
}