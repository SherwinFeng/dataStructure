package stack;
/**
*
*@author Sherwin
*@name 
*@version 1.0
*@description
*
*/
public class Test {

	public static void main(String[] args) {

        //----------------------------------------------------对栈基本方法的测试
		
		//测试线序栈
//		//初始化栈(char类型)
//        SqStack stack = new SqStack(3);
//        
//        //2状态
//        System.out.println("栈是否为空："+stack.isNull());
//        System.out.println("栈是否已满："+stack.isFull());
//        
//        //2操作
//        //依次压栈
//        stack.push('a');
//        stack.push('b');
//        stack.push('c');
//        System.out.println("栈是否已满："+stack.isFull());
//        
//        //依次弹栈
//        System.out.println("弹栈顺序：");
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
		
		//测试链式栈
//		LinkedStack ls = new LinkedStack();
//        
//        //1状态
//        System.out.println("栈是否为空："+ls.isNull());
//        
//        //2操作
//        //依次压栈
//        ls.push('a');
//        ls.push('b');       
//        ls.push('c');        
//        //依次弹栈
//        System.out.println("弹栈顺序：");
//        System.out.println(ls.pop());
//        System.out.println(ls.pop());
//        System.out.println(ls.pop());
		
	
        
        //----------------------------------------------------对栈的应用的测试
		//测试数制转换
//        String s = StackUtils.integerToNhex(123456, 16);
//        System.out.println("转换得到的16进制数为:"+s);
		//测试括号匹配
//		String str1 = "i((l)o[v{e}]y)o{u}!";//表达式1：(()[{}]){}
//		String str2 = "you((do)[not{}])know{}!)";//表达式2：(()[{}]){})
//		boolean match1 = StackUtils.isMatch(str1);
//		boolean match2 = StackUtils.isMatch(str2);
//		System.out.println("str1中的括号是否匹配："+match1);
//		System.out.println("str2中的括号是否匹配："+match2);
		
		//测试中缀表达式转为后缀表达式
//		StackUtils.convert("1+((2+3)*4)-5");
		
		//测试后缀表达式求值
		StackUtils.calculate("123+4*+5-");
	}
}

































