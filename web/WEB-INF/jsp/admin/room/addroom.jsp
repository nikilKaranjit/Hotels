<%@include file="../header.jsp" %>
<% 
    
if(session.getAttribute("username")==null) 
{

response.sendRedirect("login.jsp");
}
%>
<h1>Add Room</h1>
<form action="save" method="post" commandname="file" enctype="multipart/form-data" id="roomForm">
    <div class="form-group">
        <label>Room Type</label>
        <input type="text" name="roomType"  placeholder="Enter Room Type" required="required" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Room Description</label>
        <input type="text" name="roomDescription" placeholder="Enter Room Description" required="required" class="form-control"/>
    </div>
    
    <div class="form-group">
        <label>Room Number</label>
        <input type="number" name="roomNumber" placeholder="Enter Room Number" required="required" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Room Price</label>
        <input type="number" name="roomPrice" placeholder="Enter Room Price" required="required" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Room Image</label>
        <input type="file" name="file"  placeholder="Select Room Image" required="required" class="form-control"/>
    </div>
   
      <div class="form-group">
        <label>Id</label>
        <input type="hidden" name="id"  placeholder="Select Room Image" required="required" class="form-control"/>
    </div>
    <div class="form-group"> 
    <button type="submit" class="btn btn-success"  value="submit">Save</button>
    <a href="${SITE_URL}/admin/room"class="btn btn-danger">Cancel</a>
    </div>
    <script>
      $.validator.setDefaults({
		submitHandler: function() {
			alert("submitted!");
		}
	});

	$(document).ready(function() {
		// validate the comment form when it is submitted
		//$("#customerForm").validate();

		// validate signup form on keyup and submit
		$("#userForm").validate({
			rules: {
				roomType: {
                                    required: true,
                                    lettersonly: true
                                },                                
				roomDescription: {
                                    required: true,
                                    lettersonly: true
                                },
				roomNumber: {
					required: true,
					minlength: 5,
                                        lettersonly: true
				},
				roomPrice: {
					required: true,
					minlength: 5,
                                        maxlength:20
				},
//				confirm_password: {
//					required: true,
//					minlength: 5,
//					equalTo: "#password"
//				},
				file: {
					required: true,
					email: true
				}
//				contactNo: {
//					required: true,
//                                        minlength:7,
//					maxlength: 10,
//                                        integer:true
//                                        
//				}
//				agree: "required"
			    },
			messages: {
				roomType:{ 
                                    required:"Please enter your firstname",
                                   lettersonly:"only letters"
                                    
                                },
                                
				roomDescription:{ 
                                    required:"Please enter your lastname",
                                    lettersonly:"only letters"
                                    
                                },
				roomNumber: {
					required: "Please enter a username",
					minlength: "Your username must consist of at least 5 characters",
                                        lettersonly:"only letters"
				},
				roomPrice: {
					required: "Please provide a password",
					minlength: "Your password must be at least 5 characters long"
				},
//				confirm_password: {
//					required: "Please provide a password",
//					minlength: "Your password must be at least 5 characters long",
//					equalTo: "Please enter the same password as above"
//				},
				file:{
                                    email:"Please enter a valid email address"
                                }
//				agree: "Please accept our policy",
//				topic: "Please select at least 2 topics"
//                                contactNo:{
//                                    integer:"Please enter only numbers"
//                                    minlength:"number should not be at least 10"
//                                }
			}
		}); 
            
        });
        
   </script>
</form>
<%@include  file="../footer.jsp" %>
