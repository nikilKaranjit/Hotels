<%@include file="../header.jsp" %>

<% 
    
if(session.getAttribute("username")==null) 
{
out.println("Iam here");
response.sendRedirect("views/login/login");

}
%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container-fluid">
<h1>Add Booking</h1>
<form:form modelAttribute= "Booking" action="${SITE_URL}/booking/save" method="post" role="form" >
     <div class="form-group">
        <label>First Name</label>
        <form:input path="firstName" placeholder="Enter First Name" required="required" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Last Name</label>
        <form:input path="lastName" placeholder="Enter Last Name" required="required" class="form-control"/>
    </div>
     <div class="form-group">
        <label>Room Price</label>
        <form:hidden path="room.ro_id"  id="ro_id"    name="room.ro_id"  class="form-control" value="${roomDetails.ro_id}"/>
    </div>
    <div class="form-group">
        <label></label>
        <form:input path="room.roomPrice"  id="roomprice"    name="room.roomPrice"  class="form-control" value="${roomDetails.roomPrice}"/>
    </div>
      <div class="form-group">
        <label>Room Number</label>
        <form:input path="room.roomNumber"  id="roomNumber"    name="room.roomNumber"  class="form-control" value="${roomDetails.roomNumber}"/>
    </div>
    <div class="form-group">
        <label>Room Price</label>
        <form:input path="room.roomPrice"  id="roomprice"    name="room.roomPrice"  class="form-control" value="${roomDetails.roomPrice}"/>
    </div>
    <div class="form-group">
        <label>Room Type</label>
        <form:input path="room.roomType" id="roomType" name="room.roomType"  value="${roomDetails.roomType}" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Checkin</label>
        <form:input type="date"  path="checkinDate" name="checkinDate"   required="required" class="form-control"/>
    </div>

    <div class="form-group">
        <label>Check out Date</label>
        <form:input type="date" path="checkoutDate"  name="checkoutDate"   required="required" class="form-control"/>
    </div>
    <!--    <div class="form-group">
            <label>Total nights</label>
    <form:input path="totalNights"  name="totalNights"   required="required" class="form-control"/>
</div>-->


            <div class="form-group">
        <label>Booked By</label>
        <form:input path ="Customer.username"  value="<%= session.getAttribute("username") %>"  class="form-control"/>
    </div>
 
    
    <!--      <div class="form-group">
                <label>Total Price</label>
    <form:input path="totalPrice"  id="totalPrice" name="totalPrice" placeholder="total price"  class="form-control"/>
</div>-->
    <div class="form-group">
        <label>Terms and Condition</label>
        <form:checkbox path="status" name="status" placeholder="Enter status" required="required" class="form-control"/>
    </div>
   
    <form:hidden path="bId" name="bId"/>
    <div class="form-group"> 
        <button type="submit" class="btn btn-success"   
                >Save</button>
    </div>
</form:form>
<%@include file="../footer.jsp" %>



