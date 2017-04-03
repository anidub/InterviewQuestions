package numbers;

public class mergesort {
	private  int[] result;
	private   int[] temp;
	private int length;
	
	public static void main(String[] args) {
		mergesort ms = new mergesort();
		int[] array = {1,2,3,1,1,5,2,2};
		ms.display(array);
		ms.sort(array);
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		//doMerge(0,array.length);
	}
	
	public  void sort(int[] array){
		this.result = array;
		this.length = array.length;
		this.temp = new int[length];
		doMerge(0, array.length - 1);
	}
	
	public  void doMerge(int lowindex, int highindex){
	
		if(lowindex < highindex){
			int middleindex = lowindex + (highindex - lowindex) /2;
			doMerge(lowindex,middleindex);
			doMerge(middleindex + 1, highindex);
			mergeparts(lowindex,middleindex,highindex);
		}
		
 	}
	
	public void mergeparts(int low, int middle, int high){
		int i = low;
		int j = middle + 1;
		int k = high;
		int m = 0;
		for(i =low; i <= high; i++){
			temp[i] = result[i];
		}
	
		while(i <= middle &&  j <= high){
			if(temp[i] < temp[j]){
				result[m++] = temp[i++];
			}else
				result[m++] = temp[j++];
		}
		while(i <= middle){
			result[m++] = temp[i++];
		}
		while(j <= high){
			result[m++] = temp[j++];
		}
	}
	
	public void display(int[] array){
			
		for(int i =0; i <array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
