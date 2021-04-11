<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
<base href="/PolyAss/" />
<!-- Site Icons -->
<link rel="shortcut icon"
	href=" <c:url value=" / images/favicon.ico" />" type="image/x-icon" />
<link rel="apple-touch-icon"
	href="<c:url value="/images/apple-touch-icon.png " />">
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
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

	<!-- Start header 
	
	-->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- End header
	 -->



	<div id="domain" class=" wb">
		<div class="container">
			<section class="row">
				<jsp:include page="${page.contenUrl }"></jsp:include>
				
			</section>
		</div>
		<!-- end container -->
	</div>
	<!-- end section -->


	<jsp:include page="footer.jsp"></jsp:include>
	<!-- end footer -->


	<a href="#" id="scroll-to-top" class="dmtop global-radius"><i
		class="fa fa-angle-up"></i></a>

	<!-- ALL JS FILES
	
	 -->
	<script src=" <c:url value="/js/all.js" />"></script>
	<!-- ALL PLUGINS
	<script src=" <c:url value="/js/custom.js" />"></script>
	 -->
	
	<script src=" <c:url value="/js/timeline.min.js" />"></script>
	<script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
	<script>
		timeline(document.querySelectorAll('.timeline'), {
			forceVerticalMode : 700,
			mode : 'horizontal',
			verticalStartPosition : 'left',
			visibleItems : 4
		});
	</script>
	<c:if test="${not empty page.scripUrl }">
		<jsp:include page="${page.scripUrl }"></jsp:include>
	</c:if>
	<script type="text/javascript">
	$('#myModal').on('shown.bs.modal', function () {
		  $('#myInput').trigger('focus')
		})
	</script>
	<script type="text/javascript">
	$(document).ready(function() {
		$('#btnCreate').click(function () {
			var userId=$('#userId').val();
			var fullname=$('#fullname').val();
			var password=$('#password').val();
			var email=$('#email').val();
			var active=$('#active').val();
			var active1=$('#active1').val();
			$.ajax({
				type : 'POST',
				data:{
					userId:userId,
					fullname:fullname,
					password:password,
					email:email,
					active:active,
					active1:active1
					},
				url: 'UserManagement',
				success : function (result) {
					$('#result1').html(result);
				}
			});
		});
	});
	</script>
	<script type="text/javascript">
	$(document).ready(function() {
		$('#next').click(function (event) {
			event.preventdefault();
			console.log("đâsad")
		});
	});
	</script>
</body>
</html>