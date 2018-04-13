package com.ch.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @RequestMapping("/scu")
    public String demo() {
        return "scu2";
    }

}
