<%@include file="../header.jsp" %>
        <h1>Checkin</h1>
        <div class="pull-right">
                
        </div>
        <table class="table table-bordered table-hover table-striped">
            <tr>
            <td>Id</td>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Room Price</td>
            <td>Room Number</td>
            <td>CheckIn</td>
            <td>Total Nights</td>
            <td>Check outDate</td>
            <td>Total Price</td>
            <td>Action</td>
            </tr>
            <c:forEach var="checkout" items="${Checkout}">    
                <tr>
                <td>${checkout.checkoutId}</td>
                <td>${checkout.getCheckin().getFirstName()}</td>
                <td>${checkout.getCheckin().getLastName()}</td>
                <td>${checkout.getCheckin().getBooking().getRoom().getRoomPrice()}</td>
                <td>${checkout.getCheckin().getBooking().getRoom().getRoomNumber()}</td>
                <td>${checkout.getCheckin().getBooking().getCheckinDate()}</td>
                <td>${checkout.getCheckin().getBooking().getTotalNights()}</td>
                <td>${checkout.getCheckin().getBooking.getCheckoutDate()}</td>
                <td>${checkout.getCheckin().getBooking().getTotalPrice()}</td>
                <td>
                   </a>
                    <a href="${SITE_URL}/admin/checkin/checkout"  class="btn btn-success" onclick=" return confirm('Are you sure to checkout')">
                        <span class="glyphicon glyphicon-home"></span>
                    </a>
                    <a href="${SITE_URL}/admin/booking/delete/${booking.bId}" class="btn btn-danger"  onclick=" return confirm('Are you sure to Delete')">
                        <span class="glyphicon glyphicon-trash">Delete</span>
                    </a>
                        
                </td>
                </tr>
                </c:forEach>
           
        </table>
        <%@include  file="../footer.jsp" %>
