<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col mt-4 mb-4">
	<h1 class="text-center"><strong>Video Management</strong> </h1>
	<jsp:include page="/common/inform.jsp"></jsp:include>
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item"><a class="nav-link active"
			id="videoEditing-tab" data-toggle="tab" href="#videoEditing"
			role="tab" aria-controls="videoEditing" aria-selected="true">Video
				Editing</a></li>
		<li class="nav-item"><a class="nav-link" id="videoList-tab"
			data-toggle="tab" href="#videoList" role="tab"
			aria-controls="videoList" aria-selected="false">Video List</a></li>
	</ul>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="videoEditing"
			role="tabpanel" aria-labelledby="videoEditing-tab">
			<form action="VideoManagement" method="post" enctype="multipart/form-data">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col-3">
								<div class="border p-3">
									<img
										src="${video.poster != null ? video.poster:'uploads/img.png'}"
										alt="" class="img-fluid">
									
								</div>
								<div class="input-group mb-3 mt-3">
										<div class="custom-file">
											<input type="file"  class="custom-file-input" id="cover" name="cover">
											<label for="cover" class="btn btn-info">Choose File</label>
										</div>

									</div>
							</div>
							<div class="col-9">
								<div class="form-group">
									<label for="youtubeId">Video ID:</label> <input type="text" 
										value="${video.videoId }" class="form-control" name="videoId"
										id="videoId" aria-describedby="videoHid"> 
										<small id="videoHid"  class="form-text text-muted">Video id is required!</small>
								</div>
								<div class="form-group">
									<label for="videotitle">Video title:</label> <input type="text"
										value="${video.title }" class="form-control" name="title"
										id="videotitle" aria-describedby="videotitleHid"
										> <small id="videotitleHid"
										 class="form-text text-muted">Video
										title id is required!</small>
								</div>
								<div class="form-group">
									<label for="viewCount">View Count:</label> <input type="text"
										value="${video.view }" class="form-control" name="view"
										id="viewCount" aria-describedby="viewCountHid"
										> <small id="viewCountHid"
										class="form-text text-muted">View count id is
										required!</small>
								</div>
								<div class="form-check form-check-inline">
									<label for="status"> <input type="radio"
										class="form-check-input" value="true"
										${video.active?'checked':'' } name="active" id="status">
										Active
									</label> <label for="statu" class="ml-3"> <input type="radio"
										${!video.active?'checked':'' } class="form-check-input"
										value="false" name="active" id="statu"> Inactive
									</label>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col">
								<label for="description">Description</label>
								<textarea class="form-control" name="description"
									 id="description" cols="10"
									rows="4">${video.description}</textarea>
							</div>
						</div>
					</div>
					<div class="card-footer text-muted text-center">
						<button class="btn btn-primary"
							formaction="VideoManagement/create">Create</button>
						<button class="btn btn-warning"
							formaction="VideoManagement/update">Update</button>
						<button class="btn btn-danger"
							formaction="VideoManagement/delete">Delete</button>
						<button class="btn btn-info"
							formaction="VideoManagement/reset">Reset</button>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="videoList" role="tabpanel"
			aria-labelledby="videoList-tab">
			<table class="table table-stripe">
				<tr>
					<td>Video ID:</td>
					<td>Video title</td>
					<td>View Count</td>
					<td>Status</td>
					<td>Description</td>
					<td>&nbsp;</td>
				</tr>
				<c:forEach var="item" items="${listVideo }">
					<tr>
						<td>${item.videoId }</td>
						<td>${item.title }</td>
						<td>${item.view }</td>
						<td>${item.active ? 'Active':'Deactive' }</td>
						<td>${item.description }</td>
						<td><a class="btn btn-warning"
							href="VideoManagement/edit?videoId=${item.videoId }">
								<i class="fa fa-edit" aria-hidden="true"></i> Edit
						</a></td>
					</tr>
				</c:forEach>
			</table>
			<div style="width: 20%; margin: 0px auto" >
				<ul class="pagination">
    		<li class="page-item">
    			<a href="/PolyAss/VideoManagement?page=${ page1 - 1 }"
    				class="page-link">Previous</a>
    		</li>
    		<li class="page-item">
    			<a class="page-link">${ page1 }</a>
    		</li>
    		<li class="page-item">
    			<a aria-selected="true" href="/PolyAss/VideoManagement?page=${ page1 + 1 }"
    				id="next" class="page-link">Next</a>
    		</li>
    	</ul>
			</div>
		</div>
	</div>
</div>