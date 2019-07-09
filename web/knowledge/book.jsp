<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="no-js">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title></title>
		<meta name="description" content="Animated Books with CSS 3D Transforms" />
		<meta name="keywords" content="book, 3d, interactive, animated, 3d transform, css, web design" />
		<link rel="stylesheet" type="text/css" href="css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="css/demo.css" />
		<link rel="stylesheet" type="text/css" href="css/book.css" />
	</head>
	<body>
		<div class="container">
			<div class="component">
				<ul class="align">
					<li id="userM">
						<figure class='book'>

							<!-- Front -->

							<ul class='hardcover_front'>
								<li>
									<img src="image/cover.jpg" alt="" width="100%" height="100%">
								</li>
								<li></li>
							</ul>

							<!-- Pages -->
                            <c:if test="${user.userRank==1}">
							<ul class='page'>
								<li></li>
								<li>
									<a class="btn" id="user">用户管理</a>
								</li>
								<li></li>
								<li></li>
								<li></li>
							</ul>

							<!-- Back -->

							<ul class='hardcover_back'>
								<li></li>
								<li></li>
							</ul>
							<ul class='book_spine'>
								<li></li>
								<li></li>
							</ul>
							<figcaption>
								<h1></h1>
							</figcaption>
						</figure>
					</li>
					<li>
						<figure class='book'>

							<!-- Front -->

							<ul class='hardcover_front'>
								<li>
									<img src="image/cover.jpg" alt="" width="100%" height="100%">
								</li>
								<li></li>
							</ul>
                            </c:if>
							<!-- Pages -->

							<ul class='page'>
								<li></li>
								<li>
									<a class="btn" id="medicine">中药方剂</a>
								</li>
								<li></li>
								<li></li>
								<li></li>
							</ul>

							<!-- Back -->

							<ul class='hardcover_back'>
								<li></li>
								<li></li>
							</ul>
							<ul class='book_spine'>
								<li></li>
								<li></li>
							</ul>
							<figcaption>
								<h1></h1>
							</figcaption>
						</figure>
					</li>
					<li>
						<figure class='book'>

							<!-- Front -->

							<ul class='hardcover_front'>
								<li>
									<img src="image/cover.jpg" alt="" width="100%" height="100%">
								</li>
								<li></li>
							</ul>

							<!-- Pages -->

							<ul class='page'>
								<li></li>
								<li>
									<a class="btn" id="disease">中医疾病症状</a>
								</li>
								<li></li>
								<li></li>
								<li></li>
							</ul>

							<!-- Back -->

							<ul class='hardcover_back'>
								<li></li>
								<li></li>
							</ul>
							<ul class='book_spine'>
								<li></li>
								<li></li>
							</ul>
							<figcaption>
								<h1></h1>
							</figcaption>
						</figure>
					</li>
					<li>
						<figure class='book'>


						<!-- Front -->

							<ul class='hardcover_front'>
								<li>
									<img src="image/cover.jpg" alt="" width="100%" height="100%">
								</li>
								<li></li>
							</ul>

							<!-- Pages -->

							<ul class='page'>
								<li></li>
								<li>
									<a class="btn" id="technology">中医技术</a>
								</li>
								<li></li>
								<li></li>
								<li></li>
							</ul>

							<!-- Back -->

							<ul class='hardcover_back'>
								<li></li>
								<li></li>
							</ul>
							<ul class='book_spine'>
								<li></li>
								<li></li>
							</ul>
							<figcaption>
								<h1></h1>
							</figcaption>
						</figure>
					</li>
				</ul>
			</div>
		</div><!-- /container -->
	</body>
<script>
	var a = document.querySelector('#user');
	var b = document.querySelector('#medicine');
	var c= document.querySelector('#disease');
    var d= document.querySelector('#technology');
	a.addEventListener('click', function (evt) {
        window.parent.location.href='../userList.do'
	})
	b.addEventListener('click', function (evt) {
        window.parent.location.href='/medicineList.do'
	})
	c.addEventListener('click', function (evt) {
		window.parent.location.href='/diseaseList.do'
	})
	d.addEventListener('click', function (evt) {
		window.parent.location.href='/technologyList.do'
	})
</script>
<style>
	.align{
		width: 100%;
		position: absolute;
		left: 200px;
	}
</style>

</html>
