/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2018-12-17 20:40:59
 * @version $Id$
 */
$(function() {
    var a = JSON.parse(window.localStorage.novel_detail);
    //console.log(a);
    console.log(window.location.search)
    var url = window.location.search
    if (url.indexOf("?") != -1) {
        var str = url.substr(1)
        strs = str.split("&&");
        //console.log(strs);
        //console.log(strs[1].split('=')[1]);
        var index = strs[1].split('=')[1];
    }
    var nav_tap = function(){
        for(var i = 0;i<3;i++){
        $('div#book_nav ul.book_nav_box li').eq(i).tap(function(){
            $('div#book_nav ul.book_nav_box li').removeClass('active')
            $(this).addClass('active');
            //console.log(this.index);
            if($(this).index()==1){
                //window.location.href='download.html';
            }
            if($(this).index()==2){
                if(window.localStorage.user_id){
                var user_id = JSON.parse(window.localStorage.user_id);
                bookshelf_aj(a,user_id);
               // window.location.href='bookshelf.html';
                }else{
                 console.log("未登录");
                }
            }

        })
    }
    }
    nav_tap();
    var novel_content_set = function() {
        //console.log(a.bid)
        $('div.back_bar span').text(a.name)
        $('div#book_bar img').attr('src',a.path)
        $('div#book_bar div.book_detail p').eq(0).text(a.name)
        $('div#book_bar div.book_detail p').eq(1).text(a.author)
        $('div#book_bar div.book_detail p').eq(2).text(a.type)
        // $('div#book_bar div.book_detail span').eq(0).text(a.countNumber)
        $('div#book_bar div.book_detail span').eq(0).text(a.style)
    }
    novel_content_set();

    var novel_chater = function(data) {
        $('div#chapter_bar').append('<div class="chapter_top">' +
            '共<span>1187</span>章' +
            '<p>正序</p>' +
            '</div>' +
            '<div class="chapter_box">' +
            '<ul></ul>' +
            '</div>'
        )
        for (var i = 0; i < data.length; i++) {
            $('div#chapter_bar div.chapter_box ul').append('<li>' +
                '第<span>一</span>章&nbsp;&nbsp;&nbsp;<p>斗罗大陆初章</p>' +
                '</li>')
        }
    }
    var novel_chater_set = function(data) {
        $('div#chapter_bar div.chapter_top span').text(data.length + 1)
        for (var i = 0; i < data.length; i++) {
            $('div#chapter_bar div.chapter_box ul li').eq(i).children('span').text(i + 1)
            $('div#chapter_bar div.chapter_box ul li').eq(i).children('p').text(data[i].title)
        }
    }
    var novel_chater_tap = function(data) {
        for (var i = 0; i < data.length; i++) {
            $('div#chapter_bar div.chapter_box ul li').eq(i).tap(function() {
                var b = $(this).index();
                window.localStorage.novel_content = JSON.stringify(data[b])
                window.location.href = 'read.html?b='+(b+1);
                window.localStorage.novel_title = JSON.stringify(data[b]);
                 window.localStorage.novel_alltitle = JSON.stringify(data);
            })
        }
    }
    var novel_chater_aj = function(a) {
        $.ajax({
            type: 'GET',
            url: 'http://47.112.20.73/web-novel/message/get_title.action',
            // post payload:
            dataType: 'json',
            data: {
                'bid': a.bid
            },
            // contentType: 'application/json;charset=uft-8',
            success: function(data) {
                //console.log(data);
                novel_chater(data);
                novel_chater_set(data)
                novel_chater_tap(data)
            },
            error: function(xhr, type) {
                console.log(2);
                console.log(xhr);
                console.log(1);
                console.log(type);
            }
        });
    }
    var bookshelf_aj = function(a,user_id) {
        $.ajax({
            type: 'GET',
            url: 'http://47.112.20.73/web-novel/message/save.action',
            // post payload:
            dataType: 'json',
            data: {
                'bid':a.bid,
                'id':user_id
            },
            // contentType: 'application/json;charset=uft-8',
            success: function(data) {
                //console.log('书架交互成功');
                //console.log(data);
                novel_chater(data);
                novel_chater_set(data)
                novel_chater_tap(data)
            },
            error: function(xhr, type) {
                console.log(2);
                console.log(xhr);
                console.log(1);
                console.log(type);
            }
        });
    }
     var back_tap = function() {
        $('div.back_bar img').tap(function() {
            var novel_detail2 = JSON.parse(window.localStorage.novel_detail2);
            if(novel_detail2=='首页'){
            window.location.href='index.html'
            }
            if(novel_detail2=='排行榜'){
            window.location.href='ranking_list.html'
            }
            if(novel_detail2=='分类'){
            window.location.href='sort.html'
            }
            if(novel_detail2=='书架'){
            window.location.href='bookshelf.html'
            }
            if(novel_detail2=='搜索'){
            window.location.href='search.html'
            }
        });
    }
       var count_aj = function(a) {
        $.ajax({
            type: 'POST',
            url: 'http://47.112.20.73/web-novel/message/count.action',
            // post payload:
            dataType: 'json',
            data: {
                'bid':a.bid
                 },
            // contentType: 'application/json;charset=uft-8',
            success: function(data) {
                //console.log('阅读量交互成功');
                //var aj_img_json = $.parseJSON(data);
                console.log(a.bid);
                //console.log(data);
            },
            error: function(xhr, type) {
                console.log(2);
                console.log(xhr);
                console.log(1);
                console.log(type);
            }
        });
    }
    back_tap();
    novel_chater_aj(a);
    count_aj(a);
    //下载
});