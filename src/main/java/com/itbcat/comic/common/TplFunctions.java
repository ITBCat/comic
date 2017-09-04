package com.itbcat.comic.common;

import com.blade.kit.StringKit;
import com.itbcat.comic.comic;

/**
 * 模板函数
 *
 * @author biezhi
 * @date 2017/7/31
 */
public class TplFunctions {

    public static String siteUrl() {
        return siteUrl("");
    }

    public static String siteUrl(String sub) {
        if (StringKit.isBlank(sub)) {
            return comic.me().getSetting("site_url");
        }
        String url = comic.me().getSetting("site_url") + "/" + sub;
        return url;
    }
}