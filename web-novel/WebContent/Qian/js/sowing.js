// JavaScript Document

$(function() {
    //自动轮播
    //第一步获取一些必要的值比如说索引，屏幕宽度，移动的ul
    //和下面小圆点的index
    var index = 0;
    var width = $('.sowing_bar').width();
    var moveUl = $(".sowing_img li");
    var index_li = $(".sowing_button li");

    //封装ul移动的方法
    var animateMoveUl = function() {

        moveUl.animate({
            "transform": "translate(" + index * width * -1 + "px)"
        }, 150, "ease", function() {
            if (index >= 5) {
                index = 0;
                moveUl.css({ "transiton": "none", "transform": "translate(" + index * width * -1 + "px)" });
            } else if (index < 0) {
                index = 4;
                moveUl.css({ "transiton": "none", "transform": "translate(" + index * width * -1 + "px)" });
            }
            //修改index的值
            index_li.removeClass("active").eq(index).addClass("active");

            //判断timeId的值如果为undefined说明我们干掉了计时器这是要重新开启定时器
            if (timeId === undefined) {
                timeId = setInterval(function() {
                    index++;
                    animateMoveUl();
                }, 3000);
            }
        });
    };
    //定时器自动轮播
    var timeId = setInterval(function() {
        //对index进行累加
        index++;
        //调用移动ul的方法
        animateMoveUl();
    }, 3000);

    //左右滑动的右滑动
    moveUl.swipeRight(function() {
        clearInterval(timeId);
        timeId = undefined;
        //调用移动ul的方法
        index--;
        animateMoveUl();
    });
    moveUl.swipeLeft(function() {
        clearInterval(timeId);
        timeId = undefined;
        //调用移动ul的方法
        index++;
        animateMoveUl();
    });

    var aj = function() {

        $.ajax({
            type: 'GET',
            url: 'http://47.112.20.73/web-novel/message/topImage.action',
            dataType: 'json',
            success: function(data) {
                // console.log('轮播图交互成功');
                // console.log(data);
                for (var i = 0; i < 5; i++) {
                    var a = data[i].path
                    $('div.sowing_bar ul.sowing_img li img').eq(i).attr('src',a);
                    //console.log(data[i].bid);
                    $('div.sowing_bar ul.sowing_img li').eq(i).tap(function(){
                        //console.log($(this).index());
                        // console.log(data[$(this).index()]);
                        // console.log(data[$(this).index()].bid);
                        // get_aj(data[$(this).index()].bid);
                        get_aj(data[$(this).index()].bid);
                    });
                    ;
                }
            },
            error: function(xhr, type) {
                console.log(2);
                console.log(xhr);
                console.log(1);
                console.log(type);
            }
        });
    }
    aj();
     var get_aj = function(bid) {
        $.ajax({
            type: 'GET',
            url: 'http://47.112.20.73/web-novel/search/get.action',
            dataType: 'json',
            data:{
                'bid':bid
            },
            success: function(data) {
                //console.log('轮播图bid交互成功');
                //console.log(data);
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
       var novel_tap = function(data) {
                window.location.href = 'book.html';
                window.localStorage.novel_detail = JSON.stringify(data[0]);
                window.localStorage.novel_detail2 = JSON.stringify('首页');
        
    }
});