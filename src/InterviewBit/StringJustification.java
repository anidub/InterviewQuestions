package InterviewBit;

import java.util.ArrayList;

public class StringJustification {
//https://www.interviewbit.com/problems/justified-text/
//http://www.programcreek.com/2014/05/leetcode-text-justification-java/
//https://scyforce.gitbooks.io/leetcode/content/text_justification.html
	public static void main(String[] args) {
		String[] message = {"This", "is", "an", "example", "of", "text", "justification."};
		ArrayList<String> m = new ArrayList<String>();
		m.add("This");m.add("is");m.add("an");m.add("example");m.add("of");m.add("text");m.add("justification.");
		ArrayList<String> result = fullJustify(m,16);
		for(String tmp : result){
			System.out.print(tmp);
		}
		System.out.println("LeetCode");
		result = fullJustifya(message,16);
		for(String tmp : result){
			System.out.print(tmp);
		}

     }
	
	public static ArrayList<String> fullJustify(ArrayList<String> A, int maxWidth) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0, w; i < A.size(); i = w) {
			int l = -1;
			for (w = i; w < A.size() && A.get(w).length() + 1 + l <= maxWidth; w++)
				l += A.get(w).length() + 1;
			
			StringBuilder sb = new StringBuilder(A.get(i));
			int spaces = 1, extra = 0;
			if (w != i + 1 && w != A.size()) {
				spaces = (maxWidth - l) / (w - i - 1) + 1;
				extra = (maxWidth - l) % (w - i - 1);
			}
			for (int j = i + 1; j < w; j++) {
				for (int s = 0; s < spaces; s++)
					sb.append(' ');
				if (extra-- > 0)
					sb.append(' ');
				sb.append(A.get(j));
			}
			int remaining =maxWidth - sb.length();
			while (remaining-- > 0)
				sb.append(' ');
			list.add(sb.toString());
		}
		return list;
	}
	//studied
	public static ArrayList<String> fullJustifya(String[] words, int maxWidth) {
		ArrayList<String> result = new ArrayList<String>();	 
	    if(words==null || words.length==0) return result;	 	 
	    int count=0;
	    int last=0;
	    for(int i=0; i<words.length; i++){
	        count = count + words[i].length();	 
	        if(count+i-last>maxWidth){
	            int wordsLen = count-words[i].length();
	            int spaceLen = maxWidth-wordsLen;
	            int eachLen = 1;
	            int extraLen = 0;	 
	            if(i-last-1>0){
	                eachLen = spaceLen/(i-last-1);
	                extraLen = spaceLen%(i-last-1);
	            }	 
	            StringBuilder sb = new StringBuilder();	 
	            for(int k=last; k<i-1; k++){
	                sb.append(words[k]);	 
	                int ce = 0;
	                while(ce<eachLen){
	                    sb.append(" ");
	                    ce++;
	                }	 
	                if(extraLen>0){
	                    sb.append(" ");
	                    extraLen--;
	                }
	            }	 
	            sb.append(words[i-1]);//last words in the line
	            //if only one word in this line, need to fill left with space
	            while(sb.length()<maxWidth){
	                sb.append(" ");
	            }	 
	            result.add(sb.toString());	 
	            last = i;
	            count=words[i].length();
	        }
	    }	 
	    
	    StringBuilder sb = new StringBuilder();	 
	    for(int i=last; i<words.length-1; i++){
	        count = count+words[i].length();
	        sb.append(words[i]+" ");
	    }	 
	    sb.append(words[words.length-1]);
	    while(sb.length()<maxWidth){
	        sb.append(" ");
	    }
	    result.add(sb.toString());	 
	    return result;
	}	 
}