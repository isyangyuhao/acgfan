/**
 * 弹幕播放器核心
 * Created by acgit on 2015/7/23.
 * Copyright 2015 by Ruiko Of AcGit.cc
 * @license MIT
 *
 * 版本2.0 2015/08/12
 */


;
(function ($) {


    var DanmuPlayer = function (element, options) {
        this.$element = $(element);
        this.options = options;
        $(element).data("paused", 1);
        var that = this;
        //播放器全局样式
        this.$element.css({
            "position": "relation",
            //"left":this.options.left,
            //"top":this.options.top,
            "width": this.options.width,
            "height": this.options.height,
            "overflow": "hidden"
        });


        //选择器规范
        this.$element.addClass("danmu-player");
        if (!$(element).attr("id"))
            $(element).attr("id", (Math.random() * 65535).toString());
        this.id = "#" + $(element).attr("id");


        //弹幕层设置,使用了定制的jquery.danmu.js
        this.$element.append('<div class="danmu-div"id="' + $(element).attr("id") + '-danmu-div" ></div>');
        $(this.id + " .danmu-div").danmu({
            width: "100%",
            height: "100%",
            speed: options.speed,
            opacity: options.opacity,
            fontSizeSmall: options.fontSizeSmall,
            FontSizeBig: options.FontSizeBig,
            topBottonDanmuTime: options.topBottonDanmuTime,
            SubtitleProtection: true,
            positionOptimize: true
        });


        //控件添加
        this.$element.css("height", this.$element.height() + 40);
        this.$element.append('<video class="danmu-video" src="' + options.src + '" width="' + options.width + '" height="' + options.height + '"></video>');
        this.$element.append('<div class="danmu-player-load" ></div>');
        this.$element.append('<div class="danmu-player-ctrl" ></div>');
        this.$element.append('<div class="danmu-player-tip" ></div>');
        this.$tip = $(this.id + " .danmu-player-tip");
        this.$ctrl = $(this.id + " .danmu-player-ctrl");
        this.$ctrl.append('<div class="ctrl-progress"><div class="current">' +
            '<div class="progress-handle"></div></div>' +
            '<div class="buffered"></div></div>');
        this.$ctrl.append('<div class="ctrl-main"></div>');
        this.$ctrlMain = $(this.id + " .ctrl-main");
        this.$ctrlMain.append('<div class="play-btn ctrl-btn" style="background:#f36c60;"><span class="iplay" aria-hidden="true"></span></div>');
        this.$ctrlMain.append('<div class="current-time time-text ctrl-btn">0:00</div>');
        this.$ctrlMain.append('<div class="slash time-text ctrl-btn">/</div>');
        this.$ctrlMain.append('<div class="duration ctrl-btn time-text" >0:00</div>');
        this.$ctrlMain.append('<input class="danmu-input ctrl-btn form-control"   type="textarea" id="danmu_text" max=300 />'); // -> button あ
        this.$ctrlMain.append('<div class=" send-btn  ctrl-btn" style="background-color:#f36c60; border-radius:5px; margin-left:-50px;" >发送 ></div>');
        this.$ctrlMain.append('<div class="full-screen  ctrl-btn-right"><span class="" aria-hidden="true">全屏</span></div>');
        this.$ctrlMain.append('<div class="show-danmu  ctrl-btn-right ctrl-btn-right-active"><span class="" aria-hidden="true">弹幕off</span></div>');

        //播放器状态
        this.video = $(this.id + " .danmu-video").get(0);
        this.current = 0;  //当前播放时间
        this.duration = this.video.duration;  //总时间
        this.danmuPlayerFullScreen = false;
        this.danmuShowed = true;
        this.isLoop = false;
        this.danmuSize = 0;
        this.danmuColor = this.options.defaultColor;
        this.danmuPosition = 0;
        //等待层
        $(this.id + " .danmu-player-load").shCircleLoader({
            keyframes: "0%   {background:black}\
         40%  {background:transparent}\
         60%  {background:transparent}\
         100% {background:black}"
        });

        


        //从后端获取弹幕
        this.getDanmu = function () {
            $.get(that.options.urlToGetDanmu, function (data, status) {
                danmuFromSql = eval(data);
				$(that.id + ' .danmu-div').danmu("addDanmu", danmuFromSql);
            });
        };

        if (options.urlToGetDanmu)
            this.getDanmu();

        //发送弹幕
        this.sendDanmu = function (e) {
            var text = $(e.data.that.id + " .danmu-input").get(0).value;
            if (text.length == 0) {
                return;
            }
            if (text.length > 255){
                alert("弹幕过长！");
                return;
            }
            text = text.replace(/&/g, "&gt;").replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/\"/g, "&quot;").replace(/\n/g, "<br>");
            var color = e.data.that.danmuColor;
			var position = 0;
			var size = 1;
            var time = $(e.data.that.id + " .danmu-div").data("nowTime") + 3;
            var textObj = '{ "text":"' + text + '","color":"' + color + '","size":"' + size + '","position":"' + position + '","time":' + time + '}';
            if (e.data.that.options.urlToPostDanmu)
				console.log(textObj);
				console.log(e.data.that.options.urlToPostDanmu);
                $.post(e.data.that.options.urlToPostDanmu, {
                    danmu: textObj
                });
            textObj = '{ "text":"' + text + '","color":"' + color + '","size":"' + size + '","position":"' + position + '","time":' + time + ',"isnew":""}';
            var newObj = eval('(' + textObj + ')');
            $(e.data.that.id + " .danmu-div").danmu("addDanmu", newObj);
            $(e.data.that.id + " .danmu-input").get(0).value = '';
            //触发事件
            $(e.data.that).trigger("senddanmu");
            //==============将弹幕信息发送到服务器 [[==============
            var url = "index-danmu-ajax";
            var args = {"videoId":videoId, "text":text, "color":color, "size":size, "position":position, "time":time};
            $.post(url, args, function(data) {
            	
            })
            //==============将弹幕信息发送到服务器 ]]==============
        };

        //播放暂停
        this.playPause = function (e) {
            if (e.data.video.paused) {
                e.data.video.play();
                $(e.data.that.id + " .danmu-div").danmu('danmuResume');
                $(e.data.that.id + " .play-btn span").removeClass("iplay").addClass("ipause");
            }
            else {
                e.data.video.pause();
                $(e.data.that.id + " .danmu-div").danmu('danmuPause');
                $(e.data.that.id + " .play-btn span").removeClass("ipause").addClass("iplay");
            }
        };

        //主计时器
        var mainTimer = setInterval(function () {
            //缓冲条
            var bufTime=$(that.id + " .danmu-video").get(0).buffered.end($(that.id + " .danmu-video").get(0).buffered.length-1);

            var buffPrecent = (bufTime/that.duration) * 100;
            $(that.id + ".danmu-player .ctrl-progress .buffered ").css("width", buffPrecent + "%");
           // 时间轴修正
           // if (Math.abs($(that.id + " .danmu-div").data("nowTime") - parseInt(that.video.currentTime)*10) > 1) {
           //     $(that.id + " .danmu-div").data("nowTime", parseInt(that.video.currentTime)*10);
           //     console.log("revise time：")
           // }
        }, 1000);


        var secTimer = setInterval(function () {
           // if (Math.abs($(that.id + " .danmu-div").data("nowTime") - parseInt(that.video.currentTime*10)) > 1) {
              //  console.log("revise time"+$(that.id + " .danmu-div").data("nowTime")+ ","+that.video.currentTime*10);
                $(that.id + " .danmu-div").data("nowTime", parseInt(that.video.currentTime*10));

          //  }
        }, 50);
        //按键事件
        $(document).ready(function () {
            jQuery("body").keydown({that: that}, function (event) {
                if (event.which == 13) {
                    that.sendDanmu(event);
                    return false
                }

            });
        });


        //播放事件
        $(this.id + " .play-btn").on("click", {video: this.video, that: that}, function (e) {
            that.playPause(e);
        });
        $(this.id + " .danmu-div").on("click", {video: this.video, that: that}, function (e) {
            that.playPause(e);

        });

        //waiting事件
        $(this.id + " .danmu-video").on('waiting', {that: that}, function (e) {

            if ($(e.data.that.id + " .danmu-video").get(0).currentTime == 0) {
                $(e.data.that.id + " .danmu-div").data("nowTime", 0);
                $(e.data.that.id + " .danmu-div").data("danmuPause");
            } else {
                $(e.data.that.id + " .danmu-div").data("nowTime", parseInt($(e.data.that.id + " .danmu-video").get(0).currentTime)*10);
                $(e.data.that.id + " .danmu-div").data("danmuPause");
            }
            $(e.data.that.id + " .danmu-player-load").css("display","block");

        });

        //playing事件
        $(this.id + " .danmu-video").on('play playing', {that: that}, function (e) {

            if ($(e.data.that.id + " .danmu-video").get(0).currentTime == 0) {
                $(e.data.that.id + " .danmu-div").data("nowTime", 0);
                $(e.data.that.id + " .danmu-div").data("danmuResume");
            } else {
                $(e.data.that.id + " .danmu-div").data("nowTime", parseInt($(e.data.that.id + " .danmu-video").get(0).currentTime)*10);
                $(e.data.that.id + " .danmu-div").data("danmuResume");
            }
            $(e.data.that.id + " .danmu-player-load").css("display","none");

        });


        //seeked事件
        $(this.id + " .danmu-video").on('seeked ', {that: that}, function (e) {
            $(e.data.that.id + " .danmu-div").danmu("danmuHideAll");
        });
		
        //全屏事件
        $(this.id + " .full-screen").on("click", {video: this.video, that: that}, function (e) {
            if (!e.data.that.danmuPlayerFullScreen) {
                //$css({"position":"fixed","zindex":"999","top":"0","left":"0","height":"100vh","width":"100vw"});
                $(e.data.that.id).addClass("danmu-player-full-screen");
                e.data.that.danmuPlayerFullScreen = true;
				$(e.data.that.id + " .full-screen span").html('退出全屏');
            }
            else {
                $(e.data.that.id).removeClass("danmu-player-full-screen");
                e.data.that.danmuPlayerFullScreen = false;
				$(e.data.that.id + " .full-screen span").html('全屏');
            }

        });

        //显示和隐藏弹幕按钮事件
        $(this.id + " .show-danmu").on("click", {that: that}, function (e) {
            if (e.data.that.danmuShowed) {
                $(e.data.that.id + " .danmu-div").css("visibility", "hidden");
                e.data.that.danmuShowed = false;
				$(e.data.that.id + " .show-danmu").html('弹幕on');
            }
            else {
                e.data.that.danmuShowed = true;
                $(e.data.that.id + " .danmu-div").css("visibility", "visible");
				$(e.data.that.id + " .show-danmu").html('弹幕off');
            }

        });

        //循环播放按钮事件
        $(this.id + " .loop-btn").on("click", {that: that}, function (e) {
            if (!e.data.that.isLoop) {
                e.data.that.video.loop = true;
                e.data.that.isLoop = true;
                $(e.data.that.id + " .loop-btn").addClass("ctrl-btn-right-active");
            }
            else {
                e.data.that.video.loop = true;
                e.data.that.isLoop = false;

                $(e.data.that.id + " .loop-btn").removeClass("ctrl-btn-right-active");
            }
        });

        //时间改变事件
        $(this.id + " .danmu-video").on('loadedmetadata', {video: this.video, that: that}, function (e) {
            e.data.that.duration = e.data.video.duration;
            var duraMin = parseInt(e.data.that.duration / 60);
            var duraSec = parseInt(e.data.that.duration % 60) < 10 ? "0" + parseInt(e.data.that.duration % 60) : parseInt(e.data.that.duration % 60);
            $(e.data.that.id + " .duration").text(duraMin + ":" + duraSec);
            $(e.data.that.id + " .danmu-video").on('timeupdate', {
                video: e.data.video,
                that: e.data.that
            }, function (e) {
                var current = e.data.that.current = e.data.video.currentTime;
                var curMin = parseInt(current / 60);
                var curSec = parseInt(current % 60) < 10 ? "0" + parseInt(current % 60) : parseInt(current % 60);
                $(e.data.that.id + " .current-time").text(curMin + ":" + curSec);
                var duraMin = parseInt(e.data.that.duration / 60);
                var duraSec = parseInt(e.data.that.duration % 60) < 10 ? "0" + parseInt(e.data.that.duration % 60) : parseInt(e.data.that.duration % 60);
                $(e.data.that.id + " .duration").text(duraMin + ":" + duraSec);
                var percentage = 100 * current / e.data.that.duration;
                $(e.data.that.id + '.danmu-player .ctrl-progress .current ').css('width', percentage + '%');
                e.data.that.reviseFlag = e.data.that.reviseFlag + 1;
            });
        });

        //进度条事件
        $(this.id + " .ctrl-progress").on('click', {video: this.video, that: that}, function (e) {
            var sumLen = $(e.data.that.id + " .ctrl-progress").width();
            var pos = e.pageX - $(e.data.that.id + " .ctrl-progress").offset().left;
            var percentage = pos / sumLen;
            $(e.data.that.id + '.danmu-player .ctrl-progress .current ').css('width', percentage * 100 + '%');
            aimTime = parseFloat(percentage * e.data.that.duration);
            e.data.video.currentTime = aimTime;
        });
        var timeDrag = false;
        $(this.id + " .ctrl-progress").on('mousedown touchstart', function (e) {
            timeDrag = true;
        });
        $(document).on('mouseup', function (e) {
            if (timeDrag) timeDrag = false;
        });
        $(this.id + " .ctrl-progress").on('mousemove touchmove', {video: this.video, that: that}, function (e) {
            if (timeDrag) {
                var sumLen = $(e.data.that.id + " .ctrl-progress").width();
                var pos = e.pageX - $(e.data.that.id + " .ctrl-progress").offset().left;
                var percentage = pos / sumLen;
                if (percentage > 1)
                    percentage = 1;
                if (percentage < 0)
                    percentage = 0;
                aimTime = parseFloat(percentage * e.data.that.duration);
                e.data.video.currentTime = aimTime;
                $(e.data.that.id + '.danmu-player .ctrl-progress .current ').css('width', percentage * 100 + '%');
            }
        });

        //发送弹幕事件
        $(this.id + " .send-btn").on("click", {that: that}, function (e) {
            e.data.that.sendDanmu(e);
        });

        //用户操作控制条事件
        $(this.id + " .ctrl-progress").on("mouseup touchend", {that: that}, function (e) {
            $(e.data.that.id + " .danmaku").remove();
        });

    };//danmuplayer构造函数


    DanmuPlayer.DEFAULTS = {
        left: 0,
        top: 0,
        height: 360,
        width: 640,
        zindex: 100,
        speed: 8000,
        sumTime: 65535,
        defaultColor: "#ffffff",
        fontSizeSmall: 16,
        FontSizeBig: 24,
        opacity: ".8",
        topBottonDanmuTime: 6000,
        urlToGetDanmu: "",
        urlToPostDanmu: ""
    };


    function Plugin(option, arg) {
        return this.each(function () {
            var $this = $(this);
            var options = $.extend({}, DanmuPlayer.DEFAULTS, typeof option == 'object' && option);
            var data = $this.data('DanmuPlayer');
            var action = typeof option == 'string' ? option : NaN;
            if (!data) $this.data('danmu', (data = new DanmuPlayer(this, options)));
            if (action)    data[action](arg);
        })
    }


    $.fn.DanmuPlayer = Plugin;
    $.fn.DanmuPlayer.Constructor = DanmuPlayer;


})(jQuery);