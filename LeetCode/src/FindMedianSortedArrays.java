
public class FindMedianSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalNum = nums1.length + nums2.length;
        boolean isEven = totalNum % 2 == 0 ? true : false;
        int medianIdx = totalNum / 2;
        if(medianIdx == 0) medianIdx = 1;
        System.out.println(medianIdx);
        if(nums1.length == 0){
            return isEven?(nums2[medianIdx] + nums2[medianIdx - 1])/2 : nums2[medianIdx];
        }
        if(nums2.length == 0){
            return isEven?(nums1[medianIdx] + nums1[medianIdx - 1])/2 : nums1[medianIdx];
        }
        int m = 0;
        int n = 0;
        int medianLeft = 0;
        int medianRight = 0;
        while(m + n <= medianIdx){
        	medianLeft = medianRight;
        	System.out.println(m + " ---- " + n);
        	if(m == nums1.length) m--;
        	if(m == nums2.length) n--;
        	System.out.println(nums1[m] + " :::: " + nums2[n]);
            if(nums1[m] < nums2[n]){
            	medianRight = nums1[m];
            	m++;
            } else {
            	medianRight = nums2[n];
            	n++;
            }
        }
       
        if(m>n) m--;
        else n--;
        System.out.println(medianLeft + " &&&&  "+ medianRight);
        System.out.println(m + ":" + n);
        System.out.println("isEven: "+isEven);
        if(isEven){
        	return (medianLeft + medianRight) / 2.0;
        } else {
        	return medianRight;
        }
    }
}
