<%@include file="../header.jsp" %>
        <h1>Checkout</h1>
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
                   
                </td>
                </tr>
                </c:forEach>
           
        </table>
        <%@include  file="../footer.jsp" %>
