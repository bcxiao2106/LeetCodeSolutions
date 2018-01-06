package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
        
        int pIdx = 0;
        for(int p = 0; p < nums.length; p++){
        	if(nums[p] > 0){
        		pIdx = p;
        		break;
        	}
        }
        if(pIdx == 0){
            pIdx = nums.length - 2;
        }
        
        for( int i = 0; i < pIdx; i++ ){
        	int firstVal = nums[i];
        	int j = i + 1;
        	int k = nums.length - 1;
        	SECOND: while(j < k){
        		int sum = nums[j] + nums[k];
        		int requiredVal = 0 - firstVal;

        		if(sum > requiredVal){
        			k--;
        		} else if(sum < requiredVal){
        			j++;
        		} else {
        			ArrayList<Integer> temp = new ArrayList<Integer>();
    				temp.add(nums[i]);
    				temp.add(nums[j]);
    				temp.add(nums[k]);
    				if(!resultLst.contains(temp)){
    					resultLst.add(temp);
    					//System.out.println("\t***** Right Match: [" + nums[i] + ", " + nums[j] + ", " + nums[k] + "]");
    				}
    				j++;
    				k--;
        		}
        	}
        }
        System.out.println("resultLst.size: " + resultLst.size());
        return resultLst;
	}
}