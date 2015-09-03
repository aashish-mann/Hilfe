package com.springapp.mvc.service;

import com.springapp.mvc.dao.IHilfeDao;
import com.springapp.mvc.entity.Login;
import com.springapp.mvc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by aashish on 3/6/15.
 */
@Service
public class HilfeServiceImpl implements IHilfeService{

    @Autowired
    IHilfeDao hilfeDao;

    @Transactional
    @Override
    public User getdetails() {
        return hilfeDao.getdetails();
    }

    @Transactional(readOnly=true)
    @Override
    public Login validateLogin(Login login) {
        return hilfeDao.validateLogin(login.getUsername(),login.getPassword());
    }




}
