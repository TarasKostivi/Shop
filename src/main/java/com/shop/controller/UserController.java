package com.shop.controller;

import com.itextpdf.text.pdf.qrcode.Mode;
import com.shop.entity.Role;
import com.shop.entity.User;
import com.shop.service.MailSenderService;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailSenderService mailSenderService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "views-user-login";
    }

    @RequestMapping(value = "saveuser", method = RequestMethod.POST)
    public String saveuser(@ModelAttribute User user, @RequestParam String confirmPass, Model model) {

        String uuid = UUID.randomUUID().toString();
        userService.setUUID(user, uuid);

        try {
            userService.save(user, confirmPass);
        } catch (Exception e) {
            model.addAttribute("exception", e.getMessage());
            e.printStackTrace();
            return "views-user-login";
        }

        String theme = "Thank you for registration";
        String mailBody = "http://localhost:8080/Shop/confirm/" + uuid;
        mailSenderService.sendMail(theme, mailBody, user.getEmail());

        return "redirect:/";
    }

    @RequestMapping(value="/userslist", method=RequestMethod.GET)
    public String usersList(Model model){
        model.addAttribute("users", userService.getWithRole(Role.ROLE_USER));
        model.addAttribute("admins", userService.getWithRole(Role.ROLE_ADMIN));
        return "views-admin-userlist";
    }

    @RequestMapping(value="/deleteuser/{id}", method=RequestMethod.GET)
    public String delete(@PathVariable String id) {
        userService.delete(Integer.parseInt(id));
        return "redirect:/userlist";
    }

    @RequestMapping(value="/changerole/{id}", method=RequestMethod.GET)
    public String changeRole(@PathVariable String id) {
        userService.changeRole(Integer.parseInt(id));
        return "redirect:/userlist";
    }

    @RequestMapping(value="/changeenabled/{id}", method=RequestMethod.GET)
    public String changeEnable(@PathVariable String id){
        userService.changeEnabled(Integer.parseInt(id));
        return "redirect:/userlist";
    }

}
