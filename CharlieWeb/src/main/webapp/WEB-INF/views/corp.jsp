<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>CharlieWeb</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
   新增公司
</h1>
 
<c:url var="addAction" value="/corp/add" ></c:url>
 
<form:form action="${addAction}" commandName="corp">
<table>
    <tr>
        <td>
            <form:label path="sname">
                <spring:message text="英文簡稱"/>
            </form:label>
        </td>
        <td>
            <c:if test="${empty corp.created}">
                <form:input path="sname" />
            </c:if>
            <c:if test="${!empty corp.created}">
                <form:input path="sname" readonly="true" size="8"  disabled="true" />
                <form:hidden path="sname" />
                <form:hidden path="created" />
            </c:if>
        </td>
        <td>
            <form:label path="dname">
                <spring:message text="名稱"/>
            </form:label>
        </td>
        <td>
            <form:input path="dname" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="address">
                <spring:message text="住址"/>
            </form:label>
        </td>
        <td>
            <form:input path="address" />
        </td>
        <td>
            <form:label path="email">
                <spring:message text="Email"/>
            </form:label>
        </td>
        <td>
            <form:input path="email" />
        </td>
    </tr>
    <tr>
    	<td>
            <form:label path="phone">
                <spring:message text="電話號碼"/>
            </form:label>
        </td>
        <td>
            <form:input path="phone" />
        </td>
    	<td>
            <form:label path="fax">
                <spring:message text="傳真號碼"/>
            </form:label>
        </td>
        <td>
            <form:input path="fax" />
        </td>
    </tr>
    <tr>
        <td colspan="5">
            <c:if test="${!empty corp.created}">
                <input type="submit"
                    value="<spring:message text="修改"/>" />
            </c:if>
            <c:if test="${empty corp.created}">
                <input type="submit" 
                    value="<spring:message text="新增"/>" />
            </c:if>
        </td>
    </tr>
</table>  
</form:form>
<br>
<h3>公司列表</h3>
<c:if test="${!empty listCorps}">
    <table class="tg">
    <tr>
        <th width="120">英文簡稱</th>
        <th width="120">名稱</th>
        <th width="120">住址</th>
        <th width="120">Email</th>
        <th width="120">電話號碼</th>
        <th width="120">傳真號碼</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listCorps}" var="corp">
        <tr>
            <td>${corp.sname}</td>
            <td>${corp.dname}</td>
            <td>${corp.address}</td>
            <td>${corp.email}</td>
            <td>${corp.phone}</td>
            <td>${corp.fax}</td>
            <td><a href="<c:url value='/corp/edit/${corp.sname}' />" >Edit</a></td>
            <td><a href="<c:url value='/corp/remove/${corp.sname}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>