<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
 	 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  	 <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:0px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
    <script type="text/javascript">
		function myFunction() {
    		document.getElementById("myP").style.cursor = "pointer";
		}
	</script>
<title>CharlieBlog</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="<c:url value='/' />">Charlie's Blog</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="<c:url value='/' />">首頁</a></li>
		<li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">履歷維護<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<c:url value='/workexps' />">工作經歷</a></li>
            <li><a href="<c:url value='/educations' />">學歷</a></li>
            <li><a href="<c:url value='/thesiss' />">論文</a></li>
            <li><a href="<c:url value='/activitiess' />">活動經歷</a></li>
          </ul>
        </li>
        <li><a href="<c:url value='/workexps' />">工作經歷</a></li>
        <li><a href="<c:url value='/educations' />">學歷</a></li>
        <li><a href="<c:url value='/thesiss' />">論文</a></li>
        <li><a href="<c:url value='/activitiess' />">活動經歷</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
<!--         <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> -->
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container">
	<div class="jumbotron">
    	<h1>ChenLi portfolio  website!</h1>
    	<p><i>Do My Best! 不放手直到夢想到手！</i></p>
  </div>
   <table class="tg">
   		<tr>
   			<td>
   				 <p> <img src="resources/951722.jpg" class="img-circle" alt="Cinque Terre" width="150" height="200"></p> 
   				 <a data-toggle="modal" href="#myModal">ChenLi (Chen,Li-ZEN)</a>
   				  <!-- Modal -->
  				<div class="modal fade" id="myModal" role="dialog">
  				<div class="modal-dialog">
    
  					<!-- Modal content-->
        				<div class="modal-content">
          				<div class="modal-header">
           				 <button type="button" class="close" data-dismiss="modal">&times;</button>
            				<h4 class="modal-title">Autobiography</h4>
          				</div>
          				<div class="modal-body">
            			<p>My name is Li-Zen Chen. I graduated from Sun Yan-Sen University’s Information Management Graduate School in 2012. 
            			My master thesis was entitled "Personalized Document Recommendation by Latent Dirichlet Allocation". 
            			My research was selected for presentation at the INFORMS conference in Beijing in 2012.  </p>
						<p>After attaining my master’s degree in management, I began working at SYSCOM Computer Engineering Company as a software engineer, 
						where I first worked on troubleshooting problems with our products and providing the best solutions for our customers. </p>

<p>The projects I did at SYSCOM were the bank, the government and the credit card company projects, mainly responsible for the bank project. Here comes up the detailed tasks description:</p>
<ul>
	<li>1.  Project design, development, testing and maintenance</li>
	<li>2.  Project Version Control</li>
	<li>3.  Online issue immediate processing</li>
	<li>4.  Verify needs and architecture with the customers</li>
	<li>5.  Training recruit </li>
</ul>

<p>	This work experience has made me learn a lot about the importance of good communication skills and I have also learned that it is sometimes necessary to change my perspective and approach when tackling a problem. 

In my spare time, I enjoy jogging and playing basketball. I am a very diligent worker because I believe that through hard work, any problem can be solved. 

I believe that my enthusiasm to learn new things will help me quickly adjust to a new work environment with ease. I hope you will give me the chance to prove myself. </p>
          				</div>
          				<div class="modal-footer">
            				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          				</div>
        				</div>
      
      				</div>
   				 </div>
   			</td>
   			<td></td>
   			<td></td>
   			<td></td>
   			<td></td>
   			<td></td>
   			<td></td>
   			<td>
   			    <c:forEach items="${listProfiles}" var="profile">
   			    <c:if test="${profile.chtname =='Chen Li-Zen' }">
   				<p><span class="glyphicon glyphicon-user"></span> 中文姓名: 陳立人</p>
   				</c:if>
   				<p><span class="glyphicon glyphicon-user"></span> 英文姓名: ${profile.engname}</p>
   				<c:if test="${profile.gender =='M' }">
            	<p><span class="glyphicon glyphicon-user"></span> 性別: 男</p>
            	</c:if>
            	<c:if test="${profile.gender =='F' }">
            	<p><span class="glyphicon glyphicon-user"></span> 性別: 女</p>
            	</c:if>
           		 <p><span class="glyphicon glyphicon-phone"></span> 手機: ${profile.cell}</p>
           		 <p><span class="glyphicon glyphicon-calendar"></span> 生日: ${profile.birthday}</p>
            	<p><span class="glyphicon glyphicon-envelope"></span> E-mail: ${profile.email}</p>
            	<p><span class="glyphicon glyphicon-home"></span> 戶籍地址: ${profile.homeaddress}</p>
            	<p><span class="glyphicon glyphicon-home"></span> 通訊地址: ${profile.bilingaddress}</p>
            	</c:forEach>
   			</td>
   			<td></td>
   			<td></td>
   			<td></td>
   			<td></td>
   			<td></td>
   			<td></td>
   			<td valign="top" align="center">
   			   <ul class="nav nav-pills nav-stacked">
        		<li class="active"><a href="#"><span class="glyphicon glyphicon-briefcase"></span> 工作經歷</a></li>
            	<c:forEach items="${listWorkexps}" var="workexp">
        					<li><a href="#">${workexp.corp}</a></li>
            	</c:forEach>
            	</ul>
   			</td>
   		</tr>
   </table>
</div>
</body>
</html>