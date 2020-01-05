package stack;
/**
*
* @author Sherwin
* @name 
* @version 1.0
* @description 
*   顺序栈(SqStack)一般用数组来实现
*   三个元素：
* ①存储数据的数组
* ②最大容量
* ③栈顶指针(用整型数表示，即数组下标)
*   五个方法：
* ①判断栈空 栈满
* ②压栈push；弹栈pop
* ③查询栈顶元素
* @ref https://www.cnblogs.com/fzz9/p/8167546.html
*/
public class SqStack {

	private Object[] data;
	private int maxSize;
	private int top;
	
	/*
	 * 构造方法
	 */
	public SqStack(int maxSize) {
		this.maxSize = maxSize;
		this.data = new Object[maxSize];
		this.top = -1; //栈顶指针初始化为1
	}
	
	/*
	 * 判断是否栈空
	 */
	public boolean isNull() {
		boolean flag = top<=-1 ? true:false;
		return flag;
	}
	
	/*
	 * 判断是否栈满
	 */
	public boolean isFull() {
		boolean flag = top==maxSize-1 ? true:false;
		return flag;
	}
	
	/*
	 * 压栈
	 */
	public boolean push(Object object) {
		if(isFull()) { //先判断是否栈满
			return false;
		}else {
			data[++top] = object; //指针先移动
			return true;
		}
	}
	
	/*
	 * 弹栈
	 */
	public Object pop() {
		if(isNull()) { //先判断是否栈空
			return null;
		}else {
			Object tmp = data[top]; //先取出栈顶元素
			top--; //指针下移
			return tmp;
		}
	}
	
	/*
	 * 获得元素个数
	 */
	public int getNum() {
		return this.top + 1;
	}
	
	/*
	 * 查询栈顶元素，但栈顶元素不出栈
	 */
	public Object peek() {
		if(isNull()) { //先判断是否栈空
			return null;
		}else {
			return data[top];
		}
	}
}
































