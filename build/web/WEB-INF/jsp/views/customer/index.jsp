<%@include file="../header.jsp" %>
<% 
    
if(session.getAttribute("username")==null) 
{

response.sendRedirect("login.jsp");
}
%>
        <h1>Customer</h1>
        
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
        
                <tr>
                <td>${Customer.c_id}</td>
                <td>${Customer.firstName}</td>
                <td>${Customer.lastName}</td>
                <td>${Customer.email}</td>
                <td>${Customer.contactNo}</td>
                <td>${Customer.username}</td>
                <td>${Customer.password}</td>
                <td>
                    <a href="${SITE_URL}/admin/customer/edit/${c.c_id}" class="btn btn-success" title="Edit">
                        <span class="glyphicon glyphicon-pencil">Edit</span>
                    </a>
                   
                </td>
                </tr>
            
        </table>
        <%@include  file="../footer.jsp" %>