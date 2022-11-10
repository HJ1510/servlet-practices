package jstlel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class _03Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<UserVo> list = new ArrayList<>();
		
		UserVo vo1 =new UserVo();
		vo1.setNo(1L);
		vo1.setName("둘리1");
		vo1.setEmail("dooly1@gmail.com");
		list.add(vo1);
		
		UserVo vo2 =new UserVo();
		vo2.setNo(2L);
		vo2.setName("둘리2");
		vo2.setEmail("dooly2@gmail.com");
		list.add(vo2);
		
		UserVo vo3 = new UserVo();
		vo3.setNo(3L);
		vo3.setName("둘리3");
		vo3.setEmail("dooly3@gmail.com");
		list.add(vo3);
		
		
		request.setAttribute("list1", list);
		request.getRequestDispatcher("/WEB-INF/views/03.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
