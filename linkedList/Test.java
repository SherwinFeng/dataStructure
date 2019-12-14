package linkedList;
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
		//������������	
		System.out.println("*******����˫������**********");
		DoubleLinkedList dList = new DoubleLinkedList();
		System.out.println("------------����add-------------");
		dList.add("a");
        dList.add("b");
        dList.add("c");
        dList.print();
		System.out.println("------------����size-------------");
        System.out.println(dList.size());
		System.out.println("------------����insert----------");
        dList.insert(0,"f");
        dList.print();
        dList.insert(2,"g");
        dList.print();
        dList.insert(4,"h");
        dList.print();
        dList.insert(6,"g");
        dList.print();
		System.out.println("------------����delete----------");
		System.out.println("ɾ��ָ���±�Ľڵ㣺");
		dList.delete(0);
        dList.print();
        dList.delete(2);
        dList.print();
        dList.delete(dList.size()-1);
        dList.print();
		System.out.println("ɾ��ָ�����ݵĽڵ㣺");
		dList.delete("a");
        dList.print();
        dList.delete("h");
        dList.print();
        dList.delete("c");
        dList.print();
        System.out.println("ɾ��β���ڵ㣺");
        System.out.println("��ʼ��");
        dList.add("a");
        dList.add("b");
        dList.add("c");
        dList.print();
        dList.delete();
        dList.print();
        System.out.println("------------����update----------");
        dList.update(0,"haha");
        dList.print();
        dList.update(dList.size()-1,"xixi");
        dList.print();
        dList.update(1,"hoho");
        dList.print();
        System.out.println("------------����get-------------");
        System.out.println(dList.get(0));
        System.out.println(dList.get(1));
        System.out.println(dList.get(2));
        System.out.println("------------����getIndex--------");
        System.out.println(dList.getIndex("xixi"));
        System.out.println(dList.getIndex("haha"));
        System.out.println(dList.getIndex("hoho"));
		
		/**
		//������������	
		System.out.println("*******���Ե�����**********");
		SingleLinkedList sList = new SingleLinkedList();
		System.out.println("------------����add-------------");
		sList.add("a");
        sList.add("b");
        sList.add("c");
        sList.print();
		System.out.println("------------����size-------------");
        System.out.println(sList.size());
		System.out.println("------------����insert----------");
        sList.insert(0,"f");
        sList.print();
        sList.insert(2,"g");
        sList.print();
        sList.insert(4,"h");
        sList.print();
        sList.insert(6,"g");
        sList.print();
		System.out.println("------------����delete----------");
		System.out.println("ɾ��ָ���±�Ľڵ㣺");
		sList.delete(0);
        sList.print();
        sList.delete(2);
        sList.print();
        sList.delete(sList.size()-1);
        sList.print();
		System.out.println("ɾ��ָ�����ݵĽڵ㣺");
		sList.delete("a");
        sList.print();
        sList.delete("h");
        sList.print();
        sList.delete("c");
        sList.print();
        System.out.println("ɾ��β���ڵ㣺");
        System.out.println("��ʼ��");
        sList.add("a");
        sList.add("b");
        sList.add("c");
        sList.print();
        sList.delete();
        sList.print();
        System.out.println("------------����update----------");
        sList.update(0,"haha");
        sList.print();
        sList.update(sList.size()-1,"xixi");
        sList.print();
        sList.update(1,"hoho");
        sList.print();
        System.out.println("------------����get-------------");
        System.out.println(sList.get(0));
        System.out.println(sList.get(1));
        System.out.println(sList.get(2));
        System.out.println("------------����getIndex--------");
        System.out.println(sList.getIndex("xixi"));
        System.out.println(sList.getIndex("haha"));
        System.out.println(sList.getIndex("hoho"));
        */
        
		/**
		//ѭ����������
		System.out.println("*******����ѭ������**********");
		CircleLinkedList cList = new CircleLinkedList();
		System.out.println("------------����add-------------");
		cList.add("a");
        cList.add("b");
        cList.add("c");
        cList.print();
        System.out.println("------------����size-------------");
        System.out.println(cList.size());
		System.out.println("------------����insert----------");
		cList.insert(0,"f");
		cList.print();
		cList.insert(2,"g");
		cList.print();
		cList.insert(4,"h");
		cList.print();
		cList.insert(6,"g");
		cList.print();
		System.out.println("------------����delete----------");
		System.out.println("ɾ��ָ���±�Ľڵ㣺");
		cList.delete(0);
        cList.print();
        cList.delete(2);
        cList.print();
        cList.delete(cList.size()-1);
        cList.print();
        System.out.println("ɾ��ָ�����ݵĽڵ㣺");
		cList.delete("a");
        cList.print();
        cList.delete("h");
        cList.print();
        cList.delete("c");
        cList.print();
        System.out.println("ɾ��β���ڵ㣺");
        System.out.println("��ʼ��");
        cList.add("a");
        cList.add("b");
        cList.add("c");
        cList.print();
        cList.delete();
        cList.print();
        System.out.println("------------����update----------");
        cList.update(0,"haha");
        cList.print();
        cList.update(cList.size()-1,"xixi");
        cList.print();
        cList.update(1,"hoho");
        cList.print();
        System.out.println("------------����get-------------");
        System.out.println(cList.get(0));
        System.out.println(cList.get(1));
        System.out.println(cList.get(2));
        System.out.println("------------����getIndex--------");
        System.out.println(cList.getIndex("xixi"));
        System.out.println(cList.getIndex("haha"));
        System.out.println(cList.getIndex("hoho"));
         */
    }
}
