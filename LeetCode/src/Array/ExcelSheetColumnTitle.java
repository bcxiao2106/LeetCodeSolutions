package Array;

public class ExcelSheetColumnTitle {
	public static String convertToTitle(int n) {
		n = 28;
		StringBuilder sb = new StringBuilder();
		while(n > 0) {
			--n;
			sb.append((char)('A' + n % 26));
			n = n / 26;
		}
		sb.reverse();
		System.out.println(sb.toString());
        return sb.toString();
    }
}
