import java.util.ArrayList;
import java.util.Collections;

public class Qualia {

	public static void main(String[] args) {
		ArrayList<Double> nums =  new ArrayList<Double>();
		for (int i=0; i < 100; i++) {
		  nums.add((Math.floor(Math.random() * 1000)/1000 + Math.floor(Math.random() * 1000)));
		}
		ArrayList<Integer> temp =  new ArrayList<Integer>();
		for(int i = 0; i < 100; i++){
			Double n = nums.get(i);
			System.out.println(n.intValue());
			System.out.println(n - n.intValue());
			Double absoluteValue = Math.floor((n - n.intValue()) * 1000);
			temp.add(absoluteValue.intValue());
		}
		Collections.sort(temp);	
	}

}
