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
            <c:forEach var="checkin" items="${Checkin}">    
                <tr>
                <td>${checkin.checkinId}</td>
                <td>${checkin.getBooking().getFirstName()}</td>
                <td>${checkin.getBooking().getLastName()}</td>
                <td>${checkin.getBooking().getRoom().getRoomPrice()}</td>
                <td>${checkin.getBooking().getRoom().getRoomNumber()}</td>
                <td>${checkin.getBooking().getCheckinDate()}</td>
                <td>${checkin.getBooking().getTotalNights()}</td>
                <td>${checkin.getBooking().getCheckoutDate()}</td>
                <td>${checkin.getBooking().getTotalPrice()}</td>
                <td>
                    <a href="${SITE_URL}/admin/booking/edit/${booking.bId}" class="btn btn-success" >
                        <span class="glyphicon glyphicon-pencil">Edit</span>
                    </a>
                    <a href="${SITE_URL}/admin/booking/delete/${booking.bId}" class="btn btn-danger"  onclick=" return confirm('Are you sure to Delete')">
                        <span class="glyphicon glyphicon-trash">Delete</span>
                    </a>
                        
                </td>
                </tr>
                </c:forEach>
           
        </table>
        <%@include  file="../footer.jsp" %>
