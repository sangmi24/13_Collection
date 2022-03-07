package com.kh.chap01_list.part02_mvc.controller;

import java.util.ArrayList;

import com.kh.chap01_list.part02_mvc.model.vo.Music;

//Controller : ������� ��û�� �޾Ƽ� ó�����ִ� Ŭ����, ó�����  View��  �������� => MVC ���Ͽ��� C�� �ش��
public class MusicController {

	 private ArrayList<Music> list = new ArrayList<>();  //�ؿ� ������ ���������� ��� ���� ���� �׷��� ��ġ ������	
	  { // �ʱ�ȭ ��� : �ʵ忡 ���� �������ִ� �뵵
		  list.add(new Music("Tears","������"));  // 0��° 
		  list.add(new Music("��","������"));  // 1��°		  		  
	  }
	  
	  
	//���ο� �� �߰� ��û�� ������ �� ����� �޼ҵ� (�� �߰� ��� ���)
	public int insertMusic(String title, String artist) {	
		
		//�߰� �� size -�߰� �� size = ��� �߰��Ǿ����� �˼� ����
		int before = list.size();
		
		list.add(new Music(title, artist));	
		
		int after =list.size();
		
		return (after-before);
	}
	
	//�� ��ü ��ȸ ��û�� ������ �� ����� �޼ҵ� (�� ��ü ��ȸ ��� ���)
	public  ArrayList<Music> selectMusicList() {   
		//��ȯ�� - ArrayList<Music>��ü�� ��ȸ�ؾ� �ϱ� ������ ������ ����
		//ArrayList<Music> list Ÿ���� ���� �� ���� �� 
		
		return list;		
	}
	//Ư�� �� �˻� ��û�� ������ �� ����� �޼ҵ�(Ư�� �� �˻� ��� ���)
	public ArrayList<Music> searchMusic(String keyword){
		
		// �˻���� => �ݺ��� �� ������ �� ������
		//        => �ݺ� �����ٰ� ���ԵȰ� ������ �˻������ ������� list �ϳ� ���� �߰�
		
		//1. �˻������ ��� ArrayList ��ü�� �ϳ� �����
		ArrayList<Music> searched = new ArrayList<>(); //���� ����� (�⺻�� 10ĭ)
		
		//2. �ݺ������鼭 ������ keyword �� ���ԵǾ��ֳ� �˻�=> ���ԵǾ������� 1������ ���� list�� �߰�
		for(int i=0; i< list.size();i++) {
			
			if(list.get(i).getTitle() .contains( keyword ) ) { //�˻������� �´ٸ�
				//  a.contains(b)
				//=> a,b�� ���ڿ�
				//=> a��� ���ڿ��� �κ� ���ڿ���  b�� ���ԵǾ�������� true /�ƴϸ� false ��ȯ
				searched.add(list.get(i));				
			}			
		} //��� �� �������� searched �� �˻� ����鸸 ��� ����!
		
		//3. �˻���� ����
		//return �˻��� ������� ��� list;
		return searched;
		
	}
	 //Ư�� �� ���� ��û�� ����� �޼ҵ�(Ư�� �� ���� ��� ���)
	public int deleteMusic(String title) {
		
		//1. ������ ������� ���� ���� ����
		int result=0; //������ ����� Ƚ��
	
		//2. �ݺ����� Ȱ���Ͽ� getTitle() �� title �� ������ؼ� ����
		// => �̶� ������ �� �Ͼ�ٸ� ������ ������� ++ó��
		for(int i=0; i< list.size();i++) {
			
			if(list.get(i).getTitle().equals(title)) { //������ �����ϴٸ� ����
				
				//����=>remove(�ε�����ġ��)
				list.remove(i);
				
				//���� Ƚ�� 1����
				result ++;
				
			}
		}	
		//3. ���� ����� ����
		return result; // 0 �ϼ��� �ְ� ������ϼ��� ����
		
	}
	//Ư�� �� ���� ��û�� ����� �޼ҵ�(Ư�� �� ���� ��� ���)
    public int updateMusic(String title,String upTitle,String upArtist) {
    	
    	//1. ��ȯ�� ������� ���� ���� ����
    	int result = 0;
    	
    	//2. �ݺ�
    	//=> �������� ��ġ�ϴ��� ����� (�����ϴٸ� ���� ����, result++;)
    	for(int i=0; i<list.size();i++) {
    		if(list.get(i).getTitle() .equals(title) ) { //�����ϴٸ� ������ �����ϰڴ�.
    			
    			//�����ϴ� �ڵ� �ۼ� => �ʵ尪�� ���� (setter �޼ҵ�)
    			//list.get(i) //i��° �����ϴ� Music Ÿ���� ��ü
    			list.get(i).setTitle(upTitle);
    			list.get(i).setArtist(upArtist);
    			
    			//result �� 1 ����
    			result++;    			
    		}
    	}   
    	//3. ����� ����
    	return result;
    	
    }
	
	
	
	
	
	
	
	
	
}
