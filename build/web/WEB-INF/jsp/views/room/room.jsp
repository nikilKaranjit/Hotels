<%@include file="../header.jsp" %>
<div class="container-fluid" >
    
    
    <c:forEach items="${Room}" var="room" >
        <div class="wrapper">
            <img src="<c:url value='/static/uploadedImages/${room.image}'/>" alt=" our rooms"/>
        <div id="getRoomDetails">
            <label>Room Type:${room.roomType}</label><br>
            <label>Room Description:${room.roomDescription}</label><br>
            <label>Room Number:${room.roomNumber}</label><br>
            <label>Room Price:${room.roomPrice}</label><br>
            <a class="btn btn-success" href="${SITE_URL}/booking/add/${room.ro_id}">
            
            <span class="glyphicon glyphicon-pencil">Book now</span>
           </a>
        </div>
        </div>
    </c:forEach>
  </div>
<%@include file="../footer.jsp" %>

