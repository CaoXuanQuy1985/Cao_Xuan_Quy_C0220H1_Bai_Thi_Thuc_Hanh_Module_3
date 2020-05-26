<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 5/26/20
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<form method="post" action="/products?action=editProduct">
    <label>Id Product:</label>
    <input type="text" value="${oldProduct.getId_Product()}" name="id_product"/><br/>
    <label>Name:</label>
    <input type="text" value="${oldProduct.getName()}" name="name_product"/><br/>
    <label>Price:</label>
    <input type="text" value="${oldProduct.getPrice()}" name="price_product"/><br/>
    <label>Quantity:</label>
    <input type="text" value="${oldProduct.getQuantity()}" name="quantity_product"/><br/>
    <label>Color:</label>
    <input type="text" value="${oldProduct.getColor()}" name="color_product"/><br/>
    <label>Description:</label>
    <input type="text" value="${oldProduct.getDescription()}" name="des_product"/><br/>
    <label>id_Category:</label>
    <input type="text" value="${oldProduct.getId_category()}" name="id_category_product"/><br/>
    <input type="submit" value="Update"/>
</form>
</body>
</html>
