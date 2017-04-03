package numbers;

import java.util.PriorityQueue;

public class mergesortedarrays {
//merge sorted arrays using merge sort : time complexity : nklognk....n = number of arrays, k is size
	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		int[] b = {2,3,4,5};
		int[] c = {2,3,4};
		int[] d = {6,7,8};
		//int[] result = merge(a,b,c,d);
		int[] result = mergeNsortedarrays(new int[][] {a,b,c,d});
		display(result);

	}
	
	public static int[] merge(int[] a, int[] b, int[] c, int[] d){
		int l1 = a.length;
		int l2 = b.length;
		int l3 = c.length;
		int l4 = d.length;
		if(l1 == 0) return b; 
		if(l2 == 0) return a;
		
		int[] result = new int[l1 + l2 + l3 + l4];
		
		int i = 0, j = 0, k = 0;
		
		/*while(i < l1 && j < l2){
			if(a[i] < b[j]){
				result[k++] = a[i++];
			}else{
				result[k++] = b[j++];
			}
		}
		
		if(i < l1){
			result[k++] = a[i++];
		}
		if(j < l2){
			result[k++] = b[j++];
		}
		*/
		
	int[] res = new int[l1 + l2 + l3 + l4];
	int count = 0;
	for(i = 0; i < l1; i++){
		res[i] = a[i];
		count++;
		}
	 for(j = 0; j < l2; j++){
		 res[count++] = b[j];
	 }
	int m = 0, n = 0;
	 for(m = 0; m < l3; m++){
		 res[count++] = c[m];
	 }
	 
	 for(n = 0; n < l4; n++){
		 res[count++] = d[n];
	 }

	 	int[] result1 = mergesort(res,0,res.length);
	 
	 return res;
		//return result;		
		}
	
	public static void display(int[] result){
		for(int i = 0; i < result.length; i++){
			System.out.print(result[i] + " ");
		}
	}
	
	public static int[] mergesort(int[] array, int lowindex, int highindex){
		int length = array.length;
		if(length < 1) return array;
		int low = 0;
		int high = length;
		
		int middle = low + (high - low)/2;
		mergesort(array,low,middle);
		mergesort(array,middle + 1, high);
		
		int[] result = mergeparts(array, low, middle, high);
		
		return result;
	}
	
	public static int[] mergeparts(int[] array, int lowindex,int midindex, int highindex){
		int i = lowindex, j = midindex+1, k = highindex;
		int[] result = new int[array.length];
			while(i < midindex && j < highindex){
			if(array[i] < array[j]){
				result[k++] = array[i++];
			}else{
				result[k++] = array[j++];
			}
		}
			while(j <= highindex){
				result[k++] = array[j++];
			}
			while(i <= midindex){
				result[k++] = array[i++];
			}
			return result;
	}
	
	
	// using heap time complexity : nklogk... n is number of arrays, k is size

	private static class ArrayContainer implements Comparable<ArrayContainer>{
		private int startindex;
		private int[] array;
		
		public ArrayContainer(int[] array){
			this.array = array;
			startindex = 0;  
		}
		
		public boolean isEmpty(){
			return startindex == array.length;
		}
		
		public int peek(){
			return array[startindex];
		}
		
		public int getNextInt(){
			return array[startindex++];
		}
		
		public int compareTo(ArrayContainer o) {
			
			return (new Integer(peek()).compareTo(o.peek()));
		}
		
	}
	
	public static int[] mergeNsortedarrays(int[][] sortedarrays){
		int totallength = 0;
		PriorityQueue<ArrayContainer> heap = new PriorityQueue<ArrayContainer>();
		
		for(int i = 0; i < sortedarrays.length; i++){
			totallength += sortedarrays[i].length;
			heap.add(new ArrayContainer(sortedarrays[i]));
		}
		
		int[] result = new int[totallength];
		int index = 0;
		
		while(!heap.isEmpty()){
			ArrayContainer arraycontainer = heap.poll();
			result[index++] = arraycontainer.getNextInt();
			if(arraycontainer.isEmpty()) continue;
			heap.add(arraycontainer);
		}
		return result;
	}
}
