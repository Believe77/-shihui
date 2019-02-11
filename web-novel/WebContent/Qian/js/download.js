/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2018-12-20 11:04:19
 * @version $Id$
 */
$(function() {
    var back_tap = function() {
        $('div.back_bar img').tap(function() {
            window.history.go(-1);
        });
    }
    back_tap();
    var switch_tap = function() {
        var flag = 0;
        for (var i = 0; i < 2; i++) {
            $('div#download_bar ul li').eq(i).tap(function() {
                $('div#download_bar ul li').removeClass('active');
                $(this).addClass('active');
                $('div.book_display_bar').hide();
                $('div.book_display_bar').eq($(this).index()).show();
            });
        }
        for (var k = 0; k < 2; k++) {
            $('div.book_display_bar').eq(1).children('ul.book_display_box').children('li').eq(k).children('img').eq(1).tap(function() {
                if (flag == 0) {
                    $(this).attr('src', 'images/icon/download.png');
                    flag = 1;
                }
                else if (flag == 1) {
                     $(this).attr('src', 'images/icon/stop.png');
                    flag = 0;
                }
            });
        }
    }
    switch_tap();
    var download_aj = function() {
        $.ajax({
            type: 'GET',
            url: 'http://47.112.20.73/web-novel/search/download.action',
            dataType: 'json',
            data: {
                'filename':'泡沫之夏.txt'
            },
            success: function(data) {
                console.log('下载成功');
            },
            error: function(xhr, type) {
                console.log(2);
                console.log(xhr);
                console.log(1);
                console.log(type);
            }
        });
    }
    download_aj();
})