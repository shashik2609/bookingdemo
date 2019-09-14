package com.antz.bookingdemo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Date;

@Controller
public class ViewController {

    //@Value("${app_mode}")
    private String appMode;

    @Autowired
    public ViewController(Environment environment) {
        appMode= environment.getProperty("app_mode");
    }

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username","Shashi K Adapa");
        model.addAttribute("mode",appMode);

        return "index";
    }
}
