/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2018-12-23 23:12:23
 * @version $Id$
 */
$(function() {
    var pw = JSON.parse(window.localStorage.user_pw);
    var back_tap = function() {
        $('div.account_num div.back_bar img').tap(function() {
            history.go(-1)
        });
    }
    back_tap();
    var revise_button = function() {
        $('input#pwId_0').tap(function() {
            $('div#tip_bar').children('div.tip_box').hide();
        });
        $('input#pwId_1').tap(function() {
            $('div#tip_bar').children('div.tip_box').hide();
        });
        $('input#pwId').tap(function() {
            $('div#tip_bar').children('div.tip_box').hide();
        });

        $('div.account_num_box button#revise').tap(function() {
            if ($('input#pwId_0').val().split('').length != 8) {
                $('div#tip_bar').children('div.tip_box').show();
            }
            if ($('input#pwId_0').val().split('').length == 8) {
                // console.log(pw);
                // console.log($('input#pwId_0').val()+'呀');
                if ($('input#pwId_0').val() == pw) {
                    $('div.account_num_box div.password_box_1').hide();
                    $('div.account_num_box div.password_box_2').show();
                    $('div.account_num_box button#revise').tap(function() {
                        if ($('input#pwId_1').val().split('').length != 8) {
                            $('div#tip_bar').children('div.tip_box').show();
                        }
                        if ($('input#pwId_1').val().split('').length== 8&&$('input#pwId_1').val()==$('input#pwId').val()) {
                            console.log('密码修改成功');
                            var user_in = JSON.parse(window.localStorage.user_in);
                            window.localStorage.user_pw = JSON.stringify($('input#pwId_1').val());
                            var user_pw = JSON.parse(window.localStorage.user_pw);
                            sign_tap(user_in,user_pw);
                        }else{
                        	$('div#tip_bar').children('div.tip_box').show();
                        }
                    });
                } else {
                    $('div#tip_bar').children('div.tip_box').show();
                }
            } else {

            }
        });
    }
    revise_button();
        var sign_tap = function(user_in,user_pw) {
            $.ajax({
                type: 'post',
                url: 'http://47.112.20.73/web-novel/user/saveMessage.action',
                data: {
                    'id': user_in.id,
                    'name': user_in.name,
                    'path': user_in.path,
                    'password': user_pw,
                    'sex': user_in.sex
                },
                success: function(data) {
                    //console.log('交互成功');
                    //var aj_img_json = $.parseJSON(data);
                    //console.log(data);
                  window.location.href="personal_information.html";
                },
                error: function(xhr, type) {
                    console.log(2);
                    console.log(xhr);
                    console.log(1);
                    console.log(type);
                   
                }
            });
    }
});