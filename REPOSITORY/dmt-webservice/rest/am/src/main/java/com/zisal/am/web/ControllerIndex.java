package com.zisal.am.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ladies Man on 1/8/2016.
 */
@RestController
public class ControllerIndex {

    @RequestMapping("/")
    public String index(){
        return "<h1>Auto Mobile Rest Application</h1>";
    }
}
