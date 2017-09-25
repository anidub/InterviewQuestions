package Designs;
/*
 * http://www.javamadesoeasy.com/2015/02/linkedhashmap-custom-implementation.html
 */
public class LinkedHashMap {
	
	Bucket[] table;
	int capacity = 4;
	Bucket head;
	Bucket last;
	
	class Bucket<key, value>{
		Integer key;
		Integer value;
		Bucket next;
		Bucket before;
		Bucket after;
		
		public Bucket(Integer key, Integer value, Bucket< key, value> next){
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	private void insertFirst(Bucket newEntry){
		if(head == null){
			head = newEntry;
			last = newEntry;
			return;
		}
		newEntry.next = head;
		head.before = newEntry;
		head = newEntry;
	}
	
	private void insertLast(Bucket newEntry){
		if(head == null){
			head = newEntry;
			last = newEntry;
			return;
		}
		last.after = newEntry;
		newEntry.before = last;
		last = newEntry;
	}
	
	private void insertAfter(Bucket beforeDeleteEntry, Bucket newEntry){
		Bucket current = head;
		while(current != beforeDeleteEntry){
			current = current.after;
		}
		newEntry.after = beforeDeleteEntry.after;
		beforeDeleteEntry.after.before = newEntry;
		newEntry.before = beforeDeleteEntry;
		beforeDeleteEntry.after = newEntry;
	}
	
	private void deleteFirst(){
		if(head == last){
			head = last = null;
			return;
		}
		head = head.after;
		head.before = null;
	}
	
	private void deleteLast(){
		if(head == last){
			head = last = null;
			return;
		}
		last = last.before;
		last.after = null;
	}
	
	private Bucket deleteSpecificBucket(Bucket newEntry){
		Bucket current = head;
		while(!current.key.equals(newEntry.key)){
			if(current.after == null) 
				return null;
			current = current.after;
		}
		Bucket beforeDeleteEntry = current.before;
		current.before.after = current.after;
		current.after.before = current.before;
		return beforeDeleteEntry;
	}
	
	public Integer get(Integer key){
		Integer hash = Math.abs(key.hashCode() % capacity);
		if(table[hash] == null)
			return null;
		else{
			Bucket temp = table[hash];
			while(temp != null){
				if(temp.key.equals(key)){
					return temp.value;
				}
				temp = temp.next;
			}
			return null;
		}
	}
	
	public void put(Integer key, Integer value){
		if(key == null) return;
		Integer hash = key.hashCode() % capacity;
		Bucket newEntry = new Bucket(key, value, null);
		maintainOrderAfterInsert(newEntry);
		if(table[hash] == null){
			table[hash] = newEntry;
		}else{
			Bucket previous = null;
			Bucket current = table[hash];
			while(current != null){
				if(current.key.equals(key)){
					if(previous == null){
						newEntry.next = current.next;
						table[hash] = newEntry;
						return;
					}else{
						newEntry.next = current.next;
						previous.next = newEntry;
						return;
					}
				}
				previous = current;
				current = current.next;
			}
			previous.next = newEntry;
		}
	}
	
	private void maintainOrderAfterInsert(Bucket newEntry){
		if(head == null){
			head = newEntry;
			last = newEntry;
			return;
		}
		
		if(head.key.equals(newEntry.key)){
			deleteFirst();
			insertLast(newEntry);
			return;
		}
		if(last.key.equals(newEntry.key)){
			deleteLast();
			insertLast(newEntry);
			return;
		}
		
		Bucket beforeDeleteEntry = deleteSpecificBucket(newEntry);
		if(beforeDeleteEntry == null){
			insertLast(newEntry);
		}else{
			insertAfter(beforeDeleteEntry, newEntry);
		}
	}
	
	public void maintainOrderAfterDeletion(Bucket deleteEntry){
		if(head.key.equals(deleteEntry.key)){
			deleteFirst();
			return;
		}
		if(last.key.equals(deleteEntry.key)){
			deleteLast();
			return;
		}
		deleteSpecificBucket(deleteEntry);
	}
	
	public boolean remove(Integer key){
		int hash = key.hashCode() % capacity;
		if(table[hash] == null)
			return false;
		
		Bucket  previous = null;
		Bucket current =  table[hash];
		
		while(current != null){
			if(current.key.equals(key)){
				maintainOrderAfterDeletion(current);
				if(previous == null){
					table[hash] = table[hash].next;
					return true;
				}else{
					previous.next = current.next;
					return true;
				}
			}
			previous = current;
			current = current.next;
		}
		return false;
	}
	
	public static void main(String[] args) {
	

	}

}
