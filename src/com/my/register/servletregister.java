package com.my.register;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.Dao.Dao;
import com.my.jdbc.example.User;
/**
 * Servlet implementation class servletregister
 */
@WebServlet("/servletregister")
public class servletregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String SUCCESS_VIEW = "/login.jsp";
    private final String ERROR_VIEW = "/register.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        //��ȡ�������
        String email = request.getParameter("email");
        String user = request.getParameter("user");
        String truename = request.getParameter("truename");
        String password = request.getParameter("password");
        String confirmedPasswd = request.getParameter("resure");
        //List<String> errors = new ArrayList<>();
        String error_email=null;
        String error_name=null;
        String error_password=null;
        if (isInvalidEmail(email)) {
            error_email="δ��д�ʼ����ʼ���ʽ����ȷ";
            System.out.println("a");
        }
        if (isInvalidUsername(user)) {
            error_name="�û���Ϊ�ջ��Ѵ���";
            System.out.println(user);
        }
        if (isInvalidPassword(password, confirmedPasswd)) {
            error_password="������6����16λ���µ�����";
            System.out.println("d");
        }
        System.out.println("asd");
        String resultPage = ERROR_VIEW;
        if (error_email!=null||error_name!=null||error_password!=null) {
        	System.out.println("asdf");
            request.setAttribute("error_email", error_email);
            request.setAttribute("error_name", error_name);
            request.setAttribute("error_password", error_password);
        } else {
            resultPage = SUCCESS_VIEW;
            System.out.println("asd");
            createUserData(email, user, password,truename);
        }
 
        request.getRequestDispatcher(resultPage).forward(request, response);
    }
 
    //�ж����������ʽ�Ƿ���ȷ
    private boolean isInvalidEmail(String email) {
        return email == null || !email.matches("^[_a-z0-9-]+([.]"
                + "[_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$");
    }
 
    //�ж��Ƿ���ڸ��û�
    private boolean isInvalidUsername(String username) {
        Dao ud=new Dao();
        User user=ud.find(username);
        if (user==null) {
        	return false;
        }
        else {
        	return true;
        }
    }
 
    //�ж������Ƿ���Ч
    private boolean isInvalidPassword(String password, String confirmedPasswd) {
        return password == null
                || password.length() < 6
                || password.length() > 16
                || !password.equals(confirmedPasswd);
    }
 
    //�����û����ϲ�д�����ݿ�
    private void createUserData(String email, String username, String password,String truename) {
    	User user=new User();
    	user.setusername(username);
    	user.setemail(email);
    	user.setpassword(password);
    	user.settruename(truename);
    	Dao ud=new Dao();
    	ud.insert(user);
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletregister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
