import java.util.ArrayList;
import java.util.Stack;

public class PayrollSystem {
	    private static PayrollSystem payrollSystem = new PayrollSystem();

	    private PayrollSystem(){
	    }

	    public static PayrollSystem getInstance(){
	        return payrollSystem;
	    }
	
        
	public static void main(String[] args) {

		String s = "20+2*3";
		//System.out.println(calculate(s));
		
		//System.out.println(getNumberOfHorses("neighneigh"));
		int[] arr = {1,2,3,4,5,6,7};
		get_odd_numbers(arr);

	}
	
	public static ArrayList<Integer> get_odd_numbers(int[] array){
		  ArrayList<Integer> result = new ArrayList<Integer>();
		  if(array == null || array.length == 0){
		    return result;
		  }
		  for(int i = 0; i < array.length; i++){
		    if(array[i] % 2 == 1){
		      result.add(array[i]);
		    }
		  }
		  return result;
		}
	
	  public static Integer calculate(String input){
		    if(input == null || input.length() == 0)
		      return null;
		    Integer result = 0;
		    Stack<Integer> stack = new Stack<Integer>();
		    Integer num = null;
		    for(int i = 0; i < input.length(); i++){
		      char c = input.charAt(i);
		      if(c == '*'){
		         if(!stack.isEmpty()){
		        	 int endIndex = getNumber(input, i+1);
				     num = Integer.parseInt(input.substring(i+1, endIndex));
				     i = endIndex-1;
		             stack.push(stack.pop() * num);
		             num = null;
		          }       
		      }
		      else if(c != '*' && c != '+'){
		        int endIndex = getNumber(input, i+1);
		        num = Integer.parseInt(input.substring(i, endIndex));
		        i = endIndex-1;
		        stack.push(num);
		      }else if(c == '+'){
		    	  continue;
		      }
		    }
		    while(!stack.isEmpty()){
		      result += stack.pop();
		    }
		    return result;

		  }
		  
		  public static int getNumber(String input, int i){
		    while(i < input.length() && (input.charAt(i) != '*' && input.charAt(i) != '+')){
		      i++;
		    }
		    return i;
		  }
		  
/*	public String getNumberOfHorses(String input) {
		if (input == null || input.length() == 0)
			return "Invalid";
		HashSet<String> allPerms = getAllPermutations("neigh");
		Integer result = 0;
		Integer temp = 0;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == 'n') {
				int endIndex = i + 5;
				String s = input.substring(i, endIndex);
				if (allPerms.contains(c)) {
					temp++;
					i = endIndex;
				}
			}
		}

	}*/
		  
	  public static String getNumberOfHorses(String input){
		  if (input == null || input.length() == 0)
		      return "Invalid";
		    String neigh = "neigh";
		    Integer result = 0;
		    Integer temp = 0;
		    for (int i = 0; i < input.length(); i++) {
		      char c = input.charAt(i);
		      if (i > 0 && input.charAt(i-1) != 'h' && c == 'n') {
		        int endIndex = i + 5;
		        String s = input.substring(i, endIndex);
		        if(s.equals(neigh)){
		          result++;
		          i = endIndex-1;
		        }
		      }else if(c == 'i'){
		        if(input.charAt(i+1) == 'g'){
		          result++;
		        }
		      }
		    } 
		    return  String.valueOf(result);
		    
		  }
}





