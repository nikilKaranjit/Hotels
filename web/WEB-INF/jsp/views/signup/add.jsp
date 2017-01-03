<%@include file="../header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h1>Add Room</h1>
<form:form modelAttribute="Customer" action="${SITE_URL}/sign/save" method="post" role="form" id="customerForm">
    <div class="form-group">
        <label>First Name</label>
        <form:input path="firstName" placeholder="" class="form-control" />
    </div>
    <div class="form-group">
        <label>Last Name</label>
        <form:input path="lastName" placeholder=""  class="form-control"/>
    </div>
    
    <div class="form-group">
        <label>Email</label>
        <form:input path="email" placeholder="Enter email" required="required" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Contact</label>
        <form:input path="contactNo" type="numbers"  required="required" class="form-control"/>
    </div>
    <div class="form-group">
        <label>UserName</label>
        <form:input path="username" placeholder="Enter username" required="required" class="form-control"/>
    </div>
     <div class="form-group">
        <label>Password</label>
        <form:input path="password"  type="password" placeholder="Enter password" required="required" class="form-control"/>
    </div>
    
   <form:hidden path="c_id"/>
    <div class="form-group"> 
    <button type="submit" class="btn btn-success" >Save</button>
    </div>
   
</form:form>
