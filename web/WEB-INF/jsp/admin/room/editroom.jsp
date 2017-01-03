
<%@include file="../header.jsp" %>
<% 
    
if(session.getAttribute("username")==null) 
{

response.sendRedirect("login.jsp");
}
%>

<h1>Edit Room</h1>
<form action="${SITE_URL}/admin/room/save"  method="post" enctype="multipart/form-data" id="roomeditForm">
    <div class="form-group">
        <label>Room Type</label>
        <input type="text" name="roomType" value="${Room.roomType}" required="required" class="form-control"/>
        
    </div>
    <div class="form-group">
        <label>Room Description</label>
        <input type="text" name="roomDescription" value="${Room.roomDescription}" required="required" class="form-control"/>
    </div>
    
    <div class="form-group">
        <label>Room Number</label>
        <input type="number" name="roomNumber" value="${Room.roomNumber}" required="required" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Room Price</label>
        <input type="number" name="roomPrice" value="${Room.roomPrice}" required="required" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Room Image</label>
        <input type="file" name="file"  src="D:/Hotels/uploadedImage/${Room.image}"   required="required" class="form-control" />
    </div>
    <form:hidden path="${Room.ro_id}" />
    <input type="text" value="${Room.ro_id}" name="id"/>
    <div class="form-group"> 
    <button type="submit" class="btn btn-success" value="editroom/ro_id" >Save</button>
    </div>
</form>
<%@include  file="../footer.jsp" %>

