package String;

import java.util.Hashtable;

public class LongestPalindromicSubstring {
	
	public String longestPalindrome(String s) {
        String result = "";
        int len = s.length();
        if(len == 1){
        	return s;
        }

        int idx1 = 0, idx2 = 1, currMaxLen = 0, maxPossibleIdx;
        FIRST: for( int i = 0; i < len - 1; i++ ){
        	maxPossibleIdx = i + currMaxLen;
        	if(maxPossibleIdx > len){//could not find longer substring, stop
        		break FIRST;
        	}
            SECOND: for(int j = len - 1; j >= maxPossibleIdx; j--){//from last character to maxPossibleIdx
                if(s.charAt(i) == s.charAt(j)){//candidate substring
                    if(isPalindrome(s, i, j)){//if it is Palindrome, update idx1, idx2, current max length currMaxLen
                    	System.out.println("maxPossibleIdx is: " + maxPossibleIdx);
                    	System.out.println("Current [i - j]: " + i + " - " + j);
                    	idx1 = i;
                    	idx2 = j + 1; //+1 for substring's endIndex(exclusive)
                    	currMaxLen = j - i + 1;//update current max length
                        System.out.println("Current length: " + currMaxLen);
                        break SECOND;
                    }
                }
            }
        }
        System.out.println(currMaxLen);
        System.out.println("Current [idx1, idx2]: " + idx1 + ", " + idx2);
        return(s.substring(idx1, idx2));
    }
    
    public boolean isPalindrome(String s, int i, int j){
        boolean isPalindrome = true;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                isPalindrome = false;
                break;
            } else if(s.charAt(i) == s.charAt(j)){
            	i ++;
            	j --;
            }
        }
        return isPalindrome;
    }
}
