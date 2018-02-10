<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<script type="text/javascript">
    $(function() {
        $('#newsEditForm').form({
            url : '${path }/news/edit',
            onSubmit : function() {
                progressLoad();
                var isValid = $(this).form('validate');
                if (!isValid) {
                    progressClose();
                }
                return isValid;
            },
            success : function(result) {
                progressClose();
                result = $.parseJSON(result);
                if (result.success) {
                    parent.$.modalDialog.openner_dataGrid.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_dataGrid这个对象，是因为user.jsp页面预定义好了
                    parent.$.modalDialog.handler.dialog('close');
                } else {
                    parent.$.messager.alert('错误', result.msg, 'error');
                }
            }
        });
    });
</script>
<div class="easyui-layout" data-options="fit:true,border:false" >
    <div data-options="region:'center',border:false" style="overflow: hidden;padding: 3px;" >
        <form id="newsEditForm" method="post">
            <table class="grid">
                <tr>
                    <td>标题</td>
                    <input name="id" type="hidden" value="${news.id }"/>
                    <td><input name="title" type="text" placeholder="标题" class="easyui-validatebox span2" data-options="required:true" value="${news.title }"></td>
                </tr>
                <tr>
                    <td>LOGO</td>
                    <td><input name="logo" type="text" placeholder="LOGO" class="easyui-validatebox span2" data-options="required:true" value="${news.logo }"></td>
                </tr>
                <tr>
                    <td>Url</td>
                    <td><input name="url" type="text" placeholder="请输Url" class="easyui-validatebox span2" data-options="required:true" value="${news.url }"></td>
                </tr>
                 <tr>
                    <td>简介内容</td>
                    <td colspan="10"><textarea name="content">${news.content }</textarea></td>
                </tr>
            </table>
        </form>
    </div>
</div>