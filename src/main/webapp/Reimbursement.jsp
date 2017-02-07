<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link href="http://fonts.googleapis.com/css?family=Lato:100italic,100,300italic,300,400italic,400,700italic,700,900italic,900" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.13/css/jquery.dataTables.css">
	<link rel="stylesheet" type="text/css" href="css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello, <c:out value="${sessionScope.user1.getU_username()}">
</c:out>!</title>
<body>
<div class="container">
	<div class="row">

<article class="col-md-4 well">
    <h3 class="page-header text-center">Submit Reimbursement<br />
        <small>submit a request for reimbursement</small>
    </h3>
    <br><hr>
    <div class="text-center">
        <a class="btn btn-success" href="#successModal" data-toggle="modal"><i class="glyphicon glyphicon-send"></i> NEW</a>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="successModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header modal-header-success">
                <div id="message"></div>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h2><i class="glyphicon glyphicon-cloud"></i>Reimbursement Form</h2>
                    
                </div>
                <div class="modal-body">
                    <div class="col-md-12 radio-choices">
                        <div class="col-md-6 col-xs-6 radio-left">
                            <form role="form" action="/ReimbursementServlet">
                            <div class="radio">
                                <label>Amount:</label>
                            </div>
                            <div class="radio">
                                <label>Receipt:</label>
                            </div>
                            <div class="radio">
                                <label>Type:</label>
                            </div>
                            <div class="radio">
                                <label>Description:</label>
                            </div>
                        </div>
 						<div class="col-md-6 col-xs-6 radio-right">
                            <div class="radio">
                                <input type="number" id="amount">
                            </div>
                            <div class="radio">
                                <input type="file"id="reciept">
                            </div>
                            <div class="radio">
                         <select class="form-control"> 
                             <c:forEach items="${reimbursementType}" var="retype" >
								<option value=<c:out value="${retype.rid}" />> <c:out value="${retype.rtype}"/></option>
								</c:forEach>
								</select> 
                            </div>
                            
                            <div class="radio">
                                <textarea class="form-control" rows="5" id="comment"></textarea>
                            </div>
                            </form>
                        </div>
                    </div>

                </div><div class="clearfix"></div>
                <div class="modal-footer">
<button type="submit" id="submit1" class="btn btn-primary pull-right">Submit</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</article>

<article class="col-md-4 well">
    <h3 class="page-header text-center">Reimbursement Status<br />
        <small>check status of your reimbursements</small>
    </h3>
    <br><hr>
    <div class="text-center">
        <a class="btn btn-success" href="#warningModal" data-toggle="modal" onclick="updateTable()"><i class="glyphicon glyphicon-eye-open"></i> CHECK</a>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="warningModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header modal-header-warning">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h2><i class="glyphicon glyphicon-user"></i>Reimbursement Status</h2>
                </div>
                <div class="modal-body">
                	<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-body">            
  <table id="table_id" class="display">
    <thead>
       	<tr>
            <th>Type</th>
            <th>Description</th>
            <th>Avenger</th>
            <th>Status</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${reimbursement}" var="re" >
        <tr>
            <td><c:out value="${re.Amount}" /></td>
            <td>House Damage</td>
            <td><c:out value="${re.Description}"/></td>
            <td><c:out value="${re.rstatus}"/></td>
            </tr>
             </c:forEach>
    </tbody>
</table>
			
					</div>
				</div>
                </div><div class="clearfix"></div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</article>

<article class="col-md-4 well">
    <h3 class="page-header text-center">User<br />
        <small>view/edit your personal information</small>
    </h3>
    <br><hr>
    <div class="text-center">
        <a class="btn btn-success" href="#primaryModal" data-toggle="modal"><i class="glyphicon glyphicon-user"></i> PROFILE</a>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="primaryModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header modal-header-primary">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"> [ × ] </button>
                    <h2><i class="glyphicon glyphicon-user"></i>USER</h2>
                </div>
                <div class="modal-body">
                     <div class="col-md-6 radio-choices">
                     <form role="form" action="">
                      <div class="radio">
                                <label>Username: </label>
                            </div>
                            <div class="radio">
                                <label>Password: </label>
                            </div>
                            <div class="radio">
                                <label>First Name: </label>
                            </div>
                            <div class="radio">
                                <label>Last Name: </label>
                            </div>
                            <div class="radio">
                                <label>Email: </label>
                            </div>
                        </div>
                        <div class="col-md-6 col-xs-6 radio-right">
                            <div class="radio">
                                <input type="text" id="usernameset" name="username" value="<c:out value="${sessionScope.user1.getU_username()}">
</c:out>">
                            </div>
                            <div class="radio">
                                <input type="text" name="password" value="<c:out value="${sessionScope.user1.getU_password()}">
</c:out>">
                            </div>
                            <div class="radio">
                                <input type="text" name="fname" value="<c:out value="${sessionScope.user1.getU_firstname()}">
</c:out>">
                            </div>
                            <div class="radio">
                                <input type="text" name="lname" value="<c:out value="${sessionScope.user1.getU_lastname()}">
</c:out>">
                            </div>
                            <div class="radio">
                                <input type="text" name="email" value="<c:out value="${sessionScope.user1.getU_email()}">
</c:out>" disabled="disabled" readonly="readonly">
								<input type="hidden" id="userid1" value="<c:out value="${sessionScope.user1.getU_id()}">
</c:out>">
                            </div>
                    </div><!-- ends col-12 -->
                </div><div class="clearfix"></div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success">Update</button>
                </div>
			</form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</article>

	</div>
</div>		
<form action="Logout" type="GET">
<button type="submit" class="btn btn-success">Logout</button>
</form>


	<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.13/js/jquery.dataTables.js"></script>
<script type="text/javascript">
		var date = new Date();
		$('#submit1').bind('click', function() {
			 var fd = new FormData(document.getElementById("receipt"));
	         fd.append("label", "WEBUPLOAD");
			$.ajax({
				  url: "Submit",
				  data: {amount: parseFloat($("#amount").val()), description: $("#comment").val(), description: $("#comment").val(), submitted: date.toUTCString(), author: $("#userid1").val(), rtype: 1},
				  method: "POST",
				  success: function(result, status, xhr){
					  		document.getElementById("message").innerHTML = result;
					  		$('#submit1').attr("disabled", true);
					  		setTimeout(function(){location.reload();}, 2000);
				  },
				  error: function(xhr, status){
					  console.log("error");
					  document.getElementById("message").innerHTML = '<div class="alert alert-danger alert-dismissable">'+
					  '<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>' +
					  '<strong>Error!</strong> Hulk must have spilled coffee on the server. Please try again.</div>';
				  },
				 complete: function(xhr, status){
					 console.log("complete!");
				 }
				});
			var a = parseFloat($("#amount").val());
			});
		$(document).ready(function(){
		    $('#table_id').DataTable();
		});
		
		
</script>
<script src="bootstrap/js/bootstrap.min.js">
</script>	
</body>
</html>