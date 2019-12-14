package linkedList;
/**
*
*@author Sherwin
*@name SingleLinkedList
*@version 1.0
*@description 单向链表的实现
*@ref 单链表：https://www.cnblogs.com/lixiaolun/p/4643886.html
*	   
*/
public class SingleLinkedList {

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
//			this.next = new Node(); 这里不能为next实例化一个next 因为实例化后 node下一个节点就不是null了 之后的判断会出错                 
		}
	}
	
	Node header;
	
	
	/*
	 * 	定义链表的构造方法
	  *     将header实例化 并将value实例化 否则在节点是否包含指定内容的方法时报空指针异常
	 */
	public SingleLinkedList() {
		header = new Node();
		header.value = new Object();
		header.next = null;
	}
	
	
	/*
	 * 	在尾部插入节点
	 */
	public void add(Object value) {
		Node node = new Node(value);
		if(header.next == null) {
			header.next = node;
		}else {
			Node tmp = header;
			while(tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = node;
		}
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
			while(tmp.next != null) {
				tmp = tmp.next;
			}
			Node node = new Node(value);
			tmp.next = node;
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
			while(tmp.next.next != null) {
				tmp = tmp.next;
			}
			tmp.next = null;
			return true;
		}
		//删除首部及中间的节点的情况
		Node tmp = header;
		int count = -1;		
		while(tmp.next != null) {
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
		while(tmp.next.next != null) {
			tmp = tmp.next;
		}
		if(tmp.next.value.equals(value)) {
			tmp.next = null;
			return true;
		}
		//判断中间节点是否含有指定内容
		tmp = header;
		while(tmp.next.next != null) {
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
		if(header.next == header) return; //没有元素就不用删
		Node tmp =header;
		while(tmp.next.next != null) {
			tmp = tmp.next;
		}
		tmp.next = null;
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
			while(tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.value = value;
			return true;
		}
		//修改中间及首部节点的情况
		Node tmp = header;
		int count = -1;
		while(tmp.next != null) {
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
			while(tmp.next != null) {
				tmp = tmp.next;
			}
			return tmp.value;
		}
		//中间及首部节点的情况
		Node tmp = header;
		int count = -1;
		while(tmp.next != null) {
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
		while(tmp.next != null) {
			if(tmp.value.equals(value)) {
				return count;
			}
			count++;
			tmp = tmp.next;
		}
		if(tmp.value.equals(value)) return count;
		return -1;
	}
	
	
	/*
	 * 	链表长度   不包含header
	 */
	public int size() {
		int count = 0;
		Node tmp = header;
		while(tmp.next != null) {
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
		while(tmp.next != null) {
			tmp = tmp.next;
			System.out.print(tmp.value + "\t");
		}
		System.out.println();
	}















}
