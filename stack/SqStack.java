package stack;
/**
*
* @author Sherwin
* @name 
* @version 1.0
* @description 
*   ˳��ջ(SqStack)һ����������ʵ��
*   ����Ԫ�أ�
* �ٴ洢���ݵ�����
* ���������
* ��ջ��ָ��(����������ʾ���������±�)
*   ���������
* ���ж�ջ�� ջ��
* ��ѹջpush����ջpop
* �۲�ѯջ��Ԫ��
* @ref https://www.cnblogs.com/fzz9/p/8167546.html
*/
public class SqStack {

	private Object[] data;
	private int maxSize;
	private int top;
	
	/*
	 * ���췽��
	 */
	public SqStack(int maxSize) {
		this.maxSize = maxSize;
		this.data = new Object[maxSize];
		this.top = -1; //ջ��ָ���ʼ��Ϊ1
	}
	
	/*
	 * �ж��Ƿ�ջ��
	 */
	public boolean isNull() {
		boolean flag = top<=-1 ? true:false;
		return flag;
	}
	
	/*
	 * �ж��Ƿ�ջ��
	 */
	public boolean isFull() {
		boolean flag = top==maxSize-1 ? true:false;
		return flag;
	}
	
	/*
	 * ѹջ
	 */
	public boolean push(Object object) {
		if(isFull()) { //���ж��Ƿ�ջ��
			return false;
		}else {
			data[++top] = object; //ָ�����ƶ�
			return true;
		}
	}
	
	/*
	 * ��ջ
	 */
	public Object pop() {
		if(isNull()) { //���ж��Ƿ�ջ��
			return null;
		}else {
			Object tmp = data[top]; //��ȡ��ջ��Ԫ��
			top--; //ָ������
			return tmp;
		}
	}
	
	/*
	 * ���Ԫ�ظ���
	 */
	public int getNum() {
		return this.top + 1;
	}
	
	/*
	 * ��ѯջ��Ԫ�أ���ջ��Ԫ�ز���ջ
	 */
	public Object peek() {
		if(isNull()) { //���ж��Ƿ�ջ��
			return null;
		}else {
			return data[top];
		}
	}
}
































