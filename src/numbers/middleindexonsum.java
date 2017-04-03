package numbers;

public class middleindexonsum {

	public static void main(String[] args) {
		int[] num = {2,4,4,5,4,1};
	/*
		int endindex = num.length - 1;
		int startindex = 0;
		int sumleft = 0, sumright = 0;
		while(true){
			if(sumleft < sumright){
				sumleft = sumleft + num[startindex++];
			}else{
				sumright = sumright + num[endindex--];
			}
			
			if(startindex > endindex){
				if(sumleft == sumright){
					break;
				}else{
					System.out.println("Incorrent input");
				}
			}
		}
		System.out.println("adding num till index : " + endindex + " is equal to numbers after endindex");
*/
		//int[] num = {2,4,4,5,4,1};
		int startindex = 0;
		int endindex = num.length - 1;
		System.out.println(endindex);
		int sumleft = 0;
		int sumright = 0;
		
		while(true){
			if(sumleft < sumright){
				sumleft = sumleft + num[startindex++];
			}else{
				sumright = sumright + num[endindex--];
			}
			if(startindex > endindex){
				if(sumleft == sumright){
					break;
				}else
					System.out.println("incorrent input");
			}
		}
		System.out.println("Adding nuumbers till end index " + endindex + " is equal");
	}
}
