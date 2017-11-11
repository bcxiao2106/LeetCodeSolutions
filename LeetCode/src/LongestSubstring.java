
public class LongestSubstring {
	
	public int lengthOfLongestSubstring(String s) {
        if(!isRepeating(s)) return s.length();
        for(int i = s.length() - 1; i > 1; i--){
            String subStr = generateSubStrings(s, i);
            if(subStr != null){
	            System.out.println(subStr);
	            return i;
            }
        }
        return 1;
    }
	/*	
	public int lengthOfLongestSubstring(String s) {
        if(!isRepeating(s)) return s.length();
        for(int i = s.length() - 1; i > 1; i--){
            String[] subStrArr = generateSubStrings(s, i);
            boolean isTarget = false;
            for(int j = 0; j < subStrArr.length; j++){
                if(!isRepeating(subStrArr[j])){
                	isTarget = true;
                	break;
                }
            }
            System.out.println(isTarget);
            if(isTarget) return i;
        }
        return 1;
    }
	
    public String[] generateSubStrings(String s, int length){
    	System.out.println(s + "  the length is: " + length);
    	int combination  = s.length() - length + 1;
    	System.out.println("Combination is : " + combination);
        String[] resultString = new String[combination];
        for(int i = 0; i < combination; i++){
        	int startIdx = i;
        	int endIdx = i + length - 1;
        	if(endIdx < s.length()){
        		resultString[i] = s.substring(startIdx, endIdx + 1);
        		System.out.println(resultString[i]);
        	}
        }
        return resultString;
    }
    */
    
    public String generateSubStrings(String s, int length){
    	System.out.println(s + "  the length is: " + length);
    	//int combination  = s.length() - length + 1;
    	//System.out.println("Combination is : " + combination);
        String resultString = "";
        for(int i = 0; i < s.length() - length + 1; i++){
        	int startIdx = i;
        	int endIdx = i + length - 1;
        	if(endIdx < s.length()){
        		resultString = s.substring(startIdx, endIdx + 1);
        		System.out.println(resultString);
        		if(isRepeating(resultString)){
        			i = i + length - 1;
        		} else {
        			return resultString;
        		}
        	}
        }
        return null;
    }
    
    public boolean isRepeating(String s){
        char[] charArr = s.toCharArray();
        for(int i = 0; i < charArr.length; i++){
            for(int j = i+1; j < charArr.length; j++){	
                if(charArr[i] == charArr[j]){
                	System.out.println(charArr[i] + "---" + charArr[j] + "  return true");
                    return true;
                }
            }
        }
        System.out.println("This time returen false : " + s);
        return false;
    }

}
