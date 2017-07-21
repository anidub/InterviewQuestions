package Strings2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class StockMessage {
	/*
	 * https://www.careercup.com/question?id=5746983810629632
	 * You are given a structure msg 

struct msg { 
	long timestamp; 
	double price; 
	string label; 
}; 

The msg represents price of a stock on a given timestamp. 

Create a class with two functions - 

addStockPrice(msg m) -> Used to add Stock Price in Data structure 

getAvgPriceForAStockLast10Minutes(String stockName) -> Get average price of a stock for last 10 minutes. 

The program should be time and space optimized
	 * N = # of messages per stock
		M = # of stocks

Time: O(logN) for add, O(NlgN) for getAvg
Space: O(MN)
	 */
	public class Message {
		  private long timestamp;
		  private double price;
		  private String label;
		  
		  public Message(long timestamp, double price, String label) {
		    this.timestamp = timestamp;
		    this.price = price;
		    this.label = label;
		  }
		  
		  public long timestamp() {
		    return timestamp;
		  }
		  
		  public double price() {
		    return price;
		  }
		  
		  public String label() {
		    return label;
		  }
		}
	public class MsgTimeComparator implements Comparator<Message> {
		  public int compare(Message m1, Message m2) {
		    return ((m1.timestamp() - m2.timestamp()) > 0) ? -1 : 1;
		  }
		  
		}

		public class StockAverager {
		  private HashMap<String, PriorityQueue<Message>> stocks;
		  
		  public StockAverager() {
		    stocks = new HashMap<String, PriorityQueue<Message>>();
		  }
		  
		  public void addStockPrice(Message m) {
		    if (stocks.containsKey(m.label())) 
		      stocks.get(m.label()).add(m);
		    else {
		    	// we need a priority queue to keep the messages in sorted fasion of their timestamp
		    	//it will be helpful in calculating the avg price for last 10 mins
		      PriorityQueue<Message> pq = new PriorityQueue<Message>(10, new MsgTimeComparator());
		      pq.add(m);
		      stocks.put(m.label(), pq);
		    }
		  }
		  
		  public double getAvgPriceForAStockLast10Minutes(String stockName) {
		    Queue<Message> lessThan10 = new LinkedList<Message>();
		    PriorityQueue<Message> msgPQ = stocks.get(stockName);
		    long currTime = 105;
		    double sum = 0.0;
		    Message m;
		    
		    while (currTime - msgPQ.peek().timestamp() <= 10) {
		      m = msgPQ.poll();
		      sum += m.price();
		      lessThan10.add(m);
		    }
		    
		    double avg = sum / (lessThan10.size() + 0.0);
		    
		    while (lessThan10.size() != 0) {
		      Message msg = lessThan10.remove();
		      System.out.println(msg.price());
		      msgPQ.add(msg);
		    }
		    
		    return avg;
		  }
		}		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
