package String;

public class RomanToInteger {
	public int romanToInt(String s) {
        if(s == null || s.equals("") || s.length() == 0){
            return 0;
        }
        
        char[] rcValueArr = new char[128];
        rcValueArr['I'] = 1;
        rcValueArr['V'] = 5;
        rcValueArr['X'] = 10;
        rcValueArr['L'] = 50;
        rcValueArr['C'] = 100;
        rcValueArr['D'] = 500;
        rcValueArr['M'] = 1000;

        int result = 0;
        int i = 0;
        for(i = 0; i < s.length() - 1; i++){
            char romanChar = s.charAt(i);
            char romanCharNext = s.charAt(i + 1);
            int value = rcValueArr[romanChar];
            int valueNext = rcValueArr[romanCharNext];
            if(value < valueNext){
                result += valueNext - value;
                i++;
            } else {
                result += value;
            }
        }
        if(i == s.length() - 1){
            result += rcValueArr[s.charAt(s.length() - 1)];
        }
        return result;
    }
}
