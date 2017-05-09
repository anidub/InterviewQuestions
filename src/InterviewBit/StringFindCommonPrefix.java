package InterviewBit;

import java.util.ArrayList;
/*///http://www.geeksforgeeks.org/longest-common-prefix-set-4-binary-search/
//https://www.interviewbit.com/problems/longest-common-prefix/
Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".*/
/*Time Complexity : T(M) = T(M/2) + O(MN) 
N = Number of strings M = Length of the largest string string*/
public class StringFindCommonPrefix{
	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>();
		words.add("geeksforgeeks");words.add("geels");
		words.add("geeks");
		System.out.println(findCommonPrefix(words));
		String[] array = {"geeksforgeeks", "geels", "geeks"};
		System.out.println(longestCommon(array));
	}
// A Function to find the string having the minimum length and returns that length
public static int findMinWord(ArrayList<String>  words){
	int min = Integer.MAX_VALUE;
	for(int i = 0; i < words.size(); i++){
		if(words.get(i).length() < min)
			min = words.get(i).length();
	}
	return min;
}

public static String findCommonPrefix(ArrayList<String> words){
	if(words.size() == 0) return "";
	int size = words.size();
	int minWord = findMinWord(words);
	int low = 0;
	String prefix = "";
	int high = minWord;
	while(low < high){
// Same as (low + high)/2, but avoids overflow for large low and high
		int mid = low + (high-low)/2;
		if(allContains(words,words.get(0),low,mid)){
// If all the strings in the input array contains this prefix then append this substring to our answer
			prefix = prefix + words.get(0).substring(low, mid-low+1);
			// And then go for the right part		
			low = mid+1;
		}else
			// Go for the left part	
			high = mid-1;
	}
	return prefix;
}

public static boolean allContains(ArrayList<String> words, String word, int start, int end){
	for(int i = 0; i < words.size(); i++){
		for(int j = start; j <end; j++){
			if(words.get(i).charAt(j) != word.charAt(j)) return false;
		}
	}
	return true;
}

/*//use this coz simple
// time complexity is O(N M) where,
N = Number of strings
M = Length of the largest string string 
Auxiliary Space : To store the longest prefix string we are allocating space which is O(M).
http://www.geeksforgeeks.org/longest-common-prefix-set-2-character-by-character-matching/
*/public static String longestCommon(String[] array){
	int n = array.length;
	String result = "";
	char current;
	int min = findMin(array);
	for(int i = 0; i < min; i++){
		current = array[0].charAt(i);
		for(int j = 1; j < n; j++){
			if(array[j].charAt(i) != current)
				return result;
		}
		result += current;
	}
	return result;
}

public static int findMin(String[] array){
	int min = Integer.MAX_VALUE;
	for(int i = 0; i < array.length;i++){
		if(array[i].length() < min)
			min = array[i].length();
	}
	return min;
}
}
