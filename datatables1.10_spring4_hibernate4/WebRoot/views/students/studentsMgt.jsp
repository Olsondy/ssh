<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--学生管理面板-->
<div class="panel panel-default dy-panel">
	<div class="panel-heading">
		<h3 class="panel-title">
			<i class="fa fa-tags fa-lg"></i>学生管理
			<div class="pull-right">
			<a><i class="fa fa-refresh reload"></i></a>
			<a><i class="fa fa-chevron-up closes"></i></a>
			</div>
		</h3>
	</div>
	<div id="overlay">
				<div class="progress">
	  				<div class="progress-bar progress-bar-striped active" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
	  		 			 <label>正在加载,请稍候......</label>
	  				</div>
				</div>
	</div>
	<div class="panel-body" >
		<form id="searchStudentForm" class="dy-form-horizontal">
			<div class="row">
				<div class="form-group col-sm-6 col-md-6 col-lg-3">
					<div class="input-group input-group-sm">
						<span class="input-group-addon">班级</span> 
						 <input type="text" class="form-control input-sm" name="classes.name" data-provide="typeahead"data-query='{"clazzKey":"TCLASSES","field":"name","num":8}' placeholder="搜索班级"autocomplete="off">
					</div>
				</div>
				<div class="form-group col-sm-6 col-md-6 col-lg-3">
					 <div class="input-group input-group-sm">
                        <span class="input-group-addon">姓名</span> <input type="text" class="form-control input-sm"
                            name="sName" placeholder="填写姓名(支持模糊查询和拼音码)" autocomplete="off"/>
                    </div>
				</div>
				
				<div class="form-group col-sm-6 col-md-6 col-lg-3">
					<div class="input-group input-group-sm">
						<span class="input-group-addon">性别</span> <select class="form-control input-sm" name="sSex">
							<option value=""></option>
							<option value="0">男</option>
							<option value="1">女</option>
							<option value="2">未知</option>
						</select>
					</div>
				</div>
				<div class="form-group col-sm-6 col-md-6 col-lg-3">
	                   <div class="input-group input-group-sm" >
                        <span class="input-group-addon">入学时间</span> <input type="text"
                            class="form-control  dy-daterangepicker" name="inDate">
                    </div>
				</div>
			</div>
			<div class=" dataTable-tool">
				<div class="dy-form-search">
					<button type="submit" class="btn btn-default btn-sm">查询</button>
					<button type="reset" class="btn btn-default btn-sm">重置</button>
				</div>
				<div class="dy-divider"></div>
				<div class="dy-curd">
					<button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#studentDataModal">新建</button>
				</div>
				<div class="pull-right export-table">
					
				</div>
			</div>
		</form>
		<!-- 表格  -->
		<table id="studentTable" class="table dy-dataTable responsive">
			<thead>
				<tr>
					<th>所在班级</th>
					<th>学生姓名</th>
					<th>性别</th>
					<th>出生日期</th>
					<th>入学时间</th>
				</tr>
			</thead>
			<tbody></tbody>
			<tfoot></tfoot>
		</table>
	</div>
</div>
<!--增加 修改 modal-->
<div class="modal fade" id="studentDataModal" data-backdrop="static">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title"></h4>
			</div>
			<form id="studentDataForm" class="add-form">
				<div class="modal-body">
					<div class="modal-scroll-content">
						<div class="row">
							<div class="form-group col-sm-6">
								<div class="input-group input-group-sm">
									<span class="input-group-addon">学生姓名</span> 
									<input type="text" class="form-control" name="sName" placeholder="填写姓名"> 
									<input type="hidden" name="id"> 
								</div>
							</div>
							<div class="form-group col-sm-6">
								<div class="input-group input-group-sm">
									<span class="input-group-addon">拼音码</span> 
									<input type="text" class="form-control"  name="pinyin" readonly="readonly"> 
								</div>
							</div>
							<div class="form-group col-sm-6">
								<div class="input-group input-group-sm">
									<span class="input-group-addon">出生日期</span> 
									<input type="text" class="form-control date datetimePicker"name="birthday" />
								</div>
							</div>
							<div class="form-group col-sm-6">
								<div class="input-group input-group-sm">
									<span class="input-group-addon">性别</span> <select class="form-control input-sm" name="sSex">
										<option value=""></option>
										<option value="0">男</option>
										<option value="1">女</option>
										<option value="2">未知</option>
									</select>
								</div>
							</div>
							<div class="form-group col-sm-6">
								<div class="input-group input-group-sm">
									<span class="input-group-addon">入学时间</span> 
									<input type="text" class="form-control date datetimePicker"name="inDate" />
								</div>
							</div>
							<div class="form-group col-sm-6">
								<div class="input-group input-group-sm">
									<span class="input-group-addon">班级</span> 
									<input type="text" class="form-control choice" name="classes.name"data-provide="typeahead"data-query='{"clazzKey":"TCLASSES","field":"name","num":8}' placeholder="搜索班级">
									<input type="hidden"name="classes.id"> 
								</div>
							</div>
							<div class="form-group col-sm-12">
								<div class="input-group input-group-sm">
									<span class="input-group-addon">入学说明</span> 
									<textarea class="form-control" name="memo" 
									data-toggle="tooltip" data-placement="top"title="填写入学说明"/>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary btn-sm">提交</button>
					<button type="reset" class="btn btn-default btn-sm">重置</button>
					<button type="button" class="btn btn-danger btn-sm" data-dismiss="modal">关闭</button>
				</div>
			</form>
		</div>
	</div>
</div>
<script src="<c:url value='/resources/js/DY/js/students.js'></c:url>" type="text/javascript"></script>
