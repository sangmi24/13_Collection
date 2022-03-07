package com.kh.chap01_list.part02_mvc.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kh.chap01_list.part02_mvc.controller.MusicController;
import com.kh.chap01_list.part02_mvc.model.vo.Music;

// View : �ð����� ��� ��� ( ����ڰ� ���� �� ȭ��� ����) => ��¹��� �Է¹��� �ַ� �� => MVC ���Ͽ��� V�� ���
public class MusicView {

	//���������� �ϸ� {}�����ȿ����� ��밡���ؼ� ���������� ����(��ġ������)
	private Scanner sc = new Scanner(System.in);
	MusicController mc = new MusicController();
	
	//����ȭ�� : ���α׷� ����� ���� ó�� �������� ȭ��
	public void mainMenu() {
		
		//System.out.println ������ �̿��ؼ� ������ �ٹ̱�
		while(true) {
			
			System.out.println("***** Welcome ���� *****");
		    System.out.println("1. ���ο� �� �߰�");
		    System.out.println("2. �� ��ü ��ȸ");
		    System.out.println("3. Ư�� �� �˻�");
		    System.out.println("4. Ư�� �� ����");
		    System.out.println("5. Ư�� �� ����");
		    System.out.println("0. ���α׷� ����");
		    
		    System.out.print("�޴��Է� : ");
		    int menu = sc.nextInt();
		    sc.nextLine();
			
			switch(menu) {
			case 1:
				//�޼ҵ�� ���� => ȣ���ϴ� ������� ����
				insertMusic();
				break;
			case 2:
				//�޼ҵ�� ���� => ȣ���ϴ� ������� ����
				selectMusicList();
				break;
			case 3:
				searchMusic();
				break;
			case 4:
				deleteMusic();
				break;
			case 5:
				updateMusic();
				break;
			case 0:
				System.out.println("���α׷��� �����մϴ�. �ȳ��� ������.");
				return; //���� �����ϱ� ���ؼ�
			default :
				System.out.println("���� �޴��� �Է��߽��ϴ�. �ٽ� �Է��� �ּ���.");
			}
		}
	}
	
	// 1. ���ο� ���� �߰��� �� �ִ� ȭ�� (insert �����ϴ�)
	public void insertMusic() {
				
		System.out.println("----1. ���ο� �� �߰�----");
		System.out.print("��� �Է� : ");
		String title =sc.nextLine();
		System.out.print("������ �Է� : ");
		String artist= sc.nextLine();
		
		// �� �������� �츮�� ������ �߰��ϰ����Ҷ� �ʿ��� �������� �� �Է¹��� ����
		
		// ��û => Controller �� �޼ҵ带 ȣ�� (�ʿ��� �������� �Ű������� �ѱ��)
		
		//MusicController mc = new MusicController();
		//�߰������� ���� �߰��� Ƚ���� ���Ϲ޾Ƽ� ����̸� ����, �ƴϸ� ���� ���
		int result = mc.insertMusic(title,artist);
		
		if(result>0) {
		System.out.println("���������� �߰��Ǿ����ϴ�. ");
		}
		else {
			System.out.println("�� �߰��� �����߽��ϴ�.");
		}
	}
	//2. ��ü ���� ��ȸ�� �� �ִ� ȭ��
	public void selectMusicList() {
		System.out.println("----2.�� ��ü ��ȸ----");
		
		// �ִ°� �� �ѷ��ָ� �׸��̱� ������ �Է¹��� �ʿ䰡 ����!
		
		// ��û => Controller�� �޼ҵ带 ȣ�� (�̹����� �ʿ��� �����Ͱ� ��� �Ű������� ���� �ȳѰܵ� ��)
		//MusicController mc = new MusicController();
		ArrayList<Music>list = mc.selectMusicList();
		
		//Controller���� ��ȸ�Ϸ��� ������ view �ܿ��� ����ϱ�� ����߱� ������ 
		
		if(list.isEmpty()) {//���࿡ �뷡�� ���ٸ�
			System.out.println("���� �����ϴ� �뷡�� �����ϴ�.");
		}
		else { // �뷡�� �ִٸ�
			
			System.out.println("���� �����ϴ� �뷡�� ��"+list.size() +"�� �Դϴ�.");
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}			
		}
	}
	  // 3. Ư�� ���� �˻��� �� �ִ� ȭ��
	public void searchMusic() {
		
		System.out.println("----3.Ư�� �� �˻�----");
		System.out.print("�˻��� ��� Ű���� : ");
		String keyword= sc.nextLine();
		
		// ��û => Controller �޼ҵ� ȣ��(�˻�� ���ѵ� ���� ��� ã�Ƽ� ��ȯ)
		// ������� 0�� OK / ������� 1�� OK / ������� 2�� �̻� OK
		//=> 2�� �̻��� ���ɼ��� �����Ƿ� ArrayList Ÿ������ �˻��� ������� ��� �����ްڴ�.
		
		ArrayList<Music> searched = mc.searchMusic(keyword);
		
		System.out.println("�˻� ���");
		if(searched.isEmpty()) { //�˻� ����� ���ٸ�
			System.out.println("�˻� ����� �����ϴ�.");
		}
		else { //�˻� ����� �ִٸ�
			System.out.println("�˻� ����� �� "+ searched.size() +"�� �Դϴ�.");
			for ( Music m : searched  ) { //��������� : �÷��Ǹ� 
				
				System.out.println(m);				
			}			
		}
	}
	  //4. Ư�� ���� ������ �� �ִ� ȭ��
	  public void deleteMusic() {
		  
		  System.out.println("----4.Ư�� �� ����----");
		  System.out.print("������ �� ��: ");
		  String title=sc.nextLine();
		  
		  // ��û=>Controller �޼ҵ� ȣ�� ( �Ű������� title �Ѱ���)
		  // �߰����� ���
		  // ������ �Ͼ Ƚ���� �޼ҵ� ��ȯ������ ����������
		  int result = mc.deleteMusic(title);
		  
		  // result �� 0�� ��� : ������ 0�� ��
		  // result �� ����� ���: ������ �׸�ŭ ��
		  if(result >0 ) { //����� ���=> ������ �����
			  System.out.println("�� "+ result + "���� �����Ǿ����ϴ�.");
		  }
		  else { //������ ���� ã�� ����
			  System.out.println("������ ���� ã�� ���߽��ϴ�.");
		  }	  
	  }
	  // 5.Ư�� ���� ������ �� �ִ� ȭ��
	  public void updateMusic() {
		  
		  System.out.println("----5.Ư�� �� ����----");
		  
		  //���� => ���� ��� �ٲܰ��� �����ؾ� ��!
		  //���� ���(����), ������ ���, ������(���) ������ ��� �Է¹�����
		 System.out.print("���� ���: ");
		 String title=sc.nextLine();
		 System.out.print("���� ����(���): ");
		 String upTitle =sc.nextLine();
		 System.out.print("���� ����(������): ");
         String upArtist=sc.nextLine();
         
         // ��û=> Controller�޼ҵ� ȣ��(title,upTitle, upArtist �Ű������� ���� �� ����)
         // �߰� ���
         // ������ Ƚ���� ��ȯ������ ������������! => 0�̶�� (����) /���(����)
         int result = mc.updateMusic(title,upTitle,upArtist);
         
         if(result>0) { // ������ �����ߴٸ�
        	 System.out.println("���������� �����Ͽ����ϴ�.");
         }
         else { //������ �����ߴٸ�
        	 System.out.println("������ ���� ã�� ���߽��ϴ�.");
         }
         
	  }
	
	
	
}
