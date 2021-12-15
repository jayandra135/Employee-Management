package com.emplogin.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emplogin.database.EmpDao;
import com.emplogin.bean.EmpBean;


/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/EmpLogin")
public class EmpLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpDao userDAO;
	
	public void init() {
		userDAO = new EmpDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/inserting":
				insertingUser(request, response);
				break;
				default:
					listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	private void insertingUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		EmpBean newUser = new EmpBean(email, country);
		userDAO.insertingUser(newUser);
	
			response.sendRedirect("listing");
		
		
	}
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<EmpBean> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Empdetails.jsp");
		dispatcher.forward(request, response);
	}

	

	

	

}