package com.kh.chap03_map.part01_hashMap.run;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.chap03_map.part01_hashMap.model.vo.Snack;

public class MapRun {

	public static void main(String[] args) {
		
		HashMap<String, Snack> hm = new HashMap<>();
        //계층 구조를 보면 List, Set계열은 Collection 인터페이스를 구현한 클래스들
		//=> 데이터를 추가할때 add 메소드를 사용함
		//단, Map은 부모가 애초에 Collection이 아님!
		//=>데이터를 추가할때 put메소드 사용 (key +value 세트로 추가 )
		
		//1. put(K key, V value) :map 공간에 key+value 세트로 추가해주는 메소드
		hm.put("꼬깔콘", new Snack("새우마요맛",200));		
		hm.put("꼬북칩", new Snack("초코츄러스맛",400));		
		hm.put("스윙칩", new Snack("그냥..양파맛?",300));		
		hm.put("새우깡", new Snack("간이된새우맛",500)); 
				
		System.out.println(hm);
		//저장 순서 유지x, 
		
		hm.put("포테이토칩", new Snack("그냥..양파맛?",300));
		
		System.out.println(hm);
		//value 값이 중복되더라도 key값이 중복되지만 않으면 잘 저장됨
		
		hm.put("새우깡", new Snack("매운새우맛",600));
		//key값이 중복된 상태
		
		System.out.println(hm);
		// 만약에 key값이 중복되었다면 가장 마지막에 put한 value가 덮어씌어진다.
		
		//2. get(Object key) :  V : 해당 키값의 value를 돌려주는 메소드
		System.out.println(hm.get("꼬북칩"));
		System.out.println(hm.get("새우깡"));
		
		//Snack s=(Snack)hm.get("새우깡");  // 제네릭을 설정하지 않는다면 매번 자식타입으로 형변환 해줘야함(다형성)
		
		//3. size() : HashMap 객체에 들어있는 자료의 갯수를 반환해주는 메소드
		System.out.println("size: "+hm.size()); //5
		
		//4. replace(K key, V value) : HashMap 객체에 해당 key값을 찾아서 새로 전달된 value로 바꿔치기 해주는 메소드
		hm.replace("꼬북칩", new Snack("인절미맛",350));
		System.out.println(hm);
		
		// put 메소드는 애초에 없는 값을 추가해서 용도라서 만약 key값이 중복된다면 덮어씌어지고, key값이 중복되지 않는다면 추가
		// replace 메소드는 애초에 있는 key 값을 찾아서 value 를 바꿔치기 해주는 용도
		
		//5. remove(Object key) : HashMap 으로부터 key 값에 해당되는 key+value를 세트로 지워주는 역할
		hm.remove("새우깡");
		System.out.println(hm);
		
		System.out.println("size: "+hm.size());  // 4
		
		System.out.println("------------------------------------------");
		
		// 순차적으로 HashMap 에 있는 데이터들에 접근하고자 할때?
		
		//참고) Set을 반복돌리고 싶을때?
		// 1. 향상된 for문 => 변수선언부 어떻게 작성..? => 사용 불가		
		// 2. ArrayList 로 옮기는 방법 => 부모가 다른 계열이기 때문에 옮기는거 불가		
		// 3.  .iterator() : Map 계열에서는 사용불가
		
		//=> Map 계열에서 제공하는 메소드2가지(Map 을 Set 으로 바꿔줌)
		
		//Map을 Set 으로 바꿔주는 메소드
		//1. keySet() : HashMap에 있던  key들만 Set으로 옮겨주는 역할 
		//Set은 객체생성x,이렇게 담는 용도로만 쓰임
		Set<String> keySet = hm.keySet();
		
		//적어도 이 시점에서는 Set 에 key값들이 다 담긴 상태 = > 1,2,3번 방법으로 반복 가능
		
		//3. .iterator() 방법으로 반복 돌려보기
		Iterator<String> itKey= keySet.iterator();
		//아까전에 뽑았던 key값들만 담겨있음 
		
		while(itKey.hasNext()) { //(조건식 =>더이상 뽑을게 있니?)
		      
			String key = itKey.next(); //key 라는 변수에는 매번 반복될때마다 HashMap에 있었던 key값이 들어갈것임!
			Snack s = hm.get(key);
			System.out.println("key: "+key+"value: "+s);
		}
		
		System.out.println("------------------------------");
		//2. entrySet() : HashMap 에 있던 key+value 모두 Set으로 옮겨주는 역할 (Entry 집합형태) //Entry()가 최소단위 
		Set<Entry<String,Snack>> entrySet = hm.entrySet();
		
		// 이 시점부터는 Set 이 완성이 된 상태라서 1,2,3 번 방법중 아무거나 반복을 돌리면 됨
		
		// .iterator() 
		Iterator<Entry<String,Snack>> itEntry=  entrySet.iterator();

		while(itEntry.hasNext()) {
			Entry<String,Snack> entry = itEntry.next();
			
			System.out.println("key: "+entry.getKey()+",value: "+ entry.getValue());
			
		}	
		
		
		
		
		
	}
}



