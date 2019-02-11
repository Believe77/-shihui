/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2018-12-11 16:32:32
 * @version $Id$
 */
$(function() {
    var sent_id = $('div#rank_bar ul li')
    var back_tap = function() {
        $('div.back_bar img').tap(function() {
            window.location.href="index.html"
        });
    }
    back_tap();
    //小说加载
    var novel_content = function(data) {
        $('div.series_bar').append('<div class="novel_bar"><ul class="novel_box clearfix"><ul></div>');
        for (k = 0; k < data.length; k++) {
            $('div.series_bar div.novel_bar ul.novel_box').append(
                '<li>' +
                '<img src="images/cover/u=2132211606,2010640083&fm=58&bpow=580&bpoh=861.jpg" alt="">' +
                '<div class="book_name">斗罗大陆</div>' +
                '<b class="abstract">小小的唐三在圣魂村开始了他的魂师修炼之路，并萌生了振兴唐门的梦想。</b>' +
                '<p class="author">唐家三少</p>' +
                '<em class="tag_small yellow">仙侠奇缘</em>' +
                '<em class="tag_small red">连载</em>' +
                // '<em class="tag_small blue">288.6万字</em>' +
                '</li>')

        }

    }
    //共3种排行，把后面的两个排行隐藏掉
    // var novel_content_hide = function(i) {
    //     if (i != 0) {
    //         $('div.series_bar div.novel_bar').eq(i).hide();
    //     }
    // // }
    var novel_content_remove = function() {
            $('div.series_bar').children('div').remove();
    }

    var nove_load_set = function(data) {
        // console.log($('div.series_bar div.novel_bar div.novel_nav b').eq(i).text())
        // var li_index = $('div.series_bar div.novel_bar ul.novel_box').children();
        for (var k = 0; k < data.length; k++) {
            $('div.series_bar div.novel_bar ul.novel_box').children('li').eq(k).children('img').attr('src', data[k].path)
            $('div.series_bar div.novel_bar ul.novel_box').children('li').eq(k).children('div.book_name').text(data[k].name)
            $('div.series_bar div.novel_bar ul.novel_box').children('li').eq(k).children('b').text(data[k].message)
            $('div.series_bar div.novel_bar ul.novel_box').children('li').eq(k).children('p').text(data[k].author)
            $('div.series_bar div.novel_bar ul.novel_box').children('li').eq(k).children('em').eq(0).text(data[k].type)
            $('div.series_bar div.novel_bar ul.novel_box').children('li').eq(k).children('em').eq(1).text(data[k].style)
            // $('div.series_bar div.novel_bar ul.novel_box').eq(i).children('li').eq(k).children('em').eq(2).text(data[k].countNumber)
        }
    }
    var novel_tap = function(data) {
        for (var j = 0; j < data.length; j++) {
            $('div.series_bar div.novel_bar ul.novel_box').children('li').eq(j).tap(function() {
                var b = $(this).index()-1;
                console.log(b)
                window.location.href = 'book.html'
                //?i='+i+'&&'+'index='+b;
                console.log(data[b].bid);
                window.localStorage.novel_detail = JSON.stringify(data[b]);
                window.localStorage.novel_detail2 = JSON.stringify('排行榜');
            });
        }
    }
    var novel_aj = function() {
        $.ajax({
            type: 'GET',
            url: 'http://47.112.20.73/web-novel/search/sort.action',
            // post payload:
            dataType: 'json',
            success: function(data) {
                console.log('交互成功');
                console.log(data);
                novel_content(data);
                nove_load_set(data);
                novel_tap(data);
            },
            error: function(xhr, type) {
                console.log(2);
                console.log(xhr);
                console.log(1);
                console.log(type);
            }
        });
    }
    novel_aj();
        for (var b = 0; b < sent_id.length; b++) {
            sent_id.eq(b).tap(function() {
                novel_content_remove();
                novel_aj();
                // window.localStorage.novel_detail2 = '排行榜'+$(this).index();
                //console.log($(this).index());
                // var num = $(this).attr('id');
                // console.log($(this).attr('id'))
                //为点击的li加上样式、隐藏和显示相关的小说内容
                for (i = 0; i < sent_id.length; i++) {
                    sent_id.eq(i).removeClass('active')
                    // $('div.series_bar div.novel_bar').eq(i).hide();
                }
                $(this).addClass('active')
                // $('div.series_bar div.novel_bar').eq(num - 1).show()
            });
        }
});