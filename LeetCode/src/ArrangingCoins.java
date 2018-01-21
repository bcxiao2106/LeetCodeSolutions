import java.math.BigDecimal;

public class ArrangingCoins {
	public static int arrangeCoins(int n) {
		//-b+-sqrt(b*b - 4ac)/2
        return (int)(-1 + Math.sqrt(1 + 8 * (double)n)) / 2;
    }
}
