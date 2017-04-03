package Strings;

import java.util.Scanner;

public class ipvalidator {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of testcases : ");
		int testcase = in.nextInt();
		System.out.println("Enter the ip address : ");
		String b = in.nextLine();
		for (int i = 0;i<testcase; i++){
			String test = in.nextLine();
			String splitter [] = test.split(" "); 
			if(splitter[0].matches("([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])") == true){
				System.out.println("IPv4");
			}
			else if(splitter[0].matches("([0-9a-f]+)\\:([0-9a-f]+)\\:([0-9a-f]+)\\:([0-9a-f]+)\\:([0-9a-f]+)\\:([0-9a-f]+)\\:([0-9a-f]+)\\:([0-9a-f]+)") == true){
				System.out.println("IPv6");
			}
			else{
				System.out.println("Neither");
			}

	}
	}
}
