package Array;

public class MaximumSubarray {
	
	public static int maxSubArray(int[] nums) {
		int maxSoFar=nums[0], maxEndingHere=nums[0];
	    for (int i = 1;i<nums.length;++i){
	    	maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
	    	maxSoFar = Math.max(maxSoFar, maxEndingHere);	
	    }
	    System.out.println(maxSoFar);
	    return maxSoFar;
    }
}
