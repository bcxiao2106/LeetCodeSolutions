package String;

import java.util.Stack;

public class ValidParentheses {
	
	public boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }
        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            char relatedChar = ' ';
            if(st.empty()){
                st.push(c);
            } else {
                switch(c){
                    case ')':relatedChar = '(';
                    break;
                    case ']':relatedChar = '[';
                    break;
                    case '}':relatedChar = '{';
                    break;
                }
                if(st.peek() == relatedChar){
                    st.pop();
                } else {
                    st.push(c);
                }
            }
        }
        return st.empty() ? true : false;
    }
}
