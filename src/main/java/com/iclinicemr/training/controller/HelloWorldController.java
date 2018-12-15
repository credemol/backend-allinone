package com.iclinicemr.training.controller;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/helloworld")
public class HelloWorldController {

    @RequestMapping(method = {RequestMethod.GET})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String helloWorld(@RequestParam(value="name", required = false) String name) {
        if(StringUtils.isEmpty(name)) {
            name = "Hello";
        }
        return "Hello " + name  + "!";
    }
}
