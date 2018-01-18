package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {
	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
        if(n == 1){
        	result.add("()");
        }
        if(n > 1){
            List<String> baseList = generateParenthesis(n - 1);
            
            for(int i = 0; i < baseList.size(); i ++){
                String temp = baseList.get(i);
                for(int j = temp.length(); j > 0; j --){
                    StringBuilder sb = new StringBuilder(temp);
                    sb.insert(j, "()");
                    String candidateStr = sb.toString();
                    if(!result.contains(candidateStr)){
                    	result.add(sb.toString());
                    	System.out.println(sb.toString());
                    } 
                }
            }
        }
        return result;
    }
}
