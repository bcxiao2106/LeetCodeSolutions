package String;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if(len == 0){
            return "";
        }
        if(len == 1){
           return strs[0];
        }
        int minLen = strs[0].length();
        for(int i = 0; i < strs.length; i++){
            minLen = (minLen < strs[i].length()) ? minLen : strs[i].length();
        }
        StringBuilder sb = new StringBuilder();
        FIRST: for(int j = 0; j < minLen; j++){
            char firstChar = strs[0].charAt(j);
            SECOND: for(int k = 1; k < strs.length; k++){
                char temp = strs[k].charAt(j);
                if(firstChar != temp){
                    break FIRST;
                }
            }
            sb.append(firstChar);
        }
        return sb.toString();
    }
}
