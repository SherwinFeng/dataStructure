package linkedList;

/**
*
*@author Sherwin
*@name 
*@version 1.0
*@description ����ѭ�������ʵ�� 
*			    ѭ������͵��������Ҫ������������ж��Ƿ�������Ľ�β
*			    ������temp.next!=null
*			    ѭ������temp.next!=header
*@ref https://www.cnblogs.com/lixiaolun/p/4643911.html
*
*/
public class CircleLinkedList {
	
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
		}
	}
	
	Node header;
	
	
	/*
	 * 	��������Ĺ��췽��
	 */
	public CircleLinkedList() {
		header = new Node(); //��headerʵ����
		header.value = new Object(); //��valueʵ���� �����ڽڵ��Ƿ����ָ�����ݵķ���ʱ����ָ���쳣
		header.next = header; //��ʼ��ʱheaderָ��header
	}
	
	
	/*
	 * 	��β������ڵ�
	 */
	public void add(Object value) {
		Node node = new Node(value);
		Node tmp = header;
		while(tmp.next != header) { //�ж��Ƿ�������Ľ�β 
			tmp = tmp.next;
		}
		tmp.next = node;
		node.next = header;  //��Ҫ�����һ���ڵ�ָ��ָ��header
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
			while(tmp.next != header) {
				tmp = tmp.next;
			}
			Node node = new Node(value);
			tmp.next = node;
			node.next = header;
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
			while(tmp.next.next != header) {
				tmp = tmp.next;
			}
			tmp.next = header;
			return true;
		}
		//ɾ���ײ����м�Ľڵ�����
		Node tmp = header;
		int count = -1;		
		while(tmp.next != header) {
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
		while(tmp.next.next != header) {
			tmp = tmp.next;
		}
		if(tmp.next.value.equals(value)) {
			tmp.next = header;
			return true;
		}
		//�ж��м�ڵ��Ƿ���ָ������
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
	 * 	ɾ��β���ڵ�
	 */
	public void delete() {
		if(header.next == null) return; //û��Ԫ�ؾͲ���ɾ
		Node tmp = header;
		while(tmp.next.next != header) {
			tmp = tmp.next;
		}
		tmp.next = header;
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
			while(tmp.next != header) {
				tmp = tmp.next;
			}
			tmp.value = value;
			return true;
		}
		//�޸��м估�ײ��ڵ�����
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
			while(tmp.next != header) {
				tmp = tmp.next;
			}
			return tmp.value;
		}
		//�м估�ײ��ڵ�����
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
	 * 	��ȡ����ָ�����ݵĽڵ���±� Ҳ���������ж��������Ƿ����ĳԪ��
	 * 	����ֻ���ǵ�һ��ƥ�� �Ҳ�������-1
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
		if(tmp.value.equals(value)) return count;  //�����ѭ������û�ҵ� ��ô��ʱ��tmp�Ѿ�ָ�����һ���ڵ��� �������������ڵ��жϼ���
		return -1;
	}
	
	
	/*
	 * 	������   ������header
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
	 * 	��ӡ����
	 */
	public void print() {
		System.out.println("��ӡ����");
		Node tmp = header;
		while(tmp.next != header) {
			tmp = tmp.next;
			System.out.print(tmp.value + "\t");
		}
		System.out.println();
	}
		
}
