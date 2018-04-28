<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/27
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <table border="3">
    <c:forEach items="${users}" var="item" varStatus="status">
      <tr>
        <td>${item.id}</td>
        <td>${item.name}</td>
        <td>${item.password}</td>
      </tr>
    </c:forEach>
  </table>
  </body>
</html>
