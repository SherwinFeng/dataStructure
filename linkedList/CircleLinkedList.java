package linkedList;

/**
*
*@author Sherwin
*@name 
*@version 1.0
*@description 单向循环链表的实现 
*			    循环链表和单链表的主要差别就在于如何判断是否到了链表的结尾
*			    单链表：temp.next!=null
*			    循环链表：temp.next!=header
*@ref https://www.cnblogs.com/lixiaolun/p/4643911.html
*
*/
public class CircleLinkedList {
	
	//定义节点
	class Node{
		Object  value;
		Node next;
		public Node() {
			value = null;   
			next = null;
		}
		public Node(Object value, Node next) {
			this.value = value;
			this.next = next;
		}
		public Node(Object value) {
			this.value = value;
			this.next = null;
		}
	}
	
	Node header;
	
	
	/*
	 * 	定义链表的构造方法
	 */
	public CircleLinkedList() {
		header = new Node(); //将header实例化
		header.value = new Object(); //将value实例化 否则在节点是否包含指定内容的方法时报空指针异常
		header.next = header; //初始化时header指向header
	}
	
	
	/*
	 * 	在尾部插入节点
	 */
	public void add(Object value) {
		Node node = new Node(value);
		Node tmp = header;
		while(tmp.next != header) { //判断是否到了链表的结尾 
			tmp = tmp.next;
		}
		tmp.next = node;
		node.next = header;  //需要将最后一个节点指针指向header
	}

	
	/*
	 * 	在指定下标i插入节点 
	 * 	返回真 代表插入成功 
	 */
	public boolean insert(int i,Object value) {
		//坐标超过范围
		if(i < 0 || i > size()) { 
			return false;
		}
		//在末尾插入的情况 插入节点作为最后一个节点
		if(i == size()) {
			Node tmp = header;
			while(tmp.next != header) {
				tmp = tmp.next;
			}
			Node node = new Node(value);
			tmp.next = node;
			node.next = header;
			return true;
		}
		//在中间及首部插入的情况
		Node tmp = header;
		int count = -1;
		while(tmp.next != null) {
			count++;
			if(count == i) {
				Node node = new Node(value);
				node.next = tmp.next;
				tmp.next = node;
				return true;
			}
			tmp = tmp.next;
		}
		return false;
	}

	
	/*
	 * 	删除链表中第i个元素
	 */
	public boolean delete(int i) {
		//坐标超过范围
		if(i < 0 || i > size() - 1) { 
			return false;
		}
		//删除尾部节点的情况
		if(i == size() - 1) {
			Node tmp = header;
			while(tmp.next.next != header) {
				tmp = tmp.next;
			}
			tmp.next = header;
			return true;
		}
		//删除首部及中间的节点的情况
		Node tmp = header;
		int count = -1;		
		while(tmp.next != header) {
			if(count == i - 1) {  //应该对待删除节点的上一个节点进行操作，使其next指针指向待删除元素的一个节点
				tmp.next = tmp.next.next;
				return true;
			}
			count++;
			tmp = tmp.next;
		}
		return false;
	}
	
	
	/*
	 * 	删除链表中包含指定内容的节点
	 */
	public boolean delete(Object value) {
		//判断最后一个节点是否含有指定内容
		Node tmp = header;
		while(tmp.next.next != header) {
			tmp = tmp.next;
		}
		if(tmp.next.value.equals(value)) {
			tmp.next = header;
			return true;
		}
		//判断中间节点是否含有指定内容
		tmp = header;
		while(tmp.next.next != header) {
			if(tmp.next.value.equals(value)) {
				tmp.next = tmp.next.next;
				return true;
			}
			tmp = tmp.next;
		}
		return false;
	}
	
	
	/*
	 * 	删除尾部节点
	 */
	public void delete() {
		if(header.next == null) return; //没有元素就不用删
		Node tmp = header;
		while(tmp.next.next != header) {
			tmp = tmp.next;
		}
		tmp.next = header;
	}
	
	
	/*
	 * 	修改指定下标i的节点
	 */
	public boolean update(int i,Object value) {
		//坐标超过范围
		if(i < 0 || i > size() - 1) { 
			return false;
		}
		//修改尾部节点的情况
		if(i == size() - 1) {
			Node tmp = header;
			while(tmp.next != header) {
				tmp = tmp.next;
			}
			tmp.value = value;
			return true;
		}
		//修改中间及首部节点的情况
		Node tmp = header;
		int count = -1;
		while(tmp.next != header) {
			if(count == i) {
				tmp.value = value;
				return true;
			}
			count++;
			tmp = tmp.next;
		}
		return false;
	}
	
	
	/*
	 * 	获取链表的第i个位置的元素的value
	 */
	public Object get(int i) {
		//坐标超过范围
		if(i < 0 || i > size() - 1) { 
			return false;
		}
		//尾部节点的情况
		if(i == size() - 1) {
			Node tmp = header;
			while(tmp.next != header) {
				tmp = tmp.next;
			}
			return tmp.value;
		}
		//中间及首部节点的情况
		Node tmp = header;
		int count = -1;
		while(tmp.next != header) {
			if(count == i) {
				return tmp.value;
			}
			count++;
			tmp = tmp.next;
		}
		return null;
		
	}
	
		
	/*
	 * 	获取包含指定内容的节点的下标 也可以用于判断链表中是否存在某元素
	 * 	这里只考虑第一个匹配 找不到返回-1
	 */
	public int getIndex(Object value) {
		Node tmp = header;
		int count = -1;
		while(tmp.next != header) {
			if(tmp.value.equals(value)) {
				return count;
			}
			count++;
			tmp = tmp.next;
		}
		if(tmp.value.equals(value)) return count;  //如果在循环体中没找到 那么这时的tmp已经指向最后一个节点了 因此在这里对最后节点判断即可
		return -1;
	}
	
	
	/*
	 * 	链表长度   不包含header
	 */
	public int size() {
		int count = 0;
		Node tmp = header;
		while(tmp.next != header) {
			tmp = tmp.next;
			count++;
		}
		return count;
	}


	/*
	 * 	打印链表
	 */
	public void print() {
		System.out.println("打印链表：");
		Node tmp = header;
		while(tmp.next != header) {
			tmp = tmp.next;
			System.out.print(tmp.value + "\t");
		}
		System.out.println();
	}
		
}
