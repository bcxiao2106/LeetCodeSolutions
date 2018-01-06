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
        	if(nums[p] >= 0){
        		pIdx = p;
        		break;
        	}
        }
        
        //[first factor + second factor + third factor] in ascending order, and sum(1,2,3) = 0
        //loop, the first factor can not be positive
        int i = 0, j = 0, k = 0;
        while(nums[i] <= 0 && i < nums.length - 2){
        	if(i > 0 && nums[i] == nums[i-1]){//repeated value, jump to next
        		i++;
        		continue;
        	}
        	SECOND: for(j = i + 1; j < nums.length - 1; j++){
        		int requiredValue = 0 - (nums[i] + nums[j]);
        		if(requiredValue >= 0 && requiredValue <= max){
        			Random rdm = new Random();
        			int start = pIdx > j + 1 ? pIdx : (j + 1);
        			int pivot = (start) + rdm.nextInt(nums.length - start);
        			//System.out.println(pivot);
        			int s = 0, e = 0;
        			if(requiredValue >= nums[pivot]){
        				s = pivot;
        				e = nums.length - 1;
        			} else {
        				s = start;
        				e = pivot - 1;
        			}
	        		THIRD: for(k = s; k <= e; k++){        			
	        			if(nums[k] == requiredValue){
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
        System.out.println("resultLst.size: " + resultLst.size());
        return resultLst;
	}
}