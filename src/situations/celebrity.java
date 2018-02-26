package situations;

public class celebrity {
	 // people numbered from 0 to 3;
	 static final int SIZE = 4;

	public static void main(String[] args) {
		int celeb = findCandidate();
        if (checkIfCelebrity(celeb)) {
            System.out.println("Celebrity found: " + celeb);
        } else
            System.out.println("Celebrity not found");
	}
	
	static int findCandidate() {
        int celeb = 0;
        for (int i = 1; i < SIZE; i++) {
            // if celeb knows i, celeb can't be the candidate.
            if (haveAcquaintance(celeb, i)) { // if true then set to i               
            	celeb = i;
            }
        }
        return celeb;
    }
 
    static boolean checkIfCelebrity(int celeb) {
        for (int i = 0; i < SIZE; i++) {
            // check if the celebrity knows noone and everyone knows the
            // celebrity.
            if ((celeb != i))
            	if (!haveAcquaintance(i, celeb)		
            			|| haveAcquaintance(celeb,i)) {
            		
                return false;
            }
        }
        return true;
    }
 
    static boolean haveAcquaintance(int a, int b) {
        // assuming valid input
        int[][] input =  { {0,0,1,1},{0,0,1,0},{0,0,0,0},{0,0,1,0} };
        if(input[a][b] == 1) {
        	System.out.println("True");
        }
        return input[a][b] == 1 ? true : false;
    }

}
