package stack;
/**
*
* @author Sherwin
* @name 
* @version 1.0
* @description
* ��ʽջ(LinkedStack)��������ʵ��
* һ��Ԫ�أ�
* ��ջ��ָ��(�ýڵ����ʾ�����ʾ��������е�header)
* �ĸ�������
* ���ж�ջ�գ��߼�����Զ������ջ�������ǵ���û�ڴ��ˣ�
* ��ѹջpush����ջpop
* @tips 
* �������϶������� push��pop������top�͵�һ���ڵ�֮�� �����Ͼ�������Ĳ����ɾ��
*
*/
public class LinkedStack {
	
	private Node top;
	
	public LinkedStack() {
		top = new Node();
		top.next = null;
	}
	
	/*
	 * �ж��Ƿ�ջ��
	 */
	public boolean isNull() {
		boolean flag = top.next==null ? true:false;
		return flag;
	}
	
	/*
	 * ѹջ
	 */
	public void push(Object data) {
		Node tmp = new Node(data);
		if(top.next == null) { //��һ�β���
			top.next = tmp;
		}else {
			tmp.next = top.next;
			top.next = tmp;
		}	
	}
	
	/*
	 * ��ջ
	 */
	public Object pop() {
		if(top.next == null) {
			return null;
		}
		if(top.next.next == null) { //���ֻʣһ��Ԫ��
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
	 * ����ڵ�
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
