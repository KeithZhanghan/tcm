package jz.controller;

import jz.util.Util;
import jz.entity.User;
import jz.server.UserServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Controller
public class Login {
    @Autowired
    UserServerImpl userServer;

    @RequestMapping("/login.do")
    @ResponseBody
    public String login(String userAccount, String password, HttpSession session) {
        if (Util.isEmpty(userAccount) || Util.isEmpty(password)) {
            return "fail";
        }
        User user = new User();
        user.setUserAccount(userAccount);
        user.setPassword(password);
        user = userServer.check(user);
        if (null != user) {
            session.setAttribute("user", user);
            return "success";
        }
        return "fail";

    }

    @RequestMapping("/register.do")
    public String addUser(User user, HttpSession session) {
        user.setIsValid(1);
        user.setUserRank(2);
        userServer.addUser(user);
        session.setAttribute("user", user);
        return "redirect:/knowledge/admin.html";
    }

    @RequestMapping("/logout.do")
    public String logout(HttpSession session) {
        Enumeration e = session.getAttributeNames();
        while (e.hasMoreElements()) {
            String sessionName = (String) e.nextElement();
            session.removeAttribute(sessionName);
            System.out.println("清除的session有：" + sessionName);
        }
        return "redirect:/login/login.html";
    }


}
