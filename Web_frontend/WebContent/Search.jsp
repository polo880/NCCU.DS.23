<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Business Analytics</title>
<link href="style.css" rel="stylesheet" type="text/css">
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link rel="preconnect" href="https://fonts.gstatic.com" />
        <link href="https://fonts.googleapis.com/css2?family=Tinos:ital,wght@0,400;0,700;1,400;1,700&amp;display=swap" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css2?family=DM+Sans:ital,wght@0,400;0,500;0,700;1,400;1,500;1,700&amp;display=swap" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="styles2.css" rel="stylesheet" type="text/css"/>

</head>

<body height: 100%; position: relative>
	
	<!-- Background Video-->
        <video class="bg-video" playsinline="playsinline" autoplay="autoplay" muted="muted" loop="loop"><source src="images/typing.mp4" type="video/mp4" /></video>
	<!-- Masthead-->
        <div class="masthead">
            <div class="masthead-content text-white">
                <div class="container-fluid px-4 px-lg-0">
                    <h1 class="fst-italic lh-1 mb-4">Business Analytics</h1>
                    <br>
                    <br>
                    <p class="mb-5">“The goal is to turn data into information, and information into insight.” </p>
				
					<form action='${requestUri}' method='get'>	
					<div class='box'class="border-style" id="email"></div>
	
					<div>
					<div class='col'>
					<input type='text' class="border-style" id="email" class="form-control"
					style='font-size: 120%; position: absolute; left: 50%; top: 48%; margin-top: -47px; margin-left: -300px; width: 500px; height: 45px'
					name='keyword' placeholder='  What you want to learn...' onfocus="placeholder= '' "
					onblur="placeholder='  What you want to learn...'" />					
					</div>
					</div>				
					<div>
					<a href='http://localhost:8080/Final_Project/TestProject'></a>
					</div>

				</form>
			</div>
		</div>
	</div>

</body>
</html>
