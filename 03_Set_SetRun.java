package com.kh.chap02_set.part01_hashSet.run;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import com.kh.chap02_set.part01_hashSet.model.vo.Student;

public class SetRun {

	public static void main(String[] args) {
		//HashSet hs1 = new HashSet();
		//Set은 추상메소드, 인터페이스라서 객체 생성 안됨 /그래서 자식클래스인 Hashset을 씀
		HashSet<String> hs1 = new HashSet<>();
		
		//적어도 이 시점부터는 HashSet 객체에 값을 주섬주섬 담을 수 있음 (복주머니)
		
		//1. add(추가할 값) : 값 추가 메소드
		hs1.add(new String("반갑습니다."));
		hs1.add(new String("반갑습니다."));
		hs1.add(new String("여러분"));
		hs1.add(new String ("안녕하세요"));
		hs1.add(new String("여러분"));
		//hs1.add(1);
		//hs1.add(new Student());
		
		
		System.out.println(hs1); // 저장 순서유지X, 중복 저장 X  /toString 오버라이딩된거
		
		//2. size() : 현재 HashSet 객체에 들은 데이터의 갯수를 반환해주는 메소드
	    System.out.println("hs1의 크기 : "+hs1.size());
	    
	    //3. remove(삭제할 값 ) : 값을 삭제해주는 메소드
	    //hs1.remove("여러분");
	    hs1.remove(new String("여러분"));
	    System.out.println(hs1);
		
	    //4. clear() : 모든 값 삭제
	    hs1.clear();
	    
	    System.out.println(hs1);  //이것도 오버라이딩 된 형태 / [ ]
	    
	    // List 계열 쓸때랑 메소드들이 비슷=> Collection 이라는 부모가 같아서 오버라이딩 된 형태임!
		
	    System.out.println("--------------------------------------");
	    
	    HashSet<Student> hs2 = new HashSet<>();
	    
	    hs2.add(new Student("공유",20,100));
	    hs2.add(new Student("김영희",25,90));
	    hs2.add(new Student("홍길동",33,80));
	    hs2.add(new Student("공유",20,100)); //주소값이 각각 다르기 때문에 중복으로 판단되지 않음!
	    
	    System.out.println(hs2); 
	    // 저장 순서 유지x, 중복 저장 o  
	    // => 왜? 동일 객체로 판단이 되지 않아서!
	    // HashSet 객체가 중복을 판단하는 기준
	    // 값이 추가될때 마다 equals(), hashCode() 메소드로 값이 중복되는지 비교후
	    // 둘다 true 값이 나온다면 동일객체로 판단
	    
	    /*
	     * HashSet에 객체를 담을 때 내부적으로 equals() 메소드를 활용해서 중복체크를 함
	     * + hashCode() 메소드를 이용해서 십진수값도 일치하는지 중복체크를 함
	     * => equals() 결과가 true 이고 hashCode() 값도 일치한다면 동일객체로 판단을 하겠다.
	     * (equals()는 주소값 비교용 메소드/hashCode()주소값 기준으로 십진수값 생성 )
	     * 
	     * 지금부터는 아무리 주소값이 다르더라도 필드에 들은 값들이 모두 일치한다면 동일 객체로 판단되게끔 메소드들을 오버라이딩!!
	     * 
	     * 각 메소드의 원래 역할
	     * Object클래스에 존재하는 equals() : 두 객체의 주소값을 가지고 동등비교해서 일치하면 true /아니면 false를 반환
	     * Object클래스에 존재하는 hashCode() : 한 객체의 주소값을 기반으로 해시코드값을 만들어서 반환
	     * 
	     * 오버라이딩할 역할
	     * Student 클래스에 존재하는 equals() : 세 필드 값이 일치하면 true/아니면 false 값을 반환하게끔 오버라이딩
	     * Student 클래스에 존재하는 hashCode() : 세 필드값을 기반으로 해서 해시코드 값을 만들어서 반환
	     * 
	     * =>equals() 와 hashCode()는 오버라이딩이 필수는 아님!
	     *   단, Set 계열에 객체를 담고자 할때는 필수!
	     */
	    System.out.println("--------------------------------------");
	    
	    // Set =>무작위 객체가 저장되어 있는 상태 => index 개념이 없음
	    // 고로 반복문 활용이 불가!!
	    // 그럼 담겨있는 객체에 순차적으로 접근을 하고자 할때?
	    
	    //1. 향상된 for문은 사용가능(for each문)=> index 개념이 없는 반복문이라서
	    //for(변수선언부 : 컬렉션명 ) {
	    for(Student s : hs2 ) {
	    	System.out.println(s);
	    }
	    System.out.println("--------------------------------------");
	    
	    //2. ArrayList 에 담아준 후 ArrayList에서 반복문을 수행
	    // ArrayList<Student> list = new ArrayList<>(); //비어있음
	    // list.addAll( hs2 ); //리스트에 hs2에 담겨있던 내용물들을 통째로 추가 
	        
	    ArrayList<Student> list = new ArrayList<>(hs2);
	    //list.addAll(hs2); 
	    //hs2 에 담겨있는 객체들이 추가된 채로 리스트가 생성됨	    
	    
	    
	    for(int i=0 ; i<list.size(); i++) {
	    	System.out.println(list.get(i));
	    }//순서는 지켜지지 않는다.
	    System.out.println("--------------------------------------");
	    
	    //3.HashSet 클래스에서 제공하는 Iterator 반복자를 이용한 방법
	    //hs2에 담겨있는 객체들을 Iterator로 옯겨담아서 반복돌리기 
	    Iterator<Student> it = hs2.iterator();
	    
	    // 반복 돌릴때의 주의사항 : 현재 it 에 더이상 뽑아낼 요소들이 있는지 검사를 해서 반복을 돌려야 함 (string토크나이저랑 비슷함)
	    while(it.hasNext() ) { //현재 it에 더이상 빼올 값이 남아있는가? 라고 물어보는 메소드 (있으면 true, 없으면 false)
	    	System.out.println(it.next());
	    	
	    }
	    //StringTokenizer 와 비슷한 원리 (토큰 뽑는듯이)
	    
	    // .iterator() : List 계열에서, Set 계열에서 쓸수 있음/ Map계열에서는 못씀!
        
	}

}






