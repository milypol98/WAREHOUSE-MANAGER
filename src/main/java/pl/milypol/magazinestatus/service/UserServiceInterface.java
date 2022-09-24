package pl.milypol.magazinestatus.service;

import pl.milypol.magazinestatus.entity.User;

public interface UserServiceInterface {
    User findByUserName(String username);
    void saveUser(User user);
}
