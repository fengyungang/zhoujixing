$(function () {
    $('#dd').dialog({
        title: '登录框',
        width: 'auto',
        height: 'auto',
        closed: false,
        cache: false,
        modal: true,
        buttons: [{
            text:'登录',
            iconCls:'icon-ok',
            handler:function(){
                document.getElementById("myform").submit();
            }
        },{
            text:'取消',
            handler:function(){
                alert('cancel');;
            }
        }]
    });
});