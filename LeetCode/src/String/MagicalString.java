package String;

public class MagicalString {

	public static int magicalStringIII(int n){
		if(n == 0){
			return 0;
		} else if(n <= 3){
			return 1;
		} else if(n <= 4){
			return 2;
		} else if(n < 7){
			return 3;
		}
		StringBuilder sb = new StringBuilder("12211");
		int count = 3;
		int currentIdx = 3;
		int nextNum = 2;

		while(sb.length() < n){
			if(sb.charAt(currentIdx) == '2' && sb.length() < n - 1){
				if(nextNum == 1){
					sb.append("11");
					count += 2;
				} else {
					sb.append("22");
				}
			} else if(sb.charAt(currentIdx) == '2' && sb.length() == n - 1){
				if(nextNum == 1){
					sb.append("1");
					count += 1;
				} else {
					sb.append("2");
				}
			} else if(sb.charAt(currentIdx) == '1' && sb.length() < n){
				if(nextNum == 1){
					sb.append("1");
					count += 1;
				} else {
					sb.append("2");
				}
			}
			currentIdx++;
			if(nextNum == 2){
				nextNum = 1;
			} else {
				nextNum = 2;
			}
			System.out.println(sb);
		}
		return count;
	}
}
