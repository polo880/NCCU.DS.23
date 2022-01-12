<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <link href="style.css" rel="stylesheet" type="text/css"> 
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" type="text/css" />
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="styles2.css" rel="stylesheet" />
</head>


<body style='background-color: #495057; position: relative'>
	<form action='${requestUri}' method='get'>
        <div>
			<input type='text' class="border-style" id="padding" name='keyword'
			style='font-size: 28px; position: absolute; left: 50%; top: 48%; margin-top: -250px; margin-left: -350px; width: 700px; height: 50px'
			placeholder = 'What you want to learn...' onfocus="placeholder= '' " onblur="placeholder='  What you want to learn...'" value='<%=request.getParameter("keyword")%>'/>
		</div>
		
	        
            <div class="container position-relative">
                <div class="row justify-content-center">
                    <div class="col-xl-6">
                        <div class="text-center text-white">
                            <!-- Page heading-->
                            <br>
                            <br>
                            <h1 class="fst-italic lh-1 mb-4" >Business Analytics</h1>

                        </div>
                    </div>
                </div>
            </div>

        	<div style='position: absolute; margin-top: 150px; margin-left: 80px; color:white'>
			
			<%
					String[][] orderList = (String[][]) request.getAttribute("query");
					for (int i = 0; i < orderList.length; i++) {
						String s=orderList[i][1];
						/* s=s.substring(7); */
					%>
			
						<a style ='font-size:25px' href='<%=s%>'><%=orderList[i][0]%> </a> <br>link<br> <br>
						<%
			}
			%>
		    </div>
	


</form>
</body>
</html>