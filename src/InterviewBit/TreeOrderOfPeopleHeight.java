package InterviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TreeOrderOfPeopleHeight {
/*//https://www.interviewbit.com/problems/order-of-people-heights/
	You are given the following :

		A positive number N
		Heights : A list of heights of N persons standing in a queue
		Infronts : A list of numbers corresponding to each person (P) that gives the number of persons who are taller than P and standing in front of P
		You need to return list of actual order of persons’s height
				Input : 
					Heights: 5 3 2 6 1 4
					InFronts: 0 1 2 0 3 2
					Output : 
					actual order is: 5 3 2 1 6 4 */
	public static void main(String[] args) {
		ArrayList<Integer> count = new ArrayList<Integer>();
		ArrayList<Integer> heights = new ArrayList<Integer>();
		heights.add(5);	heights.add(3);heights.add(2);heights.add(6);
		heights.add(1);heights.add(4);
		count.add(0);count.add(1);count.add(2);count.add(0);count.add(3);count.add(2);
		ArrayList<Integer> result = order(heights,count);

	}
//	http://stackoverflow.com/questions/19174796/puzzle-find-the-order-of-n-persons-standing-in-a-line-based-on-their-heights
	//O(nlogn)
	private static class Person {
	       public Integer height;
	       public Integer count;
	       public Person(int h, int c) {
	           height = h;
	           count = c;
	        }
	    }
	public static ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {

		Person[] persons = new Person[heights.size()];
		ArrayList<Integer> res = new ArrayList<Integer>();

		for (int i = 0; i < persons.length; i++) {
			persons[i] = new Person(heights.get(i), infronts.get(i));
		}
//reverse order
		Arrays.sort(persons, new Comparator<Person>(){
			 public int compare(Person o1, Person o2) {
			        return o2.height.compareTo(o1.height);
			    }
        });
		for (int i = 0; i < persons.length; i++) {
		 System.out.println("adding "+persons[i].height+" "+persons[i].count);
			res.add(persons[i].count, persons[i].height);//imp
		}
		return res;
	}
}