package Designs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DesignDataStructureOfOrder1 {
/*
 * HashMap and ArrayList both would be required to support 
 * the removeRandom method for order of 1. 
 */
	static class DataStructure{
		
		//Key -> element; value -> index of the element in the array list
		HashMap<Integer, Integer> map;
		ArrayList<Integer> arrList;
		
		public DataStructure(){
			map = new HashMap<Integer, Integer>();
			arrList = new ArrayList<Integer>();
		}
		
		public void add(int x){
			if(map.containsKey(x)){
				return;
			}
			
			arrList.add(x);
			map.put(x, arrList.size());
		}
		
		public void remove(int x) {
			if (!map.containsKey(x)) {
				return;
			}
			int index = map.get(x);
			map.remove(x);
			if (index == arrList.size()) {
				arrList.remove(arrList.size() - 1);
			} else {
				int lastElement = arrList.get(arrList.size() - 1);
				int temp = arrList.get(index - 1);
				arrList.set(index - 1, arrList.get(arrList.size() - 1));
				arrList.set(arrList.size() - 1, temp);
				arrList.remove(arrList.size() - 1);
				map.put(lastElement, index);
			}
		}
		
		public void removeRandom(){
			if(arrList.isEmpty()) return;
			Random random = new Random();
			int index = random.nextInt(arrList.size());
			remove(arrList.get(index));
		}
		
		public Boolean find(int x){
			return map.containsKey(x);
		}
		
	}
	
	public static void main (String[] args){
		DataStructure ds = new DataStructure();
        ds.add(1);
        ds.add(2);
        ds.add(3);
        ds.add(4);
        System.out.println(ds.find(30));
        ds.remove(20);
        ds.add(50);
        System.out.println(ds.find(50));
        ds.removeRandom();
        ds.removeRandom();
        System.out.println(ds.map.size());
        System.out.println(ds.arrList.size());
        
        ds.add(10);
        System.out.println(ds.find(10));
        ds.remove(10);
        System.out.println(ds.find(10));
        ds.removeRandom();
        ds.removeRandom();
        ds.removeRandom();
        ds.removeRandom();
        ds.removeRandom();
        ds.removeRandom();
        ds.removeRandom();
        ds.removeRandom();
        System.out.println(ds.map.size());
        System.out.println(ds.arrList.size());
        System.out.println(ds.find(10));
        ds.add(3);
        ds.add(1);
        ds.add(2);
        ds.remove(10);
        ds.remove(1);
        ds.remove(2);
        ds.remove(3);
        ds.remove(2);
        System.out.println(ds.find(3));        
	}
}
