package com.kh.chap03_map.part01_hashMap.run;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.chap03_map.part01_hashMap.model.vo.Snack;

public class MapRun {

	public static void main(String[] args) {
		
		HashMap<String, Snack> hm = new HashMap<>();
        //���� ������ ���� List, Set�迭�� Collection �������̽��� ������ Ŭ������
		//=> �����͸� �߰��Ҷ� add �޼ҵ带 �����
		//��, Map�� �θ� ���ʿ� Collection�� �ƴ�!
		//=>�����͸� �߰��Ҷ� put�޼ҵ� ��� (key +value ��Ʈ�� �߰� )
		
		//1. put(K key, V value) :map ������ key+value ��Ʈ�� �߰����ִ� �޼ҵ�
		hm.put("������", new Snack("���츶���",200));		
		hm.put("����Ĩ", new Snack("�����򷯽���",400));		
		hm.put("����Ĩ", new Snack("�׳�..���ĸ�?",300));		
		hm.put("�����", new Snack("���̵Ȼ����",500)); 
				
		System.out.println(hm);
		//���� ���� ����x, 
		
		hm.put("��������Ĩ", new Snack("�׳�..���ĸ�?",300));
		
		System.out.println(hm);
		//value ���� �ߺ��Ǵ��� key���� �ߺ������� ������ �� �����
		
		hm.put("�����", new Snack("�ſ�����",600));
		//key���� �ߺ��� ����
		
		System.out.println(hm);
		// ���࿡ key���� �ߺ��Ǿ��ٸ� ���� �������� put�� value�� ���������.
		
		//2. get(Object key) :  V : �ش� Ű���� value�� �����ִ� �޼ҵ�
		System.out.println(hm.get("����Ĩ"));
		System.out.println(hm.get("�����"));
		
		//Snack s=(Snack)hm.get("�����");  // ���׸��� �������� �ʴ´ٸ� �Ź� �ڽ�Ÿ������ ����ȯ �������(������)
		
		//3. size() : HashMap ��ü�� ����ִ� �ڷ��� ������ ��ȯ���ִ� �޼ҵ�
		System.out.println("size: "+hm.size()); //5
		
		//4. replace(K key, V value) : HashMap ��ü�� �ش� key���� ã�Ƽ� ���� ���޵� value�� �ٲ�ġ�� ���ִ� �޼ҵ�
		hm.replace("����Ĩ", new Snack("�����̸�",350));
		System.out.println(hm);
		
		// put �޼ҵ�� ���ʿ� ���� ���� �߰��ؼ� �뵵�� ���� key���� �ߺ��ȴٸ� ���������, key���� �ߺ����� �ʴ´ٸ� �߰�
		// replace �޼ҵ�� ���ʿ� �ִ� key ���� ã�Ƽ� value �� �ٲ�ġ�� ���ִ� �뵵
		
		//5. remove(Object key) : HashMap ���κ��� key ���� �ش�Ǵ� key+value�� ��Ʈ�� �����ִ� ����
		hm.remove("�����");
		System.out.println(hm);
		
		System.out.println("size: "+hm.size());  // 4
		
		System.out.println("------------------------------------------");
		
		// ���������� HashMap �� �ִ� �����͵鿡 �����ϰ��� �Ҷ�?
		
		//����) Set�� �ݺ������� ������?
		// 1. ���� for�� => ��������� ��� �ۼ�..? => ��� �Ұ�		
		// 2. ArrayList �� �ű�� ��� => �θ� �ٸ� �迭�̱� ������ �ű�°� �Ұ�		
		// 3.  .iterator() : Map �迭������ ���Ұ�
		
		//=> Map �迭���� �����ϴ� �޼ҵ�2����(Map �� Set ���� �ٲ���)
		
		//Map�� Set ���� �ٲ��ִ� �޼ҵ�
		//1. keySet() : HashMap�� �ִ�  key�鸸 Set���� �Ű��ִ� ���� 
		//Set�� ��ü����x,�̷��� ��� �뵵�θ� ����
		Set<String> keySet = hm.keySet();
		
		//��� �� ���������� Set �� key������ �� ��� ���� = > 1,2,3�� ������� �ݺ� ����
		
		//3. .iterator() ������� �ݺ� ��������
		Iterator<String> itKey= keySet.iterator();
		//�Ʊ����� �̾Ҵ� key���鸸 ������� 
		
		while(itKey.hasNext()) { //(���ǽ� =>���̻� ������ �ִ�?)
		      
			String key = itKey.next(); //key ��� �������� �Ź� �ݺ��ɶ����� HashMap�� �־��� key���� ������!
			Snack s = hm.get(key);
			System.out.println("key: "+key+"value: "+s);
		}
		
		System.out.println("------------------------------");
		//2. entrySet() : HashMap �� �ִ� key+value ��� Set���� �Ű��ִ� ���� (Entry ��������) //Entry()�� �ּҴ��� 
		Set<Entry<String,Snack>> entrySet = hm.entrySet();
		
		// �� �������ʹ� Set �� �ϼ��� �� ���¶� 1,2,3 �� ����� �ƹ��ų� �ݺ��� ������ ��
		
		// .iterator() 
		Iterator<Entry<String,Snack>> itEntry=  entrySet.iterator();

		while(itEntry.hasNext()) {
			Entry<String,Snack> entry = itEntry.next();
			
			System.out.println("key: "+entry.getKey()+",value: "+ entry.getValue());
			
		}	
		
		
		
		
		
	}
}



