package situations;

public class segregateZerosAndOnes {

	public static void main(String[] args) {
		int[] a = {0,1,0,1,0,0};
		segregate(a);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
		segregate1(a);
		
	}
	
	public static void segregate(int[] a){
		int l = a.length;
		int left = 0; int right = l-1;
		while(left < right){
			
			while(left < right && a[left] == 0) left++;
			
			while(left < right && a[right] == 1) right--;
			
			if(left < right){
				a[left] = 0;
				a[right] = 1;
				left++;right--;
			}
		}		
	}
	//use this
	public static void segregate1(int[] a){
		int l = a.length;
		int left = 0; int right = l-1;
		while(left < right){			
			if(a[left] == 1){
				int temp = a[left];
				a[left] = a[right];
				a[right] = temp;
				right--;
			}else{
				left++;
			}
		}	
		for(int i : a) System.out.print(i+" ");
	}
}
