package com.saeyan.controller;

import com.saeyan.controller.action.Action;
import com.saeyan.controller.action.BoardCheckPassAction;
import com.saeyan.controller.action.BoardCheckPassFormAction;
import com.saeyan.controller.action.BoardDeleteAction;
import com.saeyan.controller.action.BoardListAction;
import com.saeyan.controller.action.BoardUpdateAction;
import com.saeyan.controller.action.BoardUpdateFormAction;
import com.saeyan.controller.action.BoardViewAction;
import com.saeyan.controller.action.BoardWriteAction;
import com.saeyan.controller.action.BoardWriteFormAction;


//인터페이스 Action에서 객체를 생성해내는 클래스ActionFactory 따로 생성.
//ActionFactory는 싱글톤 형태로 유일하게 한 개의 객체만 생성하고 이를 getInstance()로 호출하여 사용합니다.
public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory :" + command);
		//추가된 부분 
		//01.boardList.jsp로 실행하여 결과값을 얻어오려면
		//커맨드에 따라 알맞은 작업을 처리하기 위한 명령처리 클래스인 ActionFactory를 다음과 같이 수정!
		if(command.equals("board_list")){
			action = new BoardListAction(); //Action인터페이스 상속받은 BoardListAction클래스의 오버라이딩된 execute함수 사용!
		}else if(command.equals("board_write_form")){
			action = new BoardWriteFormAction(); //Action인터페이스 상속받은 BoardWriteFormAction클래스의 오버라이딩된 execute함수 사용!
		}else if(command.equals("board_write")){
			action = new BoardWriteAction(); //Action인터페이스 상속받은 BoardWriteAction클래스의 오버라이딩된 execute함수 사용!
		}else if(command.equals("board_view")){
			action = new BoardViewAction(); //Action인터페이스 상속받은 BoardViewAction클래스의 오버라이딩된 execute함수 사용!
		}else if(command.equals("board_check_pass_form")){
			action = new BoardCheckPassFormAction(); //Action인터페이스 상속받은 BoardCheckPassFormAction클래스의 오버라이딩된 execute함수 사용!
		}else if(command.equals("board_check_pass")){
			action = new BoardCheckPassAction(); //Action인터페이스 상속받은 BoardCheckPassAction클래스의 오버라이딩된 execute함수 사용!
		}else if(command.equals("board_update_form")){
			action = new BoardUpdateFormAction(); //Action인터페이스 상속받은 BoardUpdateFormAction클래스의 오버라이딩된 execute함수 사용!
		}else if(command.equals("board_update")){
			action = new BoardUpdateAction(); //Action인터페이스 상속받은 BoardUpdateFormAction클래스의 오버라이딩된 execute함수 사용!
		}else if(command.equals("board_delete")){
			action = new BoardDeleteAction(); //Action인터페이스 상속받은 BoardDeleteAction클래스의 오버라이딩된 execute함수 사용!
		}
		
		return action;
	}
}

