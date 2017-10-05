$(function () {
    var json = {
        status: 1,
        data:  [{
            videoname:"1",
            pagetime: "2",
            time: "3",
            from:"4"
        },
            {
                videoname:"1",
                pagetime: "2",
                time: "3",
                from:"4"
            }
        ]
    };
    function getData(){
        for(var i = 0;i<=4;i++){
            $.ajax({
                url:'http://127.0.0.1:8080/webname?',
                type:'post',
                dataType:'json',
                data:{
                    webname: i
                },
                success:function(res){
                    var $tabContent = $(".tabContent").eq(i);
                    demo($tabContent, res);
                },
                error:function(){
                    console.log(i)
                }
            })
        }
    }
    getData()
    var $wrap = $("#qq_video");
    var $wrap2 = $("#youku_video");
    var $wrap3 = $("#cctv_video");
    var $wrap4 = $("#aqy_video");
    var $wrap5 = $("#ls_video");
    console.log(1);
    var x;
    function demo(dom,res) {
        for( x in res.data){
            var a = $("<tr></tr><td>"+res.data[x].videoname+"</td>"
                +"<td>"+res.data[x].pagetime+"</td>"
                +"<td>"+res.data[x].time+"</td>"
                +"<td>"+res.data[x].from+"</td></tr>"
            );
            dom.append(a)
        }
    }
    demo($wrap, json);
    demo($wrap2, json);
    demo($wrap3, json);
    demo($wrap4, json);
    demo($wrap5, json);
    console.log(1);
    var $title = $(".title");
    var $mod = $(".mod");
    $(document).on('click',".title",function () {
        var index=$title.index($(this));
        console.log(index);
        $mod.hide();
        $mod.eq(index).show();
        })
});
