package com.kh.practice.list.library.model.vo;

public class Book implements Comparable <Book> {
    
	//��ü ���� �� Comparable<Book> �̸� ����
	//���� �Ҽ� �ִ�  ������
	// category -title
	
	
	//�ʵ��
	private String title;
	private String author;
    private String category;
    private int price;
	
    //�⺻������
    public Book() {
    	
    }
    //�Ű������� �ִ� ������
    public Book(String title,String author,
    		     String category, int price) {
    	this.title=title;
    	this.author=author;
    	this.category=category;
    	this.price=price;
    }
    //�޼ҵ��
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
	//��ü�� ������ �����ϴ� �޼ҵ�
	@Override
	public String toString() {
		return "( "+ title+ "/" +author+ "/"+category+ "/"+price+ " )" ;
	}
	//�ؽ��ڵ带 �����ϴ� �޼ҵ�
	@Override
	public int hashCode() {
		return (title+ author+ category+ price).hashCode();
	}
	//��ü�� ������ ���θ� �����ϴ� �޼ҵ� 
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
	//���� ������ ������ �ִ� �޼ҵ�
	//=> �� �κ� ������� ������
	public int compareTo(Book o) {
		//������ 0, ������ 1, ������ -1
		//category / title
		int result=0;
		
		result=this.category.compareTo(o.category);
		if(result==0) {
			this.title.compareTo(o.title);
		}
		return result;
	}
  
	
}
