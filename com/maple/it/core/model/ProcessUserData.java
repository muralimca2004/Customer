package com.maple.it.core.model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcessUserData
 */
@WebServlet(name = "processUsrData", urlPatterns = { "/processUsrData" })
public class ProcessUserData extends HttpServlet implements PersonData{
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ProcessUserData() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String foreName = request.getParameter("foreName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		out.println("<P>Customer Data");
		out.println("Date Of Registration: " + new java.util.Date() +"<br/>");
		out.println("Welcome " + "<br/> "+ title +"<b>" + foreName +"<br/>"+lastName + "</b><br/>");
		HttpSession session = request.getSession();
		session.setAttribute("foreName", foreName);
		session.setAttribute("lastName", lastName);
		session.setAttribute("email", email);
		session.setAttribute("fname", request.getParameter("fname"));
		session.setAttribute("street", request.getParameter("street"));
		session.setAttribute("state", request.getParameter("state"));
		session.setAttribute("pincode", request.getParameter("pincode"));
		response.sendRedirect("./newCustomerData.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public boolean processUserData() {
		// TODO Auto-generated method stub
		return false;
	}

}
