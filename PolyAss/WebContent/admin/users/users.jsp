<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<div class="col mt-4 mb-4">
	<h1 class="text-center"><strong>User Management</strong> </h1>
	<jsp:include page="/common/inform.jsp"></jsp:include>
	<span id="result1"></span>
         <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item">
               <a class="nav-link active" id="UserEditing-tab" data-toggle="tab" href="#UserEditing" role="tab"
                  aria-controls="UserEditing" aria-selected="true"><b>User Editing</b> </a>
            </li>
            <li class="nav-item">
               <a class="nav-link" id="userList-tab" data-toggle="tab" href="#userList" role="tab"
                  aria-controls="userList" aria-selected="false"><b>User List</b> </a>
            </li>
         </ul>
         <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade show active" id="UserEditing" role="tabpanel" aria-labelledby="UserEditing-tab">
             
               <form action="UserManagement" method="post" >
                  <div class="card">
                     <div class="card-body">
                        <div class="row">
                           <div class="col">
                              <div class="form-group">
                                <label for="userId">UserID</label>
                                <input type="text" class="form-control" value="${user.userId }" name="userId" id="userId" aria-describedby="userIdHid" >
                                <small id="userIdHid" class="form-text text-muted">UserID is required!</small>
                              </div>
                              <div class="form-group">
                                <label for="fullname">Fullname</label>
                                <input type="text" class="form-control" value="${user.fullname}" name="fullname" id="fullname" aria-describedby="fullnameHid" >
                                <small id="fullnameHid" class="form-text text-muted">Fullname is required!</small>
                              </div>
                           </div>
                           <div class="col">
                              <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" value="${user.password}" name="password" id="password" aria-describedby="passwordHid" >
                                <small id="passwordHid" class="form-text text-muted">Password is required!</small>
                              </div>
                              <div class="form-group">
                                <label for="email">Email</label>
                                <input type="text" class="form-control" name="email" value="${user.email }" id="email" aria-describedby="emailHid">
                                <small id="emailHid" class="form-text text-muted">Email is required!</small>
                              </div>
                              
                           </div>
                           
                            
                        </div>
                          <div class="row">
                          <div class="col">
                                <label  for="active">Active : </label>
                                <input type="radio" class="ml-3" name="admin" value="true" ${user.admin ?'checked':''} id="active" aria-describedby="activelHid">
                                <label for="active">Admin</label>
                                 <input type="radio"  class="ml-3" name="admin" value="false" ${user.admin ?'':'checked'} id="active1" aria-describedby="activelHid">
                                <label for="active1">User</label>
                              </div></div>
                     </div>
                     <div class="card-footer text-muted text-center">
                        <button id="btnCreate" class="btn btn-primary" formaction ="UserManagement/create">Create</button>
                        <button class="btn btn-warning" formaction="UserManagement/update">Update</button>
                        <button class="btn btn-danger" formaction="UserManagement/delete"
                        data-toggle="modal" data-target="#exampleModal"
                        >Delete</button>
                        <button class="btn btn-info" formaction="UserManagement/reset">Reset</button>
                     </div>
                  </div>
               </form>
            </div>
            
            <div class="tab-pane fade" id="userList" role="tabpanel" aria-labelledby="UserEditing-tab">
               <table class="table table-stripe">
                  <tr>
                     <th>Username</th>
                     <th>Fullname</th>
                     <th>Password</th>
                     <th>Email</th>
                     <th>Role</th>
                     <td>&nbsp;</td>
                  </tr>
                  <c:forEach var="item" items="${userList }">
                  <tr>
                     <td>${item.userId }</td>
                     <td>${item.fullname }</td>
                     <td>${item.password }</td>
                     <td>${item.email }</td>
                     <td>${item.admin ? "Admin" : "User" }</td>
                     <td>
                        <a href="UserManagement/edit?userId=${item.userId }"
                        class="btn btn-warning"
                        > <i class="fa fa-edit" aria-hidden="true"></i> Edit</a>
                        <!-- 
                         <a href="UserManagement/delete?userId=${item.userId }"> <i class="fa fa-trash" aria-hidden="true"></i> Delete</a>
                         -->
                       
                     </td>
                  </tr>
                  </c:forEach>
               </table>
               
	<div style="width: 20%; margin: 0px auto;" >
				<ul class="pagination">
    		<li class="page-item">
    			<a href="/PolyAss/UserManagement?page=${ page1 - 1 }"
    				class="page-link">Previous</a>
    		</li>
    		<li class="page-item">
    			<a class="page-link">${ page1 }</a>
    		</li>
    		<li class="page-item">
    			<a aria-selected="true" href="/PolyAss/UserManagement?page=${ page1 + 1 }"
    				id="next" class="page-link">Next</a>
    		</li>
    	</ul>
			</div>
               
            </div>
         </div>
                  <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
<!-- 

 -->
      </div>