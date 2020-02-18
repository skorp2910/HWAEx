package org.itstep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MathController {
    @RequestMapping(value = {"/"})
    public String index(Model model, @RequestParam(defaultValue = "1") double a,
                        @RequestParam(defaultValue = "1") double b,
                        @RequestParam(defaultValue = "+") String op) {
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("op", op);
        double res = 0;
        if (op != null) {
            if (op.equals("+")) {
                res = a + b;
            }
            if (op.equals("-")) {
                res = a - b;
            }
            if (op.equals("/")) {
                res = a / b;
            }
            if (op.equals("*")) {
                res = a * b;
            }
        }
        model.addAttribute("res", res);
        return "index";
    }
}