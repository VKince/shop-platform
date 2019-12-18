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
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link href='http://fonts.useso.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'><!--//fonts-->
<!-- start menu -->
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>
<script src="js/simpleCart.min.js"> </script>
</head>
<body>
<!--header-->
<div class="header">
	<div class="header-top">
		<div class="container">
			<div class="search">
					<form>
						<input type="text" value="…… " onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
						<input type="submit" value="搜索">
					</form>
			</div>
			<div class="header-left">
			<%
			String user = (String)request.getSession().getAttribute("user");
			String url=null;
			if(user==null){
				url="login.jsp";
				user="登陆";
			}
			else{
				url="check.jsp";
				user="你好，"+user;
			}
			%>	
					<ul>
						<li ><a class="lock" href=<%=url %>  ><%=user %></a></li>
						<li><a class="lock" href="register.jsp"  >注册</a></li>
						<li>
</li>

					</ul>
					<div class="cart box_1">
						<a href="check.jsp">
						<h3> <div class="total">
							<span class="simpleCart_total"></span> (<span id="simpleCart_quantity" class="simpleCart_quantity"></span> 项)</div>
							<img src="images/cart.png" alt=""/></h3>
						</a>
												<p><a href="javascript:;" class="simpleCart_empty">清空</a></p>

					</div>
					<div class="clearfix"> </div>
			</div>
				<div class="clearfix"> </div>
		</div>
		</div>
		<div class="container">
			<div class="head-top">
				<div class="logo">
					<a href="index.jsp"><img src="images/logo.png" alt=""></a>	
				</div>
		  <div class=" h_menu4">
					<ul class="memenu skyblue">
					  <li class="active grid"><a class="color8" href="index.jsp">主页</a></li>	
				      <li><a class="color1" href="#">男士专区</a>
				      	<div class="mepanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<ul>
										<li><a href="products.html">暂未上架</a></li>
									</ul>	
								</div>							
							</div>
						  </div>
						</div>
					</li>
				    <li class="grid"><a class="color2" href="#">	女士专区</a>
					  	<div class="mepanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<ul>
										<li><a href="products.html">暂未上架</a></li>
									</ul>	
								</div>							
							</div>
						  </div>
						</div>
			    </li>			
				<li><a class="color6" href="check.jsp">购物车</a></li>
			  </ul> 
			</div>
				
				<div class="clearfix"> </div>
		</div>
		</div>

	</div>

	
<!--content-->
<div class=" container">
<div class=" register">
	<h1>注册</h1>
		  	  <form action ="login.do" method="post"> 
				 <div class="col-md-6 register-top-grid">
					<h3>个人信息</h3>
					 <div>
						<span>用户名</span>
						<input type="text" id="user" name="user" value="">
						<%
						String errorMsg=(String)request.getAttribute("error_name");
						if(errorMsg==null){
							errorMsg="\t";
						}
						%> 
						<span><font color="#ff0000"><%=errorMsg %></font></span>
					 </div>
					 <div>
						<span>真实姓名</span>
						<input type="text" id="truename" name="truename" value=""> 
					 </div>
					 <div>
						 <span>Email地址</span>
						 <input type="text" id="email" name="email" value=""> 
						 <%
						 String errorMsg1=(String)request.getAttribute("error_email");
						 if(errorMsg1==null){
							 errorMsg1="\t";
						 }
						%> 
						<span><font color="#ff0000"><%=errorMsg1 %></font></span>
					 </div>
					 </div>
				     <div class="col-md-6 register-bottom-grid">
						    <h3>注册信息</h3>
							 <div>
								<span>密码</span>
								<input type="password" id="password" name="password" value="">
								<%
								String errorMsg2=(String)request.getAttribute("error_password");
								String errorMsg3="\t";
								if(errorMsg2!=null){
									errorMsg3="请输入一致的密码";
								}
								else{
									errorMsg2="\t";
								}
								%>
								<span ><font color="#ff0000"><%=errorMsg2 %></font></span>
							 </div>
							 <div>
								<span>确认密码</span>
								<input type="password" id="resure" name="resure" value="">
								<span ><font color="#ff0000"><%=errorMsg3 %></font></span>
							 </div>
							 <input type="submit" name="submit" value="submit">
							
					 </div>
					 <div class="clearfix"> </div>
				</form>
			</div>
</div>
<!--//content-->
<div class="footer">
				<div class="container">
			<div class="footer-top-at">
				<div class="col-md-4 amet-sed ">
				<h4>联系我们</h4>
					<p>电话:  131 3233 3793</p>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
		</div>
</body>
</html>