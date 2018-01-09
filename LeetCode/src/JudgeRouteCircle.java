
public class JudgeRouteCircle {

	public boolean judgeCircle(String moves) {
		int[] stack = {0, 0, 0, 0};
        for(int i = 0; i < moves.length(); i++){
        	//[Command : idx] R:0; L:1; U:2; D:3
        	switch(moves.charAt(i)){
        	case 'R':
        		stack[0] = stack[0] + 1;
        		break;
        	case 'L':
        		stack[1] = stack[1] + 1;
        		break;
        	case 'U':
        		stack[2] = stack[2] + 1;
        		break;
        	case 'D':
        		stack[3] = stack[3] + 1;
        		break;
        	}
        }
        //check if the 'U' count == 'D' count and 'R' count  == 'L' count
        boolean result = (stack[0] == stack[1]) && (stack[2] == stack[3]);
        
        return result;
    }
}
