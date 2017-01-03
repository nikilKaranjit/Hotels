<%@include file="../header.jsp" %>

<div id="carousel-example-generic" class="carousel  slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
     <li data-target="#carousel-example-generic" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox"  >
  <div class="item active" style="background-image:url(${SITE_URL}/static/image/lounge.jpg);height:500px;background-repeat:no-repeat;background-position:center;background-size:cover">
  </div>
  <div class="item" style="background-image:url(${SITE_URL}/static/image/pool.jpg);height:500px;background-repeat:no-repeat;background-position: center;background-size:cover">
  </div>
  <div class="item" style="background-image:url(${SITE_URL}/static/image/bed.jpg);height:500px;background-repeat:no-repeat;background-position: center;background-size:cover">
  </div>
  <div class="item" style="background-image:url(${SITE_URL}/static/image/front.jpg);height:500px;background-repeat:no-repeat;background-position: center;background-size:cover">
  </div>
  </div>
  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
  <div class="container text-center">    
  <h3>OUR NEW OFFERS</h3><br>
  <div class="row">
  <div class="col-sm-4">
  <img src="${SITE_URL}/static/image/package.jpg" class="img-responsive" style="width:100%" alt="Image">
  </div>
  <div class="col-sm-4"> 
  <img src="${SITE_URL}/static/image/winter.jpg" class="img-responsive" style="width:100%" alt="Image">
  </div>
  <div class="col-sm-4">
  <img src="${SITE_URL}/static/image/package.jpg" class="img-responsive" style="width:100%" alt="Image">
  </div>
</div><br>
<%@include file="../footer.jsp" %>
</body>
</html>
