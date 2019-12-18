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
<script>$(document).ready(function(){$(".memenu").memenu();});
function buy(){
	return;
}
</script>
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
			String res="注册";
			String reurl="register.jsp";
			System.out.println(user);
			String url=null;
			if(user==null){
				url="login.jsp";
				user="登陆";
			}
			else{
				url="check.jsp";
				user="你好，"+user;
				reurl="login.jsp";
				res="注销";
			}
			%>		
					<ul>
						<li ><a href=<%=url %>  ><%=user %></a></li>
						<li><a  href=<%=reurl %>  ><%=res %></a></li>
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

	
<div class="container">
	<table border=2>
  <tr>
    
    <th>商品名称</th>
    <th>商品大小</th>
    <th>商品款式</th>
    <th>商品价格</th>
    <th>商品数量</th>
    <td><font color=blue>添加到购物车</font></td>
  </tr>
	<%@ page import="java.util.Map" %>
	<%@ page import="java.util.*" %>
	<%@ page import="com.my.jdbc.example.goods" %>
	<%  
	String user1 = (String)request.getSession().getAttribute("user");
	System.out.println(user1);
	HashMap<goods,Integer> car=(HashMap<goods,Integer>)session.getAttribute(""+user1+"cart");
    if(car==null)
      {
    	out.print("<h2> 购物车没有物品.</h2>");
    	out.print("</table>");
      }
    else {
    	Iterator<HashMap.Entry<goods, Integer>> iterator = car.entrySet().iterator();
       int n=0;
       double priceSum =0;
       String buygoods="";
       double price=0.00;
       while(iterator.hasNext()) {
    	   Map.Entry<goods, Integer> good=iterator.next();
           String showGoods="";
           showGoods = good.getKey().getName()+" , "+good.getKey().getsize()+" , "+good.getKey().getdesign()+" , "+good.getKey().getPrice()+" , "+good.getValue();
           n++; 
           price+=(Double.parseDouble(good.getKey().getPrice()))*(int)good.getValue();
           //购车车物品的后缀是“#价格数字"，比如“化妆品价格3989 #3989”
           buygoods=good.getKey().getId();
           String del="<form  action='buy.do' method = 'post'>"+
                     "<input type ='hidden' name='delete' value= "+good.getKey().getId()+">"+
                     "<input type ='submit'  value='删除' ></form>";
           out.print("<tr>");
           out.print("<td>"+" "+good.getKey().getName()+" "+"</td>");
           out.print("<td>"+" "+good.getKey().getsize()+" "+"</td>");
           out.print("<td>"+" "+good.getKey().getdesign()+" "+"</td>");
           out.print("<td>"+" "+good.getKey().getPrice()+" "+"</td>");
           out.print("<td>"+" "+good.getValue()+" "+"</td>");
           out.print("<td>"+del+"</td></tr>");
       }
       out.print("</table>");
       String orderForm = "<form action='buy.do' method='post'>"+         
              "<input type ='button'  value='购买' onclick='buy()'></form>";
       out.print(orderForm); 
    } 
%>
</div>


<!--//content-->
<div class="footer">
				<div class="container">
			<div class="footer-top-at">
				<div class="col-md-4 amet-sed ">
				<h4>联系我们</h4>
					<p>电话:  +131 3233 3793</p>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
		</div>
</body>
</html>