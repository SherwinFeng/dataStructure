package linkedList;
/**
*
*@author Sherwin
*@name SingleLinkedList
*@version 1.0
*@description ���������ʵ��
*@ref ������https://www.cnblogs.com/lixiaolun/p/4643886.html
*	   
*/
public class SingleLinkedList {

	//����ڵ�
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
//			this.next = new Node(); ���ﲻ��Ϊnextʵ����һ��next ��Ϊʵ������ node��һ���ڵ�Ͳ���null�� ֮����жϻ����                 
		}
	}
	
	Node header;
	
	
	/*
	 * 	��������Ĺ��췽��
	  *     ��headerʵ���� ����valueʵ���� �����ڽڵ��Ƿ����ָ�����ݵķ���ʱ����ָ���쳣
	 */
	public SingleLinkedList() {
		header = new Node();
		header.value = new Object();
		header.next = null;
	}
	
	
	/*
	 * 	��β������ڵ�
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
	 * 	��ָ���±�i����ڵ� 
	 * 	������ �������ɹ� 
	 */
	public boolean insert(int i,Object value) {
		//���곬����Χ
		if(i < 0 || i > size()) { 
			return false;
		}
		//��ĩβ�������� ����ڵ���Ϊ���һ���ڵ�
		if(i == size()) {
			Node tmp = header;
			while(tmp.next != null) {
				tmp = tmp.next;
			}
			Node node = new Node(value);
			tmp.next = node;
			return true;
		}
		//���м估�ײ���������
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
	 * 	ɾ�������е�i��Ԫ��
	 */
	public boolean delete(int i) {
		//���곬����Χ
		if(i < 0 || i > size() - 1) { 
			return false;
		}
		//ɾ��β���ڵ�����
		if(i == size() - 1) {
			Node tmp = header;
			while(tmp.next.next != null) {
				tmp = tmp.next;
			}
			tmp.next = null;
			return true;
		}
		//ɾ���ײ����м�Ľڵ�����
		Node tmp = header;
		int count = -1;		
		while(tmp.next != null) {
			if(count == i - 1) {  //Ӧ�öԴ�ɾ���ڵ����һ���ڵ���в�����ʹ��nextָ��ָ���ɾ��Ԫ�ص�һ���ڵ�
				tmp.next = tmp.next.next;
				return true;
			}
			count++;
			tmp = tmp.next;
		}
		return false;
	}
	
	
	/*
	 * 	ɾ�������а���ָ�����ݵĽڵ�
	 */
	public boolean delete(Object value) {
		//�ж����һ���ڵ��Ƿ���ָ������
		Node tmp = header;
		while(tmp.next.next != null) {
			tmp = tmp.next;
		}
		if(tmp.next.value.equals(value)) {
			tmp.next = null;
			return true;
		}
		//�ж��м�ڵ��Ƿ���ָ������
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
	 * 	ɾ��β���ڵ�
	 */
	public void delete() {
		if(header.next == header) return; //û��Ԫ�ؾͲ���ɾ
		Node tmp =header;
		while(tmp.next.next != null) {
			tmp = tmp.next;
		}
		tmp.next = null;
	}
	
	
	/*
	 * 	�޸�ָ���±�i�Ľڵ�
	 */
	public boolean update(int i,Object value) {
		//���곬����Χ
		if(i < 0 || i > size() - 1) { 
			return false;
		}
		//�޸�β���ڵ�����
		if(i == size() - 1) {
			Node tmp = header;
			while(tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.value = value;
			return true;
		}
		//�޸��м估�ײ��ڵ�����
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
	 * 	��ȡ����ĵ�i��λ�õ�Ԫ�ص�value
	 */
	public Object get(int i) {
		//���곬����Χ
		if(i < 0 || i > size() - 1) { 
			return false;
		}
		//β���ڵ�����
		if(i == size() - 1) {
			Node tmp = header;
			while(tmp.next != null) {
				tmp = tmp.next;
			}
			return tmp.value;
		}
		//�м估�ײ��ڵ�����
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
	 * 	��ȡ����ָ�����ݵĽڵ���±� Ҳ���������ж��������Ƿ����ĳԪ��
	 * 	����ֻ���ǵ�һ��ƥ�� �Ҳ�������-1
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
	 * 	������   ������header
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
	 * 	��ӡ����
	 */
	public void print() {
		System.out.println("��ӡ����");
		Node tmp = header;
		while(tmp.next != null) {
			tmp = tmp.next;
			System.out.print(tmp.value + "\t");
		}
		System.out.println();
	}















}
