<%@include file="../header.jsp" %>
<body class="hold-transition login-page">
        <div class="login-box">
            <div class="login-logo">
              
            </div> 

            <div class="login-box-body">
                <h3 class="text-center">Login</h3>
                <form action="${pageContext.request.contextPath}/login/checking" method="POST"> 
                    

                    <c:if test="${not empty error}">
                        <div class="error text-danger">${error}</div><br/>
                    </c:if>
                                              

                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" name="username" placeholder="Username">  
                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" class="form-control"  name="password" placeholder="Password">
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                    <div class="row">
                        <div class="col-xs-8">
                        </div> 
                        <div class="col-xs-4">
                            <button type="submit" class="btn btn-primary btn-block btn-flat">Log In</button>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        </div> 

                    </div>
                </form>




            </div>
            <!--/.login-->
        </div> 