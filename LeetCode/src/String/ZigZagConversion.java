package String;

public class ZigZagConversion {
	public static String convert(String s, int numRows) {
		if(s.length() <= numRows || s.equals("") || s == null || numRows < 2){
            return s;
        }
		StringBuilder sb = new StringBuilder();
        int numCols = (int) (s.length() * 1.0 / (numRows + numRows - 2) * numRows);
        char[][] zigZagArr = new char[numRows][numCols];
        int i = 0, j  = 0;
        boolean downward = true;
        for(int k = 0; k < s.length(); k ++){
        	char temp = s.charAt(k);
            if(downward && i < numRows && j <= numCols){
                zigZagArr[i][j] = temp;
                if(i == numRows - 1){
                	downward = false;
                } else {
                	i++;
                }
                continue;
            }
            if(!downward && i >= 0 && j <= numCols){
            	i --; j ++;
            	//System.out.println("Current [i,j]: " + i + ", " + j);
                zigZagArr[i][j] = temp;
                if(i == 0){
                    downward = true;
                    i ++;
                } 
                continue;
            }
        }
        
        for(int x = 0; x < numRows; x ++){
        	for(int y = 0; y < numCols; y ++){
        		char temp = zigZagArr[x][y];
        		if(temp != '\u0000')
            		sb.append(temp);
        	}
        }
        
        return sb.toString();
    }
}
