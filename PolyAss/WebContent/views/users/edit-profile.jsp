<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
            <div class="col-8 offset-2">
               <form action="" method="post">
                  <div class="card">
                     <div class="card-header">
                       <b>Edit Profile</b>
                     </div>
                     <div class="card-body">
                        <div class="row">
                           <div class="col">
                              <div class="form-group">
                              <label for="username">Username</label>      
                              <input type="text" class="form-control" name="username" id="username" aria-describedby="usernameHid" placeholder="Username">
                              <small id="usernameHid" class="form-text text-muted">Username is required!</small>
                              </div>
                              <div class="form-group">
                                 <label for="fullname">Fullname</label>                   
                                 <input type="text" class="form-control" name="fullname" id="fullname" aria-describedby="fullnameHid" placeholder="Fullname">
                                 <small id="fullnameHid" class="form-text text-muted">Fullname is required!</small>
                                 </div>
                           </div>
                           <div class="col">
                              <div class="form-group">
                                 <label for="password">Password</label>                     
                                 <input type="text" class="form-control" name="password" id="password" aria-describedby="passwordHid" placeholder="Password">
                                 <small id="passwordHid" class="form-text text-muted">password is required!</small>
                                 </div>
                                 <div class="form-group">
                                    <label for="email">Email Address</label>                     
                                    <input type="text" class="form-control" name="email" id="email" aria-describedby="emailHid" placeholder="Email Address">
                                    <small id="emailHid" class="form-text text-muted">Email is required!</small>
                                 </div>
                           </div>
                        </div>
                     </div>
                     <div class="card-footer text-muted">
                       <button class="btn btn-success">Update</button>
                     </div>
                  </div>
               </form>
            </div>