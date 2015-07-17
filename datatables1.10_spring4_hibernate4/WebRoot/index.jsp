<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
    	<script type="text/javascript">/* 创建对象 */var DY = window.DY || {};DY.URL="<%=basePath%>";</script>
		<meta charset="utf-8" />
		<meta name="renderer" content="webkit">
		<title>jqueryDatatableDemo</title>
		
		<!-- font-awesome字体 -->
		<link rel="stylesheet" href="<c:url value="/resources/components/font-awesome/css/font-awesome.css"></c:url>" />
		<!-- bootstrap相关样式 -->
		<link rel="stylesheet" href="<c:url value="/resources/components/bootstrap/css/bootstrap.css"></c:url>" />
		<link rel="stylesheet" href="<c:url value="/resources/components/bootstrap-select/css/bootstrap-select.css"></c:url>" />
		<link rel="stylesheet" href="<c:url value="/resources/components/bootstrap-dialog/css/bootstrap-dialog.css"></c:url>" />
		<!-- 表单样式 -->
		<link rel="stylesheet" href="<c:url value="/resources/components/bootstrap-validator/css/bootstrapValidator.css"></c:url>" />
		<link rel="stylesheet" href="<c:url value="/resources/components/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css"></c:url>" />
		<link rel="stylesheet" href="<c:url value="/resources/components/bootstrap-daterangepicker/css/daterangepicker-bs3.css"></c:url>" />
		<!-- 表格样式 -->
		<link rel="stylesheet" href="<c:url value="/resources/components/dataTable/css/dataTables.bootstrap.css"></c:url>" />
		<link rel="stylesheet" href="<c:url value="/resources/components/dataTable/css/dataTables.responsive.css"></c:url>" />
		<!-- 滚动条样式 -->
		<link rel="stylesheet" href="<c:url value="/resources/components/mCustomScrollbar/css/jquery.mCustomScrollbar.css"></c:url>" />
		<!-- 全日历样式 -->
		<link rel="stylesheet" href="<c:url value="/resources/components/fullcalendar/css/fullcalendar.css"></c:url>" />
		<!-- 主样式 -->
		<link rel="stylesheet" href="<c:url value="/resources/css/style.css"></c:url>" />
		<link rel="stylesheet" href="<c:url value="/resources/css/main.css"></c:url>" />
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		 <!--[if lt IE 9]>
		  <link rel="stylesheet" href="<c:url value="/resources/css/ie8-main.css"></c:url>" />
	      <script src="<c:url value="/resources/js/html5shiv.min.js"></c:url>" ></script>
	      <script src="<c:url value="/resources/js/respond.min.js"></c:url>" ></script>
    	<![endif]--> 
	</head>

	<body>
	
		<!-- 登录 -->
		<div class="dy-login">
			<div class="dy-login-common dy-login-top">
				<div class="dy-login-top-container">
					LOGO-DINGYON
				</div>
			</div>
			<div class="dy-login-common dy-login-bottom">
				<div class="dy-login-bottom-container">
					<form id="login-form">
						<div class="form-group">
							<div class="input-group input-group-sm">
								<span class="input-group-addon">
									<span class="fa fa-user fa-lg"></span>
								</span>
								<input type="text" class="form-control" name="username" autocomplete="off">
							</div>
						</div>
						<div class="form-group">
							<div class="input-group input-group-sm">
								<span class="input-group-addon">
									<span class="fa fa-lock fa-lg"></span>
								</span>
								<input type="password" class="form-control" name="password" autocomplete="off">
							</div>
						</div>
						<center><button type="submit" class="btn btn-primary btn-sm"><i class="fa fa-signin"></i>登录</button></center>
					</form>
				</div>
			</div>
		</div>
		<div id="main"></div>
		
		<script src="<c:url value="/resources/components/jquery/js/jquery-1.11.1.min.js"></c:url>"></script>
		<script src="<c:url value="/resources/components/jquery-serialize-object/js/jquery.serialize-object.js"></c:url>"></script>
		<script src="<c:url value="/resources/components/jquery-ui/js/jquery-ui.custom.min.js"></c:url>"></script>
        <!-- bootstrap上传插件 -->
        <script src="<c:url value="/resources/components/bootstrap-fileinput/js/fileinput.js"></c:url>"></script>
		<!-- bootstrap及其相关插件 -->
		<script src="<c:url value="/resources/components/bootstrap/js/bootstrap.js"></c:url>"></script>
		<script src="<c:url value="/resources/components/bootstrap-select/js/bootstrap-select.js"></c:url>"></script>
		<script src="<c:url value="/resources/components/bootstrap-dialog/js/bootstrap-dialog.js"></c:url>"></script>
		<!-- 表单插件 -->
		<script src="<c:url value="/resources/components/bootstrap-validator/js/bootstrapValidator.js"></c:url>"></script>
		<script src="<c:url value="/resources/components/moment/js/moment.min.js"></c:url>"></script>
		<script src="<c:url value="/resources/components/bootstrap-validator/js/language/zh_CN.js"></c:url>"></script>
		<script src="<c:url value="/resources/components/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></c:url>"></script>
		<script src="<c:url value="/resources/components/moment/js/locale/zh-cn.js"></c:url>"></script>
		<script src="<c:url value="/resources/components/bootstrap-daterangepicker/js/daterangepicker.js"></c:url>"></script>
		<script src="<c:url value="/resources/components/jquery-autosize/js/jquery.autosize.js"></c:url>"></script>
		<!-- 表格插件 -->
		<script src="<c:url value="/resources/components/dataTable/js/jquery.dataTables.min.js"></c:url>"></script>
		<script src="<c:url value="/resources/components/dataTable/js/dataTables.tableTools.min.js"></c:url>"></script>
		<script src="<c:url value="/resources/components/dataTable/js/dataTables.bootstrap.js"></c:url>"></script>
		<!-- 滚动条插件 -->
		<script src="<c:url value="/resources/components/mCustomScrollbar/js/jquery.mCustomScrollbar.concat.min.js"></c:url>"></script>
		<!-- 全日历插件 -->
		<script src="<c:url value="/resources/components/fullcalendar/js/fullcalendar.js"></c:url>"></script>
		<!-- js -->
		<script src="<c:url value="/resources/js/plugins.js"></c:url>"></script>
		<script type="text/javascript">
			 jQuery(function($) {
			     
                 // 绑定login表单
				DY.bindLogin = function(){
					$("#login-form").bootstrapValidator({
						fields:{
							'username' : {
								validators:{
									notEmpty:{
										message:'用户名不能为空'
									}
								}
							},
							'password' : {
								validators:{
									notEmpty:{
										message:'密码不能为空'
									}
								}
							}
						}
					}).on('success.form.bv',function(e){
						e.preventDefault();
						$.get(DY.URL+'login/loginValidate',$("#login-form").serialize(),function(data){
							$("#login-form").data('bootstrapValidator').resetForm(true);
							if(data.status == 1){
								$('#main').load('<c:url value="main.jsp" />',function(){
									DY.intoMain();
								})
							}else{
								BootstrapDialog.alert("用户名或密码有误!");
							}
						},'json').fail(function(){
							BootstrapDialog.alert("校验失败,请重新登陆!");
						});
						
					});
				
				};
			
				DY.intoMain = function(){
					$(".dy-login-top").animate({
						bottom: "100%",
						opacity: 0
					}, 1000);
					$(".dy-login-bottom").animate({
						top: "100%",
						opacity: 0
					}, 1000, function() {
						$(".dy-login").hide();
					});
				};
                
                DY.exitMain = function(){
                    $(".dy-login").show();
                    setTimeout(function(){
                        $(".dy-login-top").animate({
                            bottom: "50%",
                            opacity: 1
                        }, 1000);
                        $(".dy-login-bottom").animate({
                            top: "50%",
                            opacity: 1
                        }, 1000);
                    },100);
                    
                };
				
				//dom结构加载完成 
				$(document).ready(function() {
					//$('#main').load('<c:url value="main.jsp" />')
					// 判断是否登录 
					if(('<c:out value="${sessionScope.DYUser}" />') == ''){
						DY.bindLogin();
					}else{
						$('.dy-login').hide();
						$('#main').load('<c:url value="main.jsp" />')
					} 
				});
			
				//界面加载完成 
				$(window).load(function() {
					$("body").show();
				})
			
			});
			
		</script>
	</body>

</html>
