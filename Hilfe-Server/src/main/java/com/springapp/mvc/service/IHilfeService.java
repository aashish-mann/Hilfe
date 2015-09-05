package com.springapp.mvc.service;

import com.springapp.mvc.entity.Login;
import com.springapp.mvc.entity.User;
import com.springapp.mvc.sro.UserSRO;

/**
 * Created by aashish on 3/6/15.
 */
public interface IHilfeService {

    public User getdetails();

    public Login validateLogin(Login login);

	public void registerUser(User user);

	String validateUser(UserSRO user);

}
