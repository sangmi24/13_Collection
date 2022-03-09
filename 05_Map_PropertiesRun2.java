package com.kh.chap03_map.part02_properties.run;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesRun2 {

	public static void main(String[] args) {
		
		//���Ϸκ��� �о���̱�
		//=>������ �о���̴°� �ƴ϶� Properties ��ü�� ���� �ű⼭ ȣ���ؾ� �˾Ƽ� �� ���� ����!
		Properties prop =new Properties(); //����ִ� ����
		Properties prop2 =new Properties(); //����ִ� ����
		
		System.out.println(prop); //{}
		
	
		try {
			//�о���̴� �޼ҵ� : load(InputStream is)  //����� 
			prop.load(new FileInputStream("test.properties"));
			
			//xml �������� �о���̴� �޼ҵ� : loadFromXML (InputStream is)
			prop2.loadFromXML (new FileInputStream("test.xml"));
						
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(prop); 
		System.out.println(prop2); 
		
		// �ش� key�� �ش�Ǵ� value�� �̾ƺ��� (�Ϲ� Map �迭�� get�޼ҵ�� ���� ����)
		//getProperty(String key) : String value
		System.out.println(prop.getProperty("Map"));
		
		/*
		 * .properties ������ ����ϴ� ����
		 * �ش� ���α׷��� �⺻������ �������� �������� .properties Ȯ���� ������
		 * �����صθ� key-value ��� ���ڿ��̱� ������ ������ �Ӹ� �ƴ϶� �Ϲ� ������ ���� �ٷ�� ����.
		 * => JDBC ���� �ٷ� ����
		 * 
		 * .xml ������ ����ϴ� ����
		 *  DB ������ ó�� �� value�� ���� �� ����.
		 *  .xml ���ϰ��� ���� ȣȯ���� ���Ƽ� �ٸ� ���α׷��� ���� ȣȯ�� �����ϴ� ��� ��!
		 */
		
		

	}

}
