<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>Name: ${cinema.name}</p>
<p>Address: ${cinema.address}</p>

<c:forEach var="film" items="${cinema.films}">

    <h2>Film Name: ${film.name}</h2>
    <h2>Film Description: ${film.description}</h2>
    <h2>Date: ${film.date}</h2>
    <h2>Price: ${film.cost}</h2>



</c:forEach>

<form action="/film/add" name="film" method="post">

    <input type="hidden" name="cinema_id" value="${cinema.id}">

    Name:<input type="text" name="name"/>
    <br>
<%--    Date:<input type="date" name="date"/>--%>
<%--    <br>--%>
    Description:<input type="text" name="description"/>
    <br>
    Cost:<input type="text" name="cost"/>
    <br>
    <input type="submit" name="Save Film">
</form>

</body>
</html>
