package hum.tan.controller;

import hum.tan.domain.Role;
import hum.tan.domain.User;
import hum.tan.service.RoleService;
import hum.tan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public ModelAndView list() {

        ModelAndView modelAndView = new ModelAndView();

        List<User> userList = userService.list();

        modelAndView.addObject("userList", userList);

        modelAndView.setViewName("user-list");

        return modelAndView;
    }

    @RequestMapping("add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView();

        List<Role> roleList = roleService.list();

        modelAndView.addObject("roleList", roleList);

        modelAndView.setViewName("user-add");

        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(User user, @RequestParam("roleIds") List<Long> roleIds) {
        userService.save(user, roleIds);

        return "redirect:/user/list";
    }

}
