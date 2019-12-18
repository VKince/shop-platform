<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="New Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> 
addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
function addProductToCart(id) {
	location.href = "/buy.do?method=add&id=" + id;
}
</script>
<!--fonts-->
<link href='http://fonts.useso.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'><!--//fonts-->
<!-- start menu -->
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});
function myclick(){
	window.location.href("shoe.jsp");
}
</script>
 

<script src="js/main.js"></script>
<script src="js/simpleCart.min.js"> </script>
</head>
<body>
<!--header-->
<div class="header">
	<div class="header-top">
		<div class="container">
			<h1>后台管理系统</h1>
		</div>
	</div>
</div>	
<div class="container">
	<BR>商品管理：
	<input type="button" value="添加" onclick="myclick()">
  <table border=2>
  <tr>
    <th>商品标识号</th>
    <th>商品名称</th>
    <th>商品大小</th>
    <th>商品款式</th>
    <th>商品价格</th>
    <td><font color=blue></font>删除</td>
  </tr>
  <%@ page import="com.my.Dao.bookdao" %>
  <jsp:useBean id="dataBean" class="com.my.Dao.bookdao" scope="session"/>
  <%@ page import="java.util.ArrayList" %>
   <%@ page import="com.my.jdbc.example.goods" %>
  <%    
  	  ArrayList<goods> rowSet=dataBean.findAll();
      if(rowSet.isEmpty()) {
         out.print("没有任何查询信息，无法浏览");
         return;  
      }
      for(int i=0;i<rowSet.size();i++) {
            String id=rowSet.get(i).getId();
            String name=rowSet.get(i).getName();
            String size=rowSet.get(i).getsize();
            String design=rowSet.get(i).getdesign();
            String price=rowSet.get(i).getPrice();
            String button="<form  action='manager.do' method = 'post'>"+
                     "<input type ='hidden' name='delete' value= "+id+">"+
                     "<input type ='submit'  value='删除' ></form>";
            String button1="<form  action='manager.do' method = 'post'>"+
            		"<input type ='hidden' name='xiu' value= "+id+">"+
            		"<input type ='hidden' name='gai' value= "+"yes"+">"+
            				"<input type ='submit'  value='修改' ></form>";
            out.print("<tr>");
            out.print("<td>"+" "+id+" "+"</td>");
            out.print("<td>"+" "+name+" "+"</td>");
            out.print("<td>"+" "+size+" "+"</td>");
            out.print("<td>"+" "+design+" "+"</td>");
            out.print("<td>"+" "+price+" "+"</td>");
            out.print("<td>"+" "+button+" "+button1+" "+"</td>");
            out.print("</tr>");
         }
%>
  </table>
</div>
</body>
</html>