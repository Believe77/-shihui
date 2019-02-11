/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2018-12-09 17:35:09
 * @version $Id$
 */
$(function() {
    var rg_button = $('div.account_num_box a button')
    var user_input = $('div.account_num div.account_num_box div#user_box input')
    var pw_input = $('div.account_num div.account_num_box div#password_box input')
    var flag = 0;
    var back_tap = function() {
        $('div.account_num div.back_bar img').tap(function() {
            history.go(-1)
        });
    }
    back_tap();
    //用户填写判断
    var user_register = function() {
        user_input.tap(function() {
            if (flag == 1) {
                $('div.account_num div#tip_bar div.tip_box').hide();
                flag = 0;
            }
        });
        pw_input.tap(function() {
            if ($(user_input).val().split('').length != 11) {
                $(user_input).attr('placeholder', '请输入11位数字的账号');
            }
            if (flag == 1) {
                $('div.account_num div#tip_bar div.tip_box').hide();
                flag = 0;
            }
        });
        pw_input.eq(1).tap(function() {
            if ($(pw_input).eq(0).val().split('').lenght != 8) {
                $(pw_input).eq(0).attr('placeholder', '请输入8位数字的密码');
            }
            if (flag == 1) {
                $('div.account_num div#tip_bar div.tip_box').hide();
                flag = 0;
            }

        });
    }
    //密码填写判断

    //确定密码判断
    //注册键判断
    var bt_tap = function() {
        $('div.account_num_box button').tap(function() {
            if ($(user_input).val().split('').length != 11) {
                $('div.account_num div#tip_bar div.tip_box').show();
                flag = 1;
            }
            else if ($(user_input).val().split('').length == 11 && $(pw_input).eq(0).val().split('').length != 8) {
                $('div.account_num div#tip_bar div.tip_box span').text('密码错误');
                $('div.account_num div#tip_bar div.tip_box').show();
                flag = 1;
            }
            else if ($(user_input).val().split('').length == 11 && $(pw_input).eq(0).val().split('').length == 8 && $(pw_input).eq(1).val() != $(pw_input).eq(0).val()) {
                $('div.account_num div#tip_bar div.tip_box span').text('密码错误');
                $('div.account_num div#tip_bar div.tip_box').show();
                flag = 1;
            }
            else if ($(user_input).val().split('').length == 11 && $(pw_input).eq(1).val() == $(pw_input).eq(0).val() && $(pw_input).eq(0).val().split('').length == 8) {
                $.ajax({
                    type: 'POST',
                    url: 'http://47.112.20.73/web-novel/user/regist.action',
                    // post payload:
                    dataType: 'json',
                    data: {
                        'name': $(user_input).val(),
                        'password': $(pw_input).eq(0).val()
                    },

                    success: function(responseText) {
                        console.log(responseText);
                    },
                    error: function(xhr, type) {
                        console.log(2);
                        console.log(xhr);
                        console.log(1);
                        console.log(xhr.responseText);
                        if (xhr.responseText == 'regist success') {
                            window.location.href = 'login.html';
                        }
                        else if(xhr.responseText == 'name already exit') {
                            $('div.account_num div#tip_bar div.tip_box span').text('账号已存在');
                            $('div.account_num div#tip_bar div.tip_box').show();
                            flag = 1;
                        }else{
                            $('div.account_num div#tip_bar div.tip_box span').text('账号错误');
                            $('div.account_num div#tip_bar div.tip_box').show();
                            flag = 1;
                        }
                    }
                });
            }else {
                $('div.account_num div#tip_bar div.tip_box span').text('操作错误');
                $('div.account_num div#tip_bar div.tip_box').show();
                flag = 1;
            }

        })
    }
    user_register();
    bt_tap();
});