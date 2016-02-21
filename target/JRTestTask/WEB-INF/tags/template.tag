<%@ tag description="Template Tag" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!doctype>
<html>
<head>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/script/todoUtil.js" />"></script>
    <title>TODO List</title>

</head>
<body>
<div class="content">
    <h1>TODO List</h1>

    <jsp:doBody/>
</div>
</body>
</html>