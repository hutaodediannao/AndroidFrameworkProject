package com.hutao.androidappdesignproject.config;

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
    public static final String TAB_6 = "常用工具类";
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
        TAB_List.add(TAB_6);
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
                list.add("CardView+阴影效果");
                list.add("统计图类的UI");
                list.add("Zxing二维码扫描控件");
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
                list.add("RxJava2.0基本API");
                break;
            case Constant.TAB_5:
                list.add("DabaBinding基本使用");
                break;
            case Constant.TAB_6:
                list.add("Android系统信息工具类");
                list.add("字符串工具类");
                list.add("时间工具类");
                list.add("屏幕像素工具类");
                list.add("数学计算工具类");
                list.add("Base64加密算法工具类");
                list.add("安卓Xml存储工具类");
                list.add("文件操作工具类");
                list.add("图片优化工具类");
                list.add("拍照预览工具类");
                break;
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


}
