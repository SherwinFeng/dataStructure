package stack;
import java.util.HashMap;
/**
*
* @author Sherwin
* @name 
* @version 1.0
* @description
*   ����ջ�ṹ���Ƚ���������ص㣬���ǿ����ںܶೡ����ʹ��ջ���磺
*   ʮ����תN���ơ�У�������Ƿ�ƥ�䡢�б༭������׺���ʽת��׺���ʽ�����ʽ��ֵ��
*   ����ʵ������ջ��Ӧ�ã�`
*   ʮ����תN���ơ�У�������Ƿ�ƥ��
* @ref https://www.cnblogs.com/fzz9/p/8167546.html������ת��������ƥ�䣩
* 	   https://blog.csdn.net/Coder_Dacyuan/article/details/79941743����׺ת��׺��
* 	   https://www.cnblogs.com/menglong1108/p/11619896.html����׺���ʽ��ֵ��
* 	      
*/
public class StackUtils {

	static SqStack stack;
	
	/*
	 * ����ջ������Ԫ��
	 */
	public static Object[] popAll(SqStack s) {
		stack = s;
        if(stack.isNull()){
            return null;
        }else{
        	int initNum = stack.getNum(); //ÿ��pop��stack.getNum()�õ���ֵ���ڱ仯����Ҫ�ȴ�����
            Object[] array = new Object[initNum];
            for(int i = 0; i < initNum; i++) {
            	array[i] = stack.pop();
            }
            return array;
        }
	}

	/*
	 *  ʹ��ջ���н���װ��
	 *  hex��ʾ����  num�������ʮ������
	 */
	public static String integerToNhex(Integer num,int hex){
		//�Դ���Ľ��ƽ����ж�
        if(hex <= 0 || hex > 36){
            return "��������Ч�Ľ���";
        }else if(num == 0){
            return "0";
        }else if(num > 0){//����
            SqStack stack = new SqStack(16);  //���16������ȷ ֻ�ǿ�����һ�������ܴ�ķ�Χ
            while(num != 0){           
                int remainder = num % hex;//ȡ��ѹջ  remainder������
                stack.push(remainder);
                num = num / hex ;
            }
            stack.push(num); //���������һλʱ��num�Ѿ�Ϊ0�ˣ����Ի�����whileѭ���������һ����Ӧ����ջ�����������һ�����
            Object[] o = popAll(stack);//��ջȡ������
            StringBuilder sb = new StringBuilder();
            for(Object i : o){
                int in = (int)i;
                //ȡ�����������>=10��Ҫ����ĸ����
                if(in >= 10){
                    char c = (char) (in - 10 + 'a');
                    sb.append(c);
                }else{
                    sb.append(i);
                }
            }
            return sb.toString();
        }else{//����
            num = -num;//��ȥ����
            SqStack stack = new SqStack(16);
            while(num != 0){
                int remainder = num % hex;//ȡ��ѹջ
                stack.push(remainder);
                num = num / hex;
            }
            stack.push(num); 
            Object[] o = popAll(stack);//��ջȡ������
            StringBuilder sb = new StringBuilder();
            sb.append("-");//��Ӹ���
            for(Object i : o){
                int in = (int)i;
                //ȡ�����������>=10��Ҫ����ĸ����
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
	 * ���ʽ�����Ƿ�ƥ��()[]{}
	 * ����˼·���� ���������Ŷ���ջ�����������ž͵���ջ��Ԫ�أ��ж�ջ��Ԫ���Ƿ���������ƥ�䣨����������������ƥ��ʹ������ƥ��ͼ���ѭ��
	 * Ҫע���������ƥ�䵽�����ţ���Ҫ���ж�ջ�Ƿ�Ϊ�գ����û��ֱ�ӷ���false������ֱ��pop�ᱨ��
	 * �����е������Ŷ����������ж�ջ���Ƿ���Ԫ�أ������˵������������û��ƥ�䣬Ҳ����fasle
	 */	
	public static boolean isMatch(String str) {
		char[] arr = str.toCharArray();
		SqStack stack = new SqStack(arr.length);
		for(char tmp : arr) {
			if(tmp == '(' || tmp == '[' || tmp == '{') {
				stack.push(tmp);
			}else if(tmp == ')') {
				if(stack.isNull()){
                  return false;//ջΪ��,ƥ��ʧ��
				}else if((char)(stack.pop()) == '(') {
					continue;
				}else {
					return false;
				}
			}else if(tmp == ']') {
				if(stack.isNull()){
					return false;//ջΪ��,ƥ��ʧ��
				}else if((char)(stack.pop()) == '[') {
					continue;
				}else {
					return false;
				}
			}else if(tmp == '}') {
				if(stack.isNull()){
					return false;//ջΪ��,ƥ��ʧ��
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
	 * ��׺���ʽתΪ��׺���ʽ
	 * 
	 * 	@step
		1.��������������ӵ���׺���ʽ�л�ֱ�����
		2.ջ��ʱ�������������ֱ����ջ
		3.���������ţ�������ջ
		4.���������ţ�ִ�г�ջ�������������׺���ʽ��ֱ����������������
		ע�⣺�����Ų��������׺���ʽ
		5.��������������������������ȼ����ڻ���ڸ��������ջ��Ԫ�أ�Ȼ�󽫸��������ջ
		6.��ջ��ʣ���������ε�����׺���ʽ
	 */
	public static void convert(String str) {
		//��ʼ�����ȼ� ��map����
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		map.put('+', 1); 
		map.put('-', 1); 
		map.put('*', 2); 
		map.put('/', 2); 
		map.put('(', 0); //�����ŵ����ȼ����
		char[] arr = str.toCharArray(); //�洢��׺���ʽ���ַ�����
		SqStack stack = new SqStack(arr.length); //�洢��������������
		StringBuilder out = new StringBuilder(); //�洢���
		for(char tmp : arr) {				     //�����ַ�����
			if(tmp - '0' >= 0 && tmp - '0' <= 9) { //�����ǰ�ַ������֣�ֱ�������1��
				out.append(tmp);
			}else if(tmp == '(') {					//�����ǰ�ַ��������ţ�ֱ����ջ��3��
				stack.push(tmp);
			}else if(tmp == '+' || tmp == '-' ||tmp == '*' ||tmp == '/') { //�����ǰ�ַ���������������ж�
				if(stack.isNull() == true) { 							   //�����ǰջΪ�գ�ֱ��ѹջ��2��
					stack.push(tmp);
				}else {
					//���ȼ��ж�
					if(map.get(tmp) > map.get(stack.peek())) { 			   //�����ǰ�ַ����ȼ�����ջ���ַ���ֱ��ѹջ��5��
						stack.push(tmp);
					}else {												   //�����ǰ�ַ����ȼ�С�ڵ���ջ���ַ���5��
						while(!stack.isNull() && 						   //����Ҫ�ж��Ƿ�ջΪ�գ���Ϊ�����ѭ��������ִ�е�ջ������������ܱ���ָ���쳣
								map.get(tmp) <= map.get(stack.peek())) {   //��Ҫ�жϵ�ǰ�ַ����ȼ��Ƿ���С�ڵ���ջ���ַ�
							out.append(stack.pop());                       //��������������������㣬�ͼ�����ջ��Ϊ���
						}
						stack.push(tmp);                                   //����ѭ���󣬽���ǰԪ��ѹ��ջ��
					}
					
				}
			}else if(tmp == ')') {										   //�����ǰ�ַ��������ţ�4��
				char first = (char)(stack.peek());						   //ִ�е�ջ�������������׺���ʽ��ֱ����������������
				while(first != '(') {
					out.append(stack.pop());
					first = (char)(stack.peek());
				}
				stack.pop();                                               //������ѭ��ʱ����ʱջ��Ԫ���Ѿ��������ţ���Ҫ�������ŵ������������
			}
		}
		while(!stack.isNull()) {                                           //��ջ��ʣ���������ε�����׺���ʽ��6��
			out.append(stack.pop());
		}
		System.out.println(out.toString());                                 //���
		
	}
	
	
	/*
	 * ��׺���ʽ��ֵ
	 * @step
	 * 1����������ֱ����ջ
	 * 2��������������� ��ջ��Ԫ�� �� ջ��Ԫ�� �������㣨��ջ��Ԫ�طŵ�һ������Ȼ�󽫽��ѹ��ջ��
	 * ע�⣺��׺���ʽ��ֻ�����ֺ������
	 */
	public static void calculate(String str) {
		char[] arr = str.toCharArray(); //�洢��׺���ʽ���ַ�����
		SqStack stack = new SqStack(arr.length); //�洢������������
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



























