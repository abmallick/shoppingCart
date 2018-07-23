package com.cart.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.DAO.ItemDAO;
import com.cart.entity.ItemDetails;
import com.cart.entity.UserCredentials;
import com.cart.service.ItemService;
import com.cart.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		String action = request.getParameter("ACTION");
		HttpSession session = request.getSession();
		PrintWriter out=response.getWriter();  
		if("LOGIN".equals(action))
		{
			UserCredentials us = new UserCredentials(userID, password);
			if(UserService.authorize(us))
			{
				out.println("Successfully Logged in!");
				session.setAttribute("USERID", userID);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else
			{
				out.println("Invalid Credentials! Redirecting to Signup Page!");
				RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
				rd.forward(request, response);
			}
		}
		else if("SIGNUP".equals(action))
		{
			UserCredentials uc = new UserCredentials(userID, password);
			if(UserService.create(uc))
			{
				out.println("Successfully Signed Up!");
				session.setAttribute("USERID", userID);
				RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
				rd.forward(request, response);
			}
			else
			{
				out.println("Problem with signing up!");
				RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
				rd.forward(request, response);
			}
		}
		else if("CHECKOUT".equals(action))
		{
			if((String)session.getAttribute("USERID") != null)
			{
				Vector<ItemDetails> id = (Vector<ItemDetails>) session.getAttribute("ITEM_OBJ");
				for(ItemDetails it : id) 
				{
					ItemDAO.create(it);
				}
				request.getSession().setAttribute("ITEMS", null);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		}
		else if("LOGOUT".equals(action))
		{
			request.getSession().invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("CartServlet?ACTION=LOGOUT");
	        response.sendRedirect("index.jsp");
		}
		}

}
