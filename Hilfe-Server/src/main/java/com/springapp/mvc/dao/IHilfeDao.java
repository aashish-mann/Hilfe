package com.springapp.mvc.dao;

import com.springapp.mvc.entity.Login;
import com.springapp.mvc.entity.User;

/**
 * Created by aashish on 3/6/15.
 */
public interface IHilfeDao {

    public User getdetails();

    public Login validateLogin(String username,String password);

	String validateUser(String username, String password);

}
