package com.hutao.androidappdesignproject.config;

import com.hutao.androidappdesignproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述: 常量工具类
 * 作者: 胡涛
 * 时间: 2018-10-9 19:18
 */
public class Constant {

    //主页列表请求头部
    public static final List<String> TAB_List = new ArrayList<>();

    public static final String TAB_0 = "UI库";
    public static final String TAB_1 = "数据库框架";
    public static final String TAB_2 = "网络请求封装";
    public static final String TAB_3 = "图片加载库";
    public static final String TAB_4 = "RxJava2.0";
    public static final String TAB_5 = "DataBinding";
    //    public static final String TAB_6 = "常用工具类";
    public static final String TAB_7 = "颜色代码";
    public static final String TAB_8 = "Android新特性";
    public static final String TAB_9 = "EventBus";

    static {
        TAB_List.add(TAB_0);
        TAB_List.add(TAB_1);
        TAB_List.add(TAB_2);
        TAB_List.add(TAB_3);
        TAB_List.add(TAB_4);
        TAB_List.add(TAB_5);
//        TAB_List.add(TAB_6);
        TAB_List.add(TAB_7);
        TAB_List.add(TAB_8);
        TAB_List.add(TAB_9);
    }

    public static List<String> getTAB_List(String tab) {
        List<String> list = new ArrayList<>();
        switch (tab) {
            case Constant.TAB_0:
                list.add("上下拉刷新加载控件(SwipeToLoadLayout)");
                list.add("图片浏览手势放大缩小控件(PhotoView)");
                list.add("腾讯网页浏览器(X5WebView)");
                list.add("TabLayout+ViewPager+Fragment框架");
                list.add("底部导航切换BottomNavigationView");
                list.add("顶部Toolbar控件");
                list.add("安卓PDF查看控件");
                list.add("SurfaceView控件");
                list.add("安卓自带视频控件");
                list.add("IjkPlayer播放器");
                list.add("属性动画库");
                list.add("Dialog弹窗");
                list.add("PopWindow弹窗");
                list.add("图片选择器");
                list.add("RecyclerView支持的多种列表展示");
                list.add("CardView");
                list.add("统计图类的UI");
                list.add("Zxing二维码扫描控件");
                list.add("阿里VLayout控件");
                break;
            case Constant.TAB_1:
                list.add("原生数据库基本操作封装框架");
                list.add("GreenDao数据库框架");
                list.add("OrmLite数据库框架");
                break;
            case Constant.TAB_2:
                list.add("OkHttp+Retrofit2.0+RxJava2.0");
                list.add("Volley网络请求");
                break;
            case Constant.TAB_3:
                list.add("Glide加载图片框架");
                list.add("Pissco加载图片框架");
                break;
            case Constant.TAB_4:
                list.add("创建操作");
                list.add("变换");
                list.add("过滤");
                list.add("条件布尔操作");
                list.add("算术和聚合操作");
                list.add("String字符串操作");
                list.add("背压Backpressure");
                break;
            case Constant.TAB_5:
                list.add("基本使用UI展示(@{})");
                list.add("双向绑定{@={}}");
                list.add("表达式使用");
                list.add("列表绑定");
                list.add("自定义属性");
                list.add("动画");
                break;
//            case Constant.TAB_6:
//                list.add("Android系统信息工具类");
//                list.add("字符串工具类");
//                list.add("时间工具类");
//                list.add("屏幕像素工具类");
//                list.add("数学计算工具类");
//                list.add("Base64加密算法工具类");
//                list.add("安卓Xml存储工具类");
//                list.add("文件操作工具类");
//                list.add("图片优化工具类");
//                list.add("拍照预览工具类");
//                break;
            case Constant.TAB_7:
                list.add("常用颜色列表");
                list.add("自定义颜色选择");
                break;
            case Constant.TAB_8:
                list.add("Android6.0权限控制");
                list.add("Android5.0支持svg格式图标");
                list.add("5.0涟漪效果");
                list.add("指纹识别技术");
                list.add("蓝牙技术");
                break;
            case Constant.TAB_9:
                list.add("EventBus实现基本的通信功能");
                break;
        }
        return list;
    }

    public static List<Integer> getColors() {
        List<Integer> cs = new ArrayList<>();
        cs.add(R.color.white);
        cs.add(R.color.antiquewhite);
        cs.add(R.color.ivory);
        cs.add(R.color.lightyellow);
        cs.add(R.color.yellow);
        cs.add(R.color.snow);
        cs.add(R.color.floralwhite);
        cs.add(R.color.lemonchiffon);
        cs.add(R.color.cornsilk);
        cs.add(R.color.seaShell);
        cs.add(R.color.lavenderblush);
        cs.add(R.color.papayawhip);
        cs.add(R.color.blanchedalmond);
        cs.add(R.color.mistyrose);
        cs.add(R.color.bisque);
        cs.add(R.color.moccasin);
        cs.add(R.color.navajowhite);
        cs.add(R.color.peachpuff);
        cs.add(R.color.gold);
        cs.add(R.color.pink);
        cs.add(R.color.lightpink);
        cs.add(R.color.orange);
        cs.add(R.color.lightsalmon);
        cs.add(R.color.darkorange);
        cs.add(R.color.coral);
        cs.add(R.color.hotpink);
        cs.add(R.color.tomato);
        cs.add(R.color.orangered);
        cs.add(R.color.deeppink);
        cs.add(R.color.fuchsia);
        cs.add(R.color.magenta);
        cs.add(R.color.red);
        cs.add(R.color.oldlace);
        cs.add(R.color.lightgoldenrodyellow);
        cs.add(R.color.linen);
        cs.add(R.color.lightcyan);
        cs.add(R.color.lavender);
        cs.add(R.color.darksalmon);
        cs.add(R.color.violet);
        cs.add(R.color.palegoldenrod);
        cs.add(R.color.lightcoral);
        cs.add(R.color.khaki);
        cs.add(R.color.aliceblue);
        cs.add(R.color.honeydew);
        cs.add(R.color.azure);
        cs.add(R.color.sandybrown);
        cs.add(R.color.wheat);
        cs.add(R.color.beige);
        cs.add(R.color.whitesmoke);
        cs.add(R.color.mintcream);
        cs.add(R.color.ghostwhite);
        cs.add(R.color.salmon);
        cs.add(R.color.antiquewhite);
        cs.add(R.color.burlywood);
        cs.add(R.color.plum);
        cs.add(R.color.gainsboro);
        cs.add(R.color.crimson);
        cs.add(R.color.palevioletred);
        cs.add(R.color.goldenrod);
        cs.add(R.color.orchid);
        cs.add(R.color.thistle);
        cs.add(R.color.lightgray);
        cs.add(R.color.lightgrey);
        cs.add(R.color.tan);
        cs.add(R.color.chocolate);
        cs.add(R.color.peru);
        cs.add(R.color.indianred);
        cs.add(R.color.mediumvioletred);
        cs.add(R.color.silver);
        cs.add(R.color.darkkhaki);
        cs.add(R.color.rosybrown);
        cs.add(R.color.mediumorchid);
        cs.add(R.color.darkgoldenrod);
        cs.add(R.color.firebrick);
        cs.add(R.color.powderblue);
        cs.add(R.color.lightsteelblue);
        cs.add(R.color.paleturquoise);
        cs.add(R.color.greenyellow);
        cs.add(R.color.darkgray);
        cs.add(R.color.darkgrey);
        cs.add(R.color.brown);
        cs.add(R.color.sienna);
        cs.add(R.color.darkorchid);
        cs.add(R.color.palegreen);
        cs.add(R.color.darkviolet);
        cs.add(R.color.mediumpurple);
        cs.add(R.color.lightgreen);
        cs.add(R.color.darkseagreen);
        cs.add(R.color.saddlebrown);
        cs.add(R.color.darkmagenta);
        cs.add(R.color.darkred);
        cs.add(R.color.blueviolet);
        cs.add(R.color.lightskyblue);
        cs.add(R.color.skyblue);
        cs.add(R.color.gray);
        cs.add(R.color.olive);
        cs.add(R.color.purple);
        cs.add(R.color.maroon);
        cs.add(R.color.aquamarine);
        cs.add(R.color.chartreuse);
        cs.add(R.color.lawngreen);
        cs.add(R.color.mediumslateblue);
        cs.add(R.color.lightslategray);
        cs.add(R.color.lightslategrey);
        cs.add(R.color.slategray);
        cs.add(R.color.slategrey);
        cs.add(R.color.olivedrab);
        cs.add(R.color.slateblue);
        cs.add(R.color.dimgray);
        cs.add(R.color.dimgrey);
        cs.add(R.color.mediumaquamarine);
        cs.add(R.color.cornflowerblue);
        cs.add(R.color.cadetblue);
        cs.add(R.color.darkolivegreen);
        cs.add(R.color.indigo);
        cs.add(R.color.mediumturquoise);
        cs.add(R.color.darkslateblue);
        cs.add(R.color.steelblue);
        cs.add(R.color.royalblue);
        cs.add(R.color.turquoise);
        cs.add(R.color.limegreen);
        cs.add(R.color.darkslategray);
        cs.add(R.color.darkslategrey);
        cs.add(R.color.seagreen);
        cs.add(R.color.forestgreen);
        cs.add(R.color.lightseagreen);
        cs.add(R.color.dodgerblue);
        cs.add(R.color.aqua);
        cs.add(R.color.cyan);
        cs.add(R.color.springgreen);
        cs.add(R.color.lime);
        cs.add(R.color.mediumspringgreen);
        cs.add(R.color.darkturquoise);
        cs.add(R.color.deepskyblue);
        cs.add(R.color.darkcyan);
        cs.add(R.color.teal);
        cs.add(R.color.darkgreen);
        cs.add(R.color.blue);
        cs.add(R.color.mediumblue);
        cs.add(R.color.darkblue);
        cs.add(R.color.navy);
        cs.add(R.color.black);
        return cs;
    }


}
