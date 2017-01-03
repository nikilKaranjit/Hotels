

<%@include file="../header.jsp" %>
<% 
    
if(session.getAttribute("username")==null) 
{

response.sendRedirect("admin/default/login");
}
%>
welcome ${username}
        <h1>Users</h1>
        <div class="pull-right">
                <p>
                <a href="${SITE_URL}/admin/users/adduser" class="btn btn-primary" title="Add User"/>
                <span class="glyphicon glyphicon-plus"></span>
                </a>
                </p>
        </div>
        <table class="table table-bordered table-hover table-striped">
            <tr>
            <td>Id</td>
            <td>First Name</td>
            <td>Last Name</td>
            <td>E-mail</td>
            <td>Username</td>
            <td>Password</td>
            <td>Role</td>
            <td>Action</td>
            </tr>
            <c:forEach var="users" items="${User}">
                <tr>
                <td>${users.u_id}</td>
                <td>${users.firstName}</td>
                <td>${users.lastName}</td>
                <td>${users.email}</td>
                <td>${users.username}</td>
                <td>${users.password}</td>
                <td>${users.r_id}</td>
                <td>
                    <a href="${SITE_URL}/admin/users/edituser/${users.u_id}" class="btn btn-success" title="Edit">
                        <span class="glyphicon glyphicon-pencil">Edit</span>
                    </a>
                    <a href="${SITE_URL}/admin/users/delete/${users.u_id}" class="btn btn-danger" title="Delete" onclick=" return confirm('Are you sure to Delete')">
                        <span class="glyphicon glyphicon-trash">Delete</span>
                    </a>
                </td>
                </tr>
            </c:forEach>
        </table>
        <%@include  file="../footer.jsp" %>
