<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- 顶部导航栏 -->
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target="#navbar" aria-expanded="false"
			aria-controls="navbar">
			<span class="sr-only">展开菜单</span> 
			<span class="icon-bar"></span> 
			<span class="icon-bar"></span> 
			<span class="icon-bar"></span>
		</button>
		<div class="auth">
			<label>DINGYONG</label>
		</div>
		<a href="#" class="dy-menu">
			<span class="fa fa-bars fa-2x"></span>
		</a>
		<a href="#" class="dy-dropmenu-a">
			<span class="fa fa-chevron-down fa-lg"></span>
		</a>
	</div>
	<div id="navbar" class="navbar-collapse collapse">
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown">
				<a data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
					 <c:out value="${sessionScope.DYUser.userName}" />
					<i class="fa fa-angle-down"></i>
				</a>
				<ul class="dropdown-menu">
					<li>
						<a id="dy-exit"><span class="fa fa-remove fa-lg"></span> 退出</a>
					</li>
				</ul>
			</li>
		</ul>
	</div>
</nav>
<div class="dy-container">
	<!-- 菜单 -->
	<div class="dy-slidebar">
		<ul class="list-unstyled slidebar-menu">
			<li><a data-submenu> <span class="fa fa-users first-span"></span>菜单一<span class="fa fa-plus last-span"></span></a>
				<ul class="list-unstyled">
					<li><a data-href='<c:url value="/views/students/studentsMgt.jsp"></c:url>'><span class="fa fa-caret-right"></span> 学生管理</a></li>
				</ul>
			</li>
			<li><a data-submenu> <span class="fa fa-users first-span"></span>菜单二<span class="fa fa-plus last-span"></span></a>
				<ul class="list-unstyled">
					<li><a data-href='<c:url value="/views/students/studentsMgt.jsp"></c:url>'><span class="fa fa-caret-right"></span> 学生管理</a></li>
				</ul>
			</li>
		</ul>
	</div>
	<!-- 内容主体 -->
	<div class="dy-main">
		<div class="dy-load-content"></div>
	</div>
</div>

<!-- 右键菜单1 -->
<div id="demo-context-menu" class="context-menu">
	<ul class="dropdown-menu" role="menu">
		<li class="dropdown-header">操作</li>
		<li><a data-value="0" class="disabled"><span
				class="glyphicon glyphicon-plus"></span> 新增</a></li>
		<li><a data-value="1" data-type="update"><span
				class="glyphicon glyphicon-edit"></span> 修改</a></li>
		<li><a data-value="2"><span
				class="glyphicon glyphicon-remove"></span> 删除</a></li>
		<li><a data-value="3"><span
				class="glyphicon glyphicon-info-sign"></span> 详情</a></li>
		<li class="divider"></li>
		<li class="dropdown-header">其它</li>
		<li><a data-value="4">删除选中</a></li>
		<li><a data-value="5">全部选中</a></li>
		<li><a data-value="6">取消选中</a></li>
	</ul>
</div>

<!-- 右键菜单2 -->
<div id="order-context-menu" class="context-menu">
	<ul class="dropdown-menu" role="menu">
		<li class="dropdown-header">操作</li>
		<li><a data-value="0" class="disabled"><span
				class="glyphicon glyphicon-plus"></span> 新增</a></li>
		<li><a data-value="1"><span class="glyphicon glyphicon-print"></span>
				打印</a></li>
	</ul>
</div>
<script src="<c:url value="/resources/js/main.js"></c:url>"></script>