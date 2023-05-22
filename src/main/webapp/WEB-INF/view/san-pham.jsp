<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/san-pham/search">
    <span class="input-group-text">Tên</span>
    <input type="text" name="searchValue">
    <button type="submit">Search</button>
</form>
<br/>
<form:form action="/san-pham/add" method="post" modelAttribute="allSP">
    <div class="input-group input-group-sm mb-3">
        <span class="input-group-text">ID</span>
        <form:input path="id" type="text" class="form-control" value="${detailSP.id}"/>
        <form:errors path="id"/>
    </div>
    <div class="input-group input-group-sm mb-3">
        <span class="input-group-text">Mã</span>
        <form:input path="ma" type="text" class="form-control" value="${detailSP.ma}"/>
        <form:errors path="ma"/>
    </div>
    <div class="input-group input-group-sm mb-3">
        <span class="input-group-text">Tên</span>
        <form:input path="ten" type="text" class="form-control" value="${detailSP.ten}"/>
        <form:errors path="ten"/>
    </div>
    <div class="input-group input-group-sm mb-3">
        <span class="input-group-text">Giá</span>
        <form:input path="gia" type="text" class="form-control" value="${detailSP.gia}"/>
        <form:errors path="gia"/>
    </div>
    <div class="input-group input-group-sm mb-3">
        <span class="input-group-text">Loại</span>
        <form:input path="loai" type="text" class="form-control" value="${detailSP.loai}"/>
        <form:errors path="loai"/>
    </div>
    <button type="submit">Add</button>
</form:form>

<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Mã</th>
        <th scope="col">Tên</th>
        <th scope="col">Loại</th>
        <th scope="col">Giá</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listSanPham}" var="sp">
        <tr>
            <td>${sp.id}</td>
            <td>${sp.ma}</td>
            <td>${sp.ten}</td>
            <td>${sp.loai}</td>
            <td>${sp.gia}</td>
            <td>
                <button><a href="/san-pham/detail/${sp.id}">Detail</a></button>
                <button><a href="/san-pham/view-update/${sp.id}">Update</a></button>
                <button><a href="/san-pham/remove/${sp.id}">Remove</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>