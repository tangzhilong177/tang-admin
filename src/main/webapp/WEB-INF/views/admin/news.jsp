<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp"%>
<script type="text/javascript">
	var urlSwitchDataGrid;
	$(function() {
		urlSwitchDataGrid = $('#newsDataGrid')
				.datagrid(
						{
							url : '${path }/news/dataGrid',
							striped : true,
							rownumbers : true,
							pagination : true,
							singleSelect : true,
							idField : 'id',
							sortName : 'id',
							sortOrder : 'id',
							pageSize : 20,
							pageList : [ 10, 20, 30, 40, 50, 100, 200, 300,
									400, 500 ],
							frozenColumns : [ [
									{
										width : '100',
										title : 'id',
										field : 'id',
										sortable : true
									},
									{
										width : '80',
										title : '标题',
										field : 'title',
										sortable : true
									},
									{
										width : '80',
										title : 'LOGO',
										field : 'logo',
										sortable : true
									},
									{
										width : '300',
										title : '内容',
										field : 'content',
										sortable : true
									},
									{
										width : '200',
										title : '路径',
										field : 'url'
									},
									{
										field : 'action',
										title : '操作',
										width : 200,
										formatter : function(value, row, index) {
											var str = '';
											str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
											str += $
													.formatString(
															'<a href="javascript:void(0)" class="role-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'fi-pencil icon-blue\'" onclick="editNewsFun(\'{0}\');" >编辑</a>',
															row.id);
											str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
											str += $
													.formatString(
															'<a href="javascript:void(0)" class="role-easyui-linkbutton-del" data-options="plain:true,iconCls:\'fi-x icon-red\'" onclick="deleteNewsFun(\'{0}\');" >删除</a>',
															row.id);
											return str;
										}
									} ] ],
							onLoadSuccess : function(data) {
								$('.role-easyui-linkbutton-edit').linkbutton({
									text : '编辑'
								});
								$('.role-easyui-linkbutton-del').linkbutton({
									text : '删除'
								});
							},
							toolbar : '#newsToolbar'
						});
	});

	function addNewsFun() {
		parent.$.modalDialog({
			title : '添加',
			width : 500,
			height : 300,
			href : '${path }/news/addPage',
			buttons : [ {
				text : '确定',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = urlSwitchDataGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#newsAddForm');
					f.submit();
				}
			} ]
		});
	}

	function editNewsFun(id) {
		if (id == undefined) {
			var rows = urlSwitchDataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {
			urlSwitchDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.modalDialog({
			title : '编辑',
			width : 500,
			height : 300,
			href : '${path }/news/editPage?id=' + id,
			buttons : [ {
				text : '确定',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = urlSwitchDataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#newsEditForm');
					f.submit();
				}
			} ]
		});
	}

	function deleteNewsFun(id) {
		if (id == undefined) {//点击右键菜单才会触发这个
			var rows = urlSwitchDataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {//点击操作里面的删除图标会触发这个
			urlSwitchDataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.messager.confirm('询问', '您是否要删除当前Url？', function(b) {
			if (b) {
				progressLoad();
				$.post('${path }/news/delete', {
					id : id
				}, function(result) {
					if (result.success) {
						parent.$.messager.alert('提示', result.msg, 'info');
						urlSwitchDataGrid.datagrid('reload');
					}
					progressClose();
				}, 'JSON');
			}
		});
	}
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',fit:true,border:false">
		<table id="newsDataGrid" data-options="fit:true,border:false"></table>
	</div>
</div>
<div id="newsToolbar" style="display: none;">
	<a onclick="addNewsFun();" href="javascript:void(0);"
		class="easyui-linkbutton"
		data-options="plain:true,iconCls:'fi-plus icon-green'">添加</a>
</div>