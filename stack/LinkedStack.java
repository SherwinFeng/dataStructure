package stack;
/**
*
* @author Sherwin
* @name 
* @version 1.0
* @description
* 链式栈(LinkedStack)用链表来实现
* 一个元素：
* ①栈顶指针(用节点类表示，本质就是链表中的header)
* 四个方法：
* ①判断栈空（逻辑上永远都不会栈满，除非电脑没内存了）
* ②压栈push；弹栈pop
* @tips 
* 链表至上而下引用 push和pop发生在top和第一个节点之间 本质上就是链表的插入和删除
*
*/
public class LinkedStack {
	
	private Node top;
	
	public LinkedStack() {
		top = new Node();
		top.next = null;
	}
	
	/*
	 * 判断是否栈空
	 */
	public boolean isNull() {
		boolean flag = top.next==null ? true:false;
		return flag;
	}
	
	/*
	 * 压栈
	 */
	public void push(Object data) {
		Node tmp = new Node(data);
		if(top.next == null) { //第一次插入
			top.next = tmp;
		}else {
			tmp.next = top.next;
			top.next = tmp;
		}	
	}
	
	/*
	 * 弹栈
	 */
	public Object pop() {
		if(top.next == null) {
			return null;
		}
		if(top.next.next == null) { //如果只剩一个元素
			Node tmp = top.next;
			top.next = null;
			return tmp.data;
		}else {
			Node tmp = top.next;
			top.next = top.next.next;
			return tmp.data;
		}
			
 	}
	
	/*
	 * 定义节点
	 */
	class Node{
		Object data;
		Node next;
		public Node() {
			this.data = null;
			this.next = null;
		}
		public Node(Object data) {
			this.data = data;
		}
	}
}
