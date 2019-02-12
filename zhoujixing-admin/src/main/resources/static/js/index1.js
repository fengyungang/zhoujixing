
$(function() {
    $(window).on('resize', function () {
        var $content = $('#larry-tab .layui-tab-content');
        $content.height($(this).height() - 140);
        $content.find('iframe').each(function () {
            $(this).height($content.height());
        });
    }).resize();
})

//生成菜单
var menuItem = Vue.extend({
    name: 'menu-item',
    props: {item: {}},
    template: [
        '<li class="layui-nav-item" >',
        '<a v-if="item.menutype === 2" href="javascript:;">',

        '<span>{{item.menuname}}</span>',
        '<em class="layui-nav-more"></em>',
        '</a>',
        '<dl v-if="item.menutype === 2" class="layui-nav-child">',
        '<dd v-for="item in item.list" >',
        '<a v-if="item.menutype === 0" href="javascript:;" :data-url="item.url"><i v-if="item.icon != null" :class="item.icon" :data-icon="item.icon"></i> <span>{{item.menuname}}</span></a>',
        '</dd>',
        '</dl>',
        '<a v-if="item.menutype === 0" href="javascript:;" :data-url="item.url"><i v-if="item.icon != null" :class="item.icon" :data-icon="item.icon"></i> <span>{{item.menuname}}</span></a>',
        '</li>'
    ].join('')
});

//注册菜单组件
Vue.component('menuItem', menuItem);
isquery=true;
var vm = new Vue({
    el: '#layui_layout',
    data: {
        user: {},
        menuList: {},
        password: '',
        newPassword: '',
        navTitle: "首页"
    },
    methods: {
        getMenuList: function () {
            $.getJSON("geUserMenuList", function (r) {
                vm.menuList = r;
            });
        },
        getUser: function () {
            $.getJSON("info?_" + $.now(), function (r) {
                vm.user = r;
            });
        },
        updatePassword: function () {
            layer.open({
                type: 1,
                skin: 'layui-layer-molv',
                title: "修改密码",
                area: ['550px', '270px'],
                shadeClose: false,
                content: jQuery("#passwordLayer"),
                btn: ['修改', '取消'],
                btn1: function (index) {
                    var data = "password=" + vm.password + "&newPassword=" + vm.newPassword;
                    $.ajax({
                        type: "POST",
                        url: "password",
                        data: data,
                        dataType: "json",
                        success: function (result) {
                            if (result == 1) {
                                layer.close(index);
                                layer.alert('修改成功', function (index) {
                                    location.reload();
                                });
                            } else {
                                layer.alert(result);
                            }
                        }
                    });
                }
            });
        },
        donate: function () {
            layer.open({
                type: 2,
                title: false,
                area: ['806px', '467px'],
                closeBtn: 1,
                shadeClose: false,
                content: ['http://cdn.com.framework/donate.jpg', 'no']
            });
        }
    },
    created: function () {
        this.getMenuList();
        this.getUser();
    },updated:function(){

        if($("#larry-side .layui-nav-item>a").length==0 || !isquery){
            return;
        }
        console.log("执行")
        isquery=false;
        layui.config({
            base: 'static/js/',
        }).use(['navtab','layer'], function(){
            window.jQuery = window.$ = layui.jquery;
            window.layer = layui.layer;
            var element = layui.element();
            var  navtab = layui.navtab({
                elem: '.larry-tab-box',
                closed:false
            });
            $('#larry-nav-side').children('ul').find('li').each(function () {
                var $this = $(this);
                if ($this.find('dl').length > 0) {

                    var $dd = $this.find('dd').each(function () {
                        $(this).on('click', function () {
                            var $a = $(this).children('a');
                            var href = $a.data('url');
                            var icon = $a.children('i:first').data('icon');
                            var title = $a.children('span').text();
                            var data = {
                                href: href,
                                icon: icon,
                                title: title
                            }
                            navtab.tabAdd(data);
                        });
                    });
                } else {

                    $this.on('click', function () {
                        var $a = $(this).children('a');
                        var href = $a.data('url');
                        var icon = $a.children('i:first').data('icon');
                        var title = $a.children('span').text();
                        var data = {
                            href: href,
                            icon: icon,
                            title: title
                        }
                        navtab.tabAdd(data);
                    });
                }
            });
            $('.larry-side-menu').click(function () {
                var sideWidth = $('#larry-side').width();
                if (sideWidth === 200) {
                    $('#larry-body').animate({
                        left: '0'
                    });
                    $('#larry-footer').animate({
                        left: '0'
                    });
                    $('#larry-side').animate({
                        width: '0'
                    });
                } else {
                    $('#larry-body').animate({
                        left: '200px'
                    });
                    $('#larry-footer').animate({
                        left: '200px'
                    });
                    $('#larry-side').animate({
                        width: '200px'
                    });
                }
            });

        });
    }
});