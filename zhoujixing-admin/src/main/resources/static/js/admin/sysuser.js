$(function () {
	$("#jqGrid").jqGrid({
		url: 'getUserList',
		datatype: "json",
		colModel: [
			{ label: '编号', name: 'id', index: 'id', width: 50, key: true },
			{ label: '角色', name: 'roleid', index: 'roleId', width: 80 ,formatter:function (cellvalue, options, rowObject) {
					return $("#"+cellvalue).val();
				}},
			{ label: '用户账号', name: 'loginname', index: 'loginName', width: 80 },
			{ label: '真实姓名', name: 'realname', index: 'realName', width: 80 },
			{ label: '创建时间', name: 'createtime', index: 'createTime', width: 80 },
			{ label: '性别', name: 'sex', index: 'sex', width: 80 , formatter:function (cellvalue, options, rowObject) {
					if (cellvalue==0){
						return "女"
					}
					if (cellvalue==1){
						return "男"
					}
					if (cellvalue==2){
						return "保密"
					}
				}},
			{ label: '所属省份', name: 'province', index: 'province', width: 80 ,formatter: function (cellvalue, options, rowObject) {
					console.log($("#"+cellvalue).val());
					return $("#"+cellvalue).val();
			}},
			{ label: '所属城市', name: 'city', index: 'city', width: 80 ,formatter: function (cellvalue, options, rowObject) {
					console.log($("#"+cellvalue).val());
					return $("#"+cellvalue).val();
				}},
			{ label: '所属区县', name: 'area', index: 'area', width: 80 ,formatter: function (cellvalue, options, rowObject) {
					console.log($("#"+cellvalue).val());
					return $("#"+cellvalue).val();
				}},
			{ label: '所属企业', name: 'companyid', index: 'companyId', width: 80 },
			{ label: '电子邮箱', name: 'email', index: 'email', width: 80 },
			{ label: '登录次数', name: 'logincount', index: 'loginCount', width: 80 },
			{ label: '最后登录IP', name: 'lastloginip', index: 'lastLoginIp', width: 80 },
			{ label: '最后登录时间', name: 'lastlogintime', index: 'lastlogintime', width: 80  ,formatter:"date"},
			{ label: '最后登录地址', name: 'lastloginaddr', index: 'lastLoginAddr', width: 80 },
			{ label: '备注', name: 'remark', index: 'remark', width: 80 },
			{ label: '用户状态（0：不可用；1：可用；2：已禁用；-1：已删除）', name: 'state', index: 'state', width: 80,formatter: function (cellvalue, options, rowObject) {
					if (cellvalue ==0){
						return"不可用";
					}
					if (cellvalue ==1){
						return"正常";
					}
					if (cellvalue ==2){
						return"禁用";
					}
					if (cellvalue == -1){
						return"已删除";
					}
				}}
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
		sysUser: {}
	},
	created:function(){
		_this=this;
		$.post("getRoleList",
			function (data) {
				for (var i =0; i<data.length;i++){
					$("#roled").append("<option value='"+data[i].id+"'>"+data[i].name+"</option>")
				}
				//console.log(data);
			},"json");
		$.post("getCity",function (data) {
			for (var i=0;i<data.length;i++){
				$("#sheng").append("<option value='"+data[i].id+"'>"+data[i].name+"</option>")
			}
			//console.log("省"+data);
		});
	},
	methods: {
		city:function(){
			var parentId=$("#sheng").val();
			$.post("getcityentity",{parentId:parentId},function (data) {
				$("#city").empty();
				$("#city").append("<option>请选择</option>");
				for (var i=0;i<data.length;i++){
					$("#city").append("<option value='"+data[i].id+"'>"+data[i].name+"</option>")
				}
			});
		},
		district:function(){
			var parentId=$("#city").val();
			$.post("getcityentity",{parentId:parentId},function (data) {
				$("#xian").empty();
				for (var i=0;i<data.length;i++){
					$("#xian").append("<option value='"+data[i].id+"'>"+data[i].name+"</option>")
				}
			});
		},
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sysUser = {};
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
			var url = vm.sysUser.id == null ? "addUser" : "userupdate";
			//console.log("省"+JSON.stringify(vm.sysUser));
			$.post(url,{user:JSON.stringify(vm.sysUser)},function (data) {
				if(data.code==200){
					alert("成功");
					parent.location.href='sysuser';
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
				$.post("deleUser?userid="+ids,
					function (data) {
					if(data.code==200){
						parent.location.href='sysuser';
					}else {
						alert(data.msg);

					}
				},"json");
			});
		},
		getInfo: function(id){
			$.get( "getbyId?id="+id, function(r){
				vm.sysUser = r;
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