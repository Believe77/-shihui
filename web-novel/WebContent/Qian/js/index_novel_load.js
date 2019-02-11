/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2018-12-08 16:24:39
 * @version $Id$
 */
$(function() {
    var novel_li = $('div.series_bar div.novel_bar ul li');
    var index_tap = function() {
        $('div.top_bar div.top_right img').tap(function() {
            if (window.localStorage.user_id) {
                window.location.href = "user.html"
            } else {
                window.location.href = "login.html";
            }
        });
        $('div.search_bar div.search_box').tap(function() {
            window.location.href = "search.html"
        });
        $('div.nav_bar ul.nav_box li').eq(0).tap(function() {
            window.location.href = "ranking_list.html"
        });
        $('div.nav_bar ul.nav_box li').eq(1).tap(function() {
            window.location.href = "new.html"
        });
        $('div.nav_bar ul.nav_box li').eq(2).tap(function() {
            window.location.href = "sort.html"
        });
        $('div.nav_bar ul.nav_box li').eq(3).tap(function() {
            if (window.localStorage.user_id) {
                window.location.href = "bookshelf.html"
            } else {
               console.log('未登录');
            }

        });
    }
    index_tap();

    var nove_load = function(data, i) {
        $('div.series_bar').append('<div class="novel_bar">' +
            '<div class="novel_nav">'+
            '<span>|</span>&nbsp;&nbsp;<b></b>'+
            // '<a class="more" name="more_tap">更多&gt;&gt;</a>'+
            '</div>' +
            '<ul class="novel_box clearfix"></ul>' +
            '</div>');
        
        for (var j = 0; j < data.length; j++) {
            $('div.series_bar div.novel_bar ul.novel_box').eq(i).append(
                '<li>' +
                '<img src="images/cover/u=2132211606,2010640083&fm=58&bpow=580&bpoh=861.jpg" alt="">' +
                '<div class="book_name"></div>' +
                '<b class="abstract"></b>' +
                '<p class="author"></p>' +
                '<em class="tag_small yellow"></em>' +
                '<em class="tag_small red"></em>' +
                // '<em class="tag_small blue"></em>' +
                '</li>')
        }

    }

    var nove_load_set = function(data, i, b) {
        $('div.series_bar div.novel_bar div.novel_nav b').eq(i).html(b)
        //console.log($('div.series_bar div.novel_bar div.novel_nav b').eq(i).text())
        var li_index = $('div.series_bar div.novel_bar ul.novel_box').eq(i).children();
        for (var k = 0; k < li_index.length; k++) {
            var a = data[k].path
            $('div.series_bar div.novel_bar ul.novel_box').eq(i).children('li').eq(k).children('img').attr('src', a)
            $('div.series_bar div.novel_bar ul.novel_box').eq(i).children('li').eq(k).children('div.book_name').text(data[k].name)
            $('div.series_bar div.novel_bar ul.novel_box').eq(i).children('li').eq(k).children('b').text(data[k].message)
            $('div.series_bar div.novel_bar ul.novel_box').eq(i).children('li').eq(k).children('p').text(data[k].author)
            $('div.series_bar div.novel_bar ul.novel_box').eq(i).children('li').eq(k).children('em').eq(0).text(data[k].type)
            $('div.series_bar div.novel_bar ul.novel_box').eq(i).children('li').eq(k).children('em').eq(1).text(data[k].style)
            // $('div.series_bar div.novel_bar ul.novel_box').eq(i).children('li').eq(k).children('em').eq(2).text(data[k].countNumber)
        }
    }
    var novel_tap = function(i, data) {
        for (var j = 0; j < data.length; j++) {
            $('div.series_bar div.novel_bar ul.novel_box').eq(i).children('li').eq(j).tap(function() {
                var b = $(this).index();
                window.location.href = 'book.html'
                //?i='+i+'&&'+'index='+b;
                window.localStorage.novel_detail = JSON.stringify(data[b]);
                window.localStorage.novel_detail2 = JSON.stringify('首页');
            });
        }
    }
    var novel_aj = function(id, a, b) {
        $.ajax({
            type: 'GET',
            url: 'http://47.112.20.73/web-novel/message/ishot.action',
            dataType: 'json',
            data: {
                'ishot': id
            },
            // contentType: 'application/json;charset=uft-8',
            success: function(data) {
                //console.log(a + '交互成功');
                nove_load(data, b);
                nove_load_set(data, b, a);
                novel_tap(b, data);
                
            },
            error: function(xhr, type) {
                console.log(2);
                console.log(xhr);
                console.log(1);
                console.log(type);
            }
        });
    }
    novel_aj(1, '热门', 0);
    novel_aj(0, '推荐', 1);
    
    var more_tap = function(){
        //console.log($('div.series_bar div.novel_bar div.novel_nav a'));
        for(var i =0;i<2;i++){
        $('div.series_bar div.novel_bar div.novel_nav a').eq(i).tap(function(){
            console.log($(this).index());
            //console.log('我在这');
        });   
         }
    }
    more_tap();
});