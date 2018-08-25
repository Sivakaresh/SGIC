<%-- 
    Document   : index.jsp
    Created on : 05/08/2018, 2:16:14 PM
    Author     : Sivakaresh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Books</title>
	<link rel="stylesheet" href="assets/header-user-dropdown.css">
	<link rel="stylesheet" href="assets/demo.css">
	<link rel="stylesheet" href="assets/header-search.css">
	<link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css" href="drop.css">

	<!-- Core Style CSS --><!-- 
    <link rel="stylesheet" href="css/core-style.css">
    <link rel="stylesheet" href="style.css"> -->


</head>

<body>

<header class="header-search">

	<div class="header-limiter">

		<h1><a href="#">Library<span style="color:#F05283;">online</span></a></h1>

		<nav>
			<a href="index.jsp">Home</a>
			<!-- <a href="#" class="selected">Blog</a> -->
			<a href="ViewBookController">Books</a>
		
			
			
				<div class="dropdown">
				  <a>Classification</a>
				  <div class="dropdown-content">
				    <a href="ViewMainController">Main Classification</a><br>
				    <a href="ViewSubController">Sub Classification</a>
				   
				  </div>
				</div>

		</nav>



	</div>

</header>

<!-- The content of your page would go here. -->


<div class="menu">

	<!-- <img src="assets/demo-arrow.png" alt="arrow" height="120"> -->

	<h1>Library Management System</h1>

    <section class="single_product_details_area d-flex align-items-center">
 <div class="single_product_thumb clearfix">
            <div class="product_thumbnail_slides owl-carousel">
               
                <img src="img/product-img/product-big-2.jpg" width="500" height="300"alt="">
                <img src="img/product-img/product-5.jpg" width="500" height="300"alt="">
                <img src="img/product-img/product-6.jpg" width="500" height="300"alt="">
                <img src="img/product-img/product-7.jpg" width="500" height="300"alt="">
                <img src="img/product-img/product-8.jpg" width="500" height="300"alt="">
            </div>
        </div>
</section>

</div>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>

	$(document).ready(function() {

		$('.header-search form').on('click', function(e) {

			// If the form (which is turned into the search button) was
			// clicked directly, toggle the visibility of the search box.

			if(e.target == this) {
				$(this).find('input').toggle();
			}

		});
	});

</script>

<!--
 Demo ads. Please ignore and remove. 
<script src="http://cdn.tutorialzine.com/misc/enhance/v3.js" async></script>-->

</body>

</html>
