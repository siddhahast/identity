package com.facade.impl;

import com.dao.UserDao;
import com.datatype.LoginRequest;
import com.datatype.User;
import com.datatype.UserEvent;
import com.datatype.UserFilter;
import com.facade.UserFacade;
import com.observer.ObservableEvent;
import com.observer.ObservableEventQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserFacadeImpl implements UserFacade
{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> filter(UserFilter userFilter)
    {
        List<User> users = new ArrayList<>();
        User user1 = userDao.readUser(1L);
//        user1.setFirstName("Siddhahast");
//        user1.setEmail("siddhahast.mohapatra@gmail.com");
//        user1.setLastName("Mohapatra");
//        user1.setId(1L);
//        users.add(user1);
//

        users.add(user1);
        ObservableEventQueue.push(user1, UserEvent.TEST_EVENT);
        return users;
    }

    @Override
    public User login(LoginRequest loginRequest)
    {
        return null;
    }

    @Override
    public User searchByUserToken(String userToken) {
        return null;
    }
}
