package String;

import java.util.Hashtable;

public class LongestPalindromicSubstring {
	
	public String longestPalindrome(String s){
		System.out.println(s);
		///abbadc
		Hashtable<Integer, StringBuffer> ht = new Hashtable<Integer, StringBuffer>();
		char[] charArr = s.toCharArray();
		int len = charArr.length;
		
		char[] stack = new char[len / 2 + 1];
		stack[0] = charArr[0];
		int topPointer = 0;
		int i = 1;
		StringBuffer temp = new StringBuffer();
		while(i < len){
			if(charArr[i] != stack[topPointer]){
				System.out.println("[" + charArr[i] + ", " + stack[topPointer] + "]");
				stack[topPointer + 1] = charArr[i];
				topPointer++;
				i++;
				continue;
			} else {
				System.out.println("[" + charArr[i] + ", " + stack[topPointer] + "]");
				temp.append(charArr[i]);
				temp.append(stack[topPointer]);
				topPointer--;
			}
		}
		return temp.toString();
	}
}
