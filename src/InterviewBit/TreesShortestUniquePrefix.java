package InterviewBit;

public class TreesShortestUniquePrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*works
	  https://shawnlincoding.wordpress.com/2015/03/25/shortest-unique-prefix-to-represent-word-in-an-array/
	 */
	public static Node root;
	public static int R = 256;
	public static class Node{
		int count;
		boolean isEnd;
		private Node next[] = new Node[256];
		public Node(){
			this.count = 0;
			this.isEnd = false;
		}
		public Node(int count, boolean isEnd){
			this.count = count;
			this.isEnd = isEnd;				
		}
	}

	public static void insert(String str){
		if(root == null) root = new Node();
		Node curr = root;
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(curr.next[c] == null){
				curr.next[c] = new Node(1,false);
			}else{
				curr.next[c].count++;
			}
			curr = curr.next[c];
		}
		curr.isEnd = true;
	}
	public String shortestPrefix(String str){
		Node curr = root;
		int len = 0;
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			curr = curr.next[c];
			len++;
			if(curr.count == 1) break;
		}
		return str.substring(0,len);
	}
	
	//works
	/*public class Node {
	    char c;
	    int val;
	    Node left, mid, right;
	    public Node() {}	  
		public Node(char c) {
		    this.c = c;
		    this.val = 0;
		  }
	}
	  private Node root;	    

	public ArrayList<String> prefix(ArrayList<String> A) {
		ArrayList<String> res = new ArrayList<String>();
		for (String str : A) {
			put(str);
		}
		for (String str : A) {
			String prefix = getPrefix(str);
			res.add(prefix);
		}
		return res;

	}
		
	public String getPrefix(String str) {
	    StringBuilder strB = new StringBuilder();
	    return get(root, str, 0, strB);
	}		
		
	public String get(Node node, String str, int index, StringBuilder strB) {
		char c = str.charAt(index);
		if (c < node.c) {
			return get(node.left, str, index, strB);
		} else if (c > node.c) {
			return get(node.right, str, index, strB);
		} else if (node.val == 1) {
			strB.append(node.c);
			return strB.toString();
		} else {
			strB.append(node.c);
			return get(node.mid, str, index + 1, strB);
		}
	}
		
	public void put(String str) {
	    root = put(root, str, 0);
	}
	
	public Node put(Node node, String str, int index) {		    
		    if (index == str.length())
		        return node;		    
		    if (node == null)
		        node = new Node(str.charAt(index));
		    
		    char c = str.charAt(index);
		    
		    if (c < node.c) {
		        node.left = put(node.left, str, index);
		    } else if (c > node.c) {
		        node.right = put(node.right, str, index);
		    } else {
		        node.mid = put(node.mid, str, index + 1);
		        node.val += 1;
		    }		    
		    return node;
		}*/
	

}
