package stack;
import java.util.HashMap;
/**
*
* @author Sherwin
* @name 
* @version 1.0
* @description
*   根据栈结构“先进后出”的特点，我们可以在很多场景中使用栈，如：
*   十进制转N进制、校验括号是否匹配、行编辑器、中缀表达式转后缀表达式、表达式求值等
*   下面实现两个栈的应用：`
*   十进制转N进制、校验括号是否匹配
* @ref https://www.cnblogs.com/fzz9/p/8167546.html（数制转换、符号匹配）
* 	   https://blog.csdn.net/Coder_Dacyuan/article/details/79941743（中缀转后缀）
* 	   https://www.cnblogs.com/menglong1108/p/11619896.html（后缀表达式求值）
* 	      
*/
public class StackUtils {

	static SqStack stack;
	
	/*
	 * 弹出栈中所有元素
	 */
	public static Object[] popAll(SqStack s) {
		stack = s;
        if(stack.isNull()){
            return null;
        }else{
        	int initNum = stack.getNum(); //每次pop，stack.getNum()得到的值都在变化所以要先存起来
            Object[] array = new Object[initNum];
            for(int i = 0; i < initNum; i++) {
            	array[i] = stack.pop();
            }
            return array;
        }
	}

	/*
	 *  使用栈进行进制装换
	 *  hex表示进制  num是输入的十进制数
	 */
	public static String integerToNhex(Integer num,int hex){
		//对传入的进制进行判断
        if(hex <= 0 || hex > 36){
            return "请输入有效的进制";
        }else if(num == 0){
            return "0";
        }else if(num > 0){//正数
            SqStack stack = new SqStack(16);  //这个16并不精确 只是考虑了一个尽可能大的范围
            while(num != 0){           
                int remainder = num % hex;//取余压栈  remainder是余数
                stack.push(remainder);
                num = num / hex ;
            }
            stack.push(num); //当除到最后一位时，num已经为0了，所以会跳出while循环，但最后一个商应该入栈，所以这里加一条语句
            Object[] o = popAll(stack);//弹栈取出余数
            StringBuilder sb = new StringBuilder();
            for(Object i : o){
                int in = (int)i;
                //取出的数字如果>=10需要用字母代替
                if(in >= 10){
                    char c = (char) (in - 10 + 'a');
                    sb.append(c);
                }else{
                    sb.append(i);
                }
            }
            return sb.toString();
        }else{//负数
            num = -num;//先去负号
            SqStack stack = new SqStack(16);
            while(num != 0){
                int remainder = num % hex;//取余压栈
                stack.push(remainder);
                num = num / hex;
            }
            stack.push(num); 
            Object[] o = popAll(stack);//弹栈取出余数
            StringBuilder sb = new StringBuilder();
            sb.append("-");//添加负号
            for(Object i : o){
                int in = (int)i;
                //取出的数字如果>=10需要用字母代替
                if(in >= 10){
                    char c = (char) (in - 10 + 'a');
                    sb.append(c);
                }else{
                    sb.append(i);
                }
            }
            return sb.toString();
        }
		
	}
	
		
	/*
	 * 表达式括号是否匹配()[]{}
	 * 基本思路就是 遇到左括号都入栈，遇到右括号就弹出栈顶元素，判断栈顶元素是否与右括号匹配（三种情况），如果不匹配就错误，如果匹配就继续循环
	 * 要注意的特判是匹配到右括号，需要先判断栈是否为空，如果没空直接返回false，否则直接pop会报错
	 * 把所有的右括号都遍历后，再判断栈中是否有元素，如果有说明还有左括号没有匹配，也返回fasle
	 */	
	public static boolean isMatch(String str) {
		char[] arr = str.toCharArray();
		SqStack stack = new SqStack(arr.length);
		for(char tmp : arr) {
			if(tmp == '(' || tmp == '[' || tmp == '{') {
				stack.push(tmp);
			}else if(tmp == ')') {
				if(stack.isNull()){
                  return false;//栈为空,匹配失败
				}else if((char)(stack.pop()) == '(') {
					continue;
				}else {
					return false;
				}
			}else if(tmp == ']') {
				if(stack.isNull()){
					return false;//栈为空,匹配失败
				}else if((char)(stack.pop()) == '[') {
					continue;
				}else {
					return false;
				}
			}else if(tmp == '}') {
				if(stack.isNull()){
					return false;//栈为空,匹配失败
				}else if((char)(stack.pop()) == '{') {
					continue;
				}else {
					return false;
				}
			}
		}
		return stack.isNull();
		
	}
	
	
	/*
	 * 中缀表达式转为后缀表达式
	 * 
	 * 	@step
		1.遇到操作数：添加到后缀表达式中或直接输出
		2.栈空时：遇到运算符，直接入栈
		3.遇到左括号：将其入栈
		4.遇到右括号：执行出栈操作，输出到后缀表达式，直到弹出的是左括号
		注意：左括号不输出到后缀表达式
		5.遇到其他运算符：弹出所有优先级大于或等于该运算符的栈顶元素，然后将该运算符入栈
		6.将栈中剩余内容依次弹出后缀表达式
	 */
	public static void convert(String str) {
		//初始化优先级 用map来存
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		map.put('+', 1); 
		map.put('-', 1); 
		map.put('*', 2); 
		map.put('/', 2); 
		map.put('(', 0); //左括号的优先级最低
		char[] arr = str.toCharArray(); //存储中缀表达式的字符数组
		SqStack stack = new SqStack(arr.length); //存储操作符和左括号
		StringBuilder out = new StringBuilder(); //存储输出
		for(char tmp : arr) {				     //遍历字符数组
			if(tmp - '0' >= 0 && tmp - '0' <= 9) { //如果当前字符是数字，直接输出（1）
				out.append(tmp);
			}else if(tmp == '(') {					//如果当前字符是左括号，直接入栈（3）
				stack.push(tmp);
			}else if(tmp == '+' || tmp == '-' ||tmp == '*' ||tmp == '/') { //如果当前字符是运算符，进行判断
				if(stack.isNull() == true) { 							   //如果当前栈为空，直接压栈（2）
					stack.push(tmp);
				}else {
					//优先级判断
					if(map.get(tmp) > map.get(stack.peek())) { 			   //如果当前字符优先级大于栈顶字符，直接压栈（5）
						stack.push(tmp);
					}else {												   //如果当前字符优先级小于等于栈顶字符（5）
						while(!stack.isNull() && 						   //首先要判断是否栈为空（因为在这个循环中有在执行弹栈操作）否则可能报空指针异常
								map.get(tmp) <= map.get(stack.peek())) {   //还要判断当前字符优先级是否还是小于等于栈顶字符
							out.append(stack.pop());                       //如果上述两个条件都满足，就继续弹栈作为输出
						}
						stack.push(tmp);                                   //跳出循环后，将当前元素压入栈中
					}
					
				}
			}else if(tmp == ')') {										   //如果当前字符是右括号（4）
				char first = (char)(stack.peek());						   //执行弹栈操作，输出到后缀表达式，直到弹出的是左括号
				while(first != '(') {
					out.append(stack.pop());
					first = (char)(stack.peek());
				}
				stack.pop();                                               //当跳出循环时，此时栈顶元素已经是左括号，需要将左括号弹出，但不输出
			}
		}
		while(!stack.isNull()) {                                           //将栈中剩余内容依次弹出后缀表达式（6）
			out.append(stack.pop());
		}
		System.out.println(out.toString());                                 //输出
		
	}
	
	
	/*
	 * 后缀表达式求值
	 * @step
	 * 1、遇到数字直接入栈
	 * 2、遇到运算符，则将 次栈顶元素 和 栈顶元素 进行运算（次栈顶元素放第一个），然后将结果压入栈中
	 * 注意：后缀表达式中只有数字和运算符
	 */
	public static void calculate(String str) {
		char[] arr = str.toCharArray(); //存储后缀表达式的字符数组
		SqStack stack = new SqStack(arr.length); //存储操作符和数字
		for(char tmp : arr) {
			if(tmp - '0' >= 0 && tmp - '0' <= 9) {
				stack.push(tmp);
			}else {
				int a = (char)stack.pop() - '0';
				int b = (char)stack.pop() - '0';
				int c = 0;
				if(tmp == '+') {
					c = b + a;
				}else if(tmp == '-') {
					c = b - a;
				}else if(tmp == '*') {
					c = b * a;
				}else if(tmp == '/') {
					c = b / a;
				}
				char currentResult =  (char) (c + '0');
				stack.push(currentResult);
			}
		}
		int finalResult = (char)stack.peek() - '0';
		System.out.println(finalResult);
	}
	
}



























