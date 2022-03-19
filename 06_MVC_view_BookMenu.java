package com.kh.practice.list.library.view;

import java.nio.channels.AcceptPendingException;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice.list.library.controller.BookController;
import com.kh.practice.list.library.model.vo.Book;

public class BookMenu {

	 Scanner sc= new Scanner(System.in);
	 BookController bc = new BookController();
	 
	 //����ڰ� ���� ���� �޴��� ������ �� ����. 
	 //���� ������ �ݺ� ����. �� �޴��� ���� �� �ش� �޼ҵ�� �̵�
	 public void mainMenu() {
		  System.out.println("==Welcome KH Library ==");
		  
		  while(true) { //���� �ݺ� ����
		  System.out.println("****** ���� �޴� ******");
	 	  System.out.println("1. �� ���� �߰�");
	 	  System.out.println("2. ���� ��ü ��ȸ");
	 	  System.out.println("3. ���� �˻� ��ȸ");
	 	  System.out.println("4. ���� ����");
	 	  System.out.println("5. ���� �� �������� ����");
          System.out.println("9. ����\n");
		  System.out.print("�޴���ȣ �Է�: ");
		  int menu = sc.nextInt();
		  sc.nextLine();
		
			 
		  switch (menu) {
		case 1:
			insertBook();
			break;
		case 2:
			selectList();
			break;
		case 3:
			searchBook();
			break;
		case 4:
			deleteBook();
			break;
		case 5:
			ascBook();
			break;
		case 9:
			System.out.println("���α׷��� �����մϴ�.");
		default:
			System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
			break;
		}
	} 	  
		  
	 }
	 //1.���� �߰��� ���� ������ �޴� �޼ҵ�
	 public void insertBook() {
		 
		 String category="";
		 
		 System.out.println("==== �� ���� �߰� ====");
		 System.out.println("������: ");
		 String title=sc.nextLine();
		 
		 System.out.println("���ڸ�: ");
		 String author=sc.nextLine();
		 
		 System.out.println("�帣 (1.�ι�/2.����/3.�ܱ���/4.��Ÿ) : ");
		 int genre = sc.nextInt();
		 sc.nextLine();
		 	
		if(genre == 1) {
			category = "�ι�";
		}
		if(genre == 2) {
			category = "����";
		}
		if(genre == 3) {
			category = "�ܱ���";
		}
		if(genre == 4) {
			category = "��Ÿ";
		}
		 		 
		 System.out.println("����: ");
		 int price = sc.nextInt();
		 sc.nextLine();
		 
		 Book bk= new Book(title, author,category, price);
		 
		 bc.insertBook(bk);
		 	 
	 }
	 //2.��ü ���� ��� ��� ������ �˸��� �޼ҵ�
	 public void selectList() {
		 System.out.println("==== ���� ��ü ��ȸ ====");
		 ArrayList<Book> bookList = new ArrayList<>(bc.selectList());
		 
		 if(bookList.isEmpty() == true) {
			 System.out.println("�����ϴ� ������ �����ϴ�.");
		 }else {
			 for(int i=0; i<bookList.size(); i++) {
				 System.out.println(bookList.get(i));
			 }
		 }
	 }
	 //3.Ư�� ���� �˻� ����� �����ִ� �޼ҵ�
	 public void searchBook() {
		 System.out.println("==== ���� �˻� ====");
		 System.out.println("�˻� Ű����: ");
		 String keyword = sc.nextLine();
		 
		 ArrayList<Book> bookList = new ArrayList<>(bc.searchBook(keyword));
		 
		 if(bookList.isEmpty()== true) {
			 System.out.println("�˻� ����� �����ϴ�.");
		 }else {
			 for(int i=0; i<bookList.size(); i++) {
				 System.out.println (bookList.get(i));
			 }
		 }
	 }
	 //4.Ư�� ���� ���� ������ �˸��� �޼ҵ�
	 public void deleteBook() {
		 System.out.println("==== ���� ���� ====");
		 System.out.println("������ ���� ��: ");
		 String title=sc.nextLine();
		 System.out.println("������ ���� ��: ");
		 String author=sc.nextLine();
		 
		 Book remove = new Book();
		 remove = bc.deleteBook(title, author);
		 
		 if(remove ==null) {
			 System.out.println("������ ������ ã�� ���߽��ϴ�. ");
		 }else {
			 System.out.println("���������� �����Ǿ����ϴ�. ");
		 }		 
	 }
	 //5.å �� �������� ���� ������ �˸��� �޼ҵ�
	 public void ascBook() {
		 
		 if(bc.ascBook() ==1 ) {
			 System.out.println("���Ŀ� �����Ͽ����ϴ�. ");
		 } else {
			 System.out.println("���Ŀ� �����Ͽ����ϴ�.");
		 }
		 
		
		 
	 }
	 
	 
	
	
	
}
