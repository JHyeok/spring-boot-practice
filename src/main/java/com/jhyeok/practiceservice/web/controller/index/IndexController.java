package com.jhyeok.practiceservice.web.controller.index;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    /**
     * Hello, Spirng Boot
     */
    @GetMapping("/")
    public String hello() {
        return "Hello, Spirng Boot";
    }
}
