package situations;

public class segregateZerosAndOnes {

	public static void main(String[] args) {
		int[] a = {0,1,0,1,0,0};
		segregate(a);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
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
}
