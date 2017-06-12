import java.util.Stack;

public class getNextGreater {
/*
 * From a given input array, for each element, find next higher element present in each array. 
 * For example {40,50,11,32,55,68,75} output should be {50,55,32,55,68,75,-1}. 
 * For element if no higher element is present, print -1.
 * http://www.geeksforgeeks.org/next-greater-element/
 * https://stackoverflow.com/questions/19720349/find-next-higher-element-in-an-array-for-each-element
 */
	public static void main(String[] args) {
		getNextGreater(new int[]{11, 13, 21, 3});
		getNextHigher(new int[]{11, 13, 21, 3});
	}
	
	//O(n)
	public static void getNextGreater(int[] arr){
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[0]);
		for(int i = 1; i < arr.length; i++){
			if(!stack.isEmpty()){
				while(true){
					if(stack.isEmpty() || stack.peek() > arr[i]){
						break;
					}
					System.out.println(stack.pop() + "->" + arr[i]);
				}
			}
			stack.push(arr[i]);
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop() + "->" + (-1));
		}		
	}
	
	//O(n2)
	public static void getNextHigher(int[] arr){
		for(int i = 0; i < arr.length; i++){
			int next = -1;
			for(int j = i+1; j < arr.length; j++){
				if(arr[i] < arr[j]){
					next = arr[j];
					break;
				}
			}
			System.out.println(arr[i] + "->" + next);
		}
	}
}
