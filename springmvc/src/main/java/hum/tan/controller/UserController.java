package hum.tan.controller;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import hum.tan.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/quick12")
    @ResponseBody
    public String[] save12(String[] username) {
        return username;
    }

    @RequestMapping(value = "/quick11")
    @ResponseBody
    public User save11(User user) {
        return user;
    }

    @RequestMapping(value = "/quick10")
    @ResponseBody
    public User save10(String username, int age) {
        User user = new User();
        user.setUsername(username);
        user.setAge(age);
        return user;
    }

    @RequestMapping(value = "/quick9")
    @ResponseBody
    public User save9() {
        User user = new User();
        user.setUsername("hum tan");
        user.setAge(18);
        return user;
    }

    @RequestMapping(value = "/quick8")
    @ResponseBody
    public String save8() throws JsonProcessingException {
        User user = new User();
        user.setUsername("hum tan");
        user.setAge(18);

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(user);
    }

    @RequestMapping(value = "/quick7")
    @ResponseBody
    public String save7() {
        return "{\"username\":\"hum tan\", \"age\": 18}";
    }

    @RequestMapping(value = "/quick6")
    @ResponseBody
    public String save6() {
        return "hum tan";
    }

    @RequestMapping(value = "/quick5")
    public void save5(HttpServletResponse response) throws IOException {
        response.getWriter().print("hum tan");
    }

    @RequestMapping(value = "/quick4")
    public String save4(HttpServletRequest request) {
        request.setAttribute("username", "hum4");
        return "success";
    }

    @RequestMapping(value = "/quick3")
    public String save3(Model model) {
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
