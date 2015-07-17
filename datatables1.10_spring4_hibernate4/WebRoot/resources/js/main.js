jQuery(function($) {

	/* 获取窗口高度 */
	DY.windowHeight;
	/* 获取窗口宽度 */
	DY.windowWidth;
	/* 创建dataArray对象 */
	DY.dataArray = [];
	/* 共用对象 */
	DY.$loadCotent;

	/* 重置布局 */
	DY.resetLayout = function() {
		DY.windowHeight = $(window).height();
		DY.windowWidth = $(window).width();
		if (DY.windowWidth > 992) {
			$(".slidebar-menu").slideDown();
			/* 判断菜单下拉按钮是否有active类样式避免在web端点击菜单按钮收缩菜单 */
			if ($(".dy-dropmenu-a").hasClass("active")) {
				$(".dy-dropmenu-a").removeClass("active");
			}
		} else {
			$(".slidebar-menu").slideUp();
		}
	};

	/* 实例化共用对象 */
	DY.createPublicInstances = function() {
		DY.$loadCotent = $(".dy-load-content");
	};

	/* 设置插件等全局默认参数 */
	DY.setGlobalDefaultsParams = function() {
		
		$.ajaxSetup({
            cache: false
        });
		
		/* 设置bootstrap select全局参数 */
		$.fn.selectpicker.defaults = {
			noneSelectedText: '',
			noneResultsText: '没有找到匹配项',
			countSelectedText: '选中{1}中的{0}项',
			maxOptionsText: ['超出限制 (最多选择{n}项)', '组选择超出限制(最多选择{n}组)'],
			multipleSeparator: ', '
		};
		
		/* DataTable全局参数设置 */
		$.extend($.fn.dataTable.defaults, {
			language: {
				url: "resources/data/Chinese.json"
			},
			filter: false, //是否启用过滤功能
			ordering: false, //是否启用排序功能
			autoWidth: false,
			lengthChange: false,
			iDisplayLength: 10,
			processing: false,
			serverSide: true,
			columnDefs: [{
				"defaultContent": "",
				"targets": "_all"
			}]
		});
		/*dataTable tools 按钮参数设置*/
		$.extend($.fn.dataTable.TableTools.DEFAULTS,{
			"sSwfPath":        DY.URL+"resources/swf/copy_csv_xls.swf",
			"aButtons":        [{
                "sExtends": "xls",
                "oSelectorOpts": {
                    page: 'current'
                },
                "sButtonText": "导出",
                "sButtonClass":"btn-primary btn-sm"
            }]
		});
		/* BootstrapValidator全局参数设置 */
		$.extend($.fn.bootstrapValidator.DEFAULT_OPTIONS, {
			message: '该值无效',
			excluded: ':disabled',
			feedbackIcons: {
				valid: 'glyphicon glyphicon-ok',
				invalid: 'glyphicon glyphicon-remove',
				validating: 'glyphicon glyphicon-refresh'
			}
		});
		
		/* BootstrapDatetimepicker全局参数设置 */
		$.extend($.fn.datetimepicker.defaults, {
			format: "YYYY-MM-DD",
			dayViewHeaderFormat: 'YYYY MMMM',
			locale: moment.locale(),
			showClear: true,
			showTodayButton: true
		});
	}

	/* 设置自定义滚动条 */
	DY.setMCustomScrollbar = function() {
		$(".dy-slidebar").mCustomScrollbar({
			autoHideScrollbar: true
		});
		$(".dy-main").mCustomScrollbar();
	}

	/* 左边下拉菜单JS */
	DY.dropDownMenu = function() {
		$(".slidebar-menu a").each(function() {
			$(this).click(function() {
				if ($(this).attr("data-submenu") == undefined) {
					$(".slidebar-menu ul a").removeClass("active");
					$(this).addClass("active");
					if ($(".dy-dropmenu-a").hasClass("active")) {
						$(".slidebar-menu").slideUp();
						$(".dy-dropmenu-a").removeClass("active");
					}
				} else {
					if ($(this).hasClass("active")) {
						$(".slidebar-menu a[data-submenu]").removeClass("active");
						$(this).find(".last-span").removeClass("fa-minus").addClass("fa-plus");
						$(this).next().slideUp();
					} else {
						$(".slidebar-menu a[data-submenu]").removeClass("active");
						$(this).addClass("active");
						$(".slidebar-menu ul").slideUp();
						$(".slidebar-menu a[data-submenu]").find(".last-span").removeClass("fa-minus").addClass("fa-plus");
						$(this).find(".last-span").removeClass("fa-plus").addClass("fa-minus");
						$(this).next().slideDown();
					}
				}

				var urlStr = $(this).attr("data-href");
				if (urlStr != "" && urlStr != undefined) {
					$("textarea").remove();
					$(".bootstrap-datetimepicker-widget").remove();
					$('.daterangepicker').remove();
					DY.$loadCotent.fadeOut('fast',function() {
						DY.$loadCotent.load(urlStr, function(responseText, textStatus, xhr) {
							DY.$loadCotent.fadeIn('slow');
						});
					});
				}
			});
		});
	};

	/* 收缩菜单 */
	DY.shrinkMenu = function() {
		$(".dy-menu").on("click", function() {
			if ($(".dy-slidebar").is(":animated")) {
				return;
			}
			if ($(".dy-slidebar").hasClass("dy-menu-close")) {
				$(".slidebar-menu").slideDown(1000);
				$(".dy-slidebar").animate({
					width: 230
				}, 500, function() {
					$(this).removeClass("dy-menu-close");
				});
			} else {
				$(".dy-slidebar").animate({
					width: 0
				}, 500, function() {
					$(this).addClass("dy-menu-close");
				});
				$(".slidebar-menu").slideUp();
			}
		})
	};

	/* 终端菜单按钮事件 */
	DY.dropmenuA = function() {
		$(".dy-dropmenu-a").click(function() {
			$(this).toggleClass("active");
			$(".slidebar-menu").slideToggle();
		});
	};

	/* 绑定计算器、日历、退出等操作 */
	DY.userDropdownMenu = function() {
		$('#dy-exit').on('click',function(){
			BootstrapDialog.confirm('确认退出吗？', function(result){
	            if(result) {
	            	$.get(DY.URL+'login/exit',function(data){
	            		if(data.success == 0)
	            			window.location=DY.URL+'index.jsp';
	            	},'json');
	            }
	        });
		})
	};

	/* 绑定动态元素 */
	DY.bindDynamicElements = function() {
		/* 模态最大高度计算 */
		$(document).on('show.bs.modal','.modal:not(#fileUpload-modal)',function(){
			var windowWidth = $(window).width();
			var windowHeight = $(window).height();
			if(windowWidth >= 768){
				$(this).find('.modal-body').css({
					'overflow':'auto',
					'max-height':windowHeight - 180
				});
			}else{
				$(this).find('.modal-body').css({
					'overflow':'auto',
					'max-height':windowHeight - 140
				});
			}
		})
		$(document).on('shown.bs.modal','.modal:not(#fileUpload-modal)',function(){
			var windowWidth = $(window).width();
			var windowHeight = $(window).height();
			var $modalBody = $(this).find('.modal-body');
			if(windowWidth >= 768){
				if((windowHeight-180) > $modalBody.outerHeight()){
					$modalBody.css('overflow','visible');
				}
			}else{
				if((windowHeight-140) > $modalBody.outerHeight()){
					$modalBody.css('overflow','visible');
				}
			}
		})
	};

	/* 设置元素样式 */
	DY.setElementsStyle = function() {
		/* 设置子界面的模态滚动条 */
		/*$(".modal").mCustomScrollbar();*/
		/*　使用bootstrap select下拉框　*/
		$("select.form-control").selectpicker();
		/* tooltip */
		$(".panel,.modal").tooltip({
			selector: '[data-toggle="tooltip"]'
		});
		/* jquery autosize */
		$("textarea").autosize({
			append: false,
			callback: function() {
				var $modal = $(this).parents('.modal');
				if ($modal.hasClass("in")) {
					$modal.modal("layout");
				}
			}
		});
		/* 为.datetimePicker类的表单添加时间控件 */
		$(".datetimePicker").datetimepicker({
			format:"YYYY-MM-DD"
		});
		$(".dy-daterangepicker").daterangepicker({
				timePickerIncrement: 30,
				format: "YYYY-MM-DD",
				opens: "left",
				locale: {
					applyLabel: "确定",
					cancelLabel: "取消",
					fromLabel: "开始",
					toLabel: "结束",
				}
			},
			function(start, end, label) {}
		);
		
		/* 绑定下拉列表的值 
		$("select.form-control").each(function(e){
			var $selectObj = $(this);
			var $source = $selectObj.data('source');
			if($source == undefined || $source == '' ){
				return;
			}
			var $type = $source.type;
			if($type == undefined){
				return;
			}
			// 属于字典类型的下拉列表
			if($type == 0){
				var $parentId = $source.parentId;
				if($parentId == undefined){
					return;
				}
				$.get(DY.URL + 'common/searchDictionary'+$parentId,function(data){
					dataIntoSelect($selectObj,data);
				},'json');
			//属于其他表的
			}
		});
		
		// 将数据放入select标签中
		function dataIntoSelect($selectObj,data){
			var $val = $selectObj.selectpicker('val');
			$selectObj.html('');
			$selectObj.append('<option value=""></option>');
			$.each(data,function(index,value){
				$selectObj.append('<option value="'+value.id+'">'+value.name+'</option>');
			})
			$selectObj.selectpicker('refresh');
			$selectObj.selectpicker('val',$val);
		}*/
		
		
		/* 扫描加载后的JSP,为带有data-provider的input绑定typeahead */
		$('input[data-provide="typeahead"]').each(function(e){
			var $inputObj = $(this);
			var $query = $inputObj.data('query');
			$inputObj.typeahead({ 
				source : function(query, process){
					var param = {clazzKey : $query.clazzKey , field : $query.field , value : query , num : $query.num};
					$.get(DY.URL+'commonMgt/showFieldDatas', param , function(data){
						process(data)
					},'json');
				}
			});
		})
	}
	/* 调用公共模态 */
	DY.modal = function() {

		/* 追加对象的容器 */
		var $body = $('body');
		/* 模态容器对象 */
		var $modalWrapper;

		/* 实例化模态容器,追加到body中 */
		var createModalWrapper = function(modalId) {
			var modalWrapperId = modalId + "-wrapper";
			$body.append('<div id="' + modalWrapperId + '"></div>');
			$modalWrapper = $('#' + modalWrapperId);
		}

		/* 显示模态 */
		var showModal = function(modalUrl, modalId) {
			$modalWrapper.load(modalUrl, function() {
				$('#' + modalId).modal('show');
				$('#' + modalId).on('hidden.bs.modal', function() {
					$modalWrapper.remove();
				})
			});
		}

		return {
			init: function(modalUrl, modalId) {
				createModalWrapper(modalId);
				showModal(modalUrl, modalId);
				return $modalWrapper;
			}
		};
	};

	/* dom结构加载完成 */
	$(document).ready(function() {
		DY.resetLayout();
		DY.createPublicInstances();
		DY.setGlobalDefaultsParams();
		DY.setMCustomScrollbar();
		DY.dropDownMenu();
		DY.shrinkMenu();
		DY.dropmenuA();
		DY.userDropdownMenu();
		DY.bindDynamicElements();
		
		DY.$loadCotent.load(DY.URL + "views/students/studentsMgt.jsp");
	});

	/* 窗口变化 */
	$(window).resize(function() {
		DY.resetLayout();
	});

	/* 界面加载完成 */
	$(window).load(function() {
		$("body").show();
	})
});