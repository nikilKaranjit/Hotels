<%@include file="../header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h1>Add Users</h1>
<form:form modelAttribute="Comments" action="${SITE_URL}/about/save" method="post" role="form">
<!--    
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
                    -->
<div class="form-group">
        <label>Message</label>
        <form:input path ="Customer.username"  value="<%= session.getAttribute("username") %>"  class="form-control"/>
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