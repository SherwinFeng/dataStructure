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

        //----------------------------------------------------��ջ���������Ĳ���
		
		//��������ջ
//		//��ʼ��ջ(char����)
//        SqStack stack = new SqStack(3);
//        
//        //2״̬
//        System.out.println("ջ�Ƿ�Ϊ�գ�"+stack.isNull());
//        System.out.println("ջ�Ƿ�������"+stack.isFull());
//        
//        //2����
//        //����ѹջ
//        stack.push('a');
//        stack.push('b');
//        stack.push('c');
//        System.out.println("ջ�Ƿ�������"+stack.isFull());
//        
//        //���ε�ջ
//        System.out.println("��ջ˳��");
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
		
		//������ʽջ
//		LinkedStack ls = new LinkedStack();
//        
//        //1״̬
//        System.out.println("ջ�Ƿ�Ϊ�գ�"+ls.isNull());
//        
//        //2����
//        //����ѹջ
//        ls.push('a');
//        ls.push('b');       
//        ls.push('c');        
//        //���ε�ջ
//        System.out.println("��ջ˳��");
//        System.out.println(ls.pop());
//        System.out.println(ls.pop());
//        System.out.println(ls.pop());
		
	
        
        //----------------------------------------------------��ջ��Ӧ�õĲ���
		//��������ת��
//        String s = StackUtils.integerToNhex(123456, 16);
//        System.out.println("ת���õ���16������Ϊ:"+s);
		//��������ƥ��
//		String str1 = "i((l)o[v{e}]y)o{u}!";//���ʽ1��(()[{}]){}
//		String str2 = "you((do)[not{}])know{}!)";//���ʽ2��(()[{}]){})
//		boolean match1 = StackUtils.isMatch(str1);
//		boolean match2 = StackUtils.isMatch(str2);
//		System.out.println("str1�е������Ƿ�ƥ�䣺"+match1);
//		System.out.println("str2�е������Ƿ�ƥ�䣺"+match2);
		
		//������׺���ʽתΪ��׺���ʽ
//		StackUtils.convert("1+((2+3)*4)-5");
		
		//���Ժ�׺���ʽ��ֵ
		StackUtils.calculate("123+4*+5-");
	}
}

































