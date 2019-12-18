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
function eclick(){
	window.location.href("single.jsp");
}
function rclick(){
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
	<BR>商品添加/修改：
	<%@ page import="com.my.jdbc.example.goods" %>
	<%
	goods p =(goods)request.getSession().getAttribute("c_good");
	String id = "";
    String name = "";
    String size = "";
    String design = "";
    String price = "";
    if(p!=null){
    	id = p.getId();
        name = p.getName();
        size = p.getsize();
        design = p.getdesign();
        price = p.getPrice();
    }
	%>
	<form action="manager.do" method="post">	
			<div> 	
				<span>商品id</span>
				<input type="text" id="good-id" name="good-id" value="<%=id %>">
				<%
						String errorMsg=(String)request.getAttribute("error_-id");
						if(errorMsg==null){
							errorMsg="\t";
						}
				%> 
				<span><font color="#ff0000"><%=errorMsg %></font></span>
			</div>
			<div> 
				<span >商品名称</span>
				<input type="text" id="good-name" name="good-name" value="<%=name %>">
				<%
						String errorMsg1=(String)request.getAttribute("error_-name");
						if(errorMsg1==null){
							errorMsg1="\t";
						}
				%> 
				<span><font color="#ff0000"><%=errorMsg1 %></font></span>
			</div>
			<div> 
				<span >商品大小</span>
				<input type="text" id="good-size" name="good-size" value="<%=size %>">
				<%
						String errorMsg2=(String)request.getAttribute("error_-size");
						if(errorMsg2==null){
							errorMsg2="\t";
						}
				%> 
				<span><font color="#ff0000"><%=errorMsg2 %></font></span>
			</div>
			<div> 
				<span >商品款式</span>
				<input type="text" id="good-design" name="good-design" value="<%=design %>">
				<%
						String errorMsg3=(String)request.getAttribute("error_-design");
						if(errorMsg3==null){
							errorMsg3="\t";
						}
				%> 
				<span><font color="#ff0000"><%=errorMsg3 %></font></span>
			</div>
			<div> 
				<span >商品价格</span>
				<input type="text" id="good-price" name="good-price" value="<%=price %>">
				<%
						String errorMsg4=(String)request.getAttribute("error_-price");
						if(errorMsg4==null){
							errorMsg4="\t";
						}
				%> 
				<span><font color="#ff0000"><%=errorMsg4 %></font></span>
			</div>
			<input type="hidden" value="add" name="xiu1">
			<input type="hidden" value="<%=id %>" name="gai1">							
				<input type="submit" value="提交" name=""> 
				<input type="button" value="重置" name="" onclick="rclick()"> 
				<input type="button" value="取消" name="" onclick="eclick()"> 
	</form>

</div>
</body>
</html>