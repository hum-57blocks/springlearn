package hum.tan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/quick4")
    public String save2(HttpServletRequest request) {
        request.setAttribute("username", "hum4");
        return "success";
    }

    @RequestMapping(value = "/quick3")
    public String save2(Model model) {
        model.addAttribute("username", "hum3");
        return "success";
    }

    @RequestMapping(value = "/quick2")
    public ModelAndView save2(ModelAndView modelAndView) {
        modelAndView.addObject("username", "hum2");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/quick1")
    public ModelAndView save1() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", "hum1");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/quick", method = RequestMethod.GET, params = {"username"})
    public String save() {
        System.out.println("UserController save running...");
        return "success";
    }
}
