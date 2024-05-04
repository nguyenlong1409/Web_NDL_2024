<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/2/2024
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>FFFFF</title>
</head>
<body>

<%
    String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                  + request.getContextPath();
%>

<h3>Đã thực hiện thành công</h3>
<script>
    setTimeout(function(){
        window.location.href = 'index.jsp';
    }, 1000);
</script>
</body>
</html>
