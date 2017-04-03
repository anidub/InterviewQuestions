package situations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class divideMoney {

	public static void main(String[] args) {
		int money = 80;
		int n = 7;
		divideMoney(money, n);
	}

	public static void divideMoney(int money, int n){
		ArrayList<Integer> f = new ArrayList<Integer>();
		if(money % n == 0){
			for(int i = 0; i < n; i++){
				f.add(i, money/n);
			}
		}else if(money % n < n){
			int s = money;
			//money = money + (n - (money % n));
			for(int i = 0; i < n; i++){
				f.add(i, money/n);
			}
			money = s;
			//int random = getRandom(n);
			//f.set(random, (f.get(random) - (n - (money % n))));
			int numbers =  (money % n);//3
		//	int[] r = new int[n - (money % n)]; //3
			Set<Integer> r = new HashSet<Integer>();
			while(r.size() != numbers){
				r.add(getRandom(n));
			}
			Object[] aa = r.toArray();
			for(int i = 0; i < numbers; i++){
				int place = (Integer) aa[i];
				f.set(place, (f.get(place) + 1));
			}
			
		}
		
		int k = money % n;
		System.out.println(k);
		for(int i : f){
			System.out.print(i + " ");
		}
		
	}
	
	public static int getRandom(int n){
		Random rand = new Random();
		int max = n-1;
		int min = 0;
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
		
	}
}
