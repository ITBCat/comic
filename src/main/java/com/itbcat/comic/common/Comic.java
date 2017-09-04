package com.itbcat.comic.common;

import com.blade.Blade;
import com.blade.event.BeanProcessor;
import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Order;
import com.blade.kit.JsonKit;
import com.blade.mvc.annotation.JSON;
import com.itbcat.comic.config.DBConfig;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by 860117030 on 2017/9/4.
 */
@Order(1)
@Bean
public class Comic implements BeanProcessor {
    private static Properties props = new Properties();
    @Override
    public void processor(Blade blade) {
        InputStream in = new Comic().getClass().getResourceAsStream("/lang_zh.properties");
        try {
            props.load(in);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String get(final String key){
        return props.getProperty(key);
    }

    public static Properties getAll(){
        return props;
    }

}
