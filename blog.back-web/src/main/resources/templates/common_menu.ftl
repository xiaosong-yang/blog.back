<!-- Navbar-->
<header class="app-header"><a class="app-header__logo" href="index.html">xiao_Y Back System</a>
    <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                    aria-label="Hide Sidebar"></a>
    <!-- Navbar Right Menu-->
    <ul class="app-nav">
        <form action="${Application.projectName}/logout" method="post">
            <button class="app-search__button btn btn-primary" style="margin-right:20px;color:white;" type="submit">登出
            </button>
        </form>

    </ul>
</header>
<!-- Sidebar menu-->
<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
<aside class="app-sidebar">
    <div class="app-sidebar__user"><img class="app-sidebar__user-avatar"
                                        src="${Application.projectName}/images/header_img_boy.jpg"
                                        style="width: 30px;height: 30px;" alt="User Image">
        <div>
            <p class="app-sidebar__user-name">Welcome</p>
            <p class="app-sidebar__user-designation"></p>
        </div>
    </div>
    <ul class="app-menu">
        <#--<#if Session.baseInfo.auth == '0' || Session.baseInfo.auth == '1'>-->
        <#--<@janusAuthCheck authRoles="Super_Auth">-->
            <#--<li><a class="app-menu__item" id="f_menu1" href="${Application.projectName}/showList"><i-->
                <#--class="app-menu__icon fa fa-dashboard"></i><span class="app-menu__label">列表查看</span></a></li>-->
        <#--</@janusAuthCheck>-->
        <#--</#if>-->

        <#--<@janusAuthCheck authRoles="Super_Auth">-->
            <#--<li class="treeview" id="f_menu2"><a class="app-menu__item" href="#" data-toggle="treeview"><i-->
                    <#--class="app-menu__icon fa fa-laptop"></i><span class="app-menu__label">编辑</span><i-->
                    <#--class="treeview-indicator fa fa-angle-right"></i></a>-->
            <#--<ul class="treeview-menu">-->
            <#--<li><a class="treeview-item" id="s_menu2" href="${Application.projectName}/edit"><i-->
                        <#--class="icon fa fa-circle-o"></i>少量编辑</a></li>-->
            <#--<li><a class="treeview-item" id="s_menu3" href="${Application.projectName}/edit2"  rel="noopener"><i-->
                <#--class="icon fa fa-circle-o"></i>大量编辑</a></li>-->
            <#--</ul>-->
            <#--</li>-->
        <#--</@janusAuthCheck>-->

        <@janusAuthCheck authRoles="Super_Auth">
            <li class="treeview" id="f_menu3"><a class="app-menu__item" href="#" data-toggle="treeview"><i
                    class="app-menu__icon fa fa-laptop"></i><span class="app-menu__label">技术分享</span><i
                    class="treeview-indicator fa fa-angle-right"></i></a>
            <ul class="treeview-menu">
            <li><a class="treeview-item" id="s_menu1_f3" href="${Application.projectName}/technical/edit"><i
                class="icon fa fa-circle-o"></i>技术分享新增</a></li>
            <li><a class="treeview-item" id="s_menu2_f3" href="${Application.projectName}/technical/technicalList"><i
                class="icon fa fa-circle-o"></i>技术分享管理</a></li>
            </ul>
            </li>
        </@janusAuthCheck>

    </ul>
</aside>