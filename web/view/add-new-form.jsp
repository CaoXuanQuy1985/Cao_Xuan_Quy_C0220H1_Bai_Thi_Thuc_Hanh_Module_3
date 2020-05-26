<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 5/26/20
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Form</title>
</head>
<body>
<form method="post" action="/products?action=addNew">
    <label>Name:</label>
    <input type="text" name="${oldProduct.get}"/><br/>
    <label>Price:</label>
    <input type="text" name="priceProduct"/><br/>
    <label>Quantity:</label>
    <input type="text" name="quantiyProduct"/><br/>
    <label>Color:</label>
    <input type="text" name="colorProduct"/><br/>
    <label>Description:</label>
    <input type="text" name="desProduct"/><br/>
    <label>id_Category:</label>
    <input type="text" name="categoryProduct"/><br/>
    <input type="submit" value="Add New"/>
</form>
</body>
</html>
