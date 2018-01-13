
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
        int ls = s.length(), lp = p.length();
        int i = 0, j = 0;
        boolean result = true;
        char prePc = 0;
        char currentStarValue = 0;
        if(s == p || s.equals(p)){
            return true;
        }
        while(i < ls && j < lp){
        	System.out.println("Current [i,j]: " + i + ", " + j);
            char sc = s.charAt(i);
            char pc = p.charAt(j);
            if(pc == '*'){
            	currentStarValue = prePc;
            	if(sc == currentStarValue || currentStarValue == '.'){//matched
            		i ++;
            		continue;
            	} else {//not matched
            		j ++;
            		prePc = pc;
            		continue;
            	}
            } else if(pc != '*'){
            	if(sc == pc || pc == '.'){//matched
            		i ++;
            		j ++;
            		prePc = pc;
            		continue;
            	} else {//not matched
            		if(i == 0){
            			j ++;
                		prePc = pc;
                		continue;
            		}
            		if(j < lp - 1 && p.charAt(j + 1) == '*'){
            			prePc = p.charAt(j + 1);
            			j = j + 2;
                		continue;
            		}
            		result = false;
            		return false;
            	}
            }
        }
        System.out.println("Loop ended result: " + result);
        System.out.println("Loop ended [i,j]: " + i + ", " + j);
        if(i < ls){
        	return false;
        }
        System.out.println("Previous char is: " + prePc);
        System.out.println("Current Start Value is: " + currentStarValue);
        if(j < lp){
            char pc = p.charAt(j);
            System.out.println("current pc is: " + pc);
            if(pc == '*'){
                j ++;
                currentStarValue = s.charAt(ls - 1);
                prePc = pc;
            }
            while(j < lp && result){
                pc = p.charAt(j);
                System.out.println("current pc is: " + pc);
                System.out.println("current prePc is: " + prePc);
                System.out.println("current currentStarValue is: " + currentStarValue);
                if(pc == '*' || (prePc == '*' && (pc == currentStarValue || currentStarValue == '.')) || (j < lp - 1 && p.charAt(j + 1) == '*') ){
                	if(j < lp - 1 && p.charAt(j + 1) == '*'){
	                	prePc = p.charAt(j + 1);
	                	j = j + 1;
                	}
                } else {
                    return false;
                }
                j ++;
            }
        }
        
        return result;
    }
}
