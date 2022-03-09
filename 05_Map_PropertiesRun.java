package com.kh.chap03_map.part02_properties.run;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.kh.chap03_map.part01_hashMap.model.vo.Snack;

public class PropertiesRun {

	public static void main(String[] args) {
		
		// Properties : Map �迭=> key,value ��Ʈ�� �����
		//             ��, Properties ���� Ư¡�̶�� �Ѵٸ�
		//             key,value ��� String���� ���ѵǾ��ִ�.
		
		Properties prop = new Properties();
		
		// String �� �ƴ� ���� �ְ� �� ���
		// Map �迭�̱� ������ put�޼ҵ�� key+value ��Ʈ�� ������ �ֱ� ��!
		prop.put("�����", new Snack("§��",500)); 
		
		System.out.println(prop); 
		System.out.println(prop.get("�����"));
		// ��, �ַ� Properties �� ����ϴ� ���� Properties�� ����ִ�
		// key+value�� ���ϵ�� ��Ͻ�Ų�ٰų�,  ���Ͽ� ��ϵǾ� �ִ� key+value�� ���������� �ϱ� �����̶�
		// �ַ� <String+String>���� ����. 
		
		//(������ ���α׷� �ڵ��.)
		// ���Ϸ� ��� : output (storeXXX�޼ҵ�)   �������� 
		// ���Ϸκ��� �����ö� : input (loadXXX�޼ҵ�)
		
		Properties prop2 = new Properties();
		
		//���� �ֱ� 
		//Properties ��ü���� �����ϴ� �޼ҵ� put�̶� ���� ���� => setProperty(String key, String value)
        prop2.setProperty("List", "ArrayList");
        prop2.setProperty("Set", "HashSet");
        prop2.setProperty("Map", "HashMap");
        prop2.setProperty("Map", "Properties");
        //Ű���� ������ ��� put�� ���������� �������
        
        System.out.println(prop2); // ���� ���� ����x, key�� �ߺ� x
        
        //���Ϸ� �������� 
        try {
        	//1.store(OutputStream os ,String comments ) /OutputStream ��� ��Ʈ��
            // : Properties�� ��� key-value ��Ʈ���� ���Ϸ� ���
			prop2.store(new FileOutputStream("test.properties"), "Properties Test");
			
		    //2.storeToXML(OutputStream os, String comments)
			// : Properties�� ��� key- value ��Ʈ���� .xml �̶�� Ȯ���� �������� ���(ȣȯ���� ����)
			prop2.storeToXML(new FileOutputStream ("test.xml"), "Properties Test");
			
        } catch (IOException e) {
			e.printStackTrace();
		}
        
        
		
	}

}
