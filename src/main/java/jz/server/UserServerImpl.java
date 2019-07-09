package jz.server;

import jz.dao.UserDao;
import jz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServerImpl implements UserServer {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> list() {
       return userDao.getallUser();
    }

    @Override
    public List<User> search(String input) {
       return userDao.search(input);
    }

    @Override
    public User check(User user) {
      return userDao.check(user);
    }

    @Override
    public User getByAccount(String account) {
        return userDao.getByAccount(account);
    }

    @Override
    public boolean addUser(User user) {
      return userDao.addUser(user);
    }

    @Override
    public boolean deleteUser(String account) {
       return  userDao.deleteUser(account);
    }

    @Override
    public boolean updateUser(User user) {
      return userDao.updateUser(user);
    }
}
