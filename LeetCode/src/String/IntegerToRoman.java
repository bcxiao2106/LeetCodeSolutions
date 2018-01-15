package String;

import java.util.Hashtable;

public class IntegerToRoman {
	public String intToRoman(int num) {
        if(num <= 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int min = 1;
        int max = min * 10  - 1;
        while(num > max){
            min = min * 10;
            max = min * 10 - 1;
        }
        int digitNum = (int)Math.log10(min) + 1;
        
        Hashtable<Integer, Character> ht = new Hashtable<Integer, Character>();
        ht.put(1, 'I');
        ht.put(5, 'V');
        ht.put(10, 'X');
        ht.put(50, 'L');
        ht.put(100, 'C');
        ht.put(500, 'D');
        ht.put(1000, 'M');
        
        int restNum = num;
        for(int i = digitNum; i > 0; i --){
            int times = (int)Math.pow(10, i - 1);
            int currentDigit = restNum / times;
            int lower = times;
            int mid = 5 * times;
            int higher = 10 * times;
            if(currentDigit >= 1 && currentDigit < 4){
                for(int j = 0; j < currentDigit; j++){
                	sb.append(ht.get(lower));
                }
            } else if(currentDigit >= 4 && currentDigit < 5){
                sb.append(ht.get(lower));
                sb.append(ht.get(mid));
            } else if(currentDigit == 5){
            	sb.append(ht.get(mid));
            } else if(currentDigit > 5 && currentDigit < 9){
            	sb.append(ht.get(mid));
            	for(int j = 0; j < currentDigit - 5; j++){
                	sb.append(ht.get(lower));
                }
            } else if(currentDigit == 9){
            	sb.append(ht.get(lower));
                sb.append(ht.get(higher));
            }
            restNum = restNum - currentDigit * times;
        }
        
        return sb.toString();
    }
}
