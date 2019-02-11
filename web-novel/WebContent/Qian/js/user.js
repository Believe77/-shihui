/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2018-12-13 20:01:38
 * @version $Id$
 */
$(function() {
    // var login_flag = JSON.parse(window.localStorage.login_flag);
        var user_id = JSON.parse(window.localStorage.user_id);
        var user_tap = function() {
            $('div#user_bar div.back_bar img').tap(function() {
                window.location.href = 'index.html';
            });
            $('div#user_bar div.user_box div img').tap(function() {
                window.location.href = "personal_information.html";
            });
            $('ul.user_data_bar li').eq(0).children('img').tap(function() {
                window.location.href = "download.html";
            });
            $('ul.user_data_bar li').eq(1).children('img').tap(function() {
                window.location.href = "pr_comment.html";
            });
            $('div#user_exit_bar div#user_exit_box ').tap(function() {
                window.location.href = "login.html";
            });
        }
        user_tap();
        var user_in_set = function(data) {
            if (data.path == null) {}
            if (data.path != null) {
                $('div#user_bar div.user_box div img').attr('src', data.path);
            }
            $('div#user_bar div.user_box div.user_name span').text(data.name);
        }
        var user_aj = function(user_id) {
            $.ajax({
                type: 'GET',
                url: 'http://47.112.20.73/web-novel/user/returnPerMessage.action',
                // post payload:
                dataType: 'json',
                // contentType: 'application/json;charset=uft-8',
                data: {
                    'user_id': user_id
                },
                success: function(data) {
                    console.log(data);
                    user_in_set(data);
                    window.localStorage.user_in = JSON.stringify(data);
                },
                error: function(xhr, type) {
                    console.log(2);
                    console.log(xhr);
                    console.log(1);
                    console.log(type);
                }
            });
        }
        user_aj(user_id);
});