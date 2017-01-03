<%@include file="../header.jsp" %>
<% 
    
if(session.getAttribute("username")==null) 
{

response.sendRedirect("login.jsp");
}
%>
      <h1>Room</h1>
        <div class="pull-right">
                <p>
                <a href="${SITE_URL}/admin/room/addroom" class="btn btn-primary" title="Add User"/>
                <span class="glyphicon glyphicon-plus"></span>
                </a>
                </p>
        </div>
        <table class="table table-bordered table-hover table-striped">
            <tr>
            <td>Id</td>
            <td>Room Type</td>
            <td>Room Description</td>
            <td>Room Number</td>
            <td>Room Price</td>
            <td>Image</td>
            <td>Action</td>
            </tr>
            <c:forEach var="r" items="${Room}">
                <tr>
                <td>${r.ro_id}</td>
                <td>${r.roomType}</td>
                <td>${r.roomDescription}</td>
                <td>${r.roomNumber}</td>
                <td>${r.roomPrice}</td>
                <td>${r.image}</td>
                <td>
                    <a href="${SITE_URL}/admin/room/editroom/${r.ro_id}" class="btn btn-success" title="Edit">
                        <span class="glyphicon glyphicon-pencil">Edit</span>
                    </a>
                    <a href="${SITE_URL}/admin/room/deleteroom/${r.ro_id}" class="btn btn-danger" title="Delete" onclick=" return confirm('Are you sure to Delete')">
                        <span class="glyphicon glyphicon-trash">Delete</span>
                    </a>
                </td>
                </tr>
            </c:forEach>
        </table>
        <%@include  file="../footer.jsp" %>
