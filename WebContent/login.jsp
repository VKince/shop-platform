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
			String url="login.jsp";
			if(user==null){
				user="登陆";
			}
			else{
				user="登陆";
				request.getSession().setAttribute("user",null);
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
<div class="container">
		<div class="account">
		<h1>登陆</h1>
		<div class="account-pass">
		<div class="col-md-8 account-top">
			<form action="login.d" method="post">
				
			<div> 	
				<span>用户名</span>
				<input type="text" id="userlogin" name="userlogin" value="">
			</div>
			<div> 
				<span >密码</span>
				<input type="password" id="passwordlogin" name="passwordlogin" value="">
				<%
				String errorMsg=(String)request.getAttribute("errors");
				if(errorMsg==null){
					errorMsg="\t";
				}
				%>
				<span><font color="#ff0000"><%=errorMsg %></font></span>
			</div>				
				<input type="submit" value="Login" name="登录"> 
			</form>
		</div>
		<div class="col-md-4 left-account ">
			<a href="single.jsp"><img class="img-responsive " src="images/s1.jpg" alt=""></a>
			<div class="five">
			<h2>25% </h2><span>discount</span>
			</div>
			<a href="register.jsp" class="create">Create an account</a>
<div class="clearfix"> </div>
		</div>
	<div class="clearfix"> </div>
	</div>
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