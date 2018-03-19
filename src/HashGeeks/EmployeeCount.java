package HashGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
/*
 * https://www.geeksforgeeks.org/find-number-of-employees-under-every-manager/
 * Find number of Employees Under every Employee
3.7
Given a dictionary that contains mapping of employee and his manager as a number of (employee, manager) pairs like below.

{ "A", "C" },
{ "B", "C" },
{ "C", "F" },
{ "D", "E" },
{ "E", "F" },
{ "F", "F" } 

In this example C is manager of A, 
C is also manager of B, F is manager 
of C and so on.

1. Create a reverse map with Manager->DirectReportingEmployee 
    combination. Off-course employee will be multiple so Value 
    in Map is List of Strings.
        "C" --> "A", "B",
        "E" --> "D" 
        "F" --> "C", "E", "F"

 
2. Now use the given employee-manager map to iterate  and at 
   the same time use newly reverse map to find the count of 
   employees under manager.
   
   Let the map created in step 2 be 'mngrEmpMap' 
   Do following for every employee 'emp'.
     a) If 'emp' is not present in 'mngrEmpMap' 
          Count under 'emp' is 0 [Nobody reports to 'emp']
     b) If 'emp' is present in 'mngrEmpMap' 
          Use the list of direct reports from map 'mngrEmpMap'
          and recursively calculate number of total employees
          under 'emp'. 
 */
public class EmployeeCount {

	/*public static void main(String[] args) {
		Map<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("A", "C");
        dataSet.put("B", "C");
        dataSet.put("C", "F");
        dataSet.put("D", "E");
        dataSet.put("E", "F");
        dataSet.put("F", "F"); 
        getCount(dataSet);
        System.out.println("result = " + result);

	}*/
	static HashMap<String, Integer> result = new HashMap<String, Integer>();
	
	public static void getCount(Map<String, String> dataSet){
		//key -> manager, value -> list of employees
		HashMap<String, List<String>> managerEmpMap = new HashMap<String, List<String>>();
		
		for(Entry<String, String> entry : dataSet.entrySet()){
			String emp = entry.getKey();
			String mng = entry.getValue();
			
			if (!emp.equals(mng)) {
				List<String> directReportList = managerEmpMap.get(mng);
				if (directReportList == null) {
					directReportList = new ArrayList<String>();
				}
				directReportList.add(emp);
				managerEmpMap.put(mng, directReportList);
			}
		}
		for(String mng : dataSet.keySet()){
			populateResult(mng, managerEmpMap);
		}
	}
	
	 // This is a recursive function to fill count for 'mgr' using  mngrEmpMap.  This function uses memoization to avoid re-computations of subproblems.
	public static int populateResult(String mng, HashMap<String, List<String>> managerEmpMap){
		int count = 0;
		// means employee is not a manager of any other employee
		if(!managerEmpMap.containsKey(mng)){
			result.put(mng, 0);
			return 0;
			// this employee count has already been done by this method, so avoid re-computation
		}else if(result.containsKey(mng)){
			count = result.get(mng);
		}else{
			List<String> directReportEmpList = managerEmpMap.get(mng);
			count = directReportEmpList.size();
			for(String directEmp : directReportEmpList){
				count += populateResult(directEmp, managerEmpMap);
			}		
			result.put(mng, count);
		}
		return count;		
	}
	

    

    public static void main (String[] args) throws java.lang.Exception {
        packages = new HashMap<String, String[]>();
        packages.put("X", new String[] {"A", "E", "C"});
        packages.put("A", new String[] {"E", "H", "Y"});
        packages.put("E", new String[] {"B", "Z", "Y"});
        packages.put("C", new String[] {});
        packages.put("H", new String[] {});
        packages.put("B", new String[] {"A"});
        packages.put("Y", new String[] {});
        System.out.println(Arrays.toString(requiredPackages("X")));
    }
    
   // private static HashMap<String, String[]> packages;

    //private static HashSet<String> result = new HashSet<String>();  
/*    public static String[] requiredPackages(String p) {
      if(p == null || p.length() == 0 || !packages.containsKey(p))
        return null;
      String[] child = packages.get(p);
      HashSet<String> ancestors = new HashSet<String>();;
      for(int i = 0; i < child.length; i++){
    	result.add(child[i]);
    	 String s = child[i];
        ancestors.add(child[i]);
        getDependency(ancestors, child[i]);
      }
      String[] resultArray = new String[result.size()];   
      int index = 0;
      for(String s : result){
        resultArray[index] = s;
        index++;
      }
      return resultArray;
    }*/
  
  //AE//E
   /* public static void getDependency(HashSet<String> ancestors,String letter) {//Set//A
      if(letter == null)
        return;
      if(!packages.containsKey(letter)) return;
        //throw "Error";
      ancestors.add(letter);
      String[] child = packages.get(letter);//EHY//BZY
      for(int i = 0; i < child.length; i++){
    	  String s = child[i];
    	  if(!result.contains(child[i]) && !ancestors.contains(child[i])){
         result.add(child[i]);//E
          //ancestors.add(child[i]);//E
          getDependency(ancestors,child[i]);
        }else if(ancestors.contains(child[i])){
          return;
          //throw "Circular dependecny error";
        }
      }
    }*/
}
