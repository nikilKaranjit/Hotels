<%@include file="../header.jsp" %>
<% 
    
if(session.getAttribute("username")==null) 
{

response.sendRedirect("login.jsp");
}
%>
        <h1>Customer</h1>
        <div class="pull-right">
                <p>
                <a href="${SITE_URL}/admin/customer/add" class="btn btn-primary" title="Add Customer"/>
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
            <td>Contact no.</td>
            <td>Username</td>
            <td>Password</td>
       
            <td>Action</td>
            </tr>
            <c:forEach var="c" items="${Customer}">
                <tr>
                <td>${c.c_id}</td>
                <td>${c.firstName}</td>
                <td>${c.lastName}</td>
                <td>${c.email}</td>
                <td>${c.contactNo}</td>
                <td>${c.username}</td>
                <td>${c.password}</td>
                <td>
                    <a href="${SITE_URL}/admin/customer/edit/${c.c_id}" class="btn btn-success" title="Edit">
                        <span class="glyphicon glyphicon-pencil">Edit</span>
                    </a>
                    <a href="${SITE_URL}/admin/customer/delete/${c.c_id}" class="btn btn-danger" title="Delete" onclick=" return confirm('Are you sure to Delete')">
                        <span class="glyphicon glyphicon-trash">Delete</span>
                    </a>
                </td>
                </tr>
            </c:forEach>
        </table>
        <%@include  file="../footer.jsp" %>
