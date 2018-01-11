
public class PalindormeNumber {
	public boolean isPalindrome(int x) {
        boolean result = true;
        if(x < 10 & x >= 0){//if x is a single digit integer, return true
            return true;
        } else if(x < 0){//if x is negative, return false
        	return false;
        }
        //find the length
        int min = 10, max = min * 10 - 1;
        while(x > max){
            min = min * 10;
            max = min * 10 - 1;
        }
        int len = (int)Math.log10(min) + 1;
        
        //check if the digits in the mirror position are equal
        int preLeftValue = 0;
        for(int i = 0; i < len / 2; i ++){
        	//left digit : x = 12321, l = 12321 / 1000 - 1 * 10 = 2
            int l = x / (int)Math.pow(10, len - i - 1) - preLeftValue * 10;
          //right digit : x = 12321, r = (12321 - ((12321 / 100) * 100)) / 10 = 2
            int r = (x - (x / (int)Math.pow(10, i + 1)) * (int)Math.pow(10, i + 1)) / (int)Math.pow(10, i);
            if(l != r){//if left digit does not equal to right digit, stop
                result = false;
                break;
            }
            preLeftValue = preLeftValue * 10 + l;
        }
        return result;
    }
}
