package com.itbcat.comic.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.blade.Blade;
import com.blade.event.BeanProcessor;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by 860117030 on 2017/9/4.
 */
public class DBConfig implements BeanProcessor {
    @Override
    public void processor(Blade blade) {
        InputStream in = DBConfig.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties props = new Properties();
        try{
            props.load(in);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(props);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
