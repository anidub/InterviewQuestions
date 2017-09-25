package snippet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Snippet {
	
	static int m = 3;
	static int n  = 3;
	static boolean[][] visited = new boolean[3][3];
	static int currentArea = 0;
	static int maxarea = 0;
	
	public static int calMax(int[][] matrix){
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				currentArea = 0;
				cal(matrix,i,j);
				if(currentArea > maxarea) maxarea = currentArea;
			}
		}
		return maxarea;
	}
	public static void cal(int[][] mat, int i, int j){
		 if(i<0 || j<0 || i>=m || j>=n) return;
		if(visited[i][j] == true) return;
		if(mat[i][j] == 0){
			visited[i][j] = false;
			return;
		}
		currentArea++;
		mat[i][j] = 0;
		cal(mat, i+1, j);
		cal(mat, i, j+1);
		cal(mat, i-1, j);
		cal(mat, i, j-1);
	}
	
	
	public static void main(String[] args) {
		int arr1[][]={ 	   {1,0,0,0},
							{1,0,1,1},
							{1,1,0,1},
							{0,0,0,1} } ;
		calMax(arr1);
		System.out.println("maxarea : " + maxarea);
		
		System.out.println();
		String s = "AZQF013452BAB";
	//	System.out.println(sortSegments(s));
		ArrayList<String> arr = new ArrayList<String>();
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			arr.add(c+"");
		}
		
		Collections.sort(arr);
		String res = null;
		for(int i = 0; i < arr.size(); i++){
			res += arr.get(i);
		}
		System.out.println(res);
		
		int a = 4; int b = 0;
		int c = -1;
		try{			
			c = a/b;
		}
			catch(Exception e){
				System.out.println("ex");
			}
			finally{
				System.out.println("fina");
			}
		}
		
		
		//int[] arr = {1,1,2,1,2,2};
		//System.out.println(degreeOfArray(arr));
	//}
	
	 static int degreeOfArray(int[] arr) {
	        if(arr == null || arr.length == 0) return -1;
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for(int i : arr){
	           if(map.containsKey(i)){
	               map.put(i, map.get(i)+1);
	           }else{
	               map.put(i,1);
	           }
	        }
	        int max = Collections.max(map.values());
	        int min = Integer.MAX_VALUE;
	        ArrayList<Integer> lengths = new ArrayList<Integer>();
	        for(int i = 0; i < arr.length; i++){
	            int count = 0;
	            int k = arr[i];
	            int index = i;
	            while(index < arr.length && count != max){
	                if(k == arr[index]) 
	                    count++;
	                index++;
	            }
	            if(count == max) {
	            	min = Math.min(min, index-i);
	            }
	        }
	        Collections.sort(lengths);
	        //return lengths.get(0);
	        return min;
	        //return max;

	    }
	
	 
	 static String sortSegments(String s) {
	        String result = new String();
	        StringBuilder sb = new StringBuilder();
	        String temp = null;
	        for(int i = 0; i < s.length(); i++){
	            char c = s.charAt(i);
	            if(Character.isDigit(c)){  
	                int start = i;
	                i++;
	                while(i < s.length() && Character.isDigit(s.charAt(i))){
	                    i++;
	                }
	                
	                int end = i-1;
	                temp = s.substring(start, end+1);
	                char[] charArr = temp.toCharArray();
	                Arrays.sort(charArr);
	                sb.append(charArr);
	                i = i-1;
	            }else{
	                int start = i;
	                i++;
	                while(i < s.length() && !Character.isDigit(s.charAt(i))){
	                    i++;
	                }
	                int end = i-1;
	                /*temp = s.substring(start, end+1);
	                char[] charArr = temp.toCharArray();
	                Arrays.sort(charArr);
	                sb.append(charArr);*/
	                sortSub(sb,start, end,)
	                i = i-1;
	            }
	            
	        }
	        result = sb.toString();
	        return result; 
	        
	    }
	 
	 public StringBuilder sortSub(StringBuilder sb, String s,int start, int end){
		 String temp = s.substring(start, end+1);
         char[] charArr = temp.toCharArray();
         Arrays.sort(charArr);
         sb.append(charArr);
         return sb;
         
	 }
	
}

