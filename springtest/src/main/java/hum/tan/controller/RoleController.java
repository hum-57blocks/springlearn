package hum.tan.controller;

import hum.tan.domain.Role;
import hum.tan.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/role")
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();

        List<Role> roleList = roleService.list();

        modelAndView.addObject("roleList", roleList);

        modelAndView.setViewName("role-list");

        System.out.println(roleList);

        return modelAndView;
    }

}
