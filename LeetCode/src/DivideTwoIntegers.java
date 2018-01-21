
public class DivideTwoIntegers {
	public static int divide(int dividend, int divisor) {
		dividend = 10;
		divisor = 7;
		if(divisor == 0) return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(divisor == 1) return dividend;
        
        boolean isNegative = ((dividend > 0 && divisor > 0)||(dividend < 0 && divisor < 0)) ? false : true;
        int times = 1;
        System.out.println("isNegative: " + isNegative);
        if(Math.abs(dividend) == Math.abs(divisor)){
            if(isNegative){
            	times = -1;   
            } else {
            	times = 1;
            }
            return times;
        }
        if(Math.abs(dividend) < Math.abs(divisor)){
            return 0;
        }
        if(dividend >= Integer.MIN_VALUE){
        	dividend = dividend >> 1;
        	times = times + times;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        System.out.println("Current dividend: " + dividend);
        System.out.println("Current times: " + times);
        int currentTimes = 0;
        while(dividend > divisor){
        	dividend = dividend >> 1;
        	System.out.println("\tCurrent dividend: " + dividend);
        	currentTimes = times;
        	if(dividend >= divisor){
        		times = times + times;
        	}
        	
        	System.out.println("\tCurrent times: " + times);
        }
        System.out.println("Current dividend: " + dividend);
        System.out.println("Current times: " + times);
        if(dividend < divisor){
    		times ++;
    	}
        if(isNegative){
        	times = 0 - times;
        }
        
        return times;
    }
}
