/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2018-12-13 21:11:05
 * @version $Id$
 */
$(function() {
    var user_in = JSON.parse(window.localStorage.user_in);
    var user_id = JSON.parse(window.localStorage.user_id);
    var user_pw = JSON.parse(window.localStorage.user_pw);
    var img_tap = $('div#person_ifm_bar ul li img');
    var sex_tap = $('div#person_ifm_bar ul li').eq(3);
    var img_post = $('div.img_post');
    var sex_post = $('div.sex_bar');
    var img_hide = $('div.img_post form input').eq(1);
    var sex_hide = $('div.sex_bar ul li');
    var flag = 0;
    console.log(user_in);
    var pr_set = function(user_in) {
        $('div#person_ifm_bar ul li').eq(0).children('img').attr('src', user_in.path);
        $('div#person_ifm_bar ul li').eq(1).children('h5').text(user_in.name);
        $('div#person_ifm_bar ul li').eq(3).children('b').text(user_in.sex);
    }
    pr_set(user_in);
    var back_tap = function() {
        $('div.back_bar img').tap(function() {
            window.location.href = "user.html"
        });
    }
    var revise = function() {
        $('div#person_ifm_bar ul li').eq(2).tap(function() {
            window.location.href = "revise_pw.html";
        });
    }
    revise();
    var sex_select = function() {
        for (var i = 0; i < 2; i++) {
            sex_hide.eq(i).tap(function() {
                sex_hide.children('span').removeClass('active');
                $(this).children('span').addClass('active');
                $('div#person_ifm_bar ul li').eq(3).children('b').text($(this).children('b').text());
            });
        }
    }
    sex_select();
    var pr_tap = function(a, b, c) {
        a.tap(function() {
            if (flag == 0) {
                b.show();
                flag = 1;
            } else if (flag == 1) {
                b.hide();
                flag = 0;
            }
        });
        c.tap(function() {
            b.hide();
            flag = 0;
        });
    }

    pr_tap(img_tap, img_post, img_hide);
    pr_tap(sex_tap, sex_post, sex_hide);
    back_tap();
    console.log(user_id);
    console.log(user_in.name);
    console.log(user_pw);
    //个人信息提交
    var sign_tap = function(user_in) {
        $('div.back_bar b').tap(function() {
            $.ajax({
                type: 'post',
                url: 'http://47.112.20.73/web-novel/user/saveMessage.action',
                data: {
                    'id': user_in.id,
                    'name': user_in.name,
                    'path': $('div#person_ifm_bar ul li').eq(0).children('img').attr('src'),
                    'password': user_pw,
                    'sex': $('div#person_ifm_bar ul li').eq(3).children('b').text()
                },
                success: function(data) {
                    console.log('交互成功');
                    //var aj_img_json = $.parseJSON(data);
                    console.log(data);
                    pr_show(user_in);
                },
                error: function(xhr, type) {
                    console.log(2);
                    console.log(xhr);
                    console.log(1);
                    console.log(type);
                }
            });
        })
    }
    var pr_show = function(user_in) {
        $.ajax({
            type: 'post',
            url: 'http://47.112.20.73/web-novel/user/returnPerMessage.action',
            data: {
                'user_id': user_in.id
            },
            success: function(data) {
                console.log('交互成功');
                console.log(data);
                console.log(data.path)
                if(data.path!=null){
                    $('div#person_ifm_bar ul li').eq(0).children('img').attr('src', data.path);
                }
                $('div#person_ifm_bar ul li').eq(3).children('b').text(data.sex);
            },
            error: function(xhr, type) {
                console.log(2);
                console.log(xhr);
                console.log(1);
                console.log(type);
            }
        });
    }
    sign_tap(user_in);
    //上传图片    
    var img_load = function() {
        $.ajax({
            url: 'http://47.112.20.73/web-novel/user/perImage.action',
            type: 'POST',
            dataType: 'json',
            success: function(data) {
                console.log(data)
                for (var i = 0; i < data.length; i++) {
                    var a = data[i].image //.split('novel/')
                    $('div.img_post ul li').eq(i).children('img').attr('src', a)
                }
                img_select(data);
            },
            error: function(xhr, type) {
                console.log(2);
                console.log(xhr);
                console.log(1);
                console.log(type);
            }
        });
    }
    img_load()
    //选择图片
    var img_select = function(data) {
        for (var i = 0; i < data.length; i++) {
            $('div.img_post ul li').eq(i).tap(function() {
                    $('div#person_ifm_bar ul li').eq(0).children('img').attr('src',data[$(this).index()].image);
            });
        }
    }
});