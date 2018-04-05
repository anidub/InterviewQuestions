package HashGeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Tasks {
/*	# Basic Scheduler
	# The scheduler schedules tasks where tasks consist of a name, a list of dependencies, and a priority. The scheduler offers an interface with two methods:
	 addTask(Task task)

	# - addTask(String taskName, String[] dependencies, int priority)- which lets a user submit a task to the scheduler
	# - runAll()  - which triggers the scheduler to execute all (prints) previously added tasks in order prints
	# 
	# The scheduler is to be used like this:
	# 
	# addTask("A", ["B"],   6);
	# addTask("B", ["C"],      4);
	# addTask("C", [],      5);
	# runAll(); -> B, A, C*/
	public static void main(String[] args) {
		Task t1 = new Task();
		t1.name = "A"; ArrayList<Task> list1 = new ArrayList<Task>();
		t1.tasknames = list1; t1.priority = 6; 
		
		Task t2 = new Task();
		t2.name = "B"; ArrayList<Task> list2= new ArrayList<Task>(); 
		t2.tasknames = list2;t2.priority = 4; 
		
		Task t3 = new Task();
		t3.name = "C"; ArrayList<Task> list3 = new ArrayList<Task>();
		t3.tasknames = list3;t3.priority = 5; 
		
		list1.add(t2); list2.add(t3);
		
		addTask(t1);addTask(t2);addTask(t3);
		runAll();
		
		
	}
	
	static class Task{
		String name;
		List<Task> tasknames;
		int priority;
	}
	static Map<String, List<Task>> tasks = new TreeMap<String, List<Task>>();
	static Map<Integer, List<Task>> giventasks = new TreeMap<Integer, List<Task>>(Collections.reverseOrder());
	
	public static void addTask(Task task){
		if(giventasks.containsKey(task.priority)){
			giventasks.get(task.priority).add(task);
		}else{
			List<Task> tasks = new ArrayList<Task>();
			tasks.add(task);
			giventasks.put(task.priority, tasks);
		}
		tasks.put(task.name, task.tasknames);		
	}
	
	public static void runAll(){
		for(Entry<Integer, List<Task>> entry : giventasks.entrySet()){
			List<Task> tasks = entry.getValue();
			for(Task t : tasks){
				getFlattenTask(t);
			}
		}
		System.out.println(result);
	}
	static Set<String> result = new LinkedHashSet<String>();
	
	public static void getFlattenTask(Task task){
		if(tasks.get(task.name).size() == 0){
			result.add(task.name);
		}else{
			for(Task t : tasks.get(task.name)){
				getFlattenTask(t);
			}
		}
		result.add(task.name);
		
	}

	
}
