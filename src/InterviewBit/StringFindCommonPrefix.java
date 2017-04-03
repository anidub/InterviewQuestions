package InterviewBit;

import java.util.ArrayList;
///http://www.geeksforgeeks.org/longest-common-prefix-set-4-binary-search/
//https://www.interviewbit.com/problems/longest-common-prefix/
/*Time Complexity : T(M) = T(M/2) + O(MN) 
N = Number of strings M = Length of the largest string string*/
public class StringFindCommonPrefix{
	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>();
		words.add("geeksforgeeks");words.add("geels");
		words.add("geeks");
		System.out.println(findCommonPrefix(words));
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
}
