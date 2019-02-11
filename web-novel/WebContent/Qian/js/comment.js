/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2018-12-20 10:55:11
 * @version $Id$
 */
var novel_detail = JSON.parse(window.localStorage.novel_detail);
var novel_title = JSON.parse(window.localStorage.novel_title);
var novel_index = JSON.parse(window.localStorage.novel_index);
var user_id = JSON.parse(window.localStorage.user_id);
$(function() {
    var back_tap = function() {
        $('div.back_bar img').tap(function() {
            window.history.go(-1);
        });
    }
    var back_set = function(){
        $('div.back_bar span').children('span').eq(0).text(novel_detail.name);
        $('div.back_bar span').children('span').eq(1).text(novel_index);
        $('div.back_bar span').children('span').eq(2).text(novel_title.title);
    }
    back_set();
    var user_comment = function() {
        $('section button').tap(function() {
            var comment_content = $.trim($('section div.ui-input input').val());
            if (comment_content == '') {
                $('section div.ui-input input').attr('placeholder', '你未评论！')
            } else if (comment_content != '') {
                comemnt_aj(comment_content);
                comemnt_return_aj();
            }
        });
    }
    var Allcomment_load = function(data) {
        $('div#comment_bar').append('<ul></ul>')
        for (var i = 0; i < data.length; i++) {
            $('div#comment_bar ul').append(
                '<li class="comment_box"><img src="images/bg/5.jpg"><b>账号</b>' +
                '<p> <span>11.13</span> </p>' +
                '<h5></h5>' +
                '</li>')
        }
    }
    var Allcomment_set = function(data) {
        for (var i = 0; i < data.length; i++) {
            $('div#comment_bar ul li').eq(i).children('img').attr('src', data[i].path);
            $('div#comment_bar ul li').eq(i).children('b').text('用户：' + data[i].username);
            $('div#comment_bar ul li').eq(i).children('p').children('span').text(data[i].date);
            $('div#comment_bar ul li').eq(i).children('h5').text(data[i].comment);
            console.log();
        }
    }
    var comment_load = function(data) {
        $('div#comment_bar ul').append(
            '<li class="comment_box"><img src="images/bg/5.jpg"><b>账号</b>' +
            '<p> <span>11.13</span> </p>' +
            '<h5></h5>' +
            '</li>')
    }

    var comment_set = function(data) {
        $('div#comment_bar ul li').eq(data.length - 1).children('img').attr('src', data[data.length - 1].path);
        $('div#comment_bar ul li').eq(data.length - 1).children('b').text('用户：' + data[data.length - 1].username);
        $('div#comment_bar ul li').eq(data.length - 1).children('p').children('span').text(data[data.length - 1].date);
        $('div#comment_bar ul li').eq(data.length - 1).children('h5').text(data[data.length - 1].comment);
    }
    var comemnt_aj = function(comment_content){
        $.ajax({
            type: 'GET',
            url: 'http://47.112.20.73/web-novel/search/comment.action',
            // post payload:
            dataType: 'json',
            data: {
                'user_id': user_id,
                'bname': novel_detail.name,
                'title': novel_title.title,
                'comment': comment_content
            },
            success: function(data) {
                console.log('交互成功');
                console.log(data);
            },
            error: function(xhr, type) {
                console.log(2);
                console.log(xhr);
                console.log(1);
                console.log(type);
            }
        });
    }
    var comemntAccess_aj = function() {
        $.ajax({
            type: 'GET',
            url: 'http://47.112.20.73/web-novel/message/askComment.action',
            // post payload:
            dataType: 'json',
            data: {
                'user_id': user_id
            },
            success: function(data) {
                console.log('交互成功');
                console.log(data);
            },
            error: function(xhr, type) {
                console.log(2);
                console.log(xhr);
                console.log(1);
                console.log(type);
            }
        });
    }
    comemntAccess_aj();
    var Allcomemnt_return_aj = function() {
        $.ajax({
            type: 'GET',
            url: 'http://47.112.20.73/web-novel/search/returnTitleComment.action',
            // post payload:
            dataType: 'json',
            data: {
                'title': novel_title.title,
            },
            // contentType: 'application/json;charset=uft-8',
            success: function(data) {
                console.log('交互成功');
                //var aj_img_json = $.parseJSON(data);
                console.log(data);
                Allcomment_load(data);
                Allcomment_set(data);
            },
            error: function(xhr, type) {
                console.log(2);
                console.log(xhr);
                console.log(1);
                console.log(type);
            }
        });
    }
    var comemnt_return_aj = function() {
        $.ajax({
            type: 'GET',
            url: 'http://47.112.20.73/web-novel/search/returnTitleComment.action',
            dataType: 'json',
            data: {
                'title': novel_title.title,
            },
            success: function(data) {
                console.log('交互成功');
                console.log(data);
                comment_load(data);
                comment_set(data);
            },
            error: function(xhr, type) {
                console.log(2);
                console.log(xhr);
                console.log(1);
                console.log(type);
            }
        });
    }
    // var delete_aj = function() {
    //     $.ajax({
    //         type: 'GET',
    //         url: 'http://47.112.20.73/web-novel/search/deletePerComment.action',
    //         dataType: 'json',
    //         data: {
    //             'user_id': user_id,
    //             'bname': novel_detail.name,
    //             'title': novel_title.title,
    //             'comment': '嘻嘻嘻啊哈哈'
    //         },
    //         success: function(data) {
    //             console.log('交互成功');
    //             console.log(data);
    //             comment_load(data);
    //             comment_set(data);
    //         },
    //         error: function(xhr, type) {
    //             console.log(2);
    //             console.log(xhr);
    //             console.log(1);
    //             console.log(type);
    //         }
    //     });
    // }
    back_tap();
    Allcomemnt_return_aj();
    user_comment();
    //delete_aj();

    // var comemnt_return = function() {
    //     $.ajax({
    //         type: 'GET',
    //         url: 'http://193.112.8.16/web-novel/search/returnShelf.action',
    //         // post payload:
    //         dataType: 'json',
    //         data: {
    //             'user_id': '3'
    //         },
    //         // contentType: 'application/json;charset=uft-8',
    //         success: function(data) {
    //             console.log('测试');
    //             //var aj_img_json = $.parseJSON(data);
    //             console.log(data);
    //             comment_load(data);
    //             comment_set(data);
    //         },
    //         error: function(xhr, type) {
    //             console.log(2);
    //             console.log(xhr);
    //             console.log(1);
    //             console.log(type);
    //         }
    //     });
    // }
    // comemnt_return();
})