package controll.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CommentDao;
import model.dto.CommentDto;

@WebServlet("/admin/comment")
public class comment extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 한글 인코딩
		String type = request.getParameter("type");

		int rno = Integer.parseInt(request.getParameter("rno"));
		String ctitle = request.getParameter("ctitle");
		String ccontent = request.getParameter("ccontent");

		System.out.println(rno);
		System.out.println(ctitle);
		System.out.println(ccontent);

		CommentDto dto = new CommentDto(0, ctitle, ccontent, null, rno);

		System.out.println(dto);

		boolean result = CommentDao.getInstance().writrecomment(dto);
		System.out.println(dto.toString());

		response.getWriter().print(result);
	}
	
	private static final long serialVersionUID = 1L;
       
    public comment() {
        super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}




}
