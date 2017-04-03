package geometry;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


class node {
	int r,c,idx;
	
	
	
};

public class practise implements Comparator<node> {
	
		final int bar = 100000;
		 node A[] = new node[bar];
	
	
	int modify_BS(int tr, int n){
		int start=0,end=n;
		int mid = (start+end)/2;
	 
		while(start <= end){
			if(A[mid].r >= tr && A[mid-1].r < tr ) return mid;
			else if(tr > A[mid].r) start = mid+1;
			else end = mid-1;
	 
			mid = (start+end)/2;
		}
		return -1;
	}
	 
	int find_min_cost_idx(int idx,int n){
	 
		int ans = idx;
		for(int j=idx+1;j<n;j++){
	 
			if(A[j].c == A[ans].c){
				if(A[j].r ==  A[ans].r) {
					if(A[ans].idx > A[j].idx) ans = j; 
				}
				if(A[j].r > A[ans].r) ans=j;
			}
	 
			else if(A[j].c < A[ans].c) { 
				ans = j;
			}
	 
	 
		}
		return ans;
	}

	public static void main(String[] args) {
		/*
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of window ");
		
		int numberofwindow  = scanner.nextInt(); 
		System.out.println("Enter the tickets to be sold ");
        int ticketstobesold = scanner.nextInt();
        int[] ticketprice = new int[numberofwindow];
        ticketprice[0] = 2;
        ticketprice[1] = 5;
        
        int sum = 0 ;
      
        for(int i = 0; i < numberofwindow; i++){
        	  System.out.println("Enter the tickets remaining at window : " + (i+ 1));
        	ticketprice[i] = scanner.nextInt();
        }
        
        
        for(int i = 0; i < ticketstobesold; i++){
        Arrays.sort(ticketprice);
        
        
        sum = sum + ticketprice[numberofwindow - 1];
        
        ticketprice[numberofwindow - 1] = ticketprice[numberofwindow - 1] - 1;
        
        }
        
        System.out.println("The maximum profit is : " + sum);*/
		
		
		
		int n = 5, d = 8;
		int[] radius = new int[n];
		int[] cost = new int[n];
		practise p = new practise();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter radius ");
		for(int i = 0; i < n; i++){
			p.A[i] = new node();
		}
		for(int i = 0; i < n; i++){
			p.A[i].r = scanner.nextInt();
		
		}
		System.out.println("Enter cost ");
		
		for(int i = 0; i < n; i++){
			p.A[i].c = scanner.nextInt();
		
		}
		int[] output = new int[n];
		int mincost = 0;
		
		int[] outputradius = new int[n];
		int[] outputcost = new int[n];
		int[] T = new int[n];
		
		/*for(int i = 0; i < n; i++){
			mincost = -1;
			for(int j = 0; j < n ; j++){
				
				if(radius[i] + radius[j] >= d){
					
					if((mincost == -1) || (cost[i] + cost[j] <= mincost)){
						if(cost[i] + cost[j] == mincost) {
							if((radius[i] + radius[output[i] - 1]) > (radius[i] + radius[j])){
								break;
							}
						}
						mincost = cost[i] + cost[j];
						
					output[i] = j + 1;
					System.out.println(mincost);
					System.out.println("i : " + i + " radius  : " + radius[i] + " cost : " + cost[i]);
					System.out.println("j : " + j + " radius  : " + radius[j] + " cost : " + cost[j]);
					}
					
				
				}
				
				
			}
		}*/
	
		Arrays.sort(p.A);
		for(int i=0;i<n;i++){
			int tr = d-p.A[i].r;
			if(tr < 0) {T[p.A[i].idx] = 0; continue; }
			//printf("tr = %d\n",tr);
	 
			int ridx = p.modify_BS(tr,n);
			//printf("ridx = %d\n",ridx);
			if(ridx != -1){
				int mincostidx = p.find_min_cost_idx(ridx,n);
			//	printf("mincostidx = %d\n",mincostidx);
				T[p.A[i].idx] = p.A[mincostidx].idx;
			}
	 
	 
		}
		
		for(int i = 0; i < n; i++){
			System.out.println(output[i]);
		}

	}

	public int compare(node o1, node o2) {
		if(o1.r < o2.r) return 1;
		return 0;

		
	}

}
