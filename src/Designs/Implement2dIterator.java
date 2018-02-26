package Designs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/*
 * https://gist.github.com/cangoal/e2cde70b18e71430749be4bb59cc7166
 * // Implement an iterator to flatten a 2d vector.

// For example,
// Given 2d vector =

// [
//   [1,2],
//   [3],
//   [4,5,6]
// ]
// By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
 * 
 * /**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 * 
 * 
 */
public class Implement2dIterator implements Iterator{
	int index = 0;
	List<Iterator> iterators = new ArrayList<Iterator>();
	
	public Implement2dIterator(List<List<Integer>> vec2d){
		if(vec2d != null && vec2d.size() != 0){
			for(List<Integer> list : vec2d){
				if(list != null && list.size() > 0){
					iterators.add(list.iterator());
				}
			}
		}
	}

	public boolean hasNext() {
		if(index == iterators.size()) return false;
		else if(index < iterators.size() - 1) return true;
		else return iterators.get(index).hasNext();
	}

	public Object next() {
		while(index < iterators.size()){
			if(iterators.get(index).hasNext())
				return iterators.get(index).next();
			index++;
		}
		return null;
	}
}
