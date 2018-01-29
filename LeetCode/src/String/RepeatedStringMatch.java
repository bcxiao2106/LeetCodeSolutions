package String;

public class RepeatedStringMatch {
	
	public static int repeatedStringMatch(String A, String B) {
		A = "axaxaya";
		B = "axaya";

		if(A.length() >= 2 * B.length()){
			if(A.contains(B)){
				return 1;
			} else {
				return -1;
			}
		}
		if(A.length() >= B.length()){
			if(A.contains(B)){
				return 1;
			}
		}
        char[] charA = A.toCharArray();
        char[] charB = B.toCharArray();
        int count = 1;
        int i = 0, j = 0;
        boolean charMatched = false;
        while(j < charB.length){
        	if(count > 2 && !charMatched){
        		count = -1;
        		break;
        	}
        	if(i == charA.length){
        		if(charMatched){
	        		i = 0;
	        		count++;
	        		continue;
        		} else {
        			count = -1;
        			break;
        		}
        	}
        	System.out.println("A char["+i+"]: " + charA[i] + " == " + "B char["+j+"]: " + charB[j] + "  " + charMatched);
        	if(charA[i] == charB[j]){
        		charMatched = true;
        		i ++;
        		j ++;
        	} else {
        		charMatched = false;
        		i ++;
        		j = 0;
        	}
        	
        }
        return count;
    }
	
	public static int repeatedStringMatchII(String A, String B) {
        int count = 1;
        String repeatedStr = A;
        while(!repeatedStr.contains(B)){
        	System.out.println(repeatedStr.contains(B));
            if(repeatedStr.length() > 2 * B.length()){
                count = -1;
                break;
            }
            System.out.println(repeatedStr);
            repeatedStr += A;
            count ++;
        }
        return count;
    }
}
