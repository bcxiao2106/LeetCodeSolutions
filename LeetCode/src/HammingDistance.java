
public class HammingDistance {
	
	public int hammingDistance(int x, int y) {
        Integer z = (x | y) - (x & y);
        String b = Integer.toBinaryString(z);
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(y));
        int result = 0;
        for(int i = 0; i < b.length(); i++){
        	if(b.charAt(i) == '1'){
        		result++;
        	}
        }
        System.out.println(b);
        System.out.println(result);
        return result;
    }
}
