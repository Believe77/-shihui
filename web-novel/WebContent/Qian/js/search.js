/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2018-12-20 11:33:29
 * @version $Id$
 */
$(function() {
    var back_tap = function() {
        $('div.back_bar img').tap(function() {
            window.location.href = "index.html"
        });
    }
    back_tap();
    var input_on = function() {
        $('div#search_input_bar div#search_input_box input').on('input', function(e) {
            if ($('div#search_input_bar div#search_input_box input').val() != '') {
                //输入框内容不为空
                console.log($('div#search_input_bar div#search_input_box input').val());
            } else {
                //输入框内容为空
                console.log('内容为空');
            }
        })
    }
    //input_on();
    var novel_content = function(data) {
        $('div.series_bar').append('<div class="novel_bar"><ul class="novel_box clearfix"><ul></div>');
        for (var i = 0; i < data.length; i++) {
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
    var nove_load_set = function(data) {
        var li_index = $('div.series_bar div.novel_bar ul.novel_box').children('li');
        for (var k = 0; k < li_index.length; k++) {
            $('div.series_bar div.novel_bar ul.novel_box').children('li').eq(k).children('img').attr('src', data[k].path)
            $('div.series_bar div.novel_bar ul.novel_box').children('li').eq(k).children('div.book_name').text(data[k].name)
            $('div.series_bar div.novel_bar ul.novel_box').children('li').eq(k).children('b').text(data[k].message)
            $('div.series_bar div.novel_bar ul.novel_box').children('li').eq(k).children('p').text(data[k].author)
            $('div.series_bar div.novel_bar ul.novel_box').children('li').eq(k).children('em').eq(0).text(data[k].type)
            $('div.series_bar div.novel_bar ul.novel_box').children('li').eq(k).children('em').eq(1).text(data[k].style)
            // $('div.series_bar div.novel_bar ul.novel_box').children('li').eq(k).children('em').eq(2).text('38.2万字')
        }
    }
         var novel_content_remove = function() {
        $('div.series_bar').children("div").remove();

    }
       var novel_tap = function(data) {
        for (var j = 0; j < data.length; j++) {
            $('div.series_bar div.novel_bar ul.novel_box').children('li').eq(j).tap(function() {
                var b = $(this).index()-1;
                window.location.href = 'book.html'
                //?i='+i+'&&'+'index='+b;
                window.localStorage.novel_detail = JSON.stringify(data[b]);
                window.localStorage.novel_detail2 = JSON.stringify('搜索');
            });
        }
    }

    var search_aj = function(value1,value2) {
        $.ajax({
            type: 'GET',
            url: 'http://47.112.20.73/web-novel/search/searchbook.action',
            // post payload:
            dataType: 'json',
            data: {
                'value1':value1,
                'value2': value2
            },
            // contentType: 'application/json;charset=uft-8',
            success: function(data) {
                console.log('交互成功');
                //var aj_img_json = $.parseJSON(data);
                console.log(data);
                if(data!=''){
                novel_content(data);
                nove_load_set(data);
                novel_tap(data);
               }else{
                console.log('数据为空')
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
    var search_tap = function(){
        $('div#search_input_bar div#search_input_box img').tap(function(){
            // console.log($('div#search_input_bar div#search_input_box input').val());
            // console.log($('select.select_box').val());
            var value1 = $('select.select_box').val();
            var value2 = $('div#search_input_bar div#search_input_box input').val();
            novel_content_remove();
            search_aj(value1,value2)
        });
    }
    search_tap ();
});