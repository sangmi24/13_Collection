package com.kh.practice.list.library.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.practice.list.library.model.vo.Book;


public class BookController {

	private ArrayList<Book> bookList= new ArrayList<Book>(); 
	
	//�ʱ� ���� �־��� �⺻ ������
	public BookController() {
		
		//�ʱ� �� 4�� �߰�
		bookList.add(new Book("�ڹ��� ����","���� ��", "��Ÿ",20000 ));
		bookList.add(new Book("���� ���� �˰���","������","��Ÿ",15000));
		bookList.add(new Book("��ȭ�� ���","������","�ι�",175000));
		bookList.add(new Book("�� ������","�ڽſ�","�Ƿ�",21000));
	}
	//1.����Ʈ�� �� ���� �޼ҵ�
	public void insertBook(Book bk) {
		bookList.add(bk); //���� ���� bk�� bookList�� �߰�
	}
	//2.��� ����Ʈ�� ����ϴ� �޼ҵ�
	public ArrayList<Book> selectList(){
		return bookList;  //�ش� bookList�� �ּ� �� ��ȯ
	}
	//3.Ű����� å�� �˻��ϴ� �޼ҵ�
	public ArrayList<Book>  searchBook(String keyword){
		
		ArrayList<Book> searchList = new ArrayList<Book>();
		
		for(int i=0; i<bookList.size(); i++) {
			if(bookList.get(i).getTitle().contains(keyword) == true) {
				searchList.add(bookList.get(i));
			}
		}
		  return searchList;
	}
	//4.å ����� ���� ������ å�� �����ϴ� �޼ҵ�
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
	//5.å �� �������� �����ϴ� �޼ҵ�
	//å �̸����� �������� �� 1 ��ȯ
	public int ascBook() {
		
		Collections.sort( bookList );
		//������ ������ �־��µ� vo���� Comparable<Book> ���踦 �ϰ� ����
		//������ 
		
		return 1;
		
	}
	
	
	
	
	
	
}
