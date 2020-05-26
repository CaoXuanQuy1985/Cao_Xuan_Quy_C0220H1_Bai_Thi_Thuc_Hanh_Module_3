<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 5/26/20
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ket Qua Tim KIem</title>
</head>
<body>
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
    <%--<c:forEach items="${productList}" var="product">
        <tr>
            <td>${product.getId_Product()}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getQuantity()}</td>
            <td>${product.getColor()}</td>
            <td>${product.getId_category()}</td>
        </tr>
    </c:forEach>--%>
</table>
<label>Id Product:</label>
<input type="text" value="${product.getId_Product()}" name="id_product"/><br/>
<label>Name:</label>
<input type="text" value="${product.getName()}" name="name_product"/><br/>
<label>Price:</label>
<input type="text" value="${product.getPrice()}" name="price_product"/><br/>
<label>Quantity:</label>
<input type="text" value="${product.getQuantity()}" name="quantity_product"/><br/>
<label>Color:</label>
<input type="text" value="${product.getColor()}" name="color_product"/><br/>
<label>Description:</label>
<input type="text" value="${product.getDescription()}" name="des_product"/><br/>
<label>id_Category:</label>
<input type="text" value="${product.getId_category()}" name="id_category_product"/><br/>
</body>
</html>
