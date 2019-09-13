package com.controller;

import com.datatype.LoginRequest;
import com.datatype.User;
import com.datatype.UserFilter;
import com.facade.UserFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserServiceController
{

    @Autowired
    private UserFacade userFacade;

    private static final Logger logger = Logger.getLogger(UserServiceController.class);

    @RequestMapping(value="/userDummy", method= RequestMethod.GET)
    @ResponseBody
    public User filterDummy()
    {
        logger.info("user controller dummy method");
        User user = new User();
        user.setId(1L);
        user.setFirstName("Siddhahast");
        user.setEmail("siddhahast.nitr@gmail.com");
        return user;
    }

    @RequestMapping(value="/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> filter(@RequestParam(required = false) UserFilter filter)
    {
        List<User> users = userFacade.filter(filter);
        logger.info("In the controller section");
        return users;
    }

    @RequestMapping(value="/user/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest)
    {
        User loggedInUser = userFacade.login(loginRequest);
        return new ResponseEntity<User>(loggedInUser, HttpStatus.OK);
    }

    @RequestMapping(value="/user/login", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> filterUserByAuthToken(UserFilter filter)
    {
        User loggedInUser = userFacade.searchByUserToken(filter.getAuthToken());
        return new ResponseEntity<User>(loggedInUser, HttpStatus.OK);
    }

    @RequestMapping(value="/user", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User loggedInUser = userFacade.createUser(user);
        return new ResponseEntity<User>(loggedInUser, HttpStatus.OK);
    }
}
