package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumII {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> resultLst = new ArrayList<List<Integer>>();
        //if the length of array is less than 3, return the empty list
		if(nums.length < 3){
        	return resultLst;
        }
        //Sort the array
        Arrays.sort(nums);
        
        //Loop i from 0 to pIdx, cause the first (smallest) factor can not be positive
        for( int i = 0; i < nums.length - 2; i++ ){
        	if(i > 0 && nums[i] == nums[i - 1]){
        		continue;
        	}
        	int firstVal = nums[i];
        	if(firstVal > 0){
        		break;
        	}
        	int j = i + 1;
        	int k = nums.length - 1;
        	while(j < k){//loop, adjust j, k position to find the match of SUM = 0
        		int sum = nums[j] + nums[k];//sum of current j,k
        		int requiredVal = 0 - firstVal;//expected value to make nums[i] + requiredVal = 0
        		if(sum > requiredVal || (k < nums.length - 1 && nums[k] == nums[k + 1])){//if sum of j,k greater than the expected value
        			k--;//move the bigger pointer to left (small value direction)
        		} else if(sum < requiredVal || (j > i + 1 && nums[j] == nums[j - 1])){//if sum of j,k smaller than the expected value
        			j++;//move the smaller pointer to right (bigger value direction)
        		} else {//exactly equal (sum = requiredVal), then, save to the result list
        			resultLst.add(Arrays.asList(nums[i], nums[j], nums[k]));
    				j++;//keep searching
    				k--;//keep searching
        		}
        	}
        }
        System.out.println("resultLst.size: " + resultLst.size());
        return resultLst;
	}
}