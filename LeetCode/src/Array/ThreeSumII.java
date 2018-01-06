package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumII {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> resultLst = new ArrayList<List<Integer>>();
        if(nums.length < 3){
        	return resultLst;
        }
        //Sort the array
        Arrays.sort(nums);
        
        //if the minimum element is positive OR maximum element is negative, impossible to find the matches
        int min = nums[0];
        int max = nums[nums.length - 1];
        if(min > 0 || max < 0){
        	return resultLst;
        }
        
        int count = 0;
        //[first factor + second factor + third factor] in ascending order, and sum(1,2,3) = 0
        //loop, the first factor can not be positive
        int i = 0, j = 0, k = 0;
        while(nums[i] <= 0 && i < nums.length - 2){
        	if(i > 0 && nums[i] == nums[i-1]){
        		i++;
        		continue;
        	}
        	SECOND: for(j = i + 1; j < nums.length - 1; j++){
        		int requiredValue = 0 - (nums[i] + nums[j]);
        		if(requiredValue >= 0 && requiredValue <= max){
	        		THIRD: for(k = nums.length - 1; k > j; k--){
	        			count ++;
	        			if(nums[k] < 0){//the third factor can not be negative
	        				break THIRD;
	        			}
	        			if(nums[i] + nums[j] + nums[k] == 0){
	        				ArrayList<Integer> temp = new ArrayList<Integer>();
	        				temp.add(nums[i]);
	        				temp.add(nums[j]);
	        				temp.add(nums[k]);
	        				if(!resultLst.contains(temp)){
	        					resultLst.add(temp);
	        					//System.out.println("\t***** Right Match: [" + nums[i] + ", " + nums[j] + ", " + nums[k] + "]");
	        				}
	        				break THIRD;
	        			}
	        		}
        		}
        	}
        	i++;
        }
        System.out.println("Total loop count: " + count);
        System.out.println("resultLst.size: " + resultLst.size());
        return resultLst;
	}
}