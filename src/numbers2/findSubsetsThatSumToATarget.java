package numbers2;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
//Given a set of numbers: {1, 3, 2, 5, 4, 9}, find the number of subsets that sum to a particular value (say, 9 for this example).
//This is a classical Back tracking problem for finding all possible subsets of the integer array or set that is the input and then filtering those which sum to e given target
//Time complexity of the above solution is O(sum*n).
//https://stackoverflow.com/questions/18305843/find-all-subsets-that-sum-to-a-particular-value
public class findSubsetsThatSumToATarget {

	 /**
     * The collection for storing the unique sets that sum to a target.
     */
    private static Set<String> allSubsets = new HashSet<String>();

    /**
     * The String token
     */
    private static final String token = " ";

    /**
     * The method for finding the subsets that sum to a target.
     *
     * @param input  The input array to be processed for subset with particular sum
     * @param target The target sum we are looking for
     * @param ramp   The Temporary String to be beefed up during recursive iterations(By default value an empty String)
     * @param index  The index used to traverse the array during recursive calls
     */
    public static void findTargetSumSubsets(int[] input, int target, String ramp, int index) {
        if(index > (input.length - 1)) {
            if(getSum(ramp) == target) {
                allSubsets.add(ramp);
            }
            return;
        }
        //First recursive call going ahead selecting the int at the currenct index value
        findTargetSumSubsets(input, target, ramp + input[index] + token, index + 1);
        //Second recursive call going ahead WITHOUT selecting the int at the currenct index value
        findTargetSumSubsets(input, target, ramp, index + 1);
    }

    // A helper Method for calculating the sum from a string of integers    
    //String tokenizer allows you to break string into tokens
    private static int getSum(String intString) {
        int sum = 0;
        StringTokenizer sTokens = new StringTokenizer(intString, token);
        while (sTokens.hasMoreElements()) {
            sum += Integer.parseInt((String) sTokens.nextElement());
        }
        return sum;
    }
   
    public static void main(String[] args) {
        int [] n =  {24, 1, 15, 3, 4, 15, 3};
        int counter = 1;        
        findSubsetsThatSumToATarget.findTargetSumSubsets(n, 25, "", 0);
        for (String str: allSubsets) {
            System.out.println(counter + ") " + str);
            counter++;
        }
    }   
}
