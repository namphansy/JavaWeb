<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
	<div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="#" class="site_title"><i class="fa fa-paw"></i> <span>
              	<c:out value="${pageContext.request.remoteUser}"/>
              </span></a>
            </div>
            <div class="clearfix"></div>
            <br />
            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <!-- <h3>General</h3> -->
                <ul class="nav side-menu">
                  <li><a href="<%=request.getContextPath()%>/admin">TRANG CHỦ</a></li>
                  <li><a href="<%=request.getContextPath()%>/adminGetAllCategories.htm">DANH MỤC</a></li>
                  <li><a href="<%=request.getContextPath()%>/adminGetAllProduct.htm">SẢN PHẨM</a></li>
                  <li><a href="<%=request.getContextPath()%>/adminGetAllProductDetails">CHI TIẾT SẢN PHẨM</a></li>	
                  <li><a>TÀI KHOẢN <span class="fas fa-chevron-down"></span></a>
                  	<ul class="nav child_menu">
                    	<li><a href="<%=request.getContextPath()%>/adminGetAllUser.htm">TÀI KHOẢN USER</a></li>
                     	<li><a href="<%=request.getContextPath()%>/adminGetAllAdmin.htm">TÀI KHOẢN ADMIN</a></li>
                    </ul>
                  </li>
                  <li><a href="<%=request.getContextPath()%>/adminGetAllBrand.htm">THƯƠNG HIỆU</a></li>
                  <li><a href="<%=request.getContextPath()%>/adminGetAllOrders.htm">GIỎ HÀNG</a></li>
                  <li><a href="<%=request.getContextPath()%>/adminGetAllComment.htm">BÌNH LUẬN</a></li>
                  <li><a href="<%=request.getContextPath()%>/adminShowContact.htm">THÔNG TIN LIÊN LẠC</a></li>
                  <li><a href="<%=request.getContextPath()%>/adminGetAllBlog.htm">BÀI VIẾT</a></li>
                  <li>
                  	<form action="<c:url value='/logoutAction'/>" method="post" 
                  		style="padding: 13px 15px 12px">
                  		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
                  		<input type="submit" value="Đăng xuất" 
                  			style="color: white; background-color: #2A3F54; font-weight: 500; font-size: 20px; border-style: none">
                  	</form>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <div class="nav toggle">
                  <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                </div>
                <nav class="nav navbar-nav">
                <ul class=" navbar-right">
                  <li role="presentation" class="nav-item dropdown open">
                    <a href="javascript:;" class="dropdown-toggle info-number" id="navbarDropdown1" data-toggle="dropdown" aria-expanded="false">
                      <i class="fa fa-envelope-o"></i>
                      <span class="badge bg-green">6</span>
                    </a>
                  </li>
                </ul>
              </nav>
            </div>
          </div>
        <!-- /top navigation -->
      </div>
    </div>
	