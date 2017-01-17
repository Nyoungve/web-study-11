package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;

//게시글 삭제를 위한 액션 클래스 
public class BoardDeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num=request.getParameter("num");
		BoardDAO bDao=BoardDAO.getInstance();
		bDao.deleteBoard(num);
		new BoardListAction().execute(request, response);
	}
}

