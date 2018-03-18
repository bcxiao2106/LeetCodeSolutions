package String;

public class CountandSay {
	public static String countAndSay(int n) {
		n = 7;
		if(n == 2) return "11";
		String countStr = "11";
		for(int i = 3; i <= n; i ++) {
			StringBuilder sb = new StringBuilder();
			char reptChar = countStr.charAt(0);
			int times = 0;
			for(int j = 0; j < countStr.length(); j ++) {
				if(countStr.charAt(j) == reptChar) {
					times ++;
				} else {
					sb.append(times);
					sb.append(reptChar);
					reptChar = countStr.charAt(j);
					times = 1;
				}
				if(j == countStr.length() - 1) {
					sb.append(times);
					sb.append(reptChar);
				}
			}
			countStr = sb.toString();
		}
		System.out.println(countStr);
		return countStr;
    }
}
