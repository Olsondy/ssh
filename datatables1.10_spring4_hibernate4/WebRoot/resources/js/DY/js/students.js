jQuery(function($) {
	DY.panel;
	DY.searchStudentForm;
	DY.studentDataForm;
	DY.studentDataModal;
	DY.studentDetailModal;
	DY.studentDataTable;
	DY.dataTableStudentEntity;
	
	DY.createStudentInstance = function() {
		DY.panel = $('.panel');
		DY.searchStudentForm = $('#searchStudentForm');
		DY.studentDataForm = $('#studentDataForm');
		DY.studentDataModal = $('#studentDataModal');
		DY.studentDetailModal = $('#studentDetailModal');
		DY.studentDataTable = $('#studentTable');
	}

	/*面板JS*/
	DY.bindStudentPanel = function() {
		/* 表格数据 */
		DY.dataTableStudentEntity = DY.studentDataTable.DataTable({
			ajax: {
				url: DY.URL+"studentsMgt/findAllStu",
				data: function(data) {
					var params = 'draw='+data.draw+'&start='+data.start+'&length='+data.length+'&'+DY.searchStudentForm.serialize();
					return params;
				},
				complete :function(){
					DY.panel.find('#overlay').fadeOut(1000);
				},
				dataType : "json",
				contentType : 'application/json;charset=UTF-8'
			}, 
			columns: [{
				data: "name"
			}, {
				data: "sName"
			}, {
				data: "sex"
			}, {
				data: "birthday"
			}, {
				data: "inDate"
			}],
			columnDefs: [{
				targets: [2],
				data: 'sex',
				render: function(data, type,
						full) {
					var result = data==0?'男':data==1?'女':'未知';
					return result;
				}
			}],
			rowCallback: function(row, data) {
				$(row).contextmenu({
					target: '#demo-context-menu',
					before:function (e, element, target) {
						e.preventDefault();
						this.getMenu().find('li:first').html(data.sName+" - 操作");
						return true;
					},
					onItem: function (context, e) {
						var $value = parseInt($(e.target).attr("data-value"));
						switch ($value) {
						//新增
						case 0:
							DY.studentDataModal.modal('show');
							break;
						case 1:
							// 修改
							$.get(DY.URL+'studentsMgt/findStuById/'+data.id,function(d){
								if(d){
									DY.studentDataModal.find('input,textarea').each(function() {
										var $name = $(this).attr('name');
										if (d.hasOwnProperty($name)) {
											$(this).val(d[$name]);
										}else if($name=='classes.name'){
											$(this).val(d['cName']);
										}else if($name=='classes.id'){
											$(this).val(d['cId']);
										}
									});
									DY.studentDataModal.find('select[name="sSex"]').selectpicker('val',d.sex);
								}else{
									BootstrapDialog.alert('无信息');
								}
							},'json').done(function(){
								DY.studentDataModal.modal('show');
							}).fail(function(){
								BootstrapDialog.danger('获取失败');
								return false;
							})
							break;
						case 2:
							break;
						case 3:
							DY.modal().init(DY.URL + '');
							break;
						default:
							break;
						}
					}
				});
			},
			drawCallback:function(){
				var $export = DY.searchStudentForm.find('div.export-table');
				$export.empty();
				/*导出功能*/
				var tt = new $.fn.dataTable.TableTools(DY.dataTableStudentEntity);
				$(tt.fnContainer()).appendTo($export);
				$export.find('div.DTTT').css('margin-top','5px');
			}
		});

		/*查询*/
		DY.searchStudentForm
		.find(".dy-daterangepicker").on('apply.daterangepicker cancel.daterangepicker',function(){
			DY.searchStudentForm.data('bootstrapValidator').revalidateField('inDate');
		}).end()
		.bootstrapValidator({
			fields: {
				'classes.name': {},
				sName: {},
				sex: {},
				inDate: {}
			}
		})
		.on('success.form.bv', function(e) {
			// 阻止Form提交
			e.preventDefault();
			DY.dataTableStudentEntity.draw();
		});
		/*清空查询*/
		DY.searchStudentForm.on("click", 'button[type="reset"]', function() {
			DY.searchStudentForm.data('bootstrapValidator').resetForm(true);
			DY.searchStudentForm.find('select').selectpicker("val", "");
		});
		//体验
		DY.panel.find('.reload').on('click',function(){
			var reload = $(this)
			reload.addClass('fa-spin')
			DY.panel.find('#overlay').fadeIn(1000);
			DY.dataTableStudentEntity.draw();
			setTimeout(function(){
				reload.removeClass('fa-spin')
			}, 1000)
			
		});
		//体验
		DY.panel.find('.closes').on('click',function(){
			var close = $(this);
			if(close.hasClass('fa-chevron-up')){
				DY.panel.find('.panel-body').slideUp('slow',function(){
					close.removeClass('fa-chevron-up').addClass('fa-chevron-down');
				})
				DY.panel.find('.reload').hide();
			}else if(close.hasClass('fa-chevron-down')){
				DY.panel.find('.panel-body').slideDown('slow',function(){
					close.removeClass('fa-chevron-down').addClass('fa-chevron-up');
					DY.panel.find('.reload').show().click();
				})
			}
			
		})
	};

	/*模态JS*/
	DY.bindStudentDataModal = function() {

		/* 新增 */
		DY.studentDataModal.on("show.bs.modal",function(event) {
			var $idVal = DY.studentDataForm.find('input[name="id"]').val();
			if($idVal == ''){
				DY.studentDataModal.find('.modal-title').html("<i class='fa fa-tags fa-lg'></i>新增学生信息");
			}else{
				DY.studentDataModal.find('.modal-title').html("<i class='fa fa-edit fa-lg'></i>修改学生信息");
			}
		});
		/*增加验证*/
		DY.studentDataForm.bootstrapValidator({
			fields: {
				id:{},
				sName: {
					validators: {
						notEmpty: {},
						StringLength:{
							min:2,
							max:5,
							message:'长度应大于2小于5'
						},
						regexp: {
							regexp: /^[\u4E00-\u9FA5A-Za-z]+$/,
							message: '只能输入英文字母或者数字'
						}
					}
				},
				pinyin: {
					validators: {
						notEmpty: {},
						StringLength:{
							min:2,
							max:5,
							message:'长度应大于2小于5'
						},
						regexp: {
							regexp: /^[\u4E00-\u9FA5A-Za-z]+$/,
							message: '只能输入英文字母或者数字'
						}
					}
				},
				birthday: {
					validators: {
						notEmpty: {},
						date: {
							format: 'YYYY-MM-DD',
							message: '请输入有效的时间'
						}
					}
				},
				sSex:{
					validators: {
						notEmpty: {}
					}
				},
				inDate: {
					validators: {
						notEmpty: {},
						date: {
							format: 'YYYY-MM-DD',
							message: '请输入有效的时间'
						}
					}
				},
				memo:{
					validators: {
						stringLength: {
							min:0
						}
					}
				},
				'classes.name':{},
				'classes.id':{
					validators: {
						notEmpty: {}
					}
				}
			}
		})
		.on("success.form.bv", function(e) {
			e.preventDefault();
			var $id = DY.studentDataForm.find('input[name="id"]').val();
			$.post(DY.URL + "studentsMgt/mergeStu",DY.studentDataForm.serialize(),function(data){
				DY.dataTableStudentEntity.draw();
			}).done(function(data){
				if ($id) {
                    BootstrapDialog.success('修改成功');
                } else {
                	DY.studentDataModal.find('button[type="reset"]').click();
                    BootstrapDialog.success('添加成功');
                }
			}).fail(function(){
				if ($id) {
                   BootstrapDialog.danger('修改失败');
               } else {
                   BootstrapDialog.danger('添加失败');
               }
			})
		});
		DY.studentDataForm.on('dp.change dp.show', 'input[name="birthday"]', function(e) {
			DY.studentDataForm.data('bootstrapValidator').revalidateField(this.name);
		});
		DY.studentDataForm.on('dp.change dp.show', 'input[name="inDate"]', function(e) {
			DY.studentDataForm.data('bootstrapValidator').revalidateField(this.name);
		});
		//thpeahead 选择事件
		DY.studentDataForm.on('change','input[name="classes.name"]',function(){
			var current = $(this).typeahead("getActive");
			DY.studentDataForm.find('input[name="classes.id"]').val(current.id);
			DY.studentDataForm.data('bootstrapValidator').revalidateField('classes.id');
		})
		/* 获取拼音码 */
		DY.studentDataForm.find('input[name="sName"]').on('input propertychange',function(){
			$.get(DY.URL+'studentsMgt/getPinyin',{'name':$(this).val()},function(data){
				DY.studentDataForm.find('input[name="pinyin"]').val(data);
				DY.studentDataForm.data('bootstrapValidator').revalidateField('pinyin');
			})
		});
		/*清空增加窗体表单*/
		DY.studentDataForm.on("click",'button[type="reset"]', function() {
			DY.studentDataForm.data('bootstrapValidator').resetForm(true);
			DY.studentDataForm.find('select').selectpicker("val", "");
		});
		/*关闭窗体事件*/
		DY.studentDataModal.on('hide.bs.modal',function(event){
			DY.studentDataModal.find('button[type="reset"]').click();
		});
	};
	$(function() {
		DY.createStudentInstance();
		DY.bindStudentPanel();
		DY.bindStudentDataModal();
		DY.setElementsStyle();
	});
});