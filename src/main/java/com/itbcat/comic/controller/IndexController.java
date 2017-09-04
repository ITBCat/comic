package com.itbcat.comic.controller;

import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;
import com.itbcat.comic.common.Comic;

/**
 * Created by 860117030 on 2017/9/4.
 */
@Path(value = "/")
public class IndexController {

    @GetRoute(value = "/")
    public void index(Request request,Response response){
        request.attribute("props",Comic.getAll());
        response.render("index.html");
    }
}
