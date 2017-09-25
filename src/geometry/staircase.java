package geometry;
import java.util.Scanner;
public class staircase {
	   public static void main(String[] args) {
		   printstaircase();
	       Scanner scn=new Scanner(System.in);
	       int n=scn.nextInt();
	       for(int i=1;i<=n;i++) {
	    	   for(int j=1;j<=n;j++) {
	    		   if((i+j)>n){
	    			   System.out.print("#");
	    		   }
	    		   else {
	    			   System.out.print(" ");
	    		   }	    
	    	   }
	    	   System.out.println();	   
	       }
	   }	
	   
	   public static void printstaircase(){
		   int n = 5;
		   for(int i = 1; i <= n; i++){
			   for(int j = 1; j <= n; j++){
				   if((i+j) > n){
					   System.out.print("#");
				   }else{
					   System.out.print(" ");
				   }
			   }
			   System.out.println();
		   }
	   }
}
