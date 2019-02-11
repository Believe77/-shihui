/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2018-12-20 09:57:50
 * @version $Id$
 */
$(function() {
    //上父页面获取章节和内容
    var a = JSON.parse(window.localStorage.novel_title);
    console.log(a);
    
    console.log(window.location.search)
    var url = window.location.search
    if (url.indexOf("?") != -1) {
        var str = url.substr(1)
        console.log(str);
        console.log(str.split('=')[1]);
        var index = str.split('=')[1];
        window.localStorage.novel_index = JSON.stringify(index);
    }
    //从父页面点击进来时显示章节和内容和之后的滑动
    //返回按钮
    var back_tap = function() {
        $('div#read_bar div.read_box b img').tap(function() {
           // var novel_detail = JSON.parse(window.localStorage.novel_detail);
           window.location.href="book.html";
        });
    }
    var chapter_load = function(){
        $('div#read_bar div.read_box span').eq(0).text(index);
        $('div#read_bar div.read_box span').eq(1).text(a.title);
    }
    chapter_load();

    var chapter_tap = function() {
    	//var b = JSON.parse(window.localStorage.novel);
        var novel_alltitle = JSON.parse(window.localStorage.novel_alltitle);
        // $('div.read_content_bar div.chapter_updown ul.chapter_updown_box li').eq(0).tap(function() 
        $('div.read_nav span').eq(2).tap(function(){
        	index--;
        	if(index==0){
                index=1;
        		console.log('已经是第一章了')
        	}else{
            window.localStorage.novel_title = JSON.stringify(novel_alltitle[index-1]);
            window.localStorage.novel_index = JSON.stringify(index);
            window.location.href="read.html?b="+index;
        }
        });

        // $('div.read_content_bar div.chapter_updown ul.chapter_updown_box li').eq(1).tap(function() 
        $('div.read_nav span').eq(3).tap(function() {
        	index++;
        	if(index>novel_alltitle.length){
                index=novel_alltitle.length;
        		console.log('已经是最后一章了')
        	}else{
            window.localStorage.novel_title = JSON.stringify(novel_alltitle[index-1]);
            window.localStorage.novel_index = JSON.stringify(index);
            window.location.href="read.html?b="+index;
        }
        });
    }
    var nav_tap = function() {
        var flag = 0;
        $('div#read_bar div.read_box img').eq(1).tap(function() {
            if (flag == 0) {
                $('div#read_bar div.read_nav').show();
                flag = 1;
            } else if (flag == 1) {
                $('div#read_bar div.read_nav').hide();
                $('div#read_bar div.chapter_nav').hide();
                flag = 0;
            }
        });
        $('div#read_bar div.read_nav span').eq(1).tap(function() {
            if (window.localStorage.user_id) {
                window.location.href = "comment.html";
            } else {
               console.log('未登录');
            }
        });
        $('div#read_bar div.read_nav span').eq(2).tap(function() {
            //window.location.href = "download.html";
        });
    }
    var chapte_nav_tap = function() {
        var flag = 0;
        $('div#read_bar div.read_nav span').eq(0).tap(function() {
            if (flag == 0) {
                $('div#read_bar div.chapter_nav').show();
                flag = 1;
            } else if (flag == 1) {
                $('div#read_bar div.chapter_nav').hide();
                flag = 0;
            }
        });
    }
     var chapter_num = function(data) {
        $('div#read_bar div.read_content_bar div.read_title span').text(data[0].title);
        $('div#read_bar div.read_content_bar div.read_content text').text(data[0].content);
    }
    var chapter_content_aj = function(a) {
        $.ajax({
            type: 'GET',
            url: 'http://47.112.20.73/web-novel/message/get_content.action',
            // post payload:
            dataType: 'json',
            data: {
                'title':a.title
            },
            success: function(data) {
                console.log('内容交互成功');
                //console.log(data);
                chapter_num(data);

            },
            error: function(xhr, type) {
                console.log(2);
                console.log(xhr);
                console.log(1);
                console.log(type);
            }
        });
    }
    chapter_content_aj(a);
    back_tap();
    nav_tap();
    chapte_nav_tap();
    chapter_tap();
        var chapter_box = function(){
            var novel_alltitle = JSON.parse(window.localStorage.novel_alltitle);
            for(var i=0;i<novel_alltitle.length;i++){
            $('div.chapter_nav ul').append('<li>'+
                        '第<span>一</span>章'+
                        '&nbsp;&nbsp;&nbsp;'+
                        '<p>斗罗大陆初章</p>'+
                    '</li>');
            $('div.chapter_nav ul li').eq(i).children('span').eq(0).text(i+1);
            $('div.chapter_nav ul li').eq(i).children('p').text(novel_alltitle[i].title);
        }
    }
    chapter_box();
    var chapter_select =function(){
        var novel_alltitle = JSON.parse(window.localStorage.novel_alltitle);
        for(var i=0;i<novel_alltitle.length;i++){
            $('div.chapter_nav ul li').eq(i).tap(function(){
            index=($(this).index()+1);
            window.localStorage.novel_title = JSON.stringify(novel_alltitle[index-1]);
            window.localStorage.novel_index = JSON.stringify(index);
            window.location.href="read.html?b="+index;
            })
        }
    }
    chapter_select();
})