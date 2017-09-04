package com.itbcat.comic;

import com.blade.Blade;
import com.blade.security.web.csrf.CsrfMiddleware;
import com.blade.validator.ValidatorMiddleware;
import com.itbcat.comic.common.Comic;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Blade.me().use(
                new ValidatorMiddleware(),
                new CsrfMiddleware())
                .start(App.class, args);
        System.out.print(Comic.get("app.name"));
    }
}
