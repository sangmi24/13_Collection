package com.kh.practice.list.library.view;

import java.nio.channels.AcceptPendingException;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice.list.library.controller.BookController;
import com.kh.practice.list.library.model.vo.Book;

public class BookMenu {

	 Scanner sc= new Scanner(System.in);
	 BookController bc = new BookController();
	 
	 //사용자가 직접 메인 메뉴를 선택할 수 있음. 
	 //종료 전까지 반복 실행. 각 메뉴를 누를 시 해당 메소드로 이동
	 public void mainMenu() {
		  System.out.println("==Welcome KH Library ==");
		  
		  while(true) { //무한 반복 실행
		  System.out.println("****** 메인 메뉴 ******");
	 	  System.out.println("1. 새 도서 추가");
	 	  System.out.println("2. 도서 전체 조회");
	 	  System.out.println("3. 도서 검색 조회");
	 	  System.out.println("4. 도서 삭제");
	 	  System.out.println("5. 도서 명 오름차순 정렬");
          System.out.println("9. 종료\n");
		  System.out.print("메뉴번호 입력: ");
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
			System.out.println("프로그램을 종료합니다.");
		default:
			System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			break;
		}
	} 	  
		  
	 }
	 //1.도서 추가를 위해 정보를 받는 메소드
	 public void insertBook() {
		 
		 String category="";
		 
		 System.out.println("==== 새 도서 추가 ====");
		 System.out.println("도서명: ");
		 String title=sc.nextLine();
		 
		 System.out.println("저자명: ");
		 String author=sc.nextLine();
		 
		 System.out.println("장르 (1.인문/2.과학/3.외국어/4.기타) : ");
		 int genre = sc.nextInt();
		 sc.nextLine();
		 	
		if(genre == 1) {
			category = "인문";
		}
		if(genre == 2) {
			category = "과학";
		}
		if(genre == 3) {
			category = "외국어";
		}
		if(genre == 4) {
			category = "기타";
		}
		 		 
		 System.out.println("가격: ");
		 int price = sc.nextInt();
		 sc.nextLine();
		 
		 Book bk= new Book(title, author,category, price);
		 
		 bc.insertBook(bk);
		 	 
	 }
	 //2.전체 도서 목록 출력 성공을 알리는 메소드
	 public void selectList() {
		 System.out.println("==== 도서 전체 조회 ====");
		 ArrayList<Book> bookList = new ArrayList<>(bc.selectList());
		 
		 if(bookList.isEmpty() == true) {
			 System.out.println("존재하는 도서가 없습니다.");
		 }else {
			 for(int i=0; i<bookList.size(); i++) {
				 System.out.println(bookList.get(i));
			 }
		 }
	 }
	 //3.특정 도서 검색 결과를 보여주는 메소드
	 public void searchBook() {
		 System.out.println("==== 도서 검색 ====");
		 System.out.println("검색 키워드: ");
		 String keyword = sc.nextLine();
		 
		 ArrayList<Book> bookList = new ArrayList<>(bc.searchBook(keyword));
		 
		 if(bookList.isEmpty()== true) {
			 System.out.println("검색 결과가 없습니다.");
		 }else {
			 for(int i=0; i<bookList.size(); i++) {
				 System.out.println (bookList.get(i));
			 }
		 }
	 }
	 //4.특정 도서 삭제 성공을 알리는 메소드
	 public void deleteBook() {
		 System.out.println("==== 도서 삭제 ====");
		 System.out.println("삭제할 도서 명: ");
		 String title=sc.nextLine();
		 System.out.println("삭제할 저자 명: ");
		 String author=sc.nextLine();
		 
		 Book remove = new Book();
		 remove = bc.deleteBook(title, author);
		 
		 if(remove ==null) {
			 System.out.println("삭제할 도서를 찾지 못했습니다. ");
		 }else {
			 System.out.println("성공적으로 삭제되었습니다. ");
		 }		 
	 }
	 //5.책 명 오름차순 정렬 성공을 알리는 메소드
	 public void ascBook() {
		 
		 if(bc.ascBook() ==1 ) {
			 System.out.println("정렬에 성공하였습니다. ");
		 } else {
			 System.out.println("정렬에 실패하였습니다.");
		 }
		 
		
		 
	 }
	 
	 
	
	
	
}
