package com.garyrio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopService {
    @Autowired
    private UserService userService;

    @Transactional
    public void topService() {
        userService.changeName();
        userService.changePassword();
    }
}
