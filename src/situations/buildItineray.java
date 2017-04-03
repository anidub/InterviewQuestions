package situations;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class buildItineray {
	//given a list of tickets, build an itinerary of trip. The idea is to find start place, which will be the one occuring just once and in the to field.
	//so we reverse the hashmap and find that value.
	//O(n)

	public static void main(String[] args) {
		HashMap<String, String> tickets = new HashMap<String,String>();
		tickets.put("New York", "Richmond");
		tickets.put("Dubai", "Boston");
		tickets.put("Boston", "New York");
		tickets.put("Richmond", "Chicago");
		itinerary(tickets);
		

	}
	
	public static void itinerary(HashMap<String, String> tickets){
		if(tickets == null || tickets.size() == 0) return;
		HashMap<String, String> reverse = new HashMap<String, String>();
		for(Entry<String, String> entry : tickets.entrySet()){
			reverse.put(entry.getValue(), entry.getKey());
		}
		
		String start = null;
		for(Entry<String, String> entry : tickets.entrySet()){
			if(!reverse.containsKey(entry.getKey())){
				start = entry.getKey();
				break;
			}
		}
		String to = tickets.get(start);

		while(to != null){
			System.out.println(start + "->" + to);
			start = to;
			to = tickets.get(to);
			
		}		
	}

}
