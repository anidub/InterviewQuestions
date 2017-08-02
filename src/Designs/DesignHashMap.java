package Designs;

import java.util.Random;

public class DesignHashMap {
    /* The initial size of the bucket array */
	private int bucket_array_size = 16;
	private Node[] bucketArray = new Node[bucket_array_size];
	
	public DesignHashMap(){
		
	}
	
	public DesignHashMap(int initialSize){
		this.bucket_array_size = initialSize;
	}
	
	 /**
     * Used to put a key-value pair into the data structure.
     * @param key Key string that is used identify the key-value pair
     * @param value Value string in which the key string maps to.
     */
    public void put(String key, String value){
        /* Get the hash code */
        int hash = Math.abs(key.hashCode() % bucket_array_size);
        /* Create the Node to add to the linked list */
        Node entry = new Node(key,value);

        /* Insert the node to the bucket array at the hash index */
        if(bucketArray[hash] == null){
            /* No collision detected. Insert the node. */
            bucketArray[hash] = entry;
        }else{
            /* Collision detected. We must place the node at the end of the linked list. */
            Node current = bucketArray[hash];
            while(current != null){
                /* Check if the key already exists */
                if(current.getKey().equals(entry.getKey())){
                    /* Replace the keys value with the new one */
                    current.setValue(entry.getValue());
                    return;
                }
                current = current.next;
            }
            /* When the code gets here current.next == null */
            /* Insert the node */
            current.next = entry;
        }
    }

    /**
     * Returns the value that is mapped to the give key.
     * @param key The key string which is used to search for the value it
     *            is mapped to.
     * @return The value string
     */
    public String get(String key){
        /* Get the hash */
        int hash = Math.abs(key.hashCode() % bucket_array_size);
        /* Search for key in linked list */
        Node n = bucketArray[hash];
        if(n == null || n.key == null) return null;
        /* Traverse linked list */
        while(n != null){
            if(n.getKey().equals(key)){
                return n.getValue();
            }
            n = n.getNext();
        }
        /* Not found? then return null */
        return null;
    }
    
    public void remove(String key){
    	int hash = Math.abs(key.hashCode() % bucket_array_size);
    	Node n = bucketArray[hash];
    	
    	if(n == null) return;
    	while(n != null){
    		if(n.getKey().equals(key)){
    			if(n.next == null){
    				n.key = null;
    				n.value = null;
    				n = null;
    				return;
    			}else{
    				n.key = n.next.getKey();
    				n.value = n.next.getValue();
    				n.next = n.next.next;
    			}
    			n = n.next;    			
    		}
    	}    	
    }
   
    /*
     * If asked to implement get random :
     * USE ARRAYLIST instead of ARRAY because of its ever increasing size
     * 1) Generate a random number from 0 to last index.
	 *	2) Return the array element at the randomly generated index
	 *http://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-search-and-getrandom-in-constant-time/
     */
   /* int getRandom() {
       // Find a random index from 0 to size - 1
       Random rand = new Random();  // Choose a different seed
       int index = rand.nextInt(arr.size());
 
       // Return element at randomly picked index
       return arr.get(index);
    }*/

	public static void main(String[] args) {
		DesignHashMap map = new DesignHashMap();
		map.put("A", "DUBEY");
		map.put("M", "DUBEY");
		System.out.println(map.get("A"));
		map.put("A", "D");
		System.out.println(map.get("A"));
		map.remove("A");
		System.out.println(map.get("A"));
		System.out.println(map.get("B"));
		

	}
	
	   /* This is the simple object that we use to store each key-value pair */
	protected class Node{
		String key;
		String value;
		Node next;
		
		public Node(String key, String value){
			this.key = key;
			this.value = value;
		}
		
		public void setKey(String key){
			this.key = key;
		}
		
		public String getKey(){
			return key;
		}
		
		public void setValue(String value){
			this.value = value;
		}
		
		public String getValue(){
			return value;
		}
		
		public void setNext(Node next){
			this.next = next;
		}
		
		public Node getNext(){
			return next;
		}
	}

}
