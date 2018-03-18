package String;

public class ReverseBits {
	
	public static int reverseBits(int n) {
		n = 1;
		String binaryStr = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
		StringBuilder sb = new StringBuilder(binaryStr);
		sb.reverse();
		System.out.println(binaryStr);
        System.out.println(sb.toString());
        //System.out.println(Integer.parseInt(sb.toString(), 2));
        //return Integer.parseInt(sb.toString(), 2);
        return Integer.reverse(n);
    }
}
