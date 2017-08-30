package com.wedding.datamanager.controllers;

import com.wedding.datamanager.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by pipe on 8/28/17.
 */

@Controller
public class LandingController {
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(Model model) {
        System.out.println("welcome request");
        return "index";
    }

    @RequestMapping(value = {"/views/landing"}, method = RequestMethod.GET)
    public String landing(Model model) {
        System.out.println("welcome request");
        return "landing";
    }
}
