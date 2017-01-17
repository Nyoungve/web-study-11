package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//다형성을 위해서 비슷한 형태의 클래스를 여러개 정의할 경우 공통적으로 갖는 메소드를 인터페이스 내의 추상함수로 정의한다.!!!
//모든 모델들은 Action 인터페이스의 상속을 받는 구현 객체 이어야 한다. 이는 액션 객체라 부른다. 
//컨트롤러에서는 직접 모델(액션 객체)을 생성하지 않는 대신 액션 객체를 생성해내는 팩토리 역할을 하는 클래스를 통해서 생성한다. 
//객체를 생성해내는 클래스를 따로 설계해서 작업하는 것을 팩토리 패턴이라고 한다. 
public interface Action { //요청에 의해 동작이 일어난다는 의미의 액션
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
