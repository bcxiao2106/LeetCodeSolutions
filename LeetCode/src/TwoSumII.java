
public class TwoSumII {
	public static int[] twoSum(int[] numbers, int target) {
		int resultIdx[] = new int[2];
        int i = 0, j = numbers.length - 1;
        while(j > i) {
        	if(numbers[i] + numbers[j] > target) j --;
        	if(numbers[i] + numbers[j] < target) i ++;
        	if(numbers[i] + numbers[j] == target) {
        		resultIdx[0] = i + 1;
        		resultIdx[1] = j + 1;
        		break;
        	}
        }
        return resultIdx;
    }
}
