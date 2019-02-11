/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2018-12-23 16:06:40
 * @version $Id$
 */
var user_in = JSON.parse(window.localStorage.user_in);
$(function() {
    var back_tap = function() {
        $('div.back_bar img').tap(function() {
            history.go(-1)
        });
    }
    back_tap();
      var Allcomment_load = function(data) {
        $('div#comment_bar').append('<ul></ul>')
        for (var i = 0; i < data.length; i++) {
            $('div#comment_bar ul').append(
                '<li class="comment_box"><img src="images/bg/5.jpg"><b><span>书名</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>章节章名</span></b>' +
                '<p> <span>11.13</span> <img src="images/icon/delete.png" style="width:15px;height: 15px; float:right;"></p>' +
                '<h5></h5>' +
                '</li>')
        }
    }
    var Allcomment_set = function(data) {
        for (var i = 0; i < data.length; i++) {
            $('div#comment_bar ul li').eq(i).children('img').attr('src',data[i].path);
            $('div#comment_bar ul li').eq(i).children('b').children('span').eq(0).text(data[i].bname);
            // $('div#comment_bar ul li').eq(i).children('b').children('span').eq(1).text(data[i].title);
            // console.log(data[i].title);
            // console.log(data[i].date);
            //pr_comemnt_delete(data[i].date);
            $('div#comment_bar ul li').eq(i).children('b').children('span').eq(1).text(data[i].title);
            $('div#comment_bar ul li').eq(i).children('p').children('span').text(data[data.length - 1].date);
            $('div#comment_bar ul li').eq(i).children('h5').text(data[i].comment);
        }
    }
    var pr_comemnt_return_aj = function(user_in) {
        $.ajax({
            type: 'GET',
            url: 'http://47.112.20.73/web-novel/search/returnComment.action',
            dataType: 'json',
            data: {
                'username': user_in.name
            },
            success: function(data) {
                console.log('交互成功');
                console.log(data);
                Allcomment_load(data);
                Allcomment_set(data);
                delete_tap();
               
            },
            error: function(xhr, type) {
                console.log(2);
                console.log(xhr);
                console.log(1);
                console.log(type);
            }
        });
    }
    pr_comemnt_return_aj(user_in);

    var delete_tap = function(){
        // console.log($('div#comment_bar ul li.comment_box p img'));
        var del = $('div#comment_bar ul li.comment_box p img');
        for(var i=0;i<del.length;i++){
            del.eq(i).tap(function(){
                // console.log($(this).parent('p').children('span').text());
                var date = $(this).parent('p').children('span').text();
                pr_comemnt_delete(date);
            });
        }
    }
     var pr_comemnt_delete = function(date) {

        $.ajax({
            type: 'GET',
            url: 'http://47.112.20.73/web-novel/search/deletePerComment.action',
            dataType: 'json',
            data: {
                'username': user_in.name,
                'date':date
            },
            success: function(data) {
                console.log('交互成功');
                console.log(data);

                // Allcomment_load(data);
                // Allcomment_set(data);
            },
            error: function(xhr, type) {
                console.log(2);
                console.log(xhr);
                console.log(1);
                console.log(type);
                window.location.href="pr_comment.html";
                // Allcomment_load(data);
                // Allcomment_set(data);
            }
        });
    }
    
});