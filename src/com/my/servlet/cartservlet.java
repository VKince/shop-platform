package com.my.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.Dao.Dao;
import com.my.Dao.bookdao;
import com.my.jdbc.example.User;
import com.my.jdbc.example.goods;

import mail.mailutils;


/**
 * Servlet implementation class cartservlet
 */
@WebServlet("/cartservlet")
public class cartservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cartservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		if(id!=null) {
			add(request,response);
		}
		String del = request.getParameter("delete");
		if(del!=null) {
			delet(request,response);
		}
		String buy = request.getParameter("buy");
		if(buy!=null) {
			by(request,response);
		}
	}
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
	      System.out.println(id);
	      String user = (String)request.getSession().getAttribute("user");
	      bookdao ud=new bookdao();
	      goods p=ud.find(id);
	      HttpSession session =request.getSession();
	      HashMap<goods,Integer> cart=(HashMap<goods,Integer>)session.getAttribute(""+user+"cart");
	      try{
	            if(user==null)
	            	request.getRequestDispatcher("/login.jsp").forward(request, response);//重定向到登录页面
	            if(cart==null) {
	    			cart=new HashMap<goods,Integer>();
	    		}
	            Integer count=cart.put(p,1);
	    		if(count!=null) {
	    			cart.put(p,count+1);
	    		}
	    		session.setAttribute(""+user+"cart", cart);
	    		request.getRequestDispatcher("/check.jsp").forward(request, response);
	      }
	      catch(Exception exp){
	    	  request.getRequestDispatcher("/login.jsp").forward(request, response);//重定向到登录页面
	      }
	}
	public void delet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		  String id = request.getParameter("delete");
	      String user = (String)request.getSession().getAttribute("user");
	      bookdao ud=new bookdao();
	      goods p=ud.find(id);
	      HttpSession session =request.getSession();
	      HashMap<goods,Integer> cart=(HashMap<goods,Integer>)session.getAttribute(user+"cart");
	      try{
	            if(cart!=null) {
	            	cart.remove(p);
	    		}
	    		session.setAttribute(user+"cart", cart);
	    		request.getRequestDispatcher("/check.jsp").forward(request, response);
	      }
	      catch(Exception exp){
	    	  request.getRequestDispatcher("/login.jsp").forward(request, response);//重定向到登录页面
	      }
	}
	public void by(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
	      System.out.println(id);
	      String user = (String)request.getSession().getAttribute("user");
	      Dao dd=new Dao();
	      User us=dd.find(user);
	      HttpSession session =request.getSession();
	      HashMap<goods,Integer> cart=(HashMap<goods,Integer>)session.getAttribute(user+"cart");
	      try{
	            if(cart==null) {
	            	return;
	    		}
	            else {
	            	String message="恭喜购买成功";
	            	mailutils.sendmail(us.getemail(), message);
	            }
	    		session.setAttribute("cart", cart);
	    		request.getRequestDispatcher("/check.jsp").forward(request, response);
	      }
	      catch(Exception exp){
	    	  request.getRequestDispatcher("/login.jsp").forward(request, response);//重定向到登录页面
	      }
	}
}
