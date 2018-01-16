package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
	
	public static List<String> letterCombinations(String digits){
		if(digits.length() == 0 || digits.equals("") || digits == null){
			return new ArrayList<String>();
		}
		Hashtable<Character, char[]> ht = new Hashtable<Character, char[]>();
		ht.put('2', new char[] {'a','b','c'});
		ht.put('3', new char[] {'d','e','f'});
		ht.put('4', new char[] {'g','h','i'});
		ht.put('5', new char[] {'j','k','l'});
		ht.put('6', new char[] {'m','n','o'});
		ht.put('7', new char[] {'p','q','r','s'});
		ht.put('8', new char[] {'t','u','v'});
		ht.put('9', new char[] {'w','x','y','z'});
		
		int len = digits.length();
		char[][] charArr = new char[len][];
		int resultLen = 1;
		for(int i = 0; i < len; i ++){
			charArr[i] = ht.get(digits.charAt(i));
			resultLen *= charArr[i].length;
		}

		StringBuilder[] sb = new StringBuilder[resultLen];
		ArrayList<String> current = new ArrayList<String>();
		for(int j = 0; j < charArr[0].length; j ++){
			current.add(String.valueOf(charArr[0][j])); 
		}
		if(len == 1){
			return current;
		}
		
		ArrayList<String> result = null;
		for(int j = 1; j < len; j ++){
			result = combineChars(current, charArr[j]);
			current = result;
		}
		
		for(int k = 0; k < result.size(); k ++){
			System.out.println(result.get(k));
		}
		return result;
	}
	
	public static ArrayList<String> combineChars(ArrayList<String> current, char[] newChars){		
		int len = current.size() * newChars.length;
		ArrayList<String> result = new ArrayList<String>();
		int p = 0;
		for(int i = 0; i < current.size(); i ++){
			for(int j = 0; j < newChars.length; j ++){
				StringBuilder temp = new StringBuilder(current.get(i));
				temp.append(newChars[j]);
				result.add(temp.toString());
				p ++;
			}
		}
		return result;
	}

}
