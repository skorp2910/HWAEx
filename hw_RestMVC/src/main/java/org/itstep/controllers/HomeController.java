package org.itstep.controllers;

import org.itstep.api.UserRestApi;
import org.itstep.domain.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(path = "/")
public class HomeController {

    private final UserRestApi userRestApi;

    @Autowired
    public HomeController(UserRestApi userRestApi){
        this.userRestApi = userRestApi;
    }
    @GetMapping
    public String index(Model model){
        PageInfo pageInfo = userRestApi.getAllUsers();
       model.addAttribute("pageInfo",pageInfo.getData());
        return "index";
    }
}
