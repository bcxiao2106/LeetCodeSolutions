import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,0,1,2,-1,-4};
		ThreeSum ts = new ThreeSum(nums);
		List<List<Integer>> resultLst = ts.findThreeSumEqualsToZero();

	}

}
