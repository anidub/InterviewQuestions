package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ArraysHotelBookings {
/*	A hotel manager has to process N advance bookings of rooms for the next season.
His hotel has K rooms. Bookings contain an arrival date and a departure date. 
He wants to find out whether there are enough rooms in the hotel to satisfy the demand. 
Write a program that solves this problem in time O(N log N) .
Input : 
      Arrivals :   [1 3 5]
      Departures : [2 6 8]
      K : 1
Return : False / 0 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int rooms) {
		if(arrive == null && depart == null && arrive.size() != depart.size()) return false;
		Collections.sort(arrive);Collections.sort(depart);
		int result = 0; int currentRooms = 0;
		int i = 0; int j = 0;
		while(i < arrive.size() && j < depart.size()){
			if(arrive.get(i) < depart.get(j)){
				currentRooms++;
				if(result <= currentRooms) result = currentRooms;
				i++;
			}else{
				currentRooms--;
				j++;
			}
		}
		if(rooms >= result) return true;
		return false;		
    }
}