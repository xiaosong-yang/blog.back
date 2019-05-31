<!-- Essential javascripts for application to work-->
<script src="${Application.projectName}/javascripts/jquery-3.2.1.min.js"></script>
<script src="${Application.projectName}/javascripts/vue.min.js"></script>
<script src="${Application.projectName}/javascripts/popper.min.js"></script>
<script src="${Application.projectName}/javascripts/bootstrap.min.js"></script>
<script src="${Application.projectName}/javascripts/main.js"></script>
<script src="${Application.projectName}/layui/layui.js"></script>
<script src="${Application.projectName}/javascripts/common.js"></script>
<script src="${Application.projectName}/javascripts/wangEditor.min.js"></script>
<!-- The javascript plugin to display page loading on top-->
<script src="${Application.projectName}/javascripts/plugins/pace.min.js"></script>
<!-- Page specific javascripts-->
<script type="text/javascript" src="${Application.projectName}/javascripts/plugins/chart.js"></script>
<script type="text/javascript" src="${Application.projectName}/javascripts/plugins/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="${Application.projectName}/javascripts/plugins/select2.min.js"></script>
<script type="text/javascript" src="${Application.projectName}/javascripts/plugins/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">
    var data = {
        labels: ["January", "February", "March", "April", "May"],
        datasets: [
            {
                label: "My First dataset",
                fillColor: "rgba(220,220,220,0.2)",
                strokeColor: "rgba(220,220,220,1)",
                pointColor: "rgba(220,220,220,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(220,220,220,1)",
                data: [65, 59, 80, 81, 56]
            },
            {
                label: "My Second dataset",
                fillColor: "rgba(151,187,205,0.2)",
                strokeColor: "rgba(151,187,205,1)",
                pointColor: "rgba(151,187,205,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(151,187,205,1)",
                data: [28, 48, 40, 19, 86]
            }
        ]
    };
    var pdata = [
        {
            value: 300,
            color: "#46BFBD",
            highlight: "#5AD3D1",
            label: "Complete"
        },
        {
            value: 50,
            color:"#F7464A",
            highlight: "#FF5A5E",
            label: "In-Progress"
        }
    ]
</script>
<!-- Google analytics script-->
<script type="text/javascript">
    if(document.location.hostname == 'pratikborsadiya.in') {
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
            (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
            m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
        })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
        ga('create', 'UA-72504830-1', 'auto');
        ga('send', 'pageview');
    }
</script>
<script>
    function show_big_pic(url) {
        top.layui.use('layer', function() {
            var layer = layui.layer;
            layer.msg('<img src="' + url + '" width="80%;"></img>');
        });
    }
</script>
<script>
    if(f_menu!="" && s_menu==""){
        $("#"+f_menu).addClass("app-menu__item active");
    }else if(f_menu!="" && s_menu!=""){
        $("#"+f_menu).addClass("treeview is-expanded");
        $("#"+s_menu).addClass("treeview-item active");
    }

</script>