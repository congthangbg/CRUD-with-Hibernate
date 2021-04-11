<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<div class="col mt-4">
<jsp:include page="/common/inform.jsp"></jsp:include>
         <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item">
               <a class="nav-link active" id="videoEditing-tab" data-toggle="tab" href="#videoEditing" role="tab"
                  aria-controls="videoEditing" aria-selected="true">Favorite</a>
            </li>
            <li class="nav-item">
               <a class="nav-link" id="videoList-tab" data-toggle="tab" href="#videoList" role="tab"
                  aria-controls="videoList" aria-selected="false">Favorite User</a>
            </li>
            <li class="nav-item">
               <a class="nav-link" id="shareFriends-tab" data-toggle="tab" href="#shareFriends" role="tab"
                  aria-controls="shareFriends" aria-selected="false">Share Friends</a>
            </li>
         </ul>
         <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade show active" id="videoEditing" role="tabpanel" aria-labelledby="videoEditing-tab">
              <table class="table table-border mt-3">
                 <tr>
                    <td>Video Title</td>
                    <td>Favorite Count</td>
                    <td>Lasted Date</td>
                    <td>Oldest Date</td>
                 </tr>
                 <c:forEach var="item" items="${listVRP }">
                 <tr>
                    <td>${item.videoTitle } </td>
                    <td>${item.favoritecount }</td>
                    <td>${item.newestDate }</td>
                    <td>${item.oldestDate }</td>
                 </tr>
                 </c:forEach>
              </table>
            </div>
            
            <div class="tab-pane fade" id="videoList" role="tabpanel" aria-labelledby="videoList-tab">
               <form action="" method="get">
                  <div class="row mt-3">
                     <div class="col">
                        <div class="form-inline">
                           <div class="form-group">
                              <label >Video title
                                 <select name="videoUserId" class="form-control ml-3" id="videoUserId">
                                    <c:forEach var="item" items="${vList }">
                                    <option value="${item.videoId }"
                                     ${item.videoId == videoUserId? 'selected': ''}>${item.title }</option>
                                    </c:forEach>
                                 </select>
                              </label>
                              <button class="btn btn-primary ml-3">Report</button>
                           </div>
                        </div>
                     </div>
                  </div>
                  <div class="row">
                     <div class="col mt-3">
                        <table class="table table-bordered">
                           <tr>
                              <td>Username</td>
                              <td>Fullname</td>
                              <td>Email</td>
                              <td>Favorite Date</td>
                           </tr>
                           <c:forEach var="item" items="${ favList}">
                           	<tr>
                              <td>${item.username }</td>
                              <td>${item.fullname }</td>
                              <td>${item.email }</td>
                              <td>${item.likeDate }</td>
                           </tr>
                           </c:forEach>
                        </table>
                     </div>
                  </div>
               </form>
            </div>
            
            <div class="tab-pane fade" id="shareFriends" role="tabpanel" aria-labelledby="shareFriends-tab">
               <form action="" method="get">
                  <div class="row mt-3">
                     <div class="col">
                        <div class="form-inline">
                           <div class="form-group">
                              <label for="">Video title
                                 <select name="" class="form-control ml-3" id="">
                                    <option>Java Programming</option>
                                    <option>Java Programming</option>
                                 </select>
                              </label>
                              <button class="btn btn-info ml-3">Report</button>
                           </div>
                        </div>
                     </div>
                  </div>
                  <div class="row">
                     <div class="col mt-3">
                        <table class="table table-bordered">
                           <tr>
                              <td>Sender name</td>
                              <td>Sender Email</td>
                              <td>Receive Email</td>
                              <td>Sent Date</td>
                           </tr>
                        </table>
                     </div>
                  </div>
               </form>
            </div>
         </div>
      </div>