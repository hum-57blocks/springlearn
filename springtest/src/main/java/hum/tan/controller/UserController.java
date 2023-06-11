package hum.tan.controller;

import hum.tan.domain.User;
import hum.tan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public ModelAndView list() {

        ModelAndView modelAndView = new ModelAndView();

        List<User> userList = userService.list();

        modelAndView.addObject("userList", userList);

        modelAndView.setViewName("user-list");

        return modelAndView;
    }

}
