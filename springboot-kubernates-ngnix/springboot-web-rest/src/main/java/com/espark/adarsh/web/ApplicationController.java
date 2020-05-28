package com.espark.adarsh.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@Controller
public class ApplicationController {

    @GetMapping("/welcome")
    public String greeting(@RequestParam(name = "name",
            required = false, defaultValue = "adarsh") String name, Model model) throws UnknownHostException {
        String ip = String.valueOf(InetAddress.getLocalHost());
        model.addAttribute("name", name);
        model.addAttribute("ip", ip);
        log.info("label=application-controller greeting() ");
        return "welcome";
    }

}