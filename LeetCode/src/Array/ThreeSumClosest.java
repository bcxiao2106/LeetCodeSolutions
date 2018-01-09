package Array;

import java.util.Arrays;

public class ThreeSumClosest {
	
	public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 3){
        	return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int diff = 0;
        int sum = 0;
        FIRST: while (diff >= 0){
	        for (int i  = 0; i < nums.length - 2; i++){
	        	int firstVal = nums[i];
	        	int requiredValSmaller = target - diff - firstVal;
	        	int requiredValGreater = target + diff - firstVal;
	        	for ( int j = i + 1; j < nums.length - 1; j ++ ){
	        		for( int k = j + 1; k < nums.length; k ++ ){
		        		int currentSum = nums[j] + nums[k];
		        		if (requiredValSmaller == currentSum || requiredValGreater == currentSum){
		        			sum = currentSum + firstVal;
		        			System.out.println("\t***** Right match: [" + nums[i] + ", " + nums[j] + ", " + nums[k] + "]");
		        			break FIRST;
		        		}
	        		}
	        	}
	        	if(i == nums.length - 2) break FIRST;
	        }
	        diff ++;
        }
        System.out.println("Target is: " + target + "\nClosest sum: " + sum);
        return sum;
    }
}
