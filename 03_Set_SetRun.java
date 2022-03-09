package com.kh.chap02_set.part01_hashSet.run;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import com.kh.chap02_set.part01_hashSet.model.vo.Student;

public class SetRun {

	public static void main(String[] args) {
		//HashSet hs1 = new HashSet();
		//Set�� �߻�޼ҵ�, �������̽��� ��ü ���� �ȵ� /�׷��� �ڽ�Ŭ������ Hashset�� ��
		HashSet<String> hs1 = new HashSet<>();
		
		//��� �� �������ʹ� HashSet ��ü�� ���� �ּ��ּ� ���� �� ���� (���ָӴ�)
		
		//1. add(�߰��� ��) : �� �߰� �޼ҵ�
		hs1.add(new String("�ݰ����ϴ�."));
		hs1.add(new String("�ݰ����ϴ�."));
		hs1.add(new String("������"));
		hs1.add(new String ("�ȳ��ϼ���"));
		hs1.add(new String("������"));
		//hs1.add(1);
		//hs1.add(new Student());
		
		
		System.out.println(hs1); // ���� ��������X, �ߺ� ���� X  /toString �������̵��Ȱ�
		
		//2. size() : ���� HashSet ��ü�� ���� �������� ������ ��ȯ���ִ� �޼ҵ�
	    System.out.println("hs1�� ũ�� : "+hs1.size());
	    
	    //3. remove(������ �� ) : ���� �������ִ� �޼ҵ�
	    //hs1.remove("������");
	    hs1.remove(new String("������"));
	    System.out.println(hs1);
		
	    //4. clear() : ��� �� ����
	    hs1.clear();
	    
	    System.out.println(hs1);  //�̰͵� �������̵� �� ���� / [ ]
	    
	    // List �迭 ������ �޼ҵ���� ���=> Collection �̶�� �θ� ���Ƽ� �������̵� �� ������!
		
	    System.out.println("--------------------------------------");
	    
	    HashSet<Student> hs2 = new HashSet<>();
	    
	    hs2.add(new Student("����",20,100));
	    hs2.add(new Student("�迵��",25,90));
	    hs2.add(new Student("ȫ�浿",33,80));
	    hs2.add(new Student("����",20,100)); //�ּҰ��� ���� �ٸ��� ������ �ߺ����� �Ǵܵ��� ����!
	    
	    System.out.println(hs2); 
	    // ���� ���� ����x, �ߺ� ���� o  
	    // => ��? ���� ��ü�� �Ǵ��� ���� �ʾƼ�!
	    // HashSet ��ü�� �ߺ��� �Ǵ��ϴ� ����
	    // ���� �߰��ɶ� ���� equals(), hashCode() �޼ҵ�� ���� �ߺ��Ǵ��� ����
	    // �Ѵ� true ���� ���´ٸ� ���ϰ�ü�� �Ǵ�
	    
	    /*
	     * HashSet�� ��ü�� ���� �� ���������� equals() �޼ҵ带 Ȱ���ؼ� �ߺ�üũ�� ��
	     * + hashCode() �޼ҵ带 �̿��ؼ� ���������� ��ġ�ϴ��� �ߺ�üũ�� ��
	     * => equals() ����� true �̰� hashCode() ���� ��ġ�Ѵٸ� ���ϰ�ü�� �Ǵ��� �ϰڴ�.
	     * (equals()�� �ּҰ� �񱳿� �޼ҵ�/hashCode()�ּҰ� �������� �������� ���� )
	     * 
	     * ���ݺ��ʹ� �ƹ��� �ּҰ��� �ٸ����� �ʵ忡 ���� ������ ��� ��ġ�Ѵٸ� ���� ��ü�� �ǴܵǰԲ� �޼ҵ���� �������̵�!!
	     * 
	     * �� �޼ҵ��� ���� ����
	     * ObjectŬ������ �����ϴ� equals() : �� ��ü�� �ּҰ��� ������ ������ؼ� ��ġ�ϸ� true /�ƴϸ� false�� ��ȯ
	     * ObjectŬ������ �����ϴ� hashCode() : �� ��ü�� �ּҰ��� ������� �ؽ��ڵ尪�� ���� ��ȯ
	     * 
	     * �������̵��� ����
	     * Student Ŭ������ �����ϴ� equals() : �� �ʵ� ���� ��ġ�ϸ� true/�ƴϸ� false ���� ��ȯ�ϰԲ� �������̵�
	     * Student Ŭ������ �����ϴ� hashCode() : �� �ʵ尪�� ������� �ؼ� �ؽ��ڵ� ���� ���� ��ȯ
	     * 
	     * =>equals() �� hashCode()�� �������̵��� �ʼ��� �ƴ�!
	     *   ��, Set �迭�� ��ü�� ����� �Ҷ��� �ʼ�!
	     */
	    System.out.println("--------------------------------------");
	    
	    // Set =>������ ��ü�� ����Ǿ� �ִ� ���� => index ������ ����
	    // ��� �ݺ��� Ȱ���� �Ұ�!!
	    // �׷� ����ִ� ��ü�� ���������� ������ �ϰ��� �Ҷ�?
	    
	    //1. ���� for���� ��밡��(for each��)=> index ������ ���� �ݺ����̶�
	    //for(��������� : �÷��Ǹ� ) {
	    for(Student s : hs2 ) {
	    	System.out.println(s);
	    }
	    System.out.println("--------------------------------------");
	    
	    //2. ArrayList �� ����� �� ArrayList���� �ݺ����� ����
	    // ArrayList<Student> list = new ArrayList<>(); //�������
	    // list.addAll( hs2 ); //����Ʈ�� hs2�� ����ִ� ���빰���� ��°�� �߰� 
	        
	    ArrayList<Student> list = new ArrayList<>(hs2);
	    //list.addAll(hs2); 
	    //hs2 �� ����ִ� ��ü���� �߰��� ä�� ����Ʈ�� ������	    
	    
	    
	    for(int i=0 ; i<list.size(); i++) {
	    	System.out.println(list.get(i));
	    }//������ �������� �ʴ´�.
	    System.out.println("--------------------------------------");
	    
	    //3.HashSet Ŭ�������� �����ϴ� Iterator �ݺ��ڸ� �̿��� ���
	    //hs2�� ����ִ� ��ü���� Iterator�� ���ܴ�Ƽ� �ݺ������� 
	    Iterator<Student> it = hs2.iterator();
	    
	    // �ݺ� �������� ���ǻ��� : ���� it �� ���̻� �̾Ƴ� ��ҵ��� �ִ��� �˻縦 �ؼ� �ݺ��� ������ �� (string��ũ�������� �����)
	    while(it.hasNext() ) { //���� it�� ���̻� ���� ���� �����ִ°�? ��� ����� �޼ҵ� (������ true, ������ false)
	    	System.out.println(it.next());
	    	
	    }
	    //StringTokenizer �� ����� ���� (��ū �̴µ���)
	    
	    // .iterator() : List �迭����, Set �迭���� ���� ����/ Map�迭������ ����!
        
	}

}






