package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ThreeSumII {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> resultLst = new ArrayList<List<Integer>>();
        //if the length of array is less than 3, return the empty list
		if(nums.length < 3){
        	return resultLst;
        }
        //Sort the array
        Arrays.sort(nums);
        //sort(nums, 0, nums.length - 1);
        
        //if the minimum element is positive OR maximum element is negative, impossible to find the matches
        int min = nums[0];
        int max = nums[nums.length - 1];
        if(min > 0 || max < 0){
        	return resultLst;
        }
        
        //find the start index of the positive elements
        int pIdx = nums.length - 2;
        for(int p = 0; p < nums.length; p++){
        	if(nums[p] > 0){
        		pIdx = p;
        		break;
        	}
        }
        
        //Loop i from 0 to pIdx, cause the first (smallest) factor can not be positive
        for( int i = 0; i < pIdx; i++ ){
        	int firstVal = nums[i];
        	int j = i + 1;
        	int k = nums.length - 1;
        	SECOND: while(j < k){//loop, adjust j, k position to find the match of SUM = 0
        		int sum = nums[j] + nums[k];//sum of current j,k
        		int requiredVal = 0 - firstVal;//expected value to make nums[i] + requiredVal = 0
        		if(sum > requiredVal){//if sum of j,k greater than the expected value
        			k--;//move the bigger pointer to left (small value direction)
        		} else if(sum < requiredVal){//if sum of j,k smaller than the expected value
        			j++;//move the smaller pointer to right (bigger value direction)
        		} else {//exactly equal (sum = requiredVal), then, save to the result list
        			ArrayList<Integer> temp = new ArrayList<Integer>();
    				temp.add(nums[i]);
    				temp.add(nums[j]);
    				temp.add(nums[k]);
    				if(!resultLst.contains(temp)){//if not exists, save
    					resultLst.add(temp);
    					//System.out.println("\t***** Right Match: [" + nums[i] + ", " + nums[j] + ", " + nums[k] + "]");
    				}
    				j++;//keep searching
    				k--;//keep searching
        		}
        	}
        }
        System.out.println("resultLst.size: " + resultLst.size());
        return resultLst;
	}
}