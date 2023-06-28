<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <title>Bài 2</title>
    <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
    <link rel="stylesheet" href="assets/css/styles.css" />
    <style>
    </style>
</head>

<body>
    <header class="d-flex align-items-center my-2">
        <div class="container px-4 px-lg-5 text-center">
            <a class="btn btn-primary btn-xl" href="bai1">Bài 1 & 4</a>
            <a class="btn btn-primary btn-xl" href="bai2">Bài 2 & 5</a>
            <a class="btn btn-primary btn-xl" href="bai3">Bài 3</a>
        </div>
    </header>
    <div id="lab6" class="m-auto w-75">
		<div class="my-3">
			<h3>SEARCH & PAGE</h3>
			<form action="/bai2">
				<div class="h5">Keywords:</div>
				<div class="my-2">
					<input name="keywords" value="${keywords}" placeholder="Keywords?" class="form-control"/>
				</div>
				<button class="btn btn-primary my-2">Search</button>
			</form>
			<table class="table table-collapse table-bordered">
				<tr class="bg-success text-white">
					<th>Id</th>
					<th>Name</th>
					<th>Price</th>
					<th>Date</th>
				</tr>
				<c:forEach var="item" items="${page.content}">
					<tr>
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td>${item.price}</td>
						<td>${item.createDate}</td>
					</tr>
				</c:forEach>
			</table>
			<div class="text-center">
				<a class="btn btn-info" href="/bai2?p=0">First</a>
					<a class="btn btn-info" href="/bai2?p=${page.number-1<0?0:page.number-1}">Previous</a>
				<a class="btn btn-info" href="/bai2?p=${page.number+1}">Next</a>
				<a class="btn btn-info" href="/bai2?p=${page.totalPages-1}">Last</a>
			</div>
			<ul class="list-group my-3">
				<li class="list-group-item">Số thực thể hiện tại: ${page.numberOfElements}</li>
				<li class="list-group-item">Trang số: ${page.number}</li>
				<li class="list-group-item">Kích thước trang: ${page.size}</li>
				<li class="list-group-item">Tổng số thực thể: ${page.totalElements}</li>
				<li class="list-group-item">Tổng số trang: ${page.totalPages}</li>
			</ul>
		</div>
	</div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>