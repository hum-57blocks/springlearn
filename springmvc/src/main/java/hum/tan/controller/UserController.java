package hum.tan.controller;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import hum.tan.domain.User;
import hum.tan.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/quick21")
    @ResponseBody
    public String save20(String username, List<MultipartFile> files) throws IOException {
        for (MultipartFile file : files) {
            String originalFilename = file.getOriginalFilename();
            file.transferTo(new File("D:\\upload\\" + originalFilename));
        }
        return username;
    }

    @RequestMapping(value = "/quick20")
    @ResponseBody
    public String save20(String username, MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        file.transferTo(new File("D:\\upload\\" + originalFilename));
        return username;
    }

    @RequestMapping(value = "/quick19")
    @ResponseBody
    public String save19(@CookieValue(value = "JSESSIONID", required = false) String jsessionId) {
        return jsessionId;
    }

    @RequestMapping(value = "/quick18")
    @ResponseBody
    public String save18(@RequestHeader(value = "Authorization", required = false) String token) {
        return token;
    }

    @RequestMapping(value = "/quick17")
    @ResponseBody
    public Date save17(@RequestParam(value = "date") Date date) {
        return date;
    }

    @RequestMapping(value = "/quick16/{username}")
    @ResponseBody
    public String save16(@PathVariable(value = "username") String username) {
        return username;
    }

    @RequestMapping(value = "/quick15")
    @ResponseBody
    public String save15(@RequestParam(value = "name") String username) {
        return username;
    }

    @RequestMapping(value = "/quick14")
    @ResponseBody
    public List<User> save14(@RequestBody List<User> userList) {
        return userList;
    }

    @RequestMapping(value = "/quick13")
    @ResponseBody
    public VO save13(VO vo) {
        return vo;
    }

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
