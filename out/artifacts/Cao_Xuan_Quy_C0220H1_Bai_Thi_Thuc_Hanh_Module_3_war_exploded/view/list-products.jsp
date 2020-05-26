<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 5/26/20
  Time: 9:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Products</title>
</head>
<body>
<h1>Danh Sach Product</h1>
<button><a href="/products?action=addNew">Add new Product</a></button>
<form method="post" action="/products?action=search">
<label>Search:</label>
    <input type="text" name="search"/>
    <input type="submit" value="Tim Kiem"/>
</form>
<table>
    <tr>
        <th>id_Product</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Color</th>
        <th>Category</th>
        <th>Action</th>
    </tr>
        <c:forEach items="${productList}" var="product">
            <tr>
                <td>${product.getId_Product()}</td>
                <td>${product.getName()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getQuantity()}</td>
                <td>${product.getColor()}</td>
                <td>${product.getId_category()}</td>
                <td><a href="/products?action=edit&id_product=${product.getId_Product()}">Edit</a></td>
                <td><a href="/products?action=delete&id_product=${product.getId_Product()}">delete</a></td>
            </tr>
        </c:forEach>
</table>
</body>
</html>
