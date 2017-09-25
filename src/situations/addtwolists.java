package situations;

import java.util.ArrayList;

public class addtwolists {
	
	//adding two positive number in a arraylist....THIS EXCLUDES NEGATIVE NUMBERS;
	//O(n)

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		a.add(1);a.add(2);a.add(9);
		//a.add(9);a.add(9);a.add(9);a.add(9);
		//b.add(9); b.add(9);b.add(9);
		b.add(2);b.add(3);b.add(9);b.add(2);
		addTwoArrayLists(a,b);
		for(int k : a){
			System.out.print(k);
		}
		System.out.println();
		for(int k : b){
			System.out.print(k);
		}
		System.out.println();
		ArrayList<Integer> c = add(a,b);
	}
	
	public static ArrayList<Integer> add(ArrayList<Integer> a, ArrayList<Integer> b){
	//	THIS EXCLUDES NEGATIVE NUMBERS;
		int n = 0;
		int l1 = a.size();
		int l2 = b.size();
		if(l1 != l2){
			if(l1 > l2){
				int diff = l1 - l2;
				while(diff > 0){
					b.add(0,0);
					diff--;
				}
			}else{
				int diff = l2 - l1;
				while(diff > 0){
					a.add(0,0);
					diff--;
				}
			}
		}
		int l = a.size();
		ArrayList<Integer> aa = new ArrayList<Integer>(l+1);
		for(int i = 0; i < l+1; i++) aa.add(0);
		int[] numarray = new int[l+1];
		
		int carry = 0;
		int sum = 0;
		int k = l;
		for(int i = l - 1; i >= 0; i--){
			int num1 = a.get(i);
			int num2 = b.get(i);
			sum = num1 + num2 + carry;
			carry = 0;
			if(sum > 9){
				carry = 1;
			}
			
			aa.set(k,sum%10);
			k--;
				numarray[i+1] = sum % 10;
		}
		
		if(carry == 1){	
			numarray[0] = 1;
			aa.set(0,1);
		}else{
			numarray[0] = 0;
			aa.set(0,0);
		}
		for(int o : aa){
			System.out.print(o);
		}
		System.out.println();
		for(int x = 0; x < numarray.length; x++){
			System.out.print(numarray[x]);
		}
		//IT STORES RESULT IN BOTH ARRAY AND ARRAYLIST
		//THIS EXCLUDES NEGATIVE NUMBERS;
		return aa;		
	}
	
	//use this//better
	public static ArrayList<Integer> addTwoArrayLists(ArrayList<Integer> a1, ArrayList<Integer> a2){
		int l1 = a1.size(); int l2 = a2.size();
		
		if(l1 > l2){
			int diff = l1-l2;
			while(diff > 0){
				a2.add(0, 0);
				diff--;
			}
		}else if(l2 > l1){
			int diff = l2-l1;
			while(diff > 0){
				a1.add(0,0);
				diff--;
			}
		}
		int sum = 0; int carry = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = a1.size() - 1; i >= 0; i--){
			int n1 = a1.get(i); 
			int n2 = a2.get(i);
			sum = n1 + n2 + carry;
			carry = 0;
			if(sum > 9){
				carry = 1;
			}
			result.add(0,sum % 10);
		}		
		return result;
		
	}
}
