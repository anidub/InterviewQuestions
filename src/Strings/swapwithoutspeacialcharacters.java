package Strings;

public class swapwithoutspeacialcharacters {

	public static void main(String[] args) {
		String str1 = "a!!!b.c.d,e'f,ghi";
		char[] str = str1.toCharArray();
		System.out.print("input : ");
		for(int i = 0; i < str.length;i++){
			System.out.print(str[i]);
		}
 		reverse(str);
 		System.out.println();
 		System.out.print("output : ");
		for(int i = 0; i < str.length;i++){
			System.out.print(str[i]);
		}
		
	}
	
	public static void reverse(char[] str){
		int left = 0;
		int right = str.length - 1;
		
		while(left < right){
			if(!((str[left]>='A' && str[left]<='Z') || (str[left]>='a' && str[left]<='z'))){
				left++;
			}else if(!((str[right]>='A' && str[right]<='Z') || (str[right]>='a' && str[right]<='z'))){
				right--;
			}else{
				char temp = str[right];
				str[right] = str[left];
				str[left] = temp;
				left++;
				right--; 
			}
	}
	}
}
