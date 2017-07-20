package Strings2;

public class BigStringPermOfSmallStrings {
	/*
	 * https://www.careercup.com/question?id=5152821373566976
	 * A list of words is given and a bigger string given how can we find whether the string is a permutation of the smaller strings. 
eg- s= badactorgoodacting dict[]={'actor','bad','act','good'] FALSE 
eg- s= badactorgoodacting dict[]={'actor','bad','acting','good'] TRUE 
The smaller words themselves don't need to be permuted. The question is whether we can find a ordering of the smaller strings such that if concatenated in that order it gives the larger string 
One more constraint - some words from dict[] may also be left over unused
Soln : Just use a boolean array to keep track of what is used in dict.
	 */

	public static void main(String[] args) {
		String[] arr = {"good", "actor","bad","acting"};
		String word = "goodbadactoracting";
		System.out.println(isPermOfDic(word, arr));
	}

	public static boolean isPermOfDic(String word, String[] dict){
		boolean[] visited = new boolean[dict.length];
		
		for(int i = 0; i < dict.length; i++){
			if(word.length() != 0){
				int index = word.indexOf(dict[i]);
				if(index >= 0){ //creates the new string minus the found word from dictionary
					String temp = word.substring(0, index);
					temp += word.substring(index + dict[i].length());
					word = new String(temp);
					visited[i] = true;
				}
			}else{
				break;
			}
		}
		
		if(word.length() > 0) return false;
		return true;
	}
}
