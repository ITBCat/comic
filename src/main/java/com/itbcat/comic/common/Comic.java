package com.itbcat.comic.common;

import com.blade.Blade;
import com.blade.event.BeanProcessor;
import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Order;
import com.itbcat.comic.config.DBConfig;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by 860117030 on 2017/9/4.
 */
@Order(3)
@Bean
public class Comic implements BeanProcessor {
    private static Properties props = new Properties();
    @Override
    public void processor(Blade blade) {
        InputStream in = new Comic().getClass().getResourceAsStream("/app.properties");
        InputStream in2 = new Comic().getClass().getResourceAsStream("/lang_zh.properties");
        try {
            props.load(in);
            props.load(in2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String get(final String key){
        return props.getProperty(key);
    }
}
