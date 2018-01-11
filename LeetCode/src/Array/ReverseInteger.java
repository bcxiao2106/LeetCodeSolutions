package Array;

public class ReverseInteger {
	
	public int reverse(int x) {
		StringBuilder input = new StringBuilder(Integer.toString(x));
        int len = input.length();
        if(len == 1){//if it is a single digit integer, return the same integer
        	return x;
        }
        
        boolean isNegative = false;
        
        //check the sign digit, if it is '-', update isNegative to true, move startIdx backward
        if(input.charAt(0) == '-'){
        	isNegative = true;
        	input.deleteCharAt(0);
        }
        //check the sign digit, if it is '+', move startIdx backward
        if(input.charAt(0) == '+'){
        	input.deleteCharAt(0);
        }
        //delete '0' at the beginning
        while(input.charAt(0) == '0'){
        	input.deleteCharAt(0);
        }
        //delete '0' at end
        while(input.charAt(input.length() - 1) == '0'){
        	input.deleteCharAt(input.length() - 1);
        }
        
        StringBuilder resultSb = input.reverse();
        
        //add the '-' sign if it is a negative integer
        if(isNegative){
        	resultSb.insert(0, '-');
        }
        
        String resultStr = resultSb.toString();
        //check if the integer is overflow the 32-bits integer
        if(isNegative){//negative boundary
        	if(resultStr.length() > 11 || 
        			(resultStr.length() == 11 && resultStr.compareTo(String.valueOf(Integer.MIN_VALUE)) > 0)){
        		return 0;
        	}
        } else {//positive boundary
        	if(resultStr.length() > 10 || 
        			(resultStr.length() == 10 && resultStr.compareTo(String.valueOf(Integer.MAX_VALUE)) > 0)){
        		return 0;
        	}
        }
        return Integer.parseInt(resultStr);
    }
}
