<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html>
<html lang="en">

    <!-- Basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">   
   
    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
 
     <!-- Site Metas -->
    <title>${page.title }</title>  
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Site Icons -->
    <link rel="shortcut icon" href=" <c:url value=" / images/favicon.ico" />" type="image/x-icon" />
    <link rel="apple-touch-icon" href="<c:url value="/images/apple-touch-icon.png " />">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href=" <c:url value="/css/bootstrap.min.css" />">
    <!-- Site CSS -->
    <link rel="stylesheet" href=" <c:url value="/style.css" />">
    <!-- ALL VERSION CSS -->
    <link rel="stylesheet" href=" <c:url value="/css/versions.css" />">
    <!-- Responsive CSS -->
    <link rel="stylesheet" href=" <c:url value="/css/responsive.css" />">
    <!-- Custom CSS -->
    <link rel="stylesheet" href=" <c:url value="/css/custom.css" />">

    <!-- Modernizer for Portfolio -->
    <script src=" <c:url value="/js/modernizer.js" />"></script>

    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body class="host_version"> 

	<!-- Modal -->
	<jsp:include page="login.jsp"></jsp:include>

	<!-- Start header 	 -->
<jsp:include page="header.jsp"></jsp:include>
	<!-- End header
	<jsp:include page="slider.jsp"></jsp:include>
	 -->
	

	
	<div id="domain" class="section wb">
        <div class="container">
         <section class="row">
          <jsp:include page="${page.contenUrl }"></jsp:include>
        </section>
        </div><!-- end container -->
    </div><!-- end section -->


<jsp:include page="footer.jsp"></jsp:include>
    <!-- end footer -->


    <a href="#" id="scroll-to-top" class="dmtop global-radius"><i class="fa fa-angle-up"></i></a>

    <!-- ALL JS FILES -->
    <script src=" <c:url value="/js/all.js" />"></script>
    <!-- ALL PLUGINS -->
    <script src=" <c:url value="/js/custom.js" />"></script>
	<script src=" <c:url value="/js/timeline.min.js" />"></script>
	<script>
		timeline(document.querySelectorAll('.timeline'), {
			forceVerticalMode: 700,
			mode: 'horizontal',
			verticalStartPosition: 'left',
			visibleItems: 4
		});
	</script>
	<c:if test="${not empty page.scripUrl }">
 	<jsp:include page="${page.scripUrl }"></jsp:include>
 	</c:if>
</body>
</html>