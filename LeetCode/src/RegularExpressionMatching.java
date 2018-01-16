
public class RegularExpressionMatching {
	public boolean isMatchII(String s, String p){
		char[] sArr = s.toCharArray();
		char[] pArr = p.toCharArray();
		int ls = sArr.length, lp = pArr.length;
        int i = 0, j = 0;
        boolean result = true;
        if(s == p || s.equals(p)){
            return true;
        }
        if(lp == 0){
            return false;
        }
        if(ls == 0 && lp > 0){
            if(lp == 2 && pArr[1] == '*'){
                return true;
            } else {
                return false;
            }
        }
        boolean superMatch = false;
        boolean repeatMatch = false;
        char starChar = ' ';
        while(i < ls && j < lp){
        	if(j < lp - 1 && pArr[j + 1] == '*'){
        		if(pArr[j] == '.'){
        			superMatch = true;
            		j = j + 2;
            		continue;
        		} else {
        			repeatMatch = true;
        			starChar = pArr[j];
        			if(sArr[i] == starChar){
        				i ++;
        			} else {
        				if(j < lp - 2){
        					j = j + 2;
        				} else {
        					result = false;
        					break;
        				}
        			}
        			//repeatMatch = false;
    				continue;
        		}
        	}
        	System.out.println("Current [i, j]: " + i + "," + j);
        	System.out.println("repeatMatch is: " + repeatMatch);
        	System.out.println("Star char is: " + starChar);
        	if(sArr[i] == pArr[j] || pArr[j] == '.'){
        		i ++;
        		j ++;
        	} else if(superMatch){
        		if(i == ls - 1){
        			result = false;
        			break;
        		} else {
        			i ++;
        		}
        	} else if(repeatMatch){
        		if(sArr[i] == starChar){
        			i ++;
        		} else {
        			repeatMatch = false;
        		}
        	} else {
        		System.out.println("\tCurrent [i, j]: " + i + "," + j);
            	System.out.println("\trepeatMatch is: " + repeatMatch);
            	System.out.println("\tStar char is: " + starChar);
        		if(pArr[j] == starChar){
        			j ++;
        			continue;
        		} else {
	        		result = false;
	        		break;
        		}
        	}
        	if(i == ls && j < lp){
        		while(j < lp){
        			if(pArr[j] != '*' && !(j < lp - 1 && pArr[j + 1] == '*')){
        				result = false;
        			}
        			j++;
        		}
        	}
        	if(j == lp && i < ls){
        		System.out.println("Star char is: " + starChar);
        		result = false;
        		break;
        	}
        }
        System.out.println("Final [i, j]: " + i + "," + j);
        return result;
    }

	public boolean isMatch(String s, String p){
		String pureChars = p.replaceAll(".\\*", "");
		if(s.equals(pureChars)){
			return true;
		}
		
        char[] sArr = s.toCharArray();
		char[] pArr = p.toCharArray();
		int ls = sArr.length, lp = pArr.length;
        int i = 0, j = 0;
        boolean result = true;
        if(s == p || s.equals(p)){
            return true;
        }
        if(lp == 0){
            return false;
        }
        if(ls == 0 && lp > 0){
            if(lp == 2 && pArr[1] == '*'){
                return true;
            } else {
                return false;
            }
        }
        boolean superMatch = false;
        boolean repeatMatch = false;
        char starChar = ' ';
        while(i < ls && j < lp){
        	if(j < lp - 1 && pArr[j + 1] == '*'){
        		if(pArr[j] == '.'){
        			superMatch = true;
            		j = j + 2;
            		continue;
        		} else {
        			repeatMatch = true;
        			starChar = pArr[j];
        			if(sArr[i] == starChar){
        				i ++;
        			} else {
        				if(j < lp - 2){
        					j = j + 2;
        				} else if(j == lp - 2 && superMatch){
        					if(pArr[lp - 1] == '*' || pArr[lp - 1] == sArr[ls - 1]){
        						result = true;
            					break;
        					} else {
        						result = false;
            					break;
        					}
        					
        				} else {
        					result = false;
        					break;
        				}
        			}
        			//repeatMatch = false;
    				continue;
        		}
        	}
        	System.out.println("Current [i, j]: " + i + "," + j);
        	System.out.println("repeatMatch is: " + repeatMatch);
        	System.out.println("Star char is: " + starChar);
        	if(sArr[i] == pArr[j] || pArr[j] == '.'){
        		i ++;
        		j ++;
        	} else if(superMatch){
        		if(i == ls - 1){
        			result = false;
        			break;
        		} else {
        			i ++;
        		}
        	} else if(repeatMatch){
        		if(sArr[i] == starChar){
        			i ++;
        		} else {
        			repeatMatch = false;
        		}
        	} else {
        		System.out.println("\tCurrent [i, j]: " + i + "," + j);
            	System.out.println("\trepeatMatch is: " + repeatMatch);
            	System.out.println("\tStar char is: " + starChar);
        		if(pArr[j] == starChar && j < lp - 1){
        			j ++;
        			continue;
        		} else {
	        		result = false;
	        		break;
        		}
        	}
        	if(i == ls && j < lp){
        		while(j < lp){
        			if(pArr[j] != '*' && !(j < lp - 1 && pArr[j + 1] == '*')){
        				result = false;
        			}
        			j++;
        		}
        	}
        	if(j == lp && i < ls){
        		System.out.println("Star char is: " + starChar);
        		if(superMatch && (pArr[lp - 1] == sArr[ls - 1] || pArr[lp - 1] == '.')){
        			result = true;
        		} else {
        			result = false;
        		}
        		break;
        	}
        }
        System.out.println("Final [i, j]: " + i + "," + j);
        return result;
	}
}
