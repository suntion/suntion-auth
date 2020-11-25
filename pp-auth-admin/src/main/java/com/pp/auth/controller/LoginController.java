package com.pp.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: suntion-auth
 * @Description:
 * @Author: Shen.Sun
 * @create: 2020-11-24 17:53
 **/
@Controller
public class LoginController {
    @RequestMapping("/test")
    public @ResponseBody  ModelAndView hello() {
        ModelAndView mv = new ModelAndView("login");

        return mv;
    }

}
