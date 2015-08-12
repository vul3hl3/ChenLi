<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

    <title>CharlieWeb</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
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
        <!-- <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> -->
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container">
<h1>
   新增學歷
</h1>
 
<c:url var="addAction" value="/education/add" ></c:url>
<form:form action="${addAction}" commandName="education">
<table>
    <tr>
        <td>
            <form:label path="name">
                <spring:message text="學校名稱"/>
            </form:label>
        </td>
        <td>
            <c:if test="${empty education.created}">
                <form:input path="name" />
            </c:if>
            <c:if test="${!empty education.created}">
                <form:input path="name" readonly="true" size="8"  disabled="true" />
                <form:hidden path="name" />
                <form:hidden path="created" />
            </c:if>
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="department">
                <spring:message text="學系"/>
            </form:label>
        </td>
        <td>
            <form:input path="department" />
        </td> 
        <td>
            <form:label path="degree">
                <spring:message text="學位"/>
            </form:label>
        </td>
        <td>
            <form:input path="degree" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="duration">
                <spring:message text="就學期間"/>
            </form:label>
        </td>
        <td>
            <form:input path="duration" />
        </td>
    </tr>
    <tr>
        <td colspan="5">
            <c:if test="${!empty education.created}">
                <input type="submit" class="btn btn-warning"
                    value="<spring:message text="修改"/>" />
            </c:if>
            <c:if test="${empty education.created}">
                <input type="submit" class="btn btn-info"
                    value="<spring:message text="新增"/>" />
            </c:if>
        </td>
    </tr>
</table>  
</form:form>
<br>
<h3>學歷</h3>
<c:if test="${!empty listEducations}">
    <table  class="table table-striped" >
    <thead>
    <tr>
        <th width="120">學校名稱</th>
        <th width="120">學系</th>
        <th width="120">學位</th>
        <th width="120">就學期間</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listEducations}" var="education">
        <tr>
            <td>${education.name}
            	<c:if test="${ education.name == 'Sun Yan-Sen University'}">
            		<a Target="_new"  href="<c:url value='http://epage.mis.nsysu.edu.tw/bin/home.php' />" class="btn btn-info btn-sm">
    						<span class="glyphicon glyphicon-search"></span>  Search
  					</a>
  				</c:if>
  				<c:if test="${ education.name == 'Yuan Ze University'}">
            		<a Target="_new"  href="<c:url value='http://www.mis.yzu.edu.tw/' />" class="btn btn-info btn-sm">
    						<span class="glyphicon glyphicon-search"></span>  Search
  					</a>
  				</c:if>
            </td>
            <td>${education.department}</td>
            <td>${education.degree}</td>
            <td>${education.duration}</td>
            <td><a href="<c:url value='/education/edit/${education.name}' />" >Edit</a></td>
            <td><a href="<c:url value='/education/remove/${education.name}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
</c:if>
</div>
</body>
</html>