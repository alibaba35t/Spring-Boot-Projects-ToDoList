package com.alibaba35t.ToDoList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/")
    public String homepage(){
        return "index.html";
    }
}
