
public class ClimbingStairs {
	public static int calculateSteps(int n) {
		if(n == 1) return 1;
        if(n == 2) return 2;
        
		int first = 1, second = 2;
		int distinctWays = first + second;
		for(int i = 3; i <= n; i++) {
			distinctWays = first + second;
			first = second;
			second = distinctWays;
			
			System.out.println("current steps: " + distinctWays);
		}
		return distinctWays;
	}
}
