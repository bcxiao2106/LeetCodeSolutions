package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> resultList = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        FIRST: for(int i = 0; i < nums.length - 3; i ++){
            if(i > 0 && nums[i] == nums[i - 1]) continue FIRST;
            SECOND: for(int j = i + 1; j < nums.length - 2; j ++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue SECOND;
                int k = j + 1;
                int l = nums.length - 1;
                int requiredValue = target - nums[i] - nums[j];
                INNER:while(l > k){
                	if(k > j + 1 && nums[k] == nums[k - 1]){
                		k ++;
                		continue INNER;
                	}
                	if(l <  nums.length - 1 && nums[l] == nums[l + 1]){
                		l --;
                		continue INNER;
                	}
                	int tempValue = nums[k] + nums[l];
                	if(tempValue > requiredValue){
                		l --;
                	} else if(tempValue < requiredValue){ 
                		k ++;
                	} else {
                		resultList.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                		k ++;
                		l --;
                	}
                }
            }
        }
        return resultList;
    }
	
	public static List<List<Integer>> fourSumII(int[] nums, int target) {
        ArrayList<List<Integer>> resultList = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        FIRST: for(int i = 0; i < nums.length - 3; i ++){
            if(i > 0 && nums[i] == nums[i - 1]) continue FIRST;
            SECOND: for(int j = i + 1; j < nums.length - 2; j ++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue SECOND;
                THIRD: for(int k = j + 1; k < nums.length - 1; k ++){
                    if(k > j + 1 && nums[k] == nums[k - 1]) continue THIRD;
                    int requiredValue = target - nums[i] - nums[j] - nums[k];
                    int l = nums.length - 1;
                    INNER:while(l > k){
                        if(requiredValue > nums[l]) break INNER;
                        if(l < nums.length - 1 && nums[l] == nums[l + 1]){
                            l --;
                            continue INNER;
                        }
                        if(requiredValue == nums[l]){
                            resultList.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                            break INNER;
                        }
                        l --;
                    }
                }
            }
        }
        return resultList;
    }
}
