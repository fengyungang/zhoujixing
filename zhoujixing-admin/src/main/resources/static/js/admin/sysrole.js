$(function () {
    $("#jqGrid").jqGrid({
        url:'getRoleGridList',
        datatype: "json",
        colModel: [			
			{ label: '编号', name: 'id', index: 'id', width: 50, key: true },
			{ label: '角色名称', name: 'name', index: 'name', width: 80 }, 			
			{ label: '角色描述', name: 'discription', index: 'discription', width: 80 }, 			
			{ label: '角色状态', name: 'state', index: 'state', width: 80 ,formatter: function (cellvalue, options, rowObject) {
				if (cellvalue==0){
					return "无效";
				}else {
					return "有效";
				}
			}},
			{ label: '是否超级管理员', name: 'rootflag', index: 'rootFlag', width: 80 }, 			
			{ label: '创建人ID', name: 'creatorid', index: 'creatorId', width: 80 }, 			
			{ label: '创建时间', name: 'createtime', index: 'createTime', width: 80  ,formatter:"date"},
			{ label: '角色权限', name: 'options', index: 'options', width: 80 ,hidden:true},
			{ label: '所属站点', name: 'fromsite', index: 'fromSite', width: 80 }, 			
			{ label: '所属平台', name: 'platform', index: 'platform', width: 80 }			
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
		sysRole: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sysRole = {};
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
			var url = vm.sysRole.id == null ? "addRole" : "updaterole";
			$.post(url,{strjson:JSON.stringify(vm.sysRole)},function (data) {
				if(data.code==200){
					alert("成功");
					parent.location.href='getRoleGrid';
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
				$.post("delRole?id="+ids,
					function (data) {
						if(data.code==200){
							parent.location.href='getRoleGrid';
						}else {
							alert(data.msg);

						}
					},"json");
			});
		},
		getInfo: function(id){
			$.get("getbyid?id="+id, function(r){
                vm.sysRole = r;
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