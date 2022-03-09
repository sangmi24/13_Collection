package com.kh.chap02_set.part01_hashSet.model.vo;

public class Student {

	// 필드부
	private String name; //이름
	private int age;  //나이
	private int score;  //점수
	
	//생성자부
	public Student() {
		super();
	}
	public Student(String name, int age, int score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}
	//메소드부
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
	}
	/*
	//equals()메소드 재정의 : 세 필드값이 모두 일치하는지 
	@Override
	public boolean equals(Object obj) { //뭐가 들어올지 몰라서 object 넣음
		
		//Student객체.equals(비교할Student객체);
		
		Student other=(Student)obj;
		
		//this.name 과 other.name이 일치하는지
		//this.age 과 other.age가 일치하는지
		//this.score 과 other.score가 일치하는지
		if( (this.name.equals(other.name) )&&
			(this.age==other.age) &&
			(this.score==other.score) ){ //모든 필드가 일치할때
			return true;
		}
		else {
			return false;
		}
			
	}
	//hashCode()메소드 재정의 :필드값을 가지고 문자열 하나로 만든 다음에 hashCode 생성
	@Override
	public int hashCode() {
		//"공유20100"
		return (name +age+score ).hashCode();
	}
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + score;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (score != other.score)
			return false;
		return true;
	}
	
	
	
	
}
