package linkedList;

/**
*
*@author Sherwin
*@name DoubleLinkedList
*@version 1.0
*@description 双向链表的实现 注：双向链表就是指双向循环链表
*			 ①与循环链表的区别就是每个节点都又next prev两个指向 
*			 ②双向链表对尾部节点的增加、删除、修改节点效率更高 这个在1.0中实现了
*			 ③在插入和查找时效率还可以更高 如果下标大于size/2 就到从尾部开始往回找 反之从头开始找
*			    但在1.0中未实现
*            ④涉及到size的地方可以优化 1.0中要求size 就需执行size(),复杂度是O(n)
*                           可以添加一个size属性，每次增加 删除时对size进行更改，但是这样做的缺点是会提高耦合度
*            ⑤好多方法是可以复用的
*@ref	结构图及原理图：https://www.cnblogs.com/ChenD/p/7814906.html
*		实现：https://www.cnblogs.com/lixiaolun/p/4643931.html
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
	 * 	双向链表的构造方法
	 */
	public DoubleLinkedList() {
		header = new Node(); // 将header实例化 	 
		header.prev = header; //刚开始header的next prev都指向自己
		header.next = header;
		header.value = new Object(); //并将value实例化 否则在节点是否包含指定内容的方法时报空指针异常
	}
	
	/*
	 * 	在尾部插入节点
	 */
	public void add(Object value) {
		Node node = new Node(value);
		if(header.next == header) {
			node.next = header;
			node.prev = header;
			header.next = node;
			header.prev = node;
		}else {
			node.next = header; //先在不改变原有链表结构的基础上设置node的next、prev指向
			node.prev = header.prev;
			header.prev.next = node; //然后通过header.prev定位到最后一个节点，让它的next指向node
			header.prev = node; //最后更新header的prev指向最后一个节点即插入的节点
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
		//在末尾插入的情况 插入节点作为最后一个节点 直接调用add方法即可
		if(i == size()) {
			add(value);
			return true;
		}
		//在中间及首部插入的情况
		Node tmp = header;
		int count = -1;
		while(tmp.next != null) {
			count++;
			if(count == i) {
				Node node = new Node(value);
				node.next = tmp.next;  //先在不改变原有链表结构的基础上设置node的next、prev指向
				node.prev = tmp;
				tmp.next.prev = node;  //然后通过tmp定位到原先位于i的节点 设置其prev指向node
				tmp.next = node; //最后让插入位置的上一个节点tmp的next指向插入节点
				return true;
			}
			tmp = tmp.next;
		}
		return false;
	}
	
	/*
	 * 	删除尾部节点 
	  *     利用双向链表降低时间复杂性
	 */
	public void delete() {
		if(header.next == header) return; //没有元素就不用删
		header.prev.prev.next = header;
		header.prev = header.prev.prev;
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
			delete();
			return true;
		}
		//删除首部及中间的节点的情况
		Node tmp = header;
		int count = -1;		
		while(tmp.next != null) {
			if(count == i) {  //由于双引用的存在 所以可以直接循环到待删除节点的下标 如果是单链表或单向循环链表就要循环到待删除节点的上一个节点                 
				tmp.prev.next = tmp.next; //这两行顺序可调换
				tmp.next.prev = tmp.prev;
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
		if(header.next == header) return false; //没有元素就不用删
		//判断最后一个节点是否含有指定内容
		if(header.prev.value.equals(value)) {
			delete(); //如果符合就删除尾部节点 调用delete()即可
			return true;
		}
		//判断第一个及中间节点是否含有指定内容
		Node tmp = header;
		while(tmp.next != header) {
			if(tmp.value.equals(value)) {
				tmp.prev.next = tmp.next; //这两行顺序可调换
				tmp.next.prev = tmp.prev;
				return true;
			}
			tmp = tmp.next;
		}
		return false;
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
			header.prev.value = value;
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
			return header.prev.value;
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
		if(tmp.value.equals(value)) return count;
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
	 *	 打印链表
     */
    void print()
    {
        System.out.print("打印双向循环链表：");
        Node temp = header;
        while(temp.next != header)
        {
            System.out.print(temp.next.value+"\t");
            temp=temp.next;
        }
        System.out.println();
    }
}
