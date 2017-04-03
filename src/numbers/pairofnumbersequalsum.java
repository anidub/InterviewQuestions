package numbers;

import java.util.HashMap;
import java.util.Map;

public class pairofnumbersequalsum {

	public static void main(String[] args) {
	int[] num = {1,2,3,4,0};
	int k = 4;
	Map<Integer,Integer> pairs = new HashMap<Integer,Integer>();
	for(int i = 0; i < num.length; i++){
		if(pairs.containsKey(num[i])){
			System.out.println(num[i] + " , " + pairs.get(num[i]));
		}
		else{
			pairs.put(k-num[i], num[i]);
		}
	}

	}

}
