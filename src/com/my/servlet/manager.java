package com.my.servlet;

import java.io.IOException;
import java.util.HashMap;

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

/**
 * Servlet implementation class manager
 */
@WebServlet("/manager")
public class manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manager() {
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
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
		String id = request.getParameter("change");
		String id1 = request.getParameter("delete");
		String dd=request.getParameter("xiu");
		String id2 = request.getParameter("gai");
		String id3 = request.getParameter("xiu1");
		String id4 = request.getParameter("gai1");
		System.out.println(id2);
		if(dd!=null&&id2!=null) {
			change(request,response);
		}
		if(id!=null&&id3==null) {
			add(request,response);
		}
		if(id1!=null) {
			delet(request,response);
		}
		if(id3!=null&&id4!=null) {
			cad(request,response);
		}
	}
	public void cad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String uid = request.getParameter("gai1");
        String id = request.getParameter("good-id");
        String name = request.getParameter("good-name");
        String size = request.getParameter("good-size");
        String design = request.getParameter("good-design");
        String price = request.getParameter("good-price");
        String error_id=null;
	      String error_name=null;
	      String error_size=null;
	      String error_design=null;
	      String error_price=null;
	      String resultPage = "/xiu.jsp";
	      System.out.println(id);
	      System.out.println(uid);
	      System.out.println(isInvalidid(id));
	      if (isInvalidid(id)&&!uid.equals(id)) {
	            error_id="id为空或已存在";
	       }
	       if (!isInvalidname(name)) {
	            error_name="商品名称为空";
	       }
	       if (!isInvalidsize(size)) {
	            error_size="商品码数为空";
	       }
	       if (!isInvaliddesign(design)) {
	            error_design="商品款式为空";
	       }
	       if (!isInvalidprice(price)) {
	            error_price="商品价格为空";
	       }
	       if (error_id!=null||error_name!=null||error_size!=null||error_design!=null||error_price!=null) {
	            request.setAttribute("error_-id", error_id);
	            request.setAttribute("error_-name", error_name);
	            request.setAttribute("error_-size", error_size);
	            request.setAttribute("error_-design", error_design);
	            request.setAttribute("error_-price", error_price);
	            resultPage = "/xiu.jsp";
	        } else {
	        	resultPage = "/single.jsp";
	        	if(uid.equals(id)) {
	        		bookdao ud=new bookdao();
	        		ud.change_name(id, name);
	        		ud.change_design(id, design);
	        		ud.change_price(id, price);
	        		ud.change_size(id, size);
	        	}
	        	else {
	        		bookdao ud=new bookdao();
	        		goods p=ud.find(uid);
	        		ud.delete(p);
	        		creategoodData(id,name,size,design,price);
	        	}
	        }
	      request.getRequestDispatcher(resultPage).forward(request, response);
	}
	public void change(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String uid = request.getParameter("xiu");
        bookdao ud=new bookdao();
        goods p=ud.find(uid);
	      String resultPage = "/xiu.jsp";
	      request.getSession().setAttribute("c_good", p);
	      request.getRequestDispatcher(resultPage).forward(request, response);
	}
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
		  String id = request.getParameter("goodid");
          String name = request.getParameter("goodname");
          String size = request.getParameter("goodsize");
          String design = request.getParameter("gooddesign");
          String price = request.getParameter("goodprice");
	      System.out.println(id);
	      String error_id=null;
	      String error_name=null;
	      String error_size=null;
	      String error_design=null;
	      String error_price=null;
	      String resultPage = "/shoe.jsp";
	      if (isInvalidid(id)) {
	            error_id="id为空或已存在";
	       }
	       if (!isInvalidname(name)) {
	            error_name="商品名称为空";
	       }
	       if (!isInvalidsize(size)) {
	            error_size="商品码数为空";
	       }
	       if (!isInvaliddesign(design)) {
	            error_design="商品款式为空";
	       }
	       if (!isInvalidprice(price)) {
	            error_price="商品价格为空";
	       }
	       if (error_id!=null||error_name!=null||error_size!=null||error_design!=null||error_price!=null) {
	            request.setAttribute("error_id", error_id);
	            request.setAttribute("error_name", error_name);
	            request.setAttribute("error_size", error_size);
	            request.setAttribute("error_design", error_design);
	            request.setAttribute("error_price", error_price);
	            resultPage = "/shoe.jsp";
	        } else {
	            resultPage = "/single.jsp";
	            creategoodData(id,name,size,design,price);
	        }
	       request.getRequestDispatcher(resultPage).forward(request, response);
	}
    private void creategoodData(String id, String name, String size,String design,String price) {
    	goods good=new goods();
    	good.setId(id);
    	good.setName(name);
    	good.setsize(size);
    	good.setdesign(design);
    	good.setPrice(price);
    	bookdao ud=new bookdao();
    	ud.insert(good);
    }
	private boolean isInvalidid(String id) {
		bookdao ud=new bookdao();
        goods good=ud.find(id);
        if(good==null) {
        	return false;
        }else {
        	return true;
        }
    }
	private boolean isInvalidname(String name) {
        if(name.equals(null)) {
        	return false;
        }else {
        	return true;
        }
    }
	private boolean isInvalidsize(String size) {
		
        if(size.equals(null)) {
        	return false;
        }else {
        	return true;
        }
    }
	private boolean isInvaliddesign(String design) {

        if(design.equals(null)) {
        	return false;
        }else {
        	return true;
        }
    }
	private boolean isInvalidprice(String price) {
        if(price.equals(null)){
        	return false;
        }else {
        	return true;
        }
    }
	public void delet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 response.setContentType("text/html;charset=UTF-8");
	        request.setCharacterEncoding("utf-8");
		  String id = request.getParameter("delete");
	      bookdao ud=new bookdao();
	      goods p=ud.find(id);
	      ud.delete(p);
	      request.getRequestDispatcher("/single.jsp").forward(request, response);
	}
}
