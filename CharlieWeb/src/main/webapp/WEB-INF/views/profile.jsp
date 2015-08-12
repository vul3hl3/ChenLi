<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
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
<h1>
   新增個人基本資料
</h1>
 
<c:url var="addAction" value="/profile/add" ></c:url>
 
<form:form action="${addAction}" commandName="profile">
<table>
   <c:if test="${empty profile.created}">
	<tr>
		<td>
			<form:label path="id">
                <spring:message text="ID"/>
            </form:label>
		</td>
		<td>
			<form:input path="id" />
		</td>
	</tr>
	</c:if>
    <tr>
        <td>
            <form:label path="chtname">
                <spring:message text="中文姓名"/>
            </form:label>
        </td>
        <td>
                <form:input path="chtname" />
                <c:if test="${!empty profile.created}">
					<form:hidden path="id" />
		 			<form:hidden path="created" />
				</c:if>
        </td>
        <td>
            <form:label path="gender">
                <spring:message text="性別"/>
            </form:label>
        </td>
        <td>
            <form:select path="gender" id="genderOptions">
	        	<form:option value="">Select Gender</form:option>
	        	<form:option value="M">男</form:option>
	        	<form:option value="F">女</form:option>
	      	</form:select>
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="engname">
                <spring:message text="英文姓名"/>
            </form:label>
        </td>
        <td>
            <form:input path="engname" />
        </td>
        <td>
            <form:label path="cell">
                <spring:message text="手機"/>
            </form:label>
        </td>
        <td>
            <form:input path="cell" />
        </td>
    </tr>
    <tr>
    	<td>
            <form:label path="birthday">
                <spring:message text="生日"/>
            </form:label>
        </td>
        <td>
            <form:input path="birthday" />
        </td>
    	<td>
            <form:label path="email">
                <spring:message text="E-mail"/>
            </form:label>
        </td>
        <td>
            <form:input path="email" />
        </td>
    </tr>
    <tr>
    	<td>
            <form:label path="homeaddress">
                <spring:message text="戶籍地址"/>
            </form:label>
        </td>
        <td>
            <form:input path="homeaddress" />
        </td>
    	<td>
            <form:label path="bilingaddress">
                <spring:message text="通訊地址"/>
            </form:label>
        </td>
        <td>
            <form:input path="bilingaddress" />
        </td>
    </tr>
    <tr>
        <td colspan="5">
            <c:if test="${!empty profile.created}">
                <input type="submit"
                    value="<spring:message text="修改"/>" />
            </c:if>
            <c:if test="${empty profile.created}">
                <input type="submit" 
                    value="<spring:message text="新增"/>" />
            </c:if>
        </td>
    </tr>
</table>  
</form:form>
<br>
<h3>個人基本資料</h3>
<c:if test="${!empty listProfiles}">
    <table class="tg">
    <tr>
        <th width="120">中文姓名</th>
        <th width="120">英文姓名</th>
        <th width="120">性別</th>
        <th width="120">手機</th>
        <th width="120">生日</th>
        <th width="120">E-mail</th>
        <th width="120">戶籍地址</th>
        <th width="120">通訊地址</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listProfiles}" var="profile">
        <tr>
            <td>${profile.chtname}</td>
            <td>${profile.engname}</td>
            <td>${profile.gender}</td>
            <td>${profile.cell}</td>
            <td>${profile.birthday}</td>
            <td>${profile.email}</td>
            <td>${profile.homeaddress}</td>
            <td>${profile.bilingaddress}</td>
            <td><a href="<c:url value='/profile/edit/${profile.id}' />" >Edit</a></td>
            <td><a href="<c:url value='/profile/remove/${profile.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>