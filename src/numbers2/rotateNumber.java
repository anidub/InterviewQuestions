package numbers2;

public class rotateNumber {

	public static void main(String[] args) {
		int[] num = {1,2,3,4,5};
		int rotate = 66;
		int[] res = rot(num, rotate); // 3 4 5 1 2
		for(int k : res){
			System.out.print(k + " ");
		}
	}
	
	public static int[] rot(int[] num, int rotate){ //1 2 3 4 5 1 2 3 4 5
		int[] temp = new int[num.length * 2];
		rotate = rotate%num.length;
		if(rotate == 0) return num;
		int k = 0;
		for(int i = 0; i < num.length; i++){
			temp[k++] = num[i];
		}
		for(int i = 0; i < num.length; i++){
			temp[k++] = num[i];
		}
		k = num.length-1;
		int[] result = new int[num.length];
		for(int j = temp.length - rotate - 1; j >= 0; j--){
			result[k--] = temp[j];
			if(k < 0) break;
		}
		return result;		
	}
}
