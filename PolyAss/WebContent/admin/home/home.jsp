<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col">
	<div class="row p-2">
		<c:forEach var="item" items="${listVideo }">
			<div class="col-3 mt-4 ">
				<div class="card text-center">
					<div class="card-body" style="height: 180px">
						<img src="${item.poster == ''? 'uploads/img1.png': item.poster }"
							width="90%" class="img-fluid" alt="">
						<div class="row border-top mt-2">
							<b>${item.title }</b>
						</div>
					</div>
					<div class="card-footer">
						<a href="LikeVideo?videoId=${item.videoId }"
							class="btn btn-success">Like</a> <a
							href="ShareVideo?videoId=${item.videoId }" class="btn btn-info">Share</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="row">
		<div class="col">
			<div style="width: 20%; margin: 0px auto;">
				<ul class="pagination">
					<li class="page-item"><a
						href="/PolyAss/HomeAdminServlet?page=${ page1 - 1 }"
						class="page-link">Previous</a></li>
					<li class="page-item"><a class="page-link">${ page1 }</a></li>
					<li class="page-item"><a aria-selected="true"
						href="/PolyAss/HomeAdminServlet?page=${ page1 + 1 }" id="next"
						class="page-link">Next</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
