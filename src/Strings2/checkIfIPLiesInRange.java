package Strings2;

public class checkIfIPLiesInRange {
/*https://stackoverflow.com/questions/4256438/calculate-whether-an-ip-address-is-in-a-specified-range-in-java
Calculate whether an IP address is in a specified range in Java
	For instance:
ip 192.200.3.0
range from 192.200.0.0
range to 192.255.0.0
should result to true.
Other examples:
assert 192.200.1.0 == true
assert 192.199.1.1 == false
assert 197.200.1.0 == false*/
	public static void main(String[] args) {
		String low = "192.200.0.0";
		String high = "192.255.0.0";		
		String test = "192.199.1.1";
		System.out.println(checkIfInRange(low, high, test));

	}

	public static boolean checkIfInRange(String low, String high, String test){
		String[] arrLow = low.split("\\.");
		String[] arrHigh = high.split("\\.");
		String[] arrTest = test.split("\\.");
		
		boolean inRange = true;
		for(int i = 0; i < arrLow.length; i++){
			Integer iLow = Integer.parseInt(arrLow[i]);
			Integer iHigh = Integer.parseInt(arrHigh[i]);
			Integer iTest = Integer.parseInt(arrTest[i]);
			if(iTest < iLow || iTest > iHigh){
				inRange = false;
				break;
			}
		}
		return inRange;
	}
}
