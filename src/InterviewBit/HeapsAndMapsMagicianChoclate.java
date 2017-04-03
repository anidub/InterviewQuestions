package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapsAndMapsMagicianChoclate {

	public static class StringComparator implements Comparator<String>{
		public int compare(String x, String y){
			if(x.length() < y.length()) return 1;
			if(x.length() > y.length()) return -1;
			return 0;
		}
	}
	
	public static void main(String[] args) {
		int time = 3;
		ArrayList<Integer> choclates = new ArrayList<Integer>();
		choclates.add(6);choclates.add(5);
		//System.out.println(nchoc(time, choclates));
		
		Comparator<String> comparator = new StringComparator();
		PriorityQueue<String> pq = new PriorityQueue<String>(comparator);
		pq.add("Hello");
		pq.add("Amazon");
		pq.add("Allahabad");
		 while (pq.size() != 0)
	        {
	            System.out.println(pq.remove());
	        }	

	}
	//not working
	static long  mod = 1000000007;
	public static int nchoc(int time, ArrayList<Integer> choclates) {
		int N = choclates.size();
		int K = time;
		long ans = 0;
		Collections.reverse(choclates);
		for(int i = 0; i < choclates.size(); i++){
			pq.add(choclates.get(i));
		}
		//priority_queue<Integer> heap(B.begin(),B.end());
		while(K > 0){
			long max_elem = pq.peek();
			ans += max_elem;
			ans = ans % mod;
			pq.poll();
			pq.add((int)(max_elem/2));
			K--;
		}   
		return (int) ans;
	}
	
	
}

