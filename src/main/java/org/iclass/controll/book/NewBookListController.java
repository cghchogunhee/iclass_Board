package org.iclass.controll.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;
import org.iclass.dao.NewBooksDao;
import org.iclass.vo.NewBooks;

public class NewBookListController implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewBooksDao dao = NewBooksDao.getInstance();
		List<NewBooks> list = dao.selectAll();
		
		request.setAttribute("books", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("newbooks.jsp");
		dispatcher.forward(request, response);

	}

}
