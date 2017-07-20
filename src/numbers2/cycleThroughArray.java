package numbers2;

public class cycleThroughArray {
/*
 * https://www.careercup.com/question?id=5720449532035072
 * https://stackoverflow.com/questions/40623412/circular-array-loop-detection
 * You are given an array of positive and negative integers.
 *  If a number n at an index is positive, then move forward n steps.
 *   Conversely, if it's negative, move backward n steps. Determine if there is a loop in this array.
 *   int[] loop = {2, -1, 1, 2, 2}; : true
    int[] noloop = {-1, 2}; : false
    Soln : The idea is to use it in similar to way we use to detect loop in linkedlist
    fastpointer : runs twice
    slowpointer : runs once
    if( begining position or slow == fast ): true
 */
	public static void main(String[] args) {
		int[] array = {2,-1,1,2,2};
		System.out.println(isCycleThroughLoop(0, array));
	}
	
	public static boolean isCycleThroughLoop(int start, int[] array){
		int slowIndex = start;
		int fastIndex = start;
		do{
			fastIndex = getNextInt(array, getNextInt(array,fastIndex)); // trying to run the fast pointer twice
			slowIndex =getNextInt(array, slowIndex);//running the slow pointer once
			if(slowIndex == start || fastIndex == slowIndex){
				return true;
			}
		}while(slowIndex != fastIndex);		
		return false;
	}
	
	public static int getNextInt(int[] array, int index){
		index += array[index];
		return index % array.length;
	}
}
