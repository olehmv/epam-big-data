package epam.java.generic;

public class LinkedStack<T> {

	public  class Node{
		T item;
		Node next;
		Node(){
			item=null;
			next=null;
		}
		public Node(T item, LinkedStack<T>.Node next) {
			super();
			this.item = item;
			this.next = next;
		}
		boolean end(){return item==null&&next==null;}	
	}
	public Node top=new Node();
	public void  push(T t){
		top=new Node(t,top);
	}
	public T pop(){
		T result=top.item;
		if(!top.end()){
			top=top.next;
		}
		return result;
	}
	public static void main(String[] args) {
		LinkedStack<String> list=new LinkedStack<>();
		for(String next:"Hello generic class".split(" "))list.push(next);
		String s;
		while((s=list.pop())!=null){
			System.out.println(s);
		}
	}
}
