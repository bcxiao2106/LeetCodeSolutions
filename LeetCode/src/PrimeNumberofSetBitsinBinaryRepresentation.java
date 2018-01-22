
public class PrimeNumberofSetBitsinBinaryRepresentation {
	public static int countPrimeSetBits(int L, int R) {
		int result = 0;
        for(int i = L; i <= R; i ++){
        	String binaryStr = Integer.toBinaryString(i);
        	int count = 0;
        	for(int j = 0; j < binaryStr.length(); j ++){
        		if(binaryStr.charAt(j) == '1'){
        			count ++;
        		}
        	}
        	if(isPrime(count)){
        		result ++;
        	}
        }
        return result;
    }
	
	public static boolean isPrime(int num){
		if(num < 2) return false;
		if(num == 2) return true;
		if(num % 2 == 0) return false;
		for(int i = 3; i < num; i ++){
			if(num % i == 0){
				return false;
			}
		}
		return true;
	}
}
