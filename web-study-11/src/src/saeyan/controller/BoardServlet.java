package src.saeyan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.ActionFactory;
import com.saeyan.controller.action.Action;


@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//command 파라미터를 쿼리 스트링 형태로 전달 해 주면 됨. 
		//주소 ?command=board_list
		//     파라미터   요청하고자하는작업
		String command = request.getParameter("command");
		System.out.println("BoardServlet에서 요청을 받음을 확인 : " + command);
		
		//사용자요청의 알맞은 처리를 위해서 ActionFactory의 getAction 메소드를 호출한다.(문제점: 새로고침할 때마다 요청을 받아서 게시글목록에 올라옴...) 
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command);
		
		//예외 발생 막기
		if(action != null){
			action.execute(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
