package com.kh.practice.list.library.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.practice.list.library.model.vo.Book;


public class BookController {

	private ArrayList<Book> bookList= new ArrayList<Book>(); 
	
	//초기 값을 넣어줄 기본 생성자
	public BookController() {
		
		//초기 값 4개 추가
		bookList.add(new Book("자바의 정석","남궁 성", "기타",20000 ));
		bookList.add(new Book("쉽게 배우는 알고리즘","문병로","기타",15000));
		bookList.add(new Book("대화의 기술","강보람","인문",175000));
		bookList.add(new Book("암 정복기","박신우","의료",21000));
	}
	//1.리스트에 값 저장 메소드
	public void insertBook(Book bk) {
		bookList.add(bk); //전달 받은 bk를 bookList에 추가
	}
	//2.모든 리스트를 출력하는 메소드
	public ArrayList<Book> selectList(){
		return bookList;  //해당 bookList의 주소 값 반환
	}
	//3.키워드로 책을 검색하는 메소드
	public ArrayList<Book>  searchBook(String keyword){
		
		ArrayList<Book> searchList = new ArrayList<Book>();
		
		for(int i=0; i<bookList.size(); i++) {
			if(bookList.get(i).getTitle().contains(keyword) == true) {
				searchList.add(bookList.get(i));
			}
		}
		  return searchList;
	}
	//4.책 제목과 저자 명으로 책을 삭제하는 메소드
	public Book deleteBook(String title, String author) {
		
		Book removeBook = null;
		
		for(int i=0; i<bookList.size(); i++) {
			
			if(bookList.get(i).getTitle().contains(title) ==true
		        && bookList.get(i).getAuthor().contains(author) == true) {
				
				removeBook = bookList.remove(i);		
			}
		}	
		return removeBook;
		
	}
	//5.책 명 오름차순 정렬하는 메소드
	//책 이름으로 오름차순 후 1 반환
	public int ascBook() {
		
		Collections.sort( bookList );
		//원래는 오류가 있었는데 vo에서 Comparable<Book> 설계를 하고 나서
		//없어짐 
		
		return 1;
		
	}
	
	
	
	
	
	
}
