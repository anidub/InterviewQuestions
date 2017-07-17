package situations;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
/*
Word Ladder (Length of shortest chain to reach a target word)
Given a dictionary, and two words ‘start’ and ‘target’ (both of same length). 
Find length of the smallest chain from ‘start’ to ‘target’ if it exists, such that adjacent words in the chain only differ 
by one character and each word in the chain is a valid word i.e., 
it exists in the dictionary. It may be assumed that the ‘target’ word exists in dictionary and length of all dictionary words is same.
The idea is to use BFS. We start from the given start word, traverse all words that adjacent 
(differ by one character) to it and keep doing so until we find the target word or we have traversed all words.
Time Complexity of the above code is O(n²m) where n is the number of entries originally in the dictionary and m is the size of the string
http://www.geeksforgeeks.org/word-ladder-length-of-shortest-chain-to-reach-a-target-word/
	http://www.programcreek.com/2012/12/leetcode-word-ladder/
		http://javabypatel.blogspot.in/2015/10/word-ladder-doublets-word-links-word-golf.html
*/
public class wordLadder {

	static class WordNode {
		String word;
		int steps;

		public WordNode(String word, int steps) {
			this.word = word;
			this.steps = steps;
		}
	}

	public static void main(String[] args) {// ["hot","dot","dog","lot","log"]
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("hot");
		dictionary.add("dot");
		dictionary.add("dog");
		dictionary.add("lot");
		dictionary.add("log");
		dictionary.add("cog");
		String source = "hit";
		String dest = "cog";
		
		
	/*	 Set<String> dictionary = new HashSet<String>();
		  dictionary.add("CAT");
		  dictionary.add("BAT");
		  dictionary.add("COT");
		  dictionary.add("COG");
		  dictionary.add("COW");
		  dictionary.add("RAT");
		  dictionary.add("BUT");
		  dictionary.add("CUT");
		  dictionary.add("DOG");
		  dictionary.add("WEB");
		 
		  String source = "CAT";
		  String dest = "DOG";*/		   

		int steps = shortestPath(source, dest, dictionary);
		System.out.println(steps);
	}

	public static boolean isAdjacent(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);

			if (c1 != c2)
				count++;
			if (count > 1)
				return false;
		}
		return true;
	}

	public static int shortestPath(String source, String dest, Set<String> dict) {
		if (source == null && dest == null)
			return 0;
		Queue<WordNode> queue = new LinkedList<WordNode>();
		WordNode node = new WordNode(source, 1);
		queue.add(node);
		
		while (!queue.isEmpty()) {			
			WordNode current = queue.poll();
			String currentWord = current.word;
			Iterator it = dict.iterator();
			
			while (it.hasNext()) {
				String word = (String) it.next();
				boolean adj = isAdjacent(currentWord, word);
				if (adj) {
					int currentsteps = current.steps + 1;
					node = new WordNode(word, currentsteps);
					queue.add(node);
					it.remove();
					if (word == dest)
						return currentsteps;
				}
			}
		}
		return 0;
	}
}