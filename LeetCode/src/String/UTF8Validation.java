package String;

public class UTF8Validation {
	public static boolean validUtf8(int[] data) {
        if(data == null || data.length == 0) {
            return false;
        }
        int len = data.length;
        //String tempStr = String.format("%8s", Integer.toBinaryString(data[0] & 0xFF)).replace(' ', '0');
        if(len == 1) {
            return (data[0] <= 127) ? true : false;
        }
        int currentByteLen = 0;
        for(int i = 0; i < len; i ++){
        	if(data[i] > 247) return false;
        	System.out.println("Current i: " + i);
    		System.out.println("currentByteLen : " + currentByteLen);
        	String tempStr = Integer.toBinaryString(data[i]);
        	System.out.println("Current tempStr: " + tempStr);
        	if(currentByteLen == 0) {
        		if(data[i] >= 192 && data[i] <= 247) {
	        		for(int j = 0; j < tempStr.length(); j ++) {
	        			if(tempStr.charAt(j) == '0') break;
	        			currentByteLen ++;
	        		}
	        		currentByteLen --;
	        		continue;
        		} else if(data[i] >= 64 && data[i] <= 127){
        			continue;
        		} else if(data[i] >= 128 && data[i] <= 191){
        			return false;
        		}
        	}
        	if(currentByteLen > 0) {
        		if(data[i] >= 128 && data[i] <= 191) {
        			currentByteLen --;
        		} else {
        			return false;
        		}
        	}
        }
        return true;
    }
}
