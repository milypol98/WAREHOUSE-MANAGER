package pl.milypol.magazinestatus.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.milypol.magazinestatus.entity.Role;
import pl.milypol.magazinestatus.entity.User;
import pl.milypol.magazinestatus.repository.RoleRepository;
import pl.milypol.magazinestatus.repository.UserRepository;
import pl.milypol.magazinestatus.service.UserServiceInterface;

import java.util.Arrays;
import java.util.HashSet;
@Service
public class UserServiceImpl implements UserServiceInterface {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }
}
