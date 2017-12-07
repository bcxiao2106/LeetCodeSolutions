package interview;

public class ClockAngle {

	public static double findSmallerAngle(double h, double m){
		double degree1 = m;//min pointer position on circumference(60)
		double degree2 = h * 5 + (m/60)*5;//hour pointer position on circumference(60)
		double distance = Math.abs(degree1 - degree2);//minimum distance
		if(distance > 30){
			distance = 60 - distance;
		}
		double result = distance / 60 * 360;
		System.out.println(result);
		return result;
	}
	
	public static int findEqualTimes(){
		int count = 0;
		for(int i = 0 ; i < 12; i++){
			for(int j = 0; j < 60; j++){
				double hourPointer = i * 5.0 + j / 60.0 * 5;
				double minPointer = j * 1.0 ;
				hourPointer = Math.round(hourPointer);
				System.out.println(hourPointer + ":" + minPointer);
				if(hourPointer == minPointer){
					System.out.println("2 pointers meet at: "+ i + ":" + j);
					count++;
				}
			}
		}
		return count;
	}
}
