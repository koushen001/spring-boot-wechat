package com.cike.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-14 10:26
 **/
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
