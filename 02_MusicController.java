package com.kh.chap01_list.part02_mvc.controller;

import java.util.ArrayList;

import com.kh.chap01_list.part02_mvc.model.vo.Music;

//Controller : 사용자의 요청을 받아서 처리해주는 클래스, 처리결과  View로  돌려보냄 => MVC 패턴에서 C에 해당됨
public class MusicController {

	 private ArrayList<Music> list = new ArrayList<>();  //밑에 있으면 지역변수라 모두 쓸수 없음 그래서 위치 변경함	
	  { // 초기화 블록 : 필드에 값을 대입해주는 용도
		  list.add(new Music("Tears","소찬휘"));  // 0번째 
		  list.add(new Music("와","이정현"));  // 1번째		  		  
	  }
	  
	  
	//새로운 곡 추가 요청이 들어왔을 때 실행될 메소드 (곡 추가 기능 담당)
	public int insertMusic(String title, String artist) {	
		
		//추가 후 size -추가 전 size = 몇개가 추가되었는지 알수 있음
		int before = list.size();
		
		list.add(new Music(title, artist));	
		
		int after =list.size();
		
		return (after-before);
	}
	
	//곡 전체 조회 요청이 들어왔을 때 실행될 메소드 (곡 전체 조회 기능 담당)
	public  ArrayList<Music> selectMusicList() {   
		//반환값 - ArrayList<Music>전체를 조회해야 하기 때문에 넣을수 있음
		//ArrayList<Music> list 타입이 같은 걸 봐야 함 
		
		return list;		
	}
	//특정 곡 검색 요청이 들어왔을 때 실행될 메소드(특정 곡 검색 기능 담당)
	public ArrayList<Music> searchMusic(String keyword){
		
		// 검색기능 => 반복은 다 돌려야 함 무조건
		//        => 반복 돌리다가 포함된게 있으면 검색결과만 들어있을 list 하나 만들어서 추가
		
		//1. 검색결과가 담길 ArrayList 객체를 하나 만들기
		ArrayList<Music> searched = new ArrayList<>(); //현재 빈상태 (기본은 10칸)
		
		//2. 반복돌리면서 곡제목에 keyword 가 포함되어있나 검사=> 포함되어있으면 1번에서 만든 list에 추가
		for(int i=0; i< list.size();i++) {
			
			if(list.get(i).getTitle() .contains( keyword ) ) { //검색조건이 맞다면
				//  a.contains(b)
				//=> a,b는 문자열
				//=> a라는 문자열에 부분 문자열로  b가 포함되어있을경우 true /아니면 false 반환
				searched.add(list.get(i));				
			}			
		} //적어도 이 시점에는 searched 에 검색 내용들만 담길 것임!
		
		//3. 검색결과 리턴
		//return 검색된 결과들이 담긴 list;
		return searched;
		
	}
	 //특정 곡 삭제 요청시 실행될 메소드(특정 곡 삭제 기능 담당)
	public int deleteMusic(String title) {
		
		//1. 리턴할 결과값을 담을 변수 셋팅
		int result=0; //삭제가 진행된 횟수
	
		//2. 반복문을 활용하여 getTitle() 과 title 을 동등비교해서 삭제
		// => 이때 삭제가 잘 일어난다면 리턴할 결과값에 ++처리
		for(int i=0; i< list.size();i++) {
			
			if(list.get(i).getTitle().equals(title)) { //제목이 동일하다면 삭제
				
				//삭제=>remove(인덱스위치값)
				list.remove(i);
				
				//삭제 횟수 1증가
				result ++;
				
			}
		}	
		//3. 정수 결과값 리턴
		return result; // 0 일수도 있고 양수값일수도 있음
		
	}
	//특정 곡 수정 요청시 실행될 메소드(특정 곡 수정 기능 담당)
    public int updateMusic(String title,String upTitle,String upArtist) {
    	
    	//1. 반환할 결과값을 담을 변수 셋팅
    	int result = 0;
    	
    	//2. 반복
    	//=> 곡제목이 일치하는지 동등비교 (동등하다면 수정 진행, result++;)
    	for(int i=0; i<list.size();i++) {
    		if(list.get(i).getTitle() .equals(title) ) { //동등하다면 수정을 진행하겠다.
    			
    			//수정하는 코드 작성 => 필드값을 수정 (setter 메소드)
    			//list.get(i) //i번째 존재하는 Music 타입의 객체
    			list.get(i).setTitle(upTitle);
    			list.get(i).setArtist(upArtist);
    			
    			//result 값 1 증가
    			result++;    			
    		}
    	}   
    	//3. 결과값 리턴
    	return result;
    	
    }
	
	
	
	
	
	
	
	
	
}
