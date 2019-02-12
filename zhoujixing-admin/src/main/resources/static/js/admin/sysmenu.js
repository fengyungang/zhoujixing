$(function () {
    $("#jqGrid").jqGrid({
        url: 'getMenuList',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '父级ID', name: 'parentid', index: 'parentId', width: 80 }, 			
			{ label: '菜单名称', name: 'menuname', index: 'menuname', width: 80 }, 			
			{ label: '排序', name: 'ordernum', index: 'orderNum', width: 80 }, 			
			{ label: '功能地址', name: 'url', index: 'url', width: 80 }, 			
			{ label: '功能图标', name: 'icon', index: 'icon', width: 80 }, 			
			{ label: '自定义属性', name: 'attributes', index: 'attributes', width: 80 }, 			
			{ label: '权限代码', name: 'actions', index: 'actions', width: 80 }, 			
			{ label: '所属平台', name: 'platform', index: 'platform', width: 80 }, 			
			{ label: '创建日期', name: 'createtime', index: 'createTime', width: 80 }, 			
			{ label: '创建人', name: 'creatorid', index: 'creatorId', width: 80 }, 			
			{ label: '状态(1:可用，0：禁用)', name: 'state', index: 'state', width: 80 }, 			
			{ label: '0：菜单；1：按钮；2：目录', name: 'menutype', index: 'menutype', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "list",
            page: "currPage",
            total: "totalPage",
            records: "totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		sysMenu: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sysMenu = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.sysMenu.id == null ? "addMenu" : "updatemenu";
			console.log("省"+JSON.stringify(vm.sysMenu));
			$.post(url,{strJsong:JSON.stringify(vm.sysMenu)},function (data) {
				if(data.code==200){
					alert("成功");
					parent.location.href='getmenulist';
				}else {
					alert("失败")
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.post("delMenu?id="+ids,
					function (data) {
						if(data.code==200){
							parent.location.href='getmenulist';
						}else {
							alert(data.msg);

						}
					},"json");
			});
		},
		getInfo: function(id){
			$.get("getmenubyid?id="+id, function(r){
                vm.sysMenu = r;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});