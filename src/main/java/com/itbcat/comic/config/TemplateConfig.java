package com.itbcat.comic.config;

import com.blade.Blade;
import com.blade.event.BeanProcessor;
import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Order;
import com.blade.mvc.view.template.JetbrickTemplateEngine;
import com.itbcat.comic.common.TplFunctions;
import jetbrick.template.resolver.GlobalResolver;

/**
 * Created by 860117030 on 2017/9/4.
 */
@Order(2)
@Bean
public class TemplateConfig implements BeanProcessor {
    @Override
    public void processor(Blade blade) {
        try {
            JetbrickTemplateEngine templateEngine = new JetbrickTemplateEngine();
            GlobalResolver resolver = templateEngine.getGlobalResolver();
            resolver.registerFunctions(TplFunctions.class);
            //resolver.registerMethods(Auth.class);
            blade.templateEngine(templateEngine);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
