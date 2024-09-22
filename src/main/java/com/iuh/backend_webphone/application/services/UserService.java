package com.iuh.backend_webphone.application.services;

import com.iuh.backend_webphone.domain.entity.User;

public interface UserService {
    User createUser(User user);

    User deleteUser(Long id);

    User getUserByUserNameAndPassWord(String userName, String password);
    
}
