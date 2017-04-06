package InterviewBit;

import java.util.Stack;
/*///http://www.geeksforgeeks.org/largest-rectangle-under-histogram//
//https://www.interviewbit.com/problems/largest-rectangle-in-histogram/
watch this video for understanding
https://www.youtube.com/watch?v=ZmnqCZp9bBs
///https://github.com/mission-peace/interview/blob/master/src/com/interview/stackqueue/MaximumHistogram.java	
Time complexity is O(n)//http://www.programcreek.com/2014/05/leetcode-largest-rectangle-in-histogram-java/
* Space complexity is O(n)*/

public class StacksandQueuesMaxAreaHistogram {

	public static void main(String[] args) {
	        int input[] = {6, 2, 5, 4, 5, 1, 6};
	        int maxArea =maxHistogram(input);
	        System.out.println(maxArea);
	}
	
    public static int maxHistogram(int input[]){
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        int area = 0;
        int i;
        for(i=0; i < input.length;){
            if(stack.isEmpty() || input[stack.peek()] <= input[i]){
                stack.push(i++);
            }else{
                int top = stack.pop();
//if stack is empty means everything till i has to be greater or equal to input[top] so get area by input[top] * i;
                if(stack.isEmpty()){
                    area = input[top] * i;
                }
//if stack is not empty then everythin from i-1 to input.peek() + 1 has to be greater or equal to input[top] so area = input[top]*(i - stack.peek() - 1);
                else{
                    area = input[top] * (i - stack.peek() - 1);
                }
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        while(!stack.isEmpty()){
            int top = stack.pop();
            //if stack is empty means everything till i has to be
            //greater or equal to input[top] so get area by
            //input[top] * i;
            if(stack.isEmpty()){
                area = input[top] * i;
            }
            //if stack is not empty then everything from i-1 to input.peek() + 1
            //has to be greater or equal to input[top]
            //so area = input[top]*(i - stack.peek() - 1);
            else{
                area = input[top] * (i - stack.peek() - 1);
            }
        if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
}
