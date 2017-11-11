import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	private int[] nums;
	
	public ThreeSum(int[] nums){
		this.nums = nums;
		Arrays.sort(this.nums);
	}
	
	public List<List<Integer>> findThreeSumEqualsToZero(){
		int endIdx = nums.length -3;
		for(int j = 0; j < nums.length; j++){
			if(nums[j]>0){
				endIdx = j;
				break;
			}
		}
		System.out.println("End index is: " + endIdx);
		ArrayList<List<Integer>> resultLst = new ArrayList<List<Integer>>();
        int f = 0, s = 1, t = 2;
        while(f < endIdx){
        	System.out.println(f + " + " + s + " + " + t);
        	if(s > nums.length - 2){
                f++;
                s = f + 1;
                t = s + 1;
                continue;
            }
            if(t > nums.length - 1){
                s++;
                t = s + 1;
                continue;
            }
            
            if(nums[f] + nums[s] + nums[t] == 0){
                Integer[] tempArr = new Integer[3];
                tempArr[0] = nums[f];
                tempArr[1] = nums[s];
                tempArr[2] = nums[t];
                List<Integer> tempList = Arrays.asList(tempArr);
                if(!resultLst.contains(tempList)){
                	resultLst.add(tempList);
                }
            } 
            t++;
        }
        System.out.println(resultLst.size());
        return resultLst;
	}
}
