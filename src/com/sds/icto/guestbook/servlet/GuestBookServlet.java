package com.sds.icto.guestbook.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.guestbook.action.deleteAction;
import com.sds.icto.guestbook.action.deleteformAction;
import com.sds.icto.guestbook.action.insertAction;
import com.sds.icto.guestbook.action.listAction;
import com.sds.icto.guestbook.dao.GuestBookDAO;
import com.sds.icto.guestbook.vo.GuestBookVO;
import com.sds.icto.web.Action;

@WebServlet("/guest")
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GuestBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		Action act = null;
		try {
			if("list".equals(action)){
				//showList(request, response);
				act = new listAction();
			} else if ("deleteform".equals(action)) {
				act = new deleteformAction();
			} else if ("delete".equals(action)) {
				act = new deleteAction();
			} else if ("insert".equals(action)) {
				act = new insertAction();
			} else {
				act = new listAction();
			}
			act.execute(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/*private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		String message = request.getParameter("content");
		
		GuestBookVO vo = new GuestBookVO();
		vo.setName(name);
		vo.setPassword(password);
		vo.setMessage(message);

		GuestBookDAO dao = new GuestBookDAO();
		try {
			dao.insert(vo);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("guest");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		GuestBookDAO dao = new GuestBookDAO();
		try {
			dao.delete(Integer.parseInt(id), password);
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("guest");	
	}

	private void showList(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		GuestBookDAO dao = new GuestBookDAO();
		ArrayList<GuestBookVO> list = new ArrayList<GuestBookVO>();
		try {
			list = dao.guestBookList();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}*/
	
}
