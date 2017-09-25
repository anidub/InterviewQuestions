package Designs;

import java.util.HashMap;
import java.util.Map.Entry;

public class DesignURLCount {
	public static void main(String[] args) {
		DesignURLCount designURLCount  = new DesignURLCount();
		designURLCount.add("User1", "A");
		designURLCount.add("User1", "B");
		designURLCount.add("User1", "C");
		designURLCount.add("User1", "D");
		designURLCount.add("User1", "E");
		designURLCount.add("User1", "A");
		designURLCount.add("User1", "B");
		designURLCount.add("User1", "C");
		
		designURLCount.add("User2", "A");
		designURLCount.add("User2", "B");
		designURLCount.add("User2", "C");
			
		for(Entry<Tuple, Integer> entry : outputMap.entrySet()){
			System.out.println(entry.getKey().a + " " +entry.getKey().b + " " + entry.getKey().c + " ->  " + entry.getValue());
		}
		

	}
	static HashMap<String, CircularQueue> inputMap = new HashMap<String, CircularQueue>();
	static HashMap<Tuple, Integer> outputMap = new HashMap<Tuple, Integer>();
	public void add(String id, String url){
		if(id == null || url == null || id.length() == 0 || url.length() == 0){
			return;
		}
		if(inputMap.containsKey(id)){
			CircularQueue cq = inputMap.get(id);
			if(cq.currentSize == 2){
				String front = (String) cq.dequeue();
				String rear = (String) cq.dequeue();
				Tuple tuple = new Tuple(front, rear, url);
				cq.enqueue(rear);
				cq.enqueue(url);
				
				outputMap.put(tuple, outputMap.getOrDefault(tuple, 0)+1);
			}else{
				cq.enqueue(url);
				inputMap.put(id, cq);
			}
		}else{
			CircularQueue cq = new CircularQueue();
			cq.enqueue(url);
			inputMap.put(id, cq);
		}
	}
	
	class Tuple{
		String a;
		String b;
		String c;
		
		public Tuple(String a, String b, String c){
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		//Auto generated from editor
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((a == null) ? 0 : a.hashCode());
			result = prime * result + ((b == null) ? 0 : b.hashCode());
			result = prime * result + ((c == null) ? 0 : c.hashCode());
			return result;
		}

		@Override
		//Auto generated from editor
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Tuple other = (Tuple) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (a == null) {
				if (other.a != null)
					return false;
			} else if (!a.equals(other.a))
				return false;
			if (b == null) {
				if (other.b != null)
					return false;
			} else if (!b.equals(other.b))
				return false;
			if (c == null) {
				if (other.c != null)
					return false;
			} else if (!c.equals(other.c))
				return false;
			return true;
		}

		private DesignURLCount getOuterType() {
			return DesignURLCount.this;
		}
		
	}
	
	//implementation of Circular Queue 
	class CircularQueue {

	    private int currentSize; 
	    private String[] circularQueueElements;
	    private int maxSize = 2; 

	    private int rear;
	    private int front; 

	    public CircularQueue() {
	        circularQueueElements = new String[this.maxSize];
	        currentSize = 0;
	        front = 0;
	        rear = 0;
	    }

	    /**
	     * Enqueue elements to rear.
	     */
	    public void enqueue(String item){
	        if (isFull()) {
	            System.out.println("Circular Queue is full. Element cannot be added");
	        }
	        else {
	            circularQueueElements[rear] = item;
	            rear = (rear + 1) % circularQueueElements.length;
	            currentSize++;
	        }
	    }

	    /**
	     * Dequeue element from Front.
	     */
	    public String dequeue() {
	    	String deQueuedElement = null;
	        if (isEmpty()) {
	            System.out.println("Circular Queue is empty. Element cannot be retrieved");
	        }
	        else {
	            deQueuedElement = circularQueueElements[front];
	            circularQueueElements[front] = null;
	            front = (front + 1) % circularQueueElements.length;
	            currentSize--;
	        }
	        return deQueuedElement;
	    }

	    /**
	     * Check if queue is full.
	     */
	    public boolean isFull() {
	        return (currentSize == circularQueueElements.length);
	    }

	    /**
	     * Check if Queue is empty.
	     */
	    public boolean isEmpty() {
	        return (currentSize == 0);
	    }

	}

}
