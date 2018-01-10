package String;

public class StringToInteger {
	
	public int myAtoi(String str) {
		System.out.println("Original String: " + str);
		if(str.length() == 0 || str == null || str.equals("")){
			return 0;
		}
        StringBuffer sb = new StringBuffer();
        boolean numberStarted = false;//check if number is started
        boolean negative = false;//check if it is a negative number with '-' at the beginning
        boolean signed = false;//check if the sign(positive / negative) of the number is confirmed 
        for( int i = 0; i < str.length(); i ++ ){
        	char c = str.charAt(i);
        	if(!numberStarted && c == ' ') continue;//filter all the white spaces at the beginning of the string
        	if((c >= 48 && c <= 57) || c == 43 || c == 45){//0 - 9 OR + OR -
        		numberStarted = true;//number started
	        	if(signed){//signed
	        		if(c == 43 || c == 45){//if it is followed by another sign character, return 0
	        			return 0;
	        		} else {//if it is followed by number, add it into string buffer
	        			sb.append(c);
	        		}
	        	} else {//not signed
	        		if(c == 43 || c == 45){//it is a sign character
	        			signed = true;//signed
	        			negative = c == 45 ? true : false;//confirm negative / positive
	        		} else {//if it is started with only number, than it is a positive number
	        			signed = true;//signed
	        			sb.append(c);//add the number into string buffer
	        		}
	        	}
        	} else {//if it is not a numeric character or sign character
        		if(numberStarted){//and if the number started, then stop the search
        			break;//end point
        		} else {// if the number is not started yet, which means, start with other character, then , return 0
        			return 0;
        		}
        	}
        }
        //Add sign to the string
        if(negative){
        	sb.insert(0, '-');
        }
        String resultStr = sb.toString();

        if(resultStr.equals("+") || resultStr.equals("-") || 
        		resultStr.length() == 0 || resultStr.equals("") || resultStr == null){
        	return 0;
        }
        
        System.out.println("Negative: " + negative);
        
        //check the range, compare to the Integer (-2147483648 ~ 2147683647, 32bits)
        if(negative){
        	if(resultStr.length() > 11 || 
        			(resultStr.length() == 11 && resultStr.compareTo(String.valueOf(Integer.MIN_VALUE)) > 0)){
        		return Integer.MIN_VALUE;
        	}
        } else {
        	if(resultStr.length() > 10 || 
        			(resultStr.length() == 10 && resultStr.compareTo(String.valueOf(Integer.MAX_VALUE)) > 0)){
        		return Integer.MAX_VALUE;
        	}
        }

        return(Integer.parseInt(resultStr));
    }
}
