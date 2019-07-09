package jz.controller;

import jz.util.Util;
import jz.entity.User;
import jz.server.UserServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserServerImpl userServer;

    @RequestMapping("/userList.do")
    public String getList(HttpSession session) {
        listFlush(session);
        session.setAttribute("page", "userList.jsp");
        session.setAttribute("search", "/searchUser.do");
        return "/index";
    }

    @RequestMapping("/deleteUser.do")
    @ResponseBody
    public void delete(String account) {
        userServer.deleteUser(account);
    }

    @RequestMapping("/addUser.do")
    public String add(User user, HttpSession session) {
        userServer.addUser(user);
        listFlush(session);
        return "/userList";
    }

    @RequestMapping("/editUser.do")
    public String edit(User user, HttpSession session) {
        user.setIsValid(1);
        userServer.updateUser(user);
        listFlush(session);
        return "/userList";
    }

    @RequestMapping("searchUser.do")
    public String searchUser(String search, HttpSession session) {
        if (Util.isEmpty(search)) {
            listFlush(session);
        } else {
            session.setAttribute("keyword",search);
            session.setAttribute("userList", userServer.search(search));
        }
        return "/index";
    }


    private void listFlush(HttpSession session) {
        List<User> userList = userServer.list();
        if (null != userList) {
            session.setAttribute("userList", userList);
        } else {
            session.setAttribute("userList", "");
        }
    }

}
