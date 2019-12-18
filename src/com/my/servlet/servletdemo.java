package com.my.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.Dao.Dao;
import com.my.jdbc.example.User;

/**
 * Servlet implementation class servletdemo
 */
@WebServlet("/servletdemo")
public class servletdemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String SUCCESS_VIEW = "/index.jsp";
    private final String ERROR_VIEW = "/login.jsp";
    
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        //获取请求参数
        String user = request.getParameter("userlogin");
        String password = request.getParameter("passwordlogin");
        if(user.equals("admin")&&password.equals("admin")) {
        	request.getRequestDispatcher("/single.jsp").forward(request, response);
        }
        //List<String> errors = new ArrayList<>();
        String error_name=null;
        if (isInvalidUsername(user,password)) {
            error_name="用户名不存在或密码错误";
            System.out.println(user);
        }
        System.out.println("asd");
        String resultPage = ERROR_VIEW;
        if (error_name!=null) {
        	System.out.println("asdf");
            request.setAttribute("errors", error_name);
        } else {
            resultPage = SUCCESS_VIEW;
            request.getSession().setAttribute("user",user);
            
            System.out.println("asd");
        }
        request.getRequestDispatcher(resultPage).forward(request, response);
    }
	private boolean isInvalidUsername(String username,String password) {
        Dao ud1=new Dao();
        User user1=ud1.find(username);
        if(user1==null) {
        	return true;
        }
        else if(user1.getpassword().equals(password)) {
        	return false;
        }
        else {
        	return true;
        }
    }
 
    //判断密码是否有效
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletdemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().write(username+"login successful");
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	public String getServletInfo() {
        return "Short description";
    }
}
