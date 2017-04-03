package numbers;

import java.util.Scanner;

public class memorysize {
	
	/*private static int count; 
	static { 
	System.out.println("In block 1"); 
	count = 10; 
	}
	
	private int[] data; { 
	System.out.println("In block 2"); 
	data = new int[count]; 
	for (int i = 0; i < count; i++) 
		data[i] = i;
	//}
	} */
	
	//public static void main(String[] args) {
		/*int x = 5, y = 0;
//		public static void main (String(] args) { 
		System.out.println("Count = " + count); 
		System.out.println("Before 1st call to new"); 
		memorysize testl = new memorysize(); 
		System.out.println("Before 2nd call to new"); 
		memorysize test2 = new memorysize(); */
		
		/*
		try {
			try {
				System.out.println(x);
				System.out.println(x/y);
				System.out.println(y);
			} catch (ArithmeticException ex) {
				System.out.println("Arithmetic innner 1 ");
				throw ex;
			}catch (RuntimeException ex) {
				System.out.println("Runtime inner 2 ");
				throw ex;
			}finally {
				System.out.println("Inner finally");
			}
		} catch (Exception e) {
			
			System.out.println("outer catch ");
		}*/
		
		
	 
		//	private int[] data; { System.out.println("In block 2"); data = new int[count]; for (int i = 0; i < count; i++) data[i] = i; } } 
			//public static void main (String(] args) { System.out.println("Count = " + count); System.out.println("Before 1st call to new"); IkmTest testl = new IkmTest(); System.out.println("Before 2nd call to new"); IkmTest test2 = new IkmTest(); 
			//} 

		public static void main(String[] argList) { 
		/*StringBuilder str = new StringBuilder();
		for (String arg : argList){
		 if (str. indexOf(arg)<1) 
			str.append(arg+" "); 
		} 
		System.out.println(str.toString()); 
		Scanner sc = new Scanner(str.toString()); 
		while (sc.hasNext()){
		if(sc.hasNextInt()) 
		System.out.print(sc.nextInt() + " ");
		else 
		sc.next(); 
		} */
			
			System.out.println("Current JVM Heap Size:"+Runtime.getRuntime().totalMemory()); 
			System.out.println("Maximum JVM Heap Size:"+Runtime.getRuntime().maxMemory()); 
			System.out.println("Free JVM Heap Size:"+Runtime.getRuntime().freeMemory()); 


		
		}

		
		
		

	}


