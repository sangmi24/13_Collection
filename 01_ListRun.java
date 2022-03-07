package com.kh.chap01_list.part01_arrayList.run;

import java.util.ArrayList;
import java.util.List;

import com.kh.chap01_list.part01_arrayList.model.vo.Music;

public class ListRun {

	/*
	 * * 컬렉션 (Collection) 
	 * "자료구조"가 내장되어있 는 클래스로 자바에서 제공하는 "자료구조"를 담당하는 "프레임워크"이다.
	 * 
	 * -자료구조
	 * 방대한 데이터들을 효율적(구조적)으로 다룰 때 필요한 개념
	 * => 여러개의 값들을 어떻게 보관하면 효율적일까? 에 대해서 공부하는 학문
	 * 
	 * -프레임워크
	 * 효율적인 기능들이 이미 정의되어있는 틀 
	 * 
	 * 정리해보면
	 * 데이터들이 새롭게 추가되거나, 삭제가 되거나, 수정이 되는 기능들이 이미 정의되어있는 틀이 있다. == "컬렉션"
	 * => 다량의 데이터들을 관리하고자 할 때 그동안은 배열을 가지고 충분히 사용했었음
	 *    단, 은근 단점들이 존재했다라는 것 (이 단점들을 보완한 개념이 컬렉션)
	 *    
	 * *배열과 컬렉션의 차이점   
	 * - 배열의 단점
	 * 1. 배열을 쓰고자 할때 먼저 크기를 지정해야 함
	 *  => 한번 지정된 크기는 변경이 불가
	 *   (새로운 값을 추가할 때 배열의 크기가 오버된다면, 새로운 크기의 배열을 만들고 기존의 내용물들을 복사해서 담아주고 새로이 값을 추가하는 코드를 일일이 다 짜야함)
	 * 2. 배열의 중간 위치에서 새로운 데이터를 추가하거나 삭제하는 경우 기존의 값들을 땡겨오거나 한칸씩 밀어주는 코드를 직접 짜야함
 	 * 3. 한가지 타입의 값들만 저장 가능 
	 * 
	 * - 컬렉션의 장점
	 * 1. 크기에 제약이 없다. 
	 * => 크기지정을 따로 해줄 필요도 없고, 만일 크기지정을 해도 알아서 크기가 늘어나면서 새로운 데이터들을 추가
	 * 2. 중간에 값을 추가하거나 삭제하는 경우 값을 땡겨주거나 밀어주는 코드가 이미 메소드로 정의되어있음
	 * => 필요 시 메소드 호출하여 사용
	 * 3. 기본적으로 여러 타입의 데이터들을 한번에 묶어서 저장할 수 있음
	 *  (단, 제네릭 설정을 통해서 한 타입의 데이터들만 들어올 수 있게끔도 설정 가능)
	 * 
	 * 방대한 데이터들을 단지 담아만 두고 조회만 할 목적=> 배열
	 * 방대한 데이터들이 빈번하게 추가,삭제,수정될것 같다=> 컬렉션
	 * 
	 * *컬렉션의 3가지 분류 (상속 구조)
	 * -List 계열 : 담고자 하는 값(value) 만 저장 / 값 저장시 순서를 유지 (==index 개념이 존재함) /중복되는값을 허용 => 배열과 거의 유사한 특징
	 *            예) ArrayList, Vector, LinkedList => ArrayList가 가장 많이 쓰인다.
	 * -Set 계열 : 담고자 하는 값(value)만 저장 / 값 저장시 순서를 유지x (index 개념이 없음) /중복되는 값이 허용x
	 * (복주머니)   예) HashSet , TreeSet  
	 * -Map 계열 : 키(key,식별자(중복x)) +담고자 하는  값(value, 중복가능) 세트로 저장/ 값 저장시 순서를 유지x(index 개념이 없음)
	 *          / key 는 중복값 허용x, value는 중복 허용
	 *          예) HashMap, Properties
	 */
		
	public static void main(String[] args) {
		
	  //ArrayList를 쓰겠다 => ArrayList 객체를 생성
		
		/*
		 * * 제네릭 (<E>)
		 * - 어떤 자료형만 담겠다 라고 컬렉션에 담길 값의 형태를 지정해주는 역할
		 * - 제네릭설정을 하면 배열처럼 한 타입의 값들밖에 못담음!
		 * 
		 *  별도의 제네릭 제시 없이 컬렉션 객체를 생성하면 => E == Object (최상위 부모, 다형성 적용해서 퉁쳐서 하나로 처리하려고)
		 *                                   => 해당 컬렉션에 다양한 타입의 데이터 값들이 담길 수 있음
		 *  별도의 제네릭 설정을 <Music> 으로 하게 되면 => E == Music 
		 *                                   => 해당 컬렉션에 Music 타입의 객체만 담길 수 있음
		 *                                   => 형변환을 매번 안해줘도 됨  
		 *                                                                   
		 *  제네릭을 설정하는 이유
		 *  1. 명시한 타입의 객체만 저장가능하도록 타입의 제한을 두기위해서
		 *  2. 컬렉션에 저장된 객체를 꺼내서 사용할 경우 매번 형변환하는 절차를 없애기 위해서 
		 *  
		 *  주의사항
		 *  제네릭에는 참조자료형만 들어갈 수 있음
		 *  만약에 기본자료형 타입으로 설정하고 싶다면 Wrapper 클래스를 이용해야 함!
		 */
	
	  //ArrayList list = new ArrayList(); //내부적으로 크기10짜리인 배열이 생성됨
		
	  // ArrayList list = new ArrayList(3); //내부적으로 크기3짜리인 배열이 생성됨
	
	  // 제네릭 설정을 추가해서 ArrayList 객체 생성
		
		ArrayList<Music> list = new ArrayList</* Music */>(3);  //Music 타입만 받아줄 수 있음
		//<Music>이 자리에 참조자료형만 들어갈 수 있음 (Double....등등)
	   // 이 시점까지 어레이리스트를 사용할 준비가 완료됨
	   
	   System.out.println(list); // [] : 안에 아무것도 없는 상태 (비어있다.)
	
	   //ArrayList에서 제공하는 메소드들: 추가, 삭제, 뽑아오기 ,...
	   // E-->Element: 제네릭 (어느 타입이 들어갈지 아무도 예측 불가하기 때문에 Element타입으로 작성한것)=>object
	   //1. add(E e) : 해당 리스트의 끝에 전달된 e(추가될 내용)를 추가시켜주는 메소드 /E e추가될내용
	   //=> 위치지정이 안되고 무조건 맨 뒤에 추가
	   list.add(new Music("Tears","소찬휘") );  //0번째 인덱스에 저장  /클래스 자체를 안에 넣을수 있음
	   list.add(new Music("와","이정현"));       //1번째 인덱스에 저장
	   list.add(new Music("바다의왕자","박명수")); //2번째 인덱스에 저장
	   //list.add("끝");                       //3번째 인덱스에 저장
	   
	   // 순서가 유지되면서 값이 추가됨(각 index 에 담겨있음)
	   // 크기에 제약이 없음
	   // 다양한 타입의 값 추가를 지원
	   
	   System.out.println(list); //toString 호출, 오버라이딩 되서 값이 문자열로 나옴
	   
	   // 2. add(int index,E e) : 리스트에 전달되는 index값 위치에 전달되는 e 추가시켜주는 메소드 
	   //=> 오버로딩된 형태로 위치지정해서 값을 넣음!
	   list.add(1, new Music("강남스타일","싸이"));
	   
	   //중간에 값 추가 시 알아서 기존의 값들을 뒤로 땡겨주는 작업이 내부적으로 진행됨
	   
	   System.out.println(list);
       
	   // 3. set(int index, E e) : 리스트에 해당 인덱스의 값을 전달되는 e로 변경시켜주는 메소드
	   // => 어느 위치의 것을 뭐로 바꿔줄것인지 
	   list.set(1, new Music("강북멋쟁이","정형돈"));
	   
	   System.out.println(list);
	   
	   // 4. remove(int index) : 리스트에 해당 인덱스의 값을 삭제시켜주는 메소드
	   list.remove(2);
	   
	   // 중간에 값 삭제 시 알아서 기존의 값들을 앞으로 땡겨주는 작업이 내부적으로 진행됨
	   
	   System.out.println(list);
	   
	   // 5. size() : 리스트에 담겨있는 데이터의 갯수를 반환해주는 메소드 
	   //=> 배열명.length 랑 같은 역할
       System.out.println("리스트에 담긴 데이터 수 : "+ list.size()); //총 4개 (노래3곡, 문자열1개)
       System.out.println("리스트의 마지막 인덱스: "+(list.size()-1) );
	   
       // 6. get(int index) : E : 리스트에 해당 index 위치의 데이터를 반환해주는 메소드
       
       //제네릭 설정 전 
       /*
       //Music m = (Music)list.get(0);  //다형성에 의해 강제형변환
       //System.out.println(m);  //toString 호출, 오버라이딩 되서 값이 문자열로 나옴
       System.out.println(list.get(0)); 
       System.out.println( ( (Music)list.get(0) ).getTitle());
       */
       
       //제네릭 설정 후
       Music m = list.get(0);
       System.out.println(m);
       System.out.println(m.getTitle());
       System.out.println( list.get(1).getTitle() ); //굳이 형변환을 할 필요가 없음!
       
       // 현재 자료형의 통일이 이뤄지지 않았기 때문에 최상위 부모인 Object를 통해서 형변환을 해야 한다. 
       System.out.println("-------------------------------------");
       
       // 반복문을 사용하여 0번~ 마지막인덱스까지 데이터 출력
       //  for문 버전
       
       for(int i=0; i<list.size(); i++) {
    	   System.out.println(list.get(i));
       }
           
       System.out.println("-------------------------------------");
       // 향상된 for문 버전 (for each문) : 단순히 조회할때만 가능하다. 
       //=> for(값을담을변수선언문(자료형 변수명): 순차적으로 접근할 배열명또는컬렉션명) { 
                                 //Object<=값을 담을 변수에는 무엇이든 담길수 있다
       /* 제네릭 설정 전
    	 for(Object o: list) {
    	     System.out.println(o);
       }*/
    	 // 제네릭 설정 후 : 애초에 들어갈 타입이 정해져 있음!
         for(Music music  : list ) {
      	   System.out.println(music);
         }
         
    	 System.out.println("-------------------------------------");
    
       // 7. subList(int beginIndex, int endIndex) : 해당 리스트로부터 beginIndex 부터 endIndex-1까지의 데이터값들을 추출해서
       //                                                          새로운 List로 반환시켜주는 메소드 
       //제네릭 설정전  
       // List sub =list.subList(0, 2); //interface를 호출(객체 생성만 안됨 , 조회는 가능)
                                       //시작인덱스<=출력할 인덱스 범위 < 마지막 인덱스 
    	 //제네릭 설정후 
    	 List<Music> sub =list.subList(0, 2); //Music만 담겨있는 Arrays로부터 부분 List를 뽑겠다(당연히 Music만 담겨있을거) 
         System.out.println(sub);            
         
         System.out.println("-------------------------------------");
	   // 8. addAll(Collection c) : 해당 리스트에 다른 컬렉션에 있는 데이터들을 통채로 추가해줄 수 있는 메소드 (연이여 붙여줌)
         
         list.addAll(sub);
         
         System.out.println(list);
         System.out.println("-------------------------------------");
       // 9. isEmpty() : 해당 리스트가 비어있는지 묻는 메소드
       //               (비어있으면 true / 비어있지 않다면 false 반환)
         System.out.println("리스트가 비어있습니까? : " +list.isEmpty() );
         
       // 10. clear() : 해당 리스트를 싹 비워주는 메소드
          System.out.println("리스트 비움 ");
          list.clear();
          System.out.println(list); // []
          System.out.println("리스트가 비어있습니까? : " +list.isEmpty());
     
	}

}
























