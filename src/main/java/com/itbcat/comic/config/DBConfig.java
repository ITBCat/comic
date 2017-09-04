package com.itbcat.comic.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.blade.Blade;
import com.blade.Environment;
import com.blade.event.BeanProcessor;
import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Order;
import com.blade.jdbc.Base;
import com.blade.jdbc.core.ActiveRecord;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * Created by 860117030 on 2017/9/4.
 */
@Slf4j
@Order(3)
@Bean
public class DBConfig implements BeanProcessor {
    @Override
    public void processor(Blade blade) {
        Properties props = new Properties();
        InputStream in = new DBConfig().getClass().getResourceAsStream("/durid.properties");
        try{
            props.load(in);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(props);
            Base.open(dataSource);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
