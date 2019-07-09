package jz.server;

import jz.entity.User;

import java.util.List;

public interface UserServer {
    public List<User> list();

    public List<User> search(String input);

    public User check(User user);

    public User getByAccount(String account);

    public boolean addUser(User user);

    public boolean deleteUser(String account);

    public boolean updateUser(User user);


}
