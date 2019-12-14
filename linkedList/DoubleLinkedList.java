package linkedList;

/**
*
*@author Sherwin
*@name DoubleLinkedList
*@version 1.0
*@description ˫�������ʵ�� ע��˫���������ָ˫��ѭ������
*			 ����ѭ��������������ÿ���ڵ㶼��next prev����ָ�� 
*			 ��˫�������β���ڵ�����ӡ�ɾ�����޸Ľڵ�Ч�ʸ��� �����1.0��ʵ����
*			 ���ڲ���Ͳ���ʱЧ�ʻ����Ը��� ����±����size/2 �͵���β����ʼ������ ��֮��ͷ��ʼ��
*			    ����1.0��δʵ��
*            ���漰��size�ĵط������Ż� 1.0��Ҫ��size ����ִ��size(),���Ӷ���O(n)
*                           �������һ��size���ԣ�ÿ������ ɾ��ʱ��size���и��ģ�������������ȱ���ǻ������϶�
*            �ݺö෽���ǿ��Ը��õ�
*@ref	�ṹͼ��ԭ��ͼ��https://www.cnblogs.com/ChenD/p/7814906.html
*		ʵ�֣�https://www.cnblogs.com/lixiaolun/p/4643931.html
*
*/
public class DoubleLinkedList {
	
	class Node{
		Object  value;
		Node next;
		Node prev;
		public Node() {
			value = null;   
			prev = null;
			next = null;
		}
		public Node(Object value, Node next,Node prev) {
			this.value = value;
			this.next = next;
			this.prev = prev;
		}
		public Node(Object value) {
			this.value = value;
			prev = null;
			next = null;
		}
	}
	
	Node header;
	
	/*
	 * 	˫������Ĺ��췽��
	 */
	public DoubleLinkedList() {
		header = new Node(); // ��headerʵ���� 	 
		header.prev = header; //�տ�ʼheader��next prev��ָ���Լ�
		header.next = header;
		header.value = new Object(); //����valueʵ���� �����ڽڵ��Ƿ����ָ�����ݵķ���ʱ����ָ���쳣
	}
	
	/*
	 * 	��β������ڵ�
	 */
	public void add(Object value) {
		Node node = new Node(value);
		if(header.next == header) {
			node.next = header;
			node.prev = header;
			header.next = node;
			header.prev = node;
		}else {
			node.next = header; //���ڲ��ı�ԭ������ṹ�Ļ���������node��next��prevָ��
			node.prev = header.prev;
			header.prev.next = node; //Ȼ��ͨ��header.prev��λ�����һ���ڵ㣬������nextָ��node
			header.prev = node; //������header��prevָ�����һ���ڵ㼴����Ľڵ�
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
		//��ĩβ�������� ����ڵ���Ϊ���һ���ڵ� ֱ�ӵ���add��������
		if(i == size()) {
			add(value);
			return true;
		}
		//���м估�ײ���������
		Node tmp = header;
		int count = -1;
		while(tmp.next != null) {
			count++;
			if(count == i) {
				Node node = new Node(value);
				node.next = tmp.next;  //���ڲ��ı�ԭ������ṹ�Ļ���������node��next��prevָ��
				node.prev = tmp;
				tmp.next.prev = node;  //Ȼ��ͨ��tmp��λ��ԭ��λ��i�Ľڵ� ������prevָ��node
				tmp.next = node; //����ò���λ�õ���һ���ڵ�tmp��nextָ�����ڵ�
				return true;
			}
			tmp = tmp.next;
		}
		return false;
	}
	
	/*
	 * 	ɾ��β���ڵ� 
	  *     ����˫��������ʱ�临����
	 */
	public void delete() {
		if(header.next == header) return; //û��Ԫ�ؾͲ���ɾ
		header.prev.prev.next = header;
		header.prev = header.prev.prev;
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
			delete();
			return true;
		}
		//ɾ���ײ����м�Ľڵ�����
		Node tmp = header;
		int count = -1;		
		while(tmp.next != null) {
			if(count == i) {  //����˫���õĴ��� ���Կ���ֱ��ѭ������ɾ���ڵ���±� ����ǵ��������ѭ�������Ҫѭ������ɾ���ڵ����һ���ڵ�                 
				tmp.prev.next = tmp.next; //������˳��ɵ���
				tmp.next.prev = tmp.prev;
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
		if(header.next == header) return false; //û��Ԫ�ؾͲ���ɾ
		//�ж����һ���ڵ��Ƿ���ָ������
		if(header.prev.value.equals(value)) {
			delete(); //������Ͼ�ɾ��β���ڵ� ����delete()����
			return true;
		}
		//�жϵ�һ�����м�ڵ��Ƿ���ָ������
		Node tmp = header;
		while(tmp.next != header) {
			if(tmp.value.equals(value)) {
				tmp.prev.next = tmp.next; //������˳��ɵ���
				tmp.next.prev = tmp.prev;
				return true;
			}
			tmp = tmp.next;
		}
		return false;
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
			header.prev.value = value;
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
			return header.prev.value;
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
		if(tmp.value.equals(value)) return count;
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
	 *	 ��ӡ����
     */
    void print()
    {
        System.out.print("��ӡ˫��ѭ������");
        Node temp = header;
        while(temp.next != header)
        {
            System.out.print(temp.next.value+"\t");
            temp=temp.next;
        }
        System.out.println();
    }
}
