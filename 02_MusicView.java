package com.kh.chap01_list.part02_mvc.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kh.chap01_list.part02_mvc.controller.MusicController;
import com.kh.chap01_list.part02_mvc.model.vo.Music;

// View : 시각적인 요소 담당 ( 사용자가 보게 될 화면과 같음) => 출력문과 입력문을 주로 씀 => MVC 패턴에서 V를 담당
public class MusicView {

	//지역변수로 하면 {}구역안에서만 사용가능해서 전역변수로 만듬(위치변경함)
	private Scanner sc = new Scanner(System.in);
	MusicController mc = new MusicController();
	
	//메인화면 : 프로그램 실행시 제일 처음 보여지는 화면
	public void mainMenu() {
		
		//System.out.println 구문을 이용해서 적당히 꾸미기
		while(true) {
			
			System.out.println("***** Welcome 별밤 *****");
		    System.out.println("1. 새로운 곡 추가");
		    System.out.println("2. 곡 전체 조회");
		    System.out.println("3. 특정 곡 검색");
		    System.out.println("4. 특정 곡 삭제");
		    System.out.println("5. 특정 곡 수정");
		    System.out.println("0. 프로그램 종료");
		    
		    System.out.print("메뉴입력 : ");
		    int menu = sc.nextInt();
		    sc.nextLine();
			
			switch(menu) {
			case 1:
				//메소드로 빼기 => 호출하는 방식으로 변경
				insertMusic();
				break;
			case 2:
				//메소드로 빼기 => 호출하는 방식으로 변경
				selectMusicList();
				break;
			case 3:
				searchMusic();
				break;
			case 4:
				deleteMusic();
				break;
			case 5:
				updateMusic();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다. 안녕히 가세요.");
				return; //완전 종료하기 위해서
			default :
				System.out.println("없는 메뉴를 입력했습니다. 다시 입력해 주세요.");
			}
		}
	}
	
	// 1. 새로운 곡을 추가할 수 있는 화면 (insert 삽입하다)
	public void insertMusic() {
				
		System.out.println("----1. 새로운 곡 추가----");
		System.out.print("곡명 입력 : ");
		String title =sc.nextLine();
		System.out.print("가수명 입력 : ");
		String artist= sc.nextLine();
		
		// 이 시점까지 우리가 음악을 추가하고자할때 필요한 정보들은 다 입력받은 상태
		
		// 요청 => Controller 의 메소드를 호출 (필요한 정보들을 매개변수로 넘길것)
		
		//MusicController mc = new MusicController();
		//추가적으로 곡이 추가된 횟수를 리턴받아서 양수이면 성공, 아니면 실패 출력
		int result = mc.insertMusic(title,artist);
		
		if(result>0) {
		System.out.println("성공적으로 추가되었습니다. ");
		}
		else {
			System.out.println("곡 추가가 실패했습니다.");
		}
	}
	//2. 전체 곡을 조회할 수 있는 화면
	public void selectMusicList() {
		System.out.println("----2.곡 전체 조회----");
		
		// 있는거 다 뿌려주면 그만이기 때문에 입력받을 필요가 없음!
		
		// 요청 => Controller의 메소드를 호출 (이번에는 필요한 데이터가 없어서 매개변수를 굳이 안넘겨도 됨)
		//MusicController mc = new MusicController();
		ArrayList<Music>list = mc.selectMusicList();
		
		//Controller에서 조회하려고 했으나 view 단에서 출력하기로 약속했기 때문에 
		
		if(list.isEmpty()) {//만약에 노래가 없다면
			System.out.println("현재 존재하는 노래가 없습니다.");
		}
		else { // 노래가 있다면
			
			System.out.println("현재 존재하는 노래는 총"+list.size() +"곡 입니다.");
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}			
		}
	}
	  // 3. 특정 곡을 검색할 수 있는 화면
	public void searchMusic() {
		
		System.out.println("----3.특정 곡 검색----");
		System.out.print("검색할 곡명 키워드 : ");
		String keyword= sc.nextLine();
		
		// 요청 => Controller 메소드 호출(검색어가 포한된 곡을 모두 찾아서 반환)
		// 결과값이 0곡 OK / 결과값이 1곡 OK / 결과값이 2곡 이상 OK
		//=> 2곡 이상일 가능성이 있으므로 ArrayList 타입으로 검색된 내용들을 묶어서 돌려받겠다.
		
		ArrayList<Music> searched = mc.searchMusic(keyword);
		
		System.out.println("검색 결과");
		if(searched.isEmpty()) { //검색 결과가 없다면
			System.out.println("검색 결과가 없습니다.");
		}
		else { //검색 결과가 있다면
			System.out.println("검색 결과는 총 "+ searched.size() +"곡 입니다.");
			for ( Music m : searched  ) { //변수선언부 : 컬렉션명 
				
				System.out.println(m);				
			}			
		}
	}
	  //4. 특정 곡을 삭제할 수 있는 화면
	  public void deleteMusic() {
		  
		  System.out.println("----4.특정 곡 삭제----");
		  System.out.print("삭제할 곡 명: ");
		  String title=sc.nextLine();
		  
		  // 요청=>Controller 메소드 호출 ( 매개변수로 title 넘겨줌)
		  // 추가적인 기능
		  // 삭제가 일어난 횟수를 메소드 반환값으로 돌려받을것
		  int result = mc.deleteMusic(title);
		  
		  // result 가 0일 경우 : 삭제가 0건 됨
		  // result 가 양수일 경우: 삭제가 그만큼 됨
		  if(result >0 ) { //양수일 경우=> 삭제가 진행됨
			  System.out.println("총 "+ result + "곡이 삭제되었습니다.");
		  }
		  else { //삭제할 곡을 찾지 못함
			  System.out.println("삭제할 곡을 찾지 못했습니다.");
		  }	  
	  }
	  // 5.특정 곡을 수정할 수 있는 화면
	  public void updateMusic() {
		  
		  System.out.println("----5.특정 곡 수정----");
		  
		  //수정 => 뭐를 어떻게 바꿀건지 제시해야 함!
		  //기존 곡명(뭐를), 수정할 곡명, 가수명(어떻게) 세가지 모두 입력받을것
		 System.out.print("기존 곡명: ");
		 String title=sc.nextLine();
		 System.out.print("수정 내용(곡명): ");
		 String upTitle =sc.nextLine();
		 System.out.print("수정 내용(가수명): ");
         String upArtist=sc.nextLine();
         
         // 요청=> Controller메소드 호출(title,upTitle, upArtist 매개변수로 세개 다 전달)
         // 추가 기능
         // 수정된 횟수를 반환값으로 돌려받을것임! => 0이라면 (실패) /양수(성공)
         int result = mc.updateMusic(title,upTitle,upArtist);
         
         if(result>0) { // 수정에 성공했다면
        	 System.out.println("성공적으로 수정하였습니다.");
         }
         else { //수정에 실패했다면
        	 System.out.println("수정할 곡을 찾지 못했습니다.");
         }
         
	  }
	
	
	
}
