package Strings;

import java.util.HashSet;
import java.util.Set;

public class Stringpermutations {

	/*public static void main(String[] args) {
		String s = "ABC";
		String s1 = "AAC";
		//System.out.println("\nPermutations for " + s + " are: \n" + permutation(s));
		//System.out.println("\nPermutations for " + s1 + " are: \n" + permutation(s1));
		//recursionpermutation("", s);
		combString(s);

	}*/
			public static Set<String> permutation(String str){
				Set<String> words = new HashSet<String>();
				if(str == null){
					return null;
				}else if(str.length() == 0){
					words.add("");
					return words;
				}
				
				char initial = str.charAt(0);
				String rem = str.substring(1);
				Set<String> letter = permutation(rem);
				for(String StrNew : letter){
					for(int i = 0; i <= StrNew.length(); i++){
						words.add(charinsert(StrNew, initial, i));
					}
				}
				return words;
				
			}
			
			public static String charinsert(String s, char c, int j){
				String begin = s.substring(0,j);
				String end = s.substring(j);
				return begin + c + end;
			}
			
			
			//by recursion
			public static void recursionpermutation(String prefix, String str){
				int n = str.length();
				if(n <= 1) System.out.println(prefix + str);
				for(int i = 0; i < n; i++){
					recursionpermutation(prefix + str.charAt(i) , str.substring(0,i) + str.substring(i+1,n));
				}
			}			
			
			//iterative works
			public static void combString(String s) {
			    // Print initial string, as only the alterations will be printed later
			    System.out.println(s);   
			    char[] a = s.toCharArray();
			    int n = a.length;
			    int[] p = new int[n];  // Weight index control array initially all zeros. Of course, same size of the char array.
			    int i = 1; //Upper bound index. i.e: if string is "abc" then index i could be at "c"
			    while (i < n) {
			        if (p[i] < i) { //if the weight index is bigger or the same it means that we have already switched between these i,j (one iteration before).
			            int j = ((i % 2) == 0) ? 0 : p[i];//Lower bound index. i.e: if string is "abc" then j index will always be 0.
			            swap(a, i, j);
			            // Print current
			            System.out.println(join(a));
			            p[i]++; //Adding 1 to the specific weight that relates to the char array.
			            i = 1; //if i was 2 (for example), after the swap we now need to swap for i=1
			        }
			        else { 
			            p[i] = 0;//Weight index will be zero because one iteration before, it was 1 (for example) to indicate that char array a[i] swapped.
			            i++;//i index will have the option to go forward in the char array for "longer swaps"
			        }
			    }
			}

			private static String join(char[] a) {
			    StringBuilder builder = new StringBuilder();
			    builder.append(a);
			    return builder.toString();
			}

			private static void swap(char[] a, int i, int j) {
			    char temp = a[i];
			    a[i] = a[j];
			    a[j] = temp;
			}
			
		//works !!	https://www.quora.com/How-do-I-write-permutation-of-a-string-in-Java
		    public static HashSet<String> getAllPermutations(String str) {
		        // Create a hash set to prevent any duplicate entries
		        HashSet<String> permutations = new HashSet<String>();
		         
		        if(str == null || str.length() == 0) {
		            permutations.add("");
		            return permutations;
		        }
		         
		        char first = str.charAt(0);
		        String remainingString = str.substring(1);
		        HashSet<String> words = getAllPermutations(remainingString);
		        for(String word: words) {
		            for(int i = 0; i <= word.length(); i++) {
		                String prefix = word.substring(0, i);
		                String suffix = word.substring(i);
		                permutations.add(prefix + first + suffix);
		            }
		        }
		        return permutations;
		    }
		     
		    public static void main(String[] args) {
		        String str = "abc";
		        HashSet<String> permutations = getAllPermutations(str);
		        System.out.println(permutations.toString());
		    }
}
