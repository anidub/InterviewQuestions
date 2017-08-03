package numbers2;

public class getMedianofTwosortedarrays {
	//http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
		//O(logn)//a median is described as the number separating the higher half of a sample, a population, or a probability distribution, from the lower half.

	public static void main(String[] args) {
		int[] a1 = new int[]{1, 3, 5, 7, 9}; //same size
		int[] a2 = new int[]{2, 4, 6, 8, 10};//same size
		System.out.println("O(logn) -> "+getMedian2(a1,a2));
	}

	public static float getMedian2(int[] a1,int[] a2){
		int end = a1.length-1;
		return getMedian2(a1,0,end,a2,0,end);
	}
 
	private static float getMedian2(int[] a1, int s1,int e1, int[] a2,int s2, int e2){
		//System.out.println("("+a1[s1]+","+a1[e1]+") to ("+a2[s2]+","+a2[e2]+")");
		int len = e1-s1+1;
		if(len <= 0)
			return -1;
		if(len == 1)
			return (a1[s1]+a2[s2])/2.0f;
		if(len == 2)
			return ( Math.max(a1[s1],a2[s2]) + Math.min(a1[e1],a2[e2]) )/2.0f;
		float m1 = getM(a1,s1,e1);
		float m2 = getM(a2,s2,e2);
		if(m1 == m2)
			return m1;
 
		if(m1 < m2){
			if(len%2 == 0)
				return getMedian2(a1, s1 + len/2, e1,  a2, s2, s2 + len/2 - 1);// pulling someone in first half = len/2 -1
			else
				return getMedian2(a1, s1 + len/2, e1,  a2, s2, s2 +len/2);
		}
		else{
			if(len%2 == 0)
				return getMedian2(a1,s1,s1 + len/2 - 1,  a2,s2 + len/2,e2);
			else
				return getMedian2(a1,s1,s1 + len/2,  a2,s2 + len/2,e2);
		}
	} 
	private static float getM(int[] arr,int s,int e){
		int len = e-s+1;
		int i=len/2;
		if(len%2 == 0){
			return (arr[i]+arr[i-1])/2.0f;
		}
		return arr[i];
	}
	
	public static float GetMedian(int[] arr1, int[] arr2){
		int end = arr1.length;
		return getmed(arr1, 0, end-1, arr2, 0, end-1);
	}
	public static float getmed(int[] arr1, int start1, int end1, int[] arr2, int start2, int end2){
		int len = end1-start1 + 1;
		if(len == 0) return -1;
		if(len == 1) return (arr1[start1] + arr2[start2])/2;
		if(len == 2) return (Math.max(arr1[start1], arr2[start2]) + Math.min(arr1[end1], arr2[end2]))/2;
		
		float m1 = getm(arr1, start1, end1);
		float m2 = getm(arr2, start2, end2);
		
		if(m1 > m2){
			if(len % 2 == 0){
				return getmed(arr1, start1+len/2, end1, arr2, start2, start2 + len/2 - 1);
			}else
				return getmed(arr1, start1+len/2, end1, arr2, start2, start2+len/2);
		}else{
			if(len % 2 == 0){
				return getmed(arr1, start1+len/2-1, end1,  arr2, start2, start2+len/2);
			}else{
				return getmed(arr1, start1+len/2, end1, arr2, start2, start2 + len/2);
			}
		}
	}
	
	public static float getm(int[] arr, int start, int end){
		int len = end-start+1;
		int i = len/2;
		if(len % 2 == 0){
			return (arr[i] + arr[i-1])/2;
		}
		return arr[i]/2;
	}
}