package com.kh.practice.list.library.model.vo;

public class Book implements Comparable <Book> {
    
	//객체 설계 시 Comparable<Book> 미리 설계
	//정렬 할수 있는  데이터
	// category -title
	
	
	//필드부
	private String title;
	private String author;
    private String category;
    private int price;
	
    //기본생성자
    public Book() {
    	
    }
    //매개변수가 있는 생성자
    public Book(String title,String author,
    		     String category, int price) {
    	this.title=title;
    	this.author=author;
    	this.category=category;
    	this.price=price;
    }
    //메소드부
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	//객체의 정보를 리턴하는 메소드
	@Override
	public String toString() {
		return "( "+ title+ "/" +author+ "/"+category+ "/"+price+ " )" ;
	}
	//해시코드를 리턴하는 메소드
	@Override
	public int hashCode() {
		return (title+ author+ category+ price).hashCode();
	}
	//객체가 같은지 여부를 리턴하는 메소드 
	@Override
	public boolean equals(Object obj) {
		
		Book other =(Book)obj;
		
		if( (this.title.equals(other.title) )&&
			(this.author.equals(other.author))&&
			(this.category.equals(other.category))&&
			(this.price==other.price) ) {		 
			return true;			
		}
		else {
			return false;
		}	
	}
	//정렬 기준을 가지고 있는 메소드
	//=> 이 부분 어려워서 참고함
	public int compareTo(Book o) {
		//같으면 0, 높으면 1, 낮으면 -1
		//category / title
		int result=0;
		
		result=this.category.compareTo(o.category);
		if(result==0) {
			this.title.compareTo(o.title);
		}
		return result;
	}
  
	
}
