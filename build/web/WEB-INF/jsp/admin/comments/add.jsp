<%@include file="../header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h1>Add Users</h1>
<form:form modelAttribute="Comments" action="${SITE_URL}/admin/comments/save" method="post" role="form" id="commentsform">
    
    <div class="form-group">
                <label for="c_id">Customer</label>

                <form:select  name="Customer.c_id" path="Customer.c_id" class="form-control">
                    <form:option value="0">Select Commentor</form:option>
                    <c:forEach var="customer" items="${Customer}">
                        <form:option value="${customer.getC_id()}">${customer.getFirstName()}
                        </form:option>
                    </c:forEach>
                </form:select>
            </div>     
                    

 
    
      <div class="form-group">
        <label>Message</label>
        <form:input path ="message" name="message"  placeholder="Enter Message" required="required" class="form-control"/>
    </div>
    
    
   
    <!--<hidden path="commentsId"/>-->
    <div class="form-group"> 
    <form:button type="submit" class="btn btn-success" >Save</form:button>
    </div>
</form:form>
s
<%@include  file="../footer.jsp" %>
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
		$("#customerForm").validate({
			rules: {
				firstName: {
                                    required: true,
                                    lettersonly: true
                                },                                
				lastName: {
                                    required: true,
                                    lettersonly: true
                                },
				username: {
					required: true,
					minlength: 5,
                                        lettersonly: true
				},
				password: {
					required: true,
					minlength: 5,
                                        maxlength:20
				},
//				confirm_password: {
//					required: true,
//					minlength: 5,
//					equalTo: "#password"
//				},
				email: {
					required: true,
					email: true
				},
				contactNo: {
					required: true,
                                        minlength:7,
					maxlength: 10,
                                        integer:true
                                        
				}
//				agree: "required"
			    },
			messages: {
				firstname:{ 
                                    required:"Please enter your firstname",
                                   lettersonly:"only letters"
                                    
                                },
                                
				lastname:{ 
                                    required:"Please enter your lastname",
                                    lettersonly:"only letters"
                                    
                                },
				username: {
					required: "Please enter a username",
					minlength: "Your username must consist of at least 5 characters",
                                        lettersonly:"only letters"
				},
				password: {
					required: "Please provide a password",
					minlength: "Your password must be at least 5 characters long"
				},
//				confirm_password: {
//					required: "Please provide a password",
//					minlength: "Your password must be at least 5 characters long",
//					equalTo: "Please enter the same password as above"
//				},
				email:{
                                    email:"Please enter a valid email address"
                                },
//				agree: "Please accept our policy",
//				topic: "Please select at least 2 topics"
                                contactNo:{
                                    integer:"Please enter only numbers"
                                    minlength:"number should not be at least 10"
                                }
			}
		}); 
            
        });
        
   </script>