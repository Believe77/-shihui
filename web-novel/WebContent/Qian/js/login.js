/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2018-12-13 10:45:53
 * @version $Id$
 */
$(function() {
    var user_input = $('div.account_num div.account_num_box div#user_box input');
    var pw_input = $('div.account_num div.account_num_box div#password_box input');
    var bn = $('div.account_num div.account_num_box button');
    var flag = 0;
     var back_tap = function() {
        $('div.account_num div.back_bar img').tap(function() {
            history.go(-1)
        });
    }
    back_tap();
    var input_tap = function() {
        user_input.tap(function() {
            if (flag == 1) {
                $('div.account_num div#tip_bar div.tip_box').hide();
                flag = 0;
            }
        })
        pw_input.tap(function() {
            if (flag == 1) {
                $('div.account_num div#tip_bar div.tip_box').hide();
                flag = 0;
            }
        })
    }
    input_tap();
    var bt_tap_aj = function() {
        bn.tap(function() {
            if (user_input.val().split('').length != 11) {
                $('div.account_num div#tip_bar div.tip_box span').text('账号错误');
                $('div.account_num div#tip_bar div.tip_box').show();
                flag = 1;
            }
            else if (user_input.val().split('').length == 11 && pw_input.val().split('').length != 8) {
                $('div.account_num div#tip_bar div.tip_box span').text('密码错误');
                $('div.account_num div#tip_bar div.tip_box').show();

                flag = 1;
            }
            else if (user_input.val().split('').length == 11 && pw_input.val().split('').length == 8) {
                $.ajax({
                    type: 'GET',
                    url: 'http://47.112.20.73/web-novel/user/login.action',
                    // post payload:
                    dataType: 'json',
                    data: {
                        'name': user_input.val(),
                        'password': pw_input.val()
                    },
                    // contentType: 'application/json;charset=uft-8',
                    success: function(data) {
                        console.log(data)
                        window.localStorage.user_id = JSON.stringify(data);
                        window.localStorage.user_pw = JSON.stringify(pw_input.val());
                        window.localStorage.login_flag = JSON.stringify(1);
                        window.location.href = "index.html";
                    },
                    error: function(xhr, type) {
                        console.log(2);
                        console.log(xhr);
                        console.log(1);
                        console.log(type);
                        if (xhr.responseText == 'name no exit') {
                            $('div.account_num div#tip_bar div.tip_box span').text('账号不存在');
                            $('div.account_num div#tip_bar div.tip_box').show();
                            flag = 1;
                        }
                        else if (xhr.responseText == 'password error') {
                            $('div.account_num div#tip_bar div.tip_box span').text('密码错误');
                            $('div.account_num div#tip_bar div.tip_box').show();
                            flag = 1;
                        } else {
                            $('div.account_num div#tip_bar div.tip_box span').text('账号错误');
                            $('div.account_num div#tip_bar div.tip_box').show();
                            flag = 1;
                        }
                    }
                });
            } else {
                $('div.account_num div#tip_bar div.tip_box span').text('账号错误');
                $('div.account_num div#tip_bar div.tip_box').show();
                flag = 1;
            }

        });
    }
    bt_tap_aj();
});