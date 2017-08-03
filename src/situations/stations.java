package situations;

public class stations {
	//Find the minimum cost to reach destination using a train

///	There are N stations on route of a train. The train goes from station 0 to N-1. 
	//The ticket cost for all pair of stations (i, j) is given where j is greater than i. Find the minimum cost to reach the destination.
	//http://www.geeksforgeeks.org/find-the-minimum-cost-to-reach-a-destination-where-every-station-is-connected-in-one-direction/
	
	public static int N = 4;
	public static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) {
		int[][] cost = {{0, 15,80,90},
						{INF,0,40,50,},
						{INF,INF,0,70},
						{INF,INF,INF,0}};
		
		System.out.println("The min cost to reach dest is : "  + mincost(cost));
	
	}
	
	public static int mincost(int[][] cost){
		int[] dest = new int[N];
		for(int i = 0; i < N; i++){
			dest[i] = INF;
		}
		dest[0] = 0;
		
		for(int i = 0; i< N; i++){
			for(int j = i + 1; j < N; j++){
				if(dest[j] > dest[i] + cost[i][j]){
					dest[j] = dest[i] +  cost[i][j];
					}
				}
			}
		return dest[N-1];
	}
}
