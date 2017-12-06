import java.util.Hashtable;

public class LongestSubstring {
	
	public static int lengthOfLongestSubstring(String s) {
		Hashtable<Character,Integer> ht = new Hashtable<Character,Integer>();
	    int n = s.length();
	    int j = 1;
	    int i = 0;
	    int length = 0;
	    ht.put(s.charAt(i),1);
	    for(i = 0; i < n; i++){ 
	        while(j < n && !ht.containsKey(s.charAt(j))){
	        	ht.put(s.charAt(j), 1);
	            j++;
	        }
	        int temp = j - i;
	        length = temp > length ? temp : length;
	        ht.remove(s.charAt(i));
	    }
	       return length;
	}
}
